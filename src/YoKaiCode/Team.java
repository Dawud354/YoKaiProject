package YoKaiCode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * YoKaiCode.Team class that holds the users current team. It allows the user to have a team of 3 YoKaiCode.YoKai
 * @see YoKai
 * @author dawud
 * @version 1.1
 * @since 04/12/2024
 */
public class Team {
    final int MAX_TEAM_SIZE = 3;
    final private List<YoKai> team = new ArrayList<>();
    private YoKaiTribes currentTeamBonus;

    // Define bonuses
    private static final Map<YoKaiTribes, Map<ValidStats, Integer>> familyBonuses = new HashMap<>() {{
        put(YoKaiTribes.brave, Map.of(ValidStats.STRENGTH, 10));
        put(YoKaiTribes.charming, Map.of(ValidStats.SPEED, 10));
        put(YoKaiTribes.mysterious, Map.of(ValidStats.SPIRIT, 10));
        put(YoKaiTribes.tough, Map.of(ValidStats.DEFENSE, 10));
        put(YoKaiTribes.eerie, Map.of(ValidStats.SPIRIT, 10));
        put(YoKaiTribes.slippery, Map.of(ValidStats.SPEED, 10));
        put(YoKaiTribes.shady, Map.of(ValidStats.DEFENSE, 10));
        put(YoKaiTribes.heartful, Map.of(ValidStats.FRIENDSHIP, 10));
    }};

    /**
     * @since 1.0
     * Constructor for the class
     * @param team array of YoKaiCode.YoKai
     */
    public Team(YoKai[] team){
        for (YoKai yoKai : team) {
            addYoKai(yoKai);
        }
    } // END Team

    /**
     * @since 1.0
     * @return the team
     */
    public List<YoKai> getTeam() {
        return team;
    } // END getTeam

    /**
     * @since 1.0
     * Add a YoKaiCode.YoKai to the team
     * Then checks if the team is full and sets the team bonus
     * @param yoKai the YoKaiCode.YoKai to add
     */
    public void addYoKai(YoKai yoKai){
        if (team!=null && team.size() < MAX_TEAM_SIZE){
            team.add(yoKai);
            setTeamBonus();
            applyBonus();
        }
    } // END addYoKai

    /**
     * @since 1.0
     * Remove a YoKaiCode.YoKai from the team and clears bonus from team members AND removed yo kai
     * @param yoKai the YoKaiCode.YoKai to remove
     */
    public void removeYoKai(YoKai yoKai){
        if (team.contains(yoKai)){
            team.remove(yoKai);
            yoKai.clearTemporaryModifiers();
            removeBonus();
        }

    } // END removeYoKai

    /**
     * @since 1.0
     * @return the currentTeamBonus
     */
    public YoKaiTribes getCurrentTeamBonus() {
        return currentTeamBonus;
    } // END getCurrentTeamBonus

    /**
     * @since 1.0
     * Checks if all 3 YoKaiCode.YoKai in the team are from the same tribe
     * If so sets the currentTeamBonus to the tribe
     */
    public void setTeamBonus(){
        if (team.size() == MAX_TEAM_SIZE){
            YoKaiTribes firstTribe = team.getFirst().getTribe();
            for (YoKai yoKai : team) {
                if (yoKai.getTribe() != firstTribe){
                    return;
                }
            }
            currentTeamBonus = firstTribe;
        }
    } // END checkTeamBonus

    /**
     * @since 1.0
     * Applies the bonus to the team members
     */
    public void applyBonus(){
        if (currentTeamBonus != null && familyBonuses.containsKey(currentTeamBonus)) {
            Map<ValidStats, Integer> bonuses = familyBonuses.get(currentTeamBonus);
            for (YoKai yoKai: team){
                for (Map.Entry<ValidStats, Integer> bonus : bonuses.entrySet()) {
                    switch (bonus.getKey()) {
                        case STRENGTH:
                            yoKai.temporaryIncreaseStrength(bonus.getValue());
                            break;
                        case DEFENSE:
                            yoKai.temporaryIncreaseDefence(bonus.getValue());
                            break;
                        case SPEED:
                            yoKai.temporaryIncreaseSpeed(bonus.getValue());
                            break;
                        case SPIRIT:
                            yoKai.temporaryIncreaseSpirit(bonus.getValue());
                            break;
                        case FRIENDSHIP:

                            yoKai.temporaryIncreaseFriendshipValue(bonus.getValue());
                            break;
                    }
                }
            }
        }
    } // END applyBonus

    /**
     * @since 1.0
     * Removes the bonus from the team members
     */
    public void removeBonus(){
        for (YoKai yokai: team){
            yokai.clearTemporaryModifiers();
        }
    } // END removeBonus

    /**
     * @since 1.1
     * Checks if the team is defeated
     * @return true if all YoKaiCode.YoKai in the team are defeated
     */
    public boolean isTeamDefeated(){
        for (YoKai yoKai: team){
            if (!yoKai.isDefeated()){
                return false;
            }
        }
        return true;
    } // END isTeamDefeated

    /**
     * Returns the names of the YoKai in the team as an array of strings
     */
    public String[] getTeamNames() {
        String[] names = new String[team.size()];
        for (int i = 0; i < team.size(); i++) {
            names[i] = team.get(i).getName();
        }
        return names;
    } // END getTeamNames

    /**
     * Returns the size of the team
     */
    public int getTeamSize() {
        return team.size();
    } // END getTeamSize

    /**
     * Returns how many YoKai are alive in the team
     */
    public int getAliveCount() {
        int count = 0;
        for (YoKai yoKai: team) {
            if (!yoKai.isDefeated()) {
                count++;
            }
        }
        return count;
    } // END getAliveCount

    /**
     * Returns a random YoKai from the team
     */
    public YoKai getRandomYoKai() {
        if (isTeamDefeated()){
            return null;
        }
        // could theoretically loop forever if random number generator is bad
        YoKai yoKai= team.get((int) (Math.random() * team.size()));
        if(yoKai.isDefeated()){
            yoKai= team.get((int) (Math.random() * team.size()));
        }
        return yoKai;
    } // END getRandomYoKai

}

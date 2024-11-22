import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Team class that holds the users current team. It allows the user to have a team of 3 YoKai
 * @see YoKai
 * @author dawud
 * @version 1.0
 * @since 17/11/2024
 */
public class Team {
    final int MAX_TEAM_SIZE = 3;
    final private List<YoKai> team = new ArrayList<>();
    private YoKaiTribes currentTeamBonus;

    // Define bonuses
    private static final Map<YoKaiTribes, Map<String, Integer>> familyBonuses = new HashMap<>() {{
        put(YoKaiTribes.brave, Map.of("attack", 10));
        put(YoKaiTribes.charming, Map.of("speed", 10));
        put(YoKaiTribes.mysterious, Map.of("spirit", 10));
        put(YoKaiTribes.tough, Map.of("defence", 10));
        put(YoKaiTribes.eerie, Map.of("spirit", 10));
        put(YoKaiTribes.slippery, Map.of("speed", 10));
        put(YoKaiTribes.shady, Map.of("defence", 10));
        put(YoKaiTribes.heartful, Map.of("friendshipValue", 10));
    }};

    /**
     * @since 1.0
     * Constructor for the class
     * @param team array of YoKai
     */
    Team(YoKai[] team){
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
     * Add a YoKai to the team
     * Then checks if the team is full and sets the team bonus
     * @param yoKai the YoKai to add
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
     * Remove a YoKai from the team and clears bonus from team members AND removed yo kai
     * @param yoKai the YoKai to remove
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
     * Checks if all 3 YoKai in the team are from the same tribe
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
            Map<String, Integer> bonuses = familyBonuses.get(currentTeamBonus);
            for (YoKai yoKai: team){
                for (Map.Entry<String, Integer> bonus : bonuses.entrySet()) {
                    switch (bonus.getKey()) {
                        case "attack":
                            yoKai.temporaryIncreaseStrength(bonus.getValue());
                            break;
                        case "defence":
                            yoKai.temporaryIncreaseDefence(bonus.getValue());
                            break;
                        case "speed":
                            yoKai.temporaryIncreaseSpeed(bonus.getValue());
                            break;
                        case "spirit":
                            yoKai.temporaryIncreaseSpirit(bonus.getValue());
                            break;
                        case "friendshipValue":
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
}

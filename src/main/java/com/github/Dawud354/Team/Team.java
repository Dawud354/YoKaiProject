package com.github.Dawud354.Team;

import java.util.ArrayList;
import java.util.List;
import com.github.Dawud354.YoKaiCode.YoKai;

/**
 * YoKaiCode.Team class that holds the users current team. It allows the user to have a team of 6 YoKaiCode.YoKai
 * @see YoKai
 * @author dawud
 * @version 1.1
 * @since 04/12/2024
 */

public class Team implements Iterable<YoKai> {
    public static final int MAX_TEAM_SIZE = 6;
    public static final int MAX_ACTIVE = 3;
    final private List<YoKai> team = new ArrayList<>();
    // store index of active YoKai
    final private List<Integer> active = new ArrayList<>();

    /**
     * @since 1.0
     * Constructor for the class
     * @param team array of YoKaiCode.YoKai
     */
    public Team(){
    } // END Team

    /**
     * @since 1.0
     * Add a YoKaiCode.YoKai to the team
     * Then checks if the team is full and sets the team bonus
     * @param yoKai the YoKaiCode.YoKai to add
     * @return true if the YoKai was added, false otherwise
     */
    public boolean addYoKai(YoKai yoKai){
        if (team!=null && team.size() < MAX_TEAM_SIZE){
            team.add(yoKai);
            if (active.size() < MAX_ACTIVE){
                active.add(team.size() - 1);
            }
            return true;
        }
        return false;
    } // END addYoKai

    /**
     * @since 1.0
     * Remove a YoKaiCode.YoKai from the team and clears bonus from team members AND removed yo kai
     * @param yoKai the YoKaiCode.YoKai to remove
     * @return true if the YoKai was removed, false otherwise
     */
    public boolean removeYoKai(YoKai yoKai){
        if (team.contains(yoKai)){
            int index = team.indexOf(yoKai);
            team.remove(yoKai);
            if (active.contains(index)){
                // we use (Integer) to remove by value, not by index
                active.remove((Integer)index);
            }
            return true;
        }
        return false;
    } // END removeYoKai

    /**
     * @since 1.0
     * Remove a YoKaiCode.YoKai from the team and clears bonus from team members AND removed yo kai
     * @param index the index of YoKai to remove
     * @return true if the YoKai was removed, false otherwise
     */
    public boolean removeYoKaiByIndex(int index){
        if (index >= 0 && index < team.size()) {
            team.remove(index);
            if (active.contains(index)){
                active.remove((Integer) index);
            }
            return true;
        }
        return false;
    }

    /**
     * Searches internal list of YoKai by name
     * @param name the name of the YoKai to search for
     * @return the YoKai with the matching name, or null if not found
     */
    public YoKai getYoKaiByName(String name){
        for (YoKai yoKai : team) {
            if (yoKai.getName().equalsIgnoreCase(name)) {
                return yoKai;
            }
        }
        return null;
    }

    public boolean swap (YoKai A, YoKai B){
        // end if not in team
        if (!team.contains(A) || !team.contains(B)) {
            return false;
        }
        int indexA = team.indexOf(A);
        int indexB = team.indexOf(B);
        // return false if both are active or both are not active
        if (active.contains((Integer) indexA) && active.contains((Integer) indexB) ||
            !active.contains((Integer) indexA) && !active.contains((Integer) indexB)) 
            {
            return false;
        }
        // Swap active status
        
        return false;
    }



    /**
     * Returns the YoKai at the specified index in the team
     * @param index the index of the YoKai to retrieve
     * @return the YoKai at the specified index, or null if the index is out of bounds
     */
    public YoKai getYoKaiByIndex(int index){
        if (index >= 0 && index < team.size()) {
            return team.get(index);
        }
        return null;
    }

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
     * Returns an array of active YoKai in the team
     * @return an array of active YoKai
     */
    public YoKai[] getActive(){
        YoKai[] activeYoKai = new YoKai[active.size()];
        for (int i = 0; i < active.size(); i++) {
            activeYoKai[i] = team.get(active.get(i));
        }
        return activeYoKai;
    }

    /**
     * Checks if there are no active YoKai in the team
     * @return true if there are no active YoKai, false otherwise
     */
    public boolean isActiveEmpty(){
        return active.isEmpty();
    }

    /**
     * Checks if a YoKai is in the team
     * @param yoKai the YoKai to check
     * @return true if the YoKai is in the team, false otherwise
     */
    public boolean contains(YoKai yoKai){
        return team.contains(yoKai);
    }

    @Override
    public java.util.Iterator<YoKai> iterator() {
        return team.iterator();
    }

}

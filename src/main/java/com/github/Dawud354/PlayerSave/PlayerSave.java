package com.github.Dawud354.PlayerSave;

import com.github.Dawud354.FileManagement.FileIOManager;
import com.github.Dawud354.Team.PlayerTeam;

public class PlayerSave {

    private static PlayerSave instance;
    private PlayerData playerData;
    
    private PlayerSave(){
        loadData();
    }

    public static PlayerSave getInstance(){
        if (instance == null) {
            instance = new PlayerSave();
        }
        return instance;
    }

    /**
     * Checks if there is a saved player data.
     * The folder it checks is the "data/player"
     * @return true if there is a saved player data, false otherwise.
     */
    public boolean isThereASave() {
        return FileIOManager.doesFolderExist("player");
    }

    public PlayerTeam getPlayerTeam() {
        return playerData.playerTeam;
    }

    public String getPlayerName() {
        return playerData.playerName;
    }

    public boolean saveData() {
        try {
            FileIOManager.save("player/playerData.json", playerData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void loadData() {
        if (FileIOManager.doesFileExist("player/playerData.json")) {
            System.out.println("Loading player data from player/playerData.json");
            try {
                playerData = FileIOManager.load("player/playerData.json", PlayerData.class);
            } catch (Exception e) {
                // make a new playerData if loading fails
                playerData = new PlayerData();
            }
        } else {
            playerData = new PlayerData();
        }
    }



}

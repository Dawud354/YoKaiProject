package com.TextBasedInterface;

import java.util.Random;

import com.github.Dawud354.PlayerSave.PlayerSave;
import com.github.Dawud354.Team.EnemyTeam;
import com.github.Dawud354.Team.PlayerTeam;
import com.github.Dawud354.YoKaiCode.PhysicalMove;
import com.github.Dawud354.YoKaiCode.SpecialMove;
import com.github.Dawud354.YoKaiCode.YoKai;
import com.github.Dawud354.YoKaiCode.YoKaiTribes;

public class SceneManager {
    
    public static void goHome(){
        HomeScreen homeScreen = new HomeScreen();
    }

    public static void goBattle() throws InterruptedException{

        PlayerTeam playerTeam = PlayerSave.getInstance().getPlayerTeam();
        EnemyTeam enemyTeam = new EnemyTeam();
        BattleFrontEnd battleScreen = new BattleFrontEnd(playerTeam, enemyTeam);
    }

    public static void goInventory(){
        System.err.println("Inventory screen is under construction.");
    }

    public static void goTrain(){
        System.err.println("Train screen is under construction.");
    }

    public static void goExit(){
        ExitScreen exitScreen = new ExitScreen();
    }

}

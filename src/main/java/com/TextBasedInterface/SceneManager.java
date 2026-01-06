package com.TextBasedInterface;

import java.util.Random;

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
        PhysicalMove pm ;
        SpecialMove sm ;
        YoKai y;
        String[] physicalMoveNames = {"Slash", "Punch","Box","Rocket Punch"};
        String[] specialMoveNames = {"Fireball", "Ice Blast", "Thunder Strike", "Earthquake"};
        String[] ykNames = {"Jibanyan", "Komasan", "Whisper", "Blazion", "Shogunyan", "Robonyan"};
        int random;
        Random rand = new Random();
        PlayerTeam playerTeam = new PlayerTeam();

        for (int i = 0; i < 5; i++) {
            random = rand.nextInt(physicalMoveNames.length);
            pm = new PhysicalMove(physicalMoveNames[random], "null", 10, 0);
            random = rand.nextInt(specialMoveNames.length);
            sm = new SpecialMove(specialMoveNames[random], "null", 10, 0);
            random = rand.nextInt(ykNames.length);
            y = new YoKai(ykNames[random], 15, 15, 10, 10, 15, 12, 19, YoKaiTribes.charming, pm, sm);
            playerTeam.addYoKai(y);
        }
        EnemyTeam enemyTeam = new EnemyTeam();
        for (int i = 0; i < 3; i++) {
            random = rand.nextInt(physicalMoveNames.length);
            pm = new PhysicalMove(physicalMoveNames[random], "null", 0, 0);
            random = rand.nextInt(specialMoveNames.length);
            sm = new SpecialMove(specialMoveNames[random], "null", 0, 0);
            random = rand.nextInt(ykNames.length);
            y = new YoKai(ykNames[random], 5, 5, 10, 10, 15, 12, 19, YoKaiTribes.charming, pm, sm);
            enemyTeam.addYoKai(y);
        }
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

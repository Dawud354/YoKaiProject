package com.github.Dawud354.Team;

import java.util.Random;

import com.github.Dawud354.FileManagement.FileIOManager;
import com.github.Dawud354.YoKaiCode.PhysicalMove;
import com.github.Dawud354.YoKaiCode.SpecialMove;
import com.github.Dawud354.YoKaiCode.YoKai;
import com.github.Dawud354.YoKaiCode.YoKaiTribes;

public class EnemyTeam extends Team {
    public EnemyTeam() {
        super();
        generateEnemyTeam();
    }

    private void generateEnemyTeam() {
        // will load 3 random yo kai from the folder data/enemy/yoKai
        if (FileIOManager.doesFolderExist("enemy/yoKai")) {
            String[] files= FileIOManager.getAllFileNames("enemy/yoKai");
            Random rand = new Random();
            for (int i  = 0; i < 3; i++) {
                String ykFile = files[rand.nextInt(files.length)];
                YoKai y = FileIOManager.load("enemy/yoKai/"+ykFile, YoKai.class);
                this.addYoKai(y);
            }
        } 
        // a backup incase data just goes bad but should really find a better solution
        else {
            PhysicalMove pm;
            SpecialMove sm;
            YoKai y;
            String[] physicalMoveNames = { "Slash", "Punch", "Box", "Rocket Punch" };
            String[] specialMoveNames = { "Fireball", "Ice Blast", "Thunder Strike", "Earthquake" };
            String[] ykNames = { "Jibanyan", "Komasan", "Whisper", "Blazion", "Shogunyan", "Robonyan" };
            int random;
            Random rand = new Random();
            for (int i = 0; i < 3; i++) {
                random = rand.nextInt(physicalMoveNames.length);
                pm = new PhysicalMove(physicalMoveNames[random], "null", 0, 0);
                random = rand.nextInt(specialMoveNames.length);
                sm = new SpecialMove(specialMoveNames[random], "null", 0, 0);
                random = rand.nextInt(ykNames.length);
                y = new YoKai(ykNames[random], 5, 5, 10, 10, 15, 12, 19, YoKaiTribes.charming, pm, sm);
                this.addYoKai(y);
            }

        }

    }}

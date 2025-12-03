package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;
import com.github.Dawud354.Team.EnemyTeam;
import com.github.Dawud354.Team.PlayerTeam;
import com.github.Dawud354.Team.Team;

import java.util.concurrent.TimeUnit;

import com.github.Dawud354.YoKaiCode.Move;
import com.github.Dawud354.YoKaiCode.YoKai;

public class BattleFrontEnd extends BaseTextProgram {
    private final BattleLogic battleLogic;

    public BattleFrontEnd(PlayerTeam playerTeam, EnemyTeam enemyTeam) throws InterruptedException {
        this.battleLogic = new BattleLogic(playerTeam, enemyTeam);
        startBattle();
    }

    private void startBattle() throws InterruptedException {
        battleLogic.startBattle();
        while (!battleLogic.isBattleOver()) {
            printCurrentTurn();
            askUserForMoves();
            executeAllMovesQueue();
        }
        outputWhoWon();

    }

    private void printCurrentTurn() {
        print("Current Turn: " + battleLogic.getTurnCount());
        print("\nPlayer Team:");
        printTeam(battleLogic.getPlayerTeam());
        print("\nEnemy Team:");
        printTeam(battleLogic.getEnemyTeam());
    }

    private void printTeam(Team team) {
        // Print Yo Kai names
        String[] yoKaiNames = team.getTeamNames();
        String[] yoKaiHP = new  String[yoKaiNames.length];
        int i = 0;
        for (YoKai yk : team) {
            if (!team.isActive(yk)) {
                yoKaiHP[i] = "Benched";
            } else if (yk.isDefeated()) {
                yoKaiHP[i] = "Defeated";
            }
            else {
                yoKaiHP[i] = "HP: " + yk.getHP();
            }
            i++;
            }
        for (String name: yoKaiNames) {
            System.out.printf("%-20s", name);
        }
        System.out.println();
        for (String hp: yoKaiHP) {
            System.out.printf("%-20s", hp);
        }
        System.out.println();
    }


    private void askUserForMoves() {
        int choice = 0;
        for (YoKai user: battleLogic.getPlayerTeam().getActive()) {
            if (!user.isDefeated()) {
                print("What would you like to do for "+ user.getName());
                print("1. Attack");
                print("2. Switch YoKai");
                choice = inputPositiveInt();
                while (choice != 1 && choice !=2) {
                    print("Invalid choice please enter only 1 or 2");
                    choice = inputPositiveInt();
                }
                if (choice == 1){
                    Move move = askUserForMove(user);
                    YoKai target = askForTarget(battleLogic.getEnemyTeam());
                    AttackIntentMessage attackIntent = new AttackIntentMessage(user, move, target);
                    battleLogic.addUserMove(attackIntent);
                } else if (choice == 2){
                    YoKai benched = askWhoToSwitchWith();
                    if (benched != null) {
                        SwitchIntentMessage switchIntent = new SwitchIntentMessage(user, benched);
                        battleLogic.addUserMove(switchIntent);
                    }
                }
            }
        }
    }

    private YoKai askWhoToSwitchWith(){
        YoKai[] benched = battleLogic.getPlayerTeam().getBenched();
        if (benched.length == 0) {
            print("No benched YoKai available to switch with.");
            return null;
        }
        print("Please select a benched yo kai from the list below.");
        for (int i = 0; i < benched.length; i++) {
            print((i + 1) + ". " + benched[i].getName());
        }
        int choice = 0;
        print("Please enter the number of the YoKai you want to switch with: ");
        choice = inputPositiveInt();
        while (choice < 1 || choice > benched.length) {
            print("Invalid choice please enter a number between 1 and " + benched.length);
            choice = inputPositiveInt();
        }
        
        return benched[choice - 1];
    }

    private Move askUserForMove(YoKai user) {
        print("Choose a move for " + user.getName());
        print("1. " + user.getPhysicalMove().getName());
        print("2. " + user.getSpecialMove().getName());
        print("Please enter the number of the move you want to use: ");
        int moveNumber = inputPositiveInt();
        while (moveNumber != 1 && moveNumber != 2) {
            print("Invalid move number. Please enter 1 or 2: ");
            moveNumber = inputPositiveInt();
        }
        if (moveNumber == 1) {
            return user.getPhysicalMove();
        }
        else {
            return user.getSpecialMove();
        }
    }

    private YoKai askForTarget(Team enemyTeam) {
        print("Choose a target: ");
        int i = 0;
        YoKai[] enemyActive = enemyTeam.getActive();
        for (YoKai yoKai: enemyActive) {
            print((i + 1) + ". " + yoKai.getName());
            i++;
        }
        int targetNumber = getUserTarget(Team.MAX_ACTIVE);
        while (enemyActive[targetNumber - 1].isDefeated()) {
            print("Target is already defeated. Please choose another target: ");
            targetNumber = getUserTarget(Team.MAX_ACTIVE);
        }
        return enemyActive[targetNumber - 1];
    } // END askForTarget


    private int getUserTarget(int max){
        int target = inputPositiveInt();
        battleLogic.getEnemyTeam();
        while (target < 1 || target > max){
            print("Invalid target number. Please enter a number between 1 and " + max + ": ");
            target = inputPositiveInt();
        }
        return target;
    }

    private void executeAllMovesQueue() throws InterruptedException {
        BattleResult result = battleLogic.executeNextMove();
        while (result != null){
            switch (result) {
                case AttackResult ar -> outputMoveToUser(ar);
                case SwitchResult sr -> outputSwitchToUser(sr);
            }
            result = battleLogic.executeNextMove();
        }
    }

    private void outputSwitchToUser(SwitchResult sr){
        if (sr.success()){
            print("Switch was successful: " + sr.memberA() + " switched with " + sr.memberB());
        }else{
            print("Switch was not successful.");
        }
    }

    private void outputMoveToUser(AttackResult ar) throws InterruptedException {
        print(ar.userName()+" used "+ar.moveName()+" on "+ar.targetName());
        TimeUnit.SECONDS.sleep(1);
        print(ar.targetName()+" took "+ar.damage()+" damage.");
        print(ar.targetName()+" has "+ar.remainingHealth()+" HP.");
        TimeUnit.SECONDS.sleep(2);
    }

    private void outputWhoWon(){
        if (battleLogic.getPlayerTeam().isTeamDefeated()){
            print("You lost!");
        }
        else {
            print("You won!");
        }
    }

}

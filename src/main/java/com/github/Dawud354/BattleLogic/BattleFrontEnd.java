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
            if (yk.isDefeated()) {
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
        for (YoKai user: battleLogic.getPlayerTeam()) {
            if (!user.isDefeated()) {
                Move move = askUserForMove(user);
                YoKai target = askForTarget(battleLogic.getEnemyTeam());
                battleLogic.addUserMove(user, move, target);
            }
        }
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
        MoveResult moveResult = battleLogic.executeNextMove();
        while (moveResult != null){
            outputMoveToUser(moveResult);
            moveResult = battleLogic.executeNextMove();
        }
    }

    private void outputMoveToUser(MoveResult moveResult) throws InterruptedException {
        print(moveResult.getUserName()+" used "+moveResult.getMoveName()+" on "+moveResult.getTargetName());
        TimeUnit.SECONDS.sleep(1);
        print(moveResult.getTargetName()+" took "+moveResult.getDamage()+" damage.");
        print(moveResult.getTargetName()+" has "+moveResult.getRemainingHealth()+" HP.");
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

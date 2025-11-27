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
        for (int i = 0; i < yoKaiNames.length; i++) {

            if (team.getTeam().get(i).isDefeated()) {
                yoKaiHP[i] = "Defeated";
            }
            else {
                yoKaiHP[i] = "HP:";
            }
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
        for (YoKai user: battleLogic.getPlayerTeam().getTeam()) {
            if (!user.isDefeated()) {
                Move move = askUserForMove(user);
                YoKai target = askForTarget(battleLogic.getEnemyTeam());
                battleLogic.addUserMoveToQueue(user, move, target);
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
        for (YoKai yoKai: enemyTeam.getTeam()) {
            print((enemyTeam.getTeam().indexOf(yoKai) + 1) + ". " + yoKai.getName());
        }
        int targetNumber = getUserTarget();
        while (enemyTeam.getTeam().get(targetNumber - 1).isDefeated()) {
            print("Target is already defeated. Please choose another target: ");
            targetNumber = getUserTarget();
        }
        return enemyTeam.getTeam().get(targetNumber - 1);
    } // END askForTarget


    private int getUserTarget(){
        int target = inputPositiveInt();
        while (target < 1 || target > battleLogic.getEnemyTeam().getTeamSize()){
            print("Invalid target number. Please enter a number between 1 and " + battleLogic.getEnemyTeam().getTeamSize() + ": ");
            target = inputPositiveInt();
        }
        return target;
    }

    private void executeAllMovesQueue() throws InterruptedException {
        NextMove nextMove = battleLogic.executeMoveQueue();
        while (nextMove != null){
            outputMoveToUser(nextMove);
            nextMove = battleLogic.executeMoveQueue();
        }
    }

    private void outputMoveToUser(NextMove nextMove) throws InterruptedException {
        print(nextMove.getUser().getName()+" used "+nextMove.getMove().getName()+" on "+nextMove.getTarget().getName());
        int damage = nextMove.getDamageForUserOutput();
        TimeUnit.SECONDS.sleep(1);
        print(nextMove.getTarget().getName()+" took "+damage+" damage.");
        print(nextMove.getTarget().getName()+" has "+" HP.");
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

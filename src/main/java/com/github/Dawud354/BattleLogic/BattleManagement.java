package com.github.Dawud354.BattleLogic;

import java.util.PriorityQueue;

import com.github.Dawud354.YoKaiCode.*;

public class BattleManagement {
    private final Team playerTeam;
    private final Team enemyTeam;
    private int turnCount = 1;
    PriorityQueue<NextMove> nextMoves = new PriorityQueue<>();

    public BattleManagement(Team playerTeam, Team enemyTeam) {
        if (playerTeam == null || enemyTeam == null) {
            throw new IllegalArgumentException("Teams must be provided");
        }
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public Team getEnemyTeam() {
        return enemyTeam;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void incrementTurnCount() {
        turnCount++;
    }

    public void resetTurnCount() {
        turnCount = 1;
    }

    public void startBattle() {
        resetTurnCount();
    }

    private Team checkYoKaiTeam(YoKai yoKai){
        if (playerTeam.getTeam().contains(yoKai)){
            return playerTeam;
        }
        else if (enemyTeam.getTeam().contains(yoKai)){
            return enemyTeam;
        }
        return null;
    }

    /**
     * Checks if the battle is over
     * @return true if the battle is over, false otherwise
     */
    public boolean isBattleOver() {
        return playerTeam.isTeamDefeated() || enemyTeam.isTeamDefeated();
    }

    public boolean addUserMoveToQueue(YoKai user, BaseMove move, YoKai target) {
        // Check if the user is in the player's team, move is valid and target is in the enemy team
        // then adds move to the queue
        boolean added = false;
        if (playerTeam.getTeam().contains(user) && user.isMoveInMoveset(move) && enemyTeam.getTeam().contains(target)) {
            NextMove nextMove = new NextMove(user, move, target, turnCount);
            nextMoves.add(nextMove);
            added = true;
        }
        return added;
    }

    public boolean addEnemyMoveToQueue(YoKai user, BaseMove move, YoKai target) {
        // Check if the user is in the enemy's team, move is valid and target is in the player team
        // then adds move to the queue
        boolean added = false;
        if (enemyTeam.getTeam().contains(user) && user.isMoveInMoveset(move) && playerTeam.getTeam().contains(target)) {
            NextMove nextMove = new NextMove(user, move, target, turnCount);
            nextMoves.add(nextMove);
            added = true;
        }
        return added;
    }

    public NextMove executeMoveQueue() {
        // stops error when all targets are dead but move queue is not empty
        // clears the queue and returns null
        if(isBattleOver()){
            nextMoves.clear();
            return null;
        }
        NextMove nextMove = getNextMove();
        if (nextMove == null) {
            return null;
        }
        handleDefeatedTarget(nextMove);
        executeMove(nextMove);
        return nextMove;
    }

    // Returns the next move in the queue
    // Skips the move if the user is defeated
    // Returns null to indicate that there are no more moves in the queue
    private NextMove getNextMove(){
        NextMove nextMove = nextMoves.poll();
        while(nextMove!=null && nextMove.getUser().isDefeated()){
            nextMove = nextMoves.poll();
        }
        return nextMove;
    }

    private void handleDefeatedTarget(NextMove nextMove) {
        if (nextMove.getTarget().isDefeated()) {
            Team team = checkYoKaiTeam(nextMove.getTarget());
            if (team != null) {
                nextMove.changeTarget(team.getRandomYoKai());
            }
        }
    }

    private void executeMove(NextMove nextMove) {
        if (nextMove.getMove().getCategory() == MoveCategory.PHYSICAL) {
            physicalMove(nextMove);
        } else if (nextMove.getMove().getCategory() == MoveCategory.SPECIAL) {
            specialMove(nextMove);
        }
    }

    public void physicalMove(NextMove nextMove){
        YoKai user = nextMove.getUser();
        BaseMove move = nextMove.getMove();
        YoKai target = nextMove.getTarget();
        int damage = calculateDamage(user.getStrength(), target.getDefence(), move.getPower());
        nextMove.setDamageForUserOutput(damage);
        target.adjustHP(-damage);
    }

    public void specialMove(NextMove nextMove){
        YoKai user = nextMove.getUser();
        BaseMove move = nextMove.getMove();
        YoKai target = nextMove.getTarget();
        int damage = calculateDamage(user.getSpirit(), target.getDefence(), move.getPower());
        nextMove.setDamageForUserOutput(damage);
        target.adjustHP(-damage);
    }


    public int calculateDamage(int userStrength, int targetDefence, int movePower){
        double randomFactor = 0.85 + Math.random() * 0.15; // Random value between 0.85 and 1.0
        targetDefence = Math.max(targetDefence, 1); // Ensure defense is at least 1
        double movePowerD = Math.max(movePower, 1); // Ensure move power is at least 1
        return (int) ((userStrength/2.0) * ( movePowerD / targetDefence) * randomFactor);
    }

}

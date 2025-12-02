package com.github.Dawud354.BattleLogic;

import java.util.ArrayList;
import java.util.List;

import com.github.Dawud354.Team.PlayerTeam;
import com.github.Dawud354.Team.Team;
import com.github.Dawud354.Team.EnemyTeam;
import com.github.Dawud354.YoKaiCode.*;

public class BattleLogic {
    private final PlayerTeam playerTeam;
    private final EnemyTeam enemyTeam;
    private int turnCount = 1;
    private boolean canAdd = false;
    private List<BattleAction> nextMoves = new ArrayList<>();

    public BattleLogic(PlayerTeam playerTeam, EnemyTeam enemyTeam) {
        if (playerTeam == null || enemyTeam == null) {
            throw new IllegalArgumentException("Teams must be provided");
        }
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    public PlayerTeam getPlayerTeam() {
        return playerTeam;
    }

    public EnemyTeam getEnemyTeam() {
        return enemyTeam;
    }

    public int getTurnCount() {
        return turnCount;
    }

    private void incrementTurnCount() {
        turnCount++;
    }

    public void startBattle() {
        if (playerTeam.isActiveEmpty() || enemyTeam.isActiveEmpty()) {
            throw new IllegalStateException("Cannot start battle with no active YoKai in one of the teams.");
        }
        turnCount = 1;
        nextMoves.clear();
        canAdd = true;
    }

    private Team checkYoKaiTeam(YoKai yoKai){
        if (playerTeam.contains(yoKai)){
            return playerTeam;
        }
        else if (enemyTeam.contains(yoKai)){
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

    public boolean addUserMove(YoKai user, Move move, YoKai target) {
        // Check if the user is in the player's team, move is valid and target is in the enemy team
        // then adds move to the queue
        if (nextMoves.size()>=3 || canAdd == false){
            return false;
        }
        boolean added = false;
        if (playerTeam.contains(user) && user.isMoveInMoveset(move) && enemyTeam.contains(target)) {
            NextMove nextMove = new NextMove(user, move, target);
            nextMoves.add(nextMove);
            added = true;
            if (nextMoves.size() == 3) {
                addEnemyMoves();
                canAdd = false;
            }
        }
        return added;
    }

    private void addEnemyMoves() {
        YoKai[] team = playerTeam.getActive();
        for (YoKai y : enemyTeam.getActive()) {
            // generate a random number between 0 and 1. 
            // 0 is physical move, 1 is special move
            int x = (int) (Math.random() * 2);
            int randomTargetIndex = (int) (Math.random() * team.length);
            NextMove nextMove;
            if ( x == 0){
                nextMove = new NextMove(y, y.getPhysicalMove(), team[randomTargetIndex]);
            }else{
                nextMove = new NextMove(y, y.getSpecialMove(), team[randomTargetIndex]);
            }
            nextMoves.add(nextMove);
        }
    }

    public MoveResult executeNextMove() {
        // only execute when player has finished adding moves
        if (canAdd == true){
            return null;
        }
        // stops error when all targets are dead but move queue is not empty
        // clears the queue and returns null
        if (nextMoves.isEmpty()){
            canAdd = true;
            incrementTurnCount();
            return null;
        }
        if(isBattleOver()){
            nextMoves.clear();
            return null;
        }
        BattleAction nextMove = nextMoves.remove(0);
        if (nextMove == null) {
            return null;
        }
        return nextMove.execute();
    }
}

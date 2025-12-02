package com.github.Dawud354.BattleLogic;

import java.util.ArrayList;
import java.util.List;

import com.github.Dawud354.Team.PlayerTeam;
import com.github.Dawud354.Team.EnemyTeam;
import com.github.Dawud354.YoKaiCode.*;

public class BattleLogic {
    BattleContext battleContext;
    private boolean canAdd = false;
    private List<BattleAction> nextMoves = new ArrayList<>();

    public BattleLogic(PlayerTeam playerTeam, EnemyTeam enemyTeam) {
        if (playerTeam == null || enemyTeam == null) {
            throw new IllegalArgumentException("Teams must be provided");
        }
        battleContext = new BattleContext(playerTeam, enemyTeam);
    }

    public PlayerTeam getPlayerTeam() {
        return battleContext.getPlayerTeam();
    }

    public EnemyTeam getEnemyTeam() {
        return battleContext.getEnemyTeam();
    }

    public int getTurnCount() {
        return battleContext.getTurnCount();
    }

    private void incrementTurnCount() {
        battleContext.incrementTurnCount();
    }

    public void startBattle() {
        if (battleContext.getPlayerTeam().isActiveEmpty() || battleContext.getEnemyTeam().isActiveEmpty()) {
            throw new IllegalStateException("Cannot start battle with no active YoKai in one of the teams.");
        }
        battleContext.resetTurnCount();
        nextMoves.clear();
        canAdd = true;
    }

    /**
     * Checks if the battle is over
     * @return true if the battle is over, false otherwise
     */
    public boolean isBattleOver() {
        return getPlayerTeam().isTeamDefeated() || getEnemyTeam().isTeamDefeated();
    }

    public boolean addUserMove(YoKai user, Move move, YoKai target) {
        // Check if the user is in the player's team, move is valid and target is in the enemy team
        // then adds move to the queue
        if (nextMoves.size()>=3 || canAdd == false){
            return false;
        }
        boolean added = false;
        if (getPlayerTeam().contains(user) && user.isMoveInMoveset(move) && getEnemyTeam().contains(target)) {
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
        YoKai[] team = getPlayerTeam().getActive();
        for (YoKai y : getEnemyTeam().getActive()) {
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
        return nextMove.execute(battleContext);
    }
}

package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.Team.*;

public class BattleContext {
    private PlayerTeam playerTeam;
    private EnemyTeam enemyTeam;
    private int turnCount = 1;

    public BattleContext(PlayerTeam playerTeam, EnemyTeam enemyTeam) {
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

    public void incrementTurnCount() {
        turnCount++;
    }

    public void resetTurnCount() {
        turnCount = 1;
    }

}
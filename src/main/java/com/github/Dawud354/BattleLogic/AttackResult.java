package com.github.Dawud354.BattleLogic;

public record AttackResult(String userName, String targetName, String moveName, int damage,
    int remainingHealth, boolean isTargetDead) implements BattleResult{
}
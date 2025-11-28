package com.github.Dawud354.BattleLogic;

public class MoveResult {

    private String userName;
    private String targetName;
    private String moveName;
    private int damage;
    private int remainingHealth;
    private boolean isTargetDead = false;

    public MoveResult(String userName, String targetName, String moveName, int damage, int remainingHealth) {
        this.targetName = targetName;
        this.userName = userName;
        this.moveName = moveName;
        this.damage = damage;
        this.remainingHealth = remainingHealth;
    }

    public String getUserName() {
        return userName;
    }

    public String getTargetName() {
        return targetName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public void setIsTargetDead(boolean isTargetDead) {
        this.isTargetDead = isTargetDead;
    }

    public boolean getIsTargetDead() {
        return isTargetDead;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }
}
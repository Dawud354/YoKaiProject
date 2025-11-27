package com.github.Dawud354.BattleLogic;

public class MoveResult {

    private String user;
    private String target;
    private String moveName;
    private int damage;
    private int remainingHealth;
    private boolean isUserDead = false;

    public MoveResult(String user, String target, String moveName, int damage, int remainingHealth) {
        this.target = target;
        this.user = user;
        this.moveName = moveName;
        this.damage = damage;
        this.remainingHealth = remainingHealth;
    }

    public String getUser() {
        return user;
    }

    public String getTarget() {
        return target;
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

    public void setIsUserDead(boolean isUserDead) {
        this.isUserDead = isUserDead;
    }

    public boolean getIsUserDead() {
        return isUserDead;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }
}
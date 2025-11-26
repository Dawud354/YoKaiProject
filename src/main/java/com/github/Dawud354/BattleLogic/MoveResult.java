package com.github.Dawud354.BattleLogic;

public class MoveResult {

    private String user;
    private String target;
    private int damage;

    public MoveResult(String user, String target, int damage) {
        this.target = target;
        this.user = user;
        this.damage = damage;
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
}
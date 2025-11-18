package com.github.Dawud354.YoKaiCode;

public class Stats {
    private final HealthStat health;
    private final Stat strength;
    private final Stat spirit;
    private final Stat speed;
    private final Stat defence;
    private final Stat friendshipValue;

    public Stats(int maxHP, int currentHP, int strength, int spirit, int speed, int defence, int friendshipValue) {
        health = new HealthStat(maxHP, currentHP);
        this.strength = new Stat(strength);
        this.spirit = new Stat(spirit);
        this.speed = new Stat(speed);
        this.defence = new Stat(defence);
        this.friendshipValue = new Stat(friendshipValue);
    }

    public void increaseHP(int amount) {
        health.increaseCurrentHP(amount);
    }

    public void decreaseHP(int amount) {
        health.decreaseCurrentHP(amount);
    }

    public void increaseMaxHP(int amount) {
        health.increaseMaxHP(amount);
    }

    public void decreaseMaxHP(int amount) {
        health.decreaseMaxHP(amount);
    }


    public int getHealth() {
        return health.getCurrentHP();
    }

    public int getMaxHealth() {
        return health.getMaxHP();
    }

    public void increaseStrength(int amount) {
        strength.increase(amount);
    }

    public void decreaseStrength(int amount) {
        strength.decrease(amount);
    }

    public int getStrength() {
        return strength.getValue();
    }

    public void increaseSpirit(int amount) {
        spirit.increase(amount);
    }

    public void decreaseSpirit(int amount) {
        spirit.decrease(amount);
    }

    public int getSpirit() {
        return spirit.getValue();
    }

    public void increaseSpeed(int amount) {
        speed.increase(amount);
    }

    public void decreaseSpeed(int amount) {
        speed.decrease(amount);
    }

    public int getSpeed() {
        return speed.getValue();
    }

    public void increaseDefence(int amount) {
        defence.increase(amount);
    }

    public void decreaseDefence(int amount) {
        defence.decrease(amount);
    }

    public int getDefence() {
        return defence.getValue();
    }

    public void increaseFriendshipValue(int amount) {
        friendshipValue.increase(amount);
    }

    public void decreaseFriendshipValue(int amount) {
        friendshipValue.decrease(amount);
    }

    public int getFriendshipValue() {
        return friendshipValue.getValue();
    }

}

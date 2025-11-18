package com.github.Dawud354.YoKaiCode;

public class HealthStat{

    final private Stat maxHP, currentHP;

    HealthStat(int maxHP, int currentHP) {
        currentHP = Math.min(currentHP, maxHP);
        this.maxHP = new Stat(maxHP);
        this.currentHP = new Stat(currentHP);
    }

    public int getMaxHP() {
        return maxHP.getValue();
    }

    public int getCurrentHP() {
        return currentHP.getValue();
    }

    public void increaseMaxHP(int amount) {
        maxHP.increase(amount);
    }

    public void increaseCurrentHP(int amount) {
        currentHP.increase(amount);
    }

    public void decreaseMaxHP(int amount) {
        maxHP.decrease(amount);
    }

    public void decreaseCurrentHP(int amount) {
        currentHP.decrease(amount);
    }

}

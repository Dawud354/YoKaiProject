public class HealthStat{

    final private Stat maxHP, currentHP;
    final int BASE_MAX_HP = 999;

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

    public void adjustCurrentHP(int amount) {
        if (amount > 0) {
            currentHP.increase(amount);
        } else {
            currentHP.decrease(-amount);
        }
        // Ensure currentHP stays within valid bounds
        if (currentHP.getValue() > maxHP.getValue()) {
            currentHP.setValue(maxHP.getValue());
        } else if (currentHP.getValue() < 0) {
            currentHP.setValue(0);
        }
    }


    public void adjustMaxHP(int amount) {
        if (amount > 0) {
            maxHP.increase(amount);
        } else {
            maxHP.decrease(-amount);
        }
        // Ensure maxHP stays within valid bounds
        if (maxHP.getValue() > BASE_MAX_HP) {
            maxHP.setValue(BASE_MAX_HP);
        } else if (maxHP.getValue() < 0) {
            maxHP.setValue(0);
        }
        // Ensure currentHP stays within valid bounds
        if (currentHP.getValue() > maxHP.getValue()) {
            currentHP.setValue(maxHP.getValue());
        }
    }
}

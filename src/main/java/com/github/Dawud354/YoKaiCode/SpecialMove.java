package com.github.Dawud354.YoKaiCode;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;

public class SpecialMove extends BaseMove {
    private final SecondaryEffect secondaryEffect;
    private ValidStats statToChange;
    private int changeAmount;

    public SpecialMove(String name,String description, int power, int accuracy, SecondaryEffect secondaryEffect, ValidStats statToChange, int changeAmount) {
        super(name,description, power, accuracy, MoveCategory.SPECIAL);
        this.secondaryEffect = secondaryEffect;
        this.statToChange = statToChange;
        setChangeAmount(changeAmount);
    }

    public SpecialMove(String name,String description, int power, int accuracy, SecondaryEffect secondaryEffect) {
        super(name,description, power, accuracy, MoveCategory.SPECIAL);
        if (secondaryEffect==SecondaryEffect.BOOST_STAT||secondaryEffect==SecondaryEffect.LOWER_STAT) {
            throw new IllegalArgumentException("Stat to change and change amount must be provided for a stat change move");
        }
        this.secondaryEffect = secondaryEffect;
    }

    public SpecialMove(String name,String description, int power, int accuracy) {
        super(name,description, power, accuracy, MoveCategory.SPECIAL);
        this.secondaryEffect = SecondaryEffect.NONE;
    }

    public ValidStats getStatToChange() {
        return statToChange;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public SecondaryEffect getSecondaryEffect() {
        return secondaryEffect;
    }


    private void setChangeAmount(int changeAmount) {
        if (changeAmount >= 0 && changeAmount <= 100) {
            this.changeAmount = changeAmount;
        }
        else {
            throw new IllegalArgumentException("Change amount must be between 0 and 100");
        }
    }


}

package com.github.Dawud354.YoKaiCode;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;

/**
 * This class represents a status move that can be used in battle
 * NOTE: THIS CLASS IS NOT BEING USED. NOT COMPLETED
 */
@Deprecated
public class StatusMove extends Move {
    SecondaryEffect secondaryEffect;
    private ValidStats statToChange;
    private int changeAmount;

    public StatusMove(String name,String description, int power, int accuracy, SecondaryEffect secondaryEffect) {
        super(name,description, power, accuracy, MoveCategory.SPECIAL);
        if (secondaryEffect==SecondaryEffect.BOOST_STAT||secondaryEffect==SecondaryEffect.LOWER_STAT) {
            throw new IllegalArgumentException("Stat to change and change amount must be provided for a stat change move");
        }
        this.secondaryEffect = secondaryEffect;
    }

    public StatusMove(String name,String description, int power, int accuracy, SecondaryEffect secondaryEffect, ValidStats statToChange, int changeAmount) {
        super(name,description, power, accuracy, MoveCategory.STATUS);
        this.secondaryEffect = secondaryEffect;
        this.statToChange = statToChange;
        setChangeAmount(changeAmount);
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

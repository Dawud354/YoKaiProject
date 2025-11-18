package com.github.Dawud354.Items;
import java.util.Map;

import com.github.Dawud354.YoKaiCode.ValidStats;

/**
 * Equipment class is used to store equipment items for the yo kai
 * @see BaseItem
 * @author dawud
 * @version 1.0
 * @since 30/11/2024
 */
public class Equipment extends BaseItem {
    private final ValidStats stat;
    private final int amount;

    /**
     * Constructor for Equipment
     * @param name name of the equipment
     * @param statModifiers the stat modifiers of the equipment
     * @param description description of the equipment
     */
    public Equipment(String name, ValidStats stat, int amount, String description) {
        super(name, description);
        this.stat = stat;
        this.amount = amount;
    }

    /**
     * @return the name of the equipment
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nDescription: " + getDescription() + "\nStat: " + stat + "\nAmount: " + amount;
    }

    /**
     * @return the stat modifiers of the equipment
     */
    public ValidStats getStatType() {
        return stat;
    }

    /**
     * @return the amount of the stat modifier
     */
    public int getAmount() {
        return amount;
    }
}
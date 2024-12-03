package Items;
import YoKaiCode.ValidStats;

import java.util.Map;

/**
 * Equipment class is used to store equipment items for the yo kai
 * @see BaseItem
 * @author dawud
 * @version 1.0
 * @since 30/11/2024
 */
public class Equipment extends BaseItem {
    private Map<ValidStats, Integer> statModifiers;

    /**
     * Constructor for Equipment
     * @param name name of the equipment
     * @param statModifiers the stat modifiers of the equipment
     * @param description description of the equipment
     */
    public Equipment(String name, Map<ValidStats, Integer> statModifiers, String description) {
        super(name, description);
        setStatModifiers(statModifiers);
    }

    /**
     * @return the name of the equipment
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nDescription: " + getDescription() + "\nStat Modifiers: " + statModifiers;
    }

    /**
     * Set the stat modifiers of the equipment. Stat modifiers cannot be null or empty.
     * @param statModifiers the stat modifiers to set
     * @throws IllegalArgumentException if statModifiers is null or empty
     */
    public void setStatModifiers(Map<ValidStats, Integer> statModifiers) {
        if (statModifiers == null|| statModifiers.isEmpty()) {
            throw new IllegalArgumentException("Stat modifiers cannot be null or empty.");
        }
        this.statModifiers = statModifiers;
    }

    /**
     * @return the stat modifiers of the equipment
     */
    public Map<ValidStats, Integer> getStatModifiers() {
        return statModifiers;
    }
}

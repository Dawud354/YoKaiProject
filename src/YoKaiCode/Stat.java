package YoKaiCode;

/**
 * Represents a simple stat that has a base value and a temporary modifier.
 * The final value of the stat is the sum of the base value and the temporary modifier.
 * @author dawud
 * @version 1.1
 * @since 01/12/2024
 */
public class Stat {
    private int baseValue;
    private transient int temporaryModifier; // For buffs or debuffs
    private static int  MAX_VALUE = 999;

    /**
     * Constructor for the class.
     * @param initialValue the initial value of the stat
     * @throws IllegalArgumentException if the initial value is negative
     */
    public Stat(int initialValue) {
        if (initialValue < 0) {
            throw new IllegalArgumentException("YoKaiCode.Stat value cannot be negative.");
        }
        this.baseValue = initialValue;
        this.temporaryModifier = 0;
    } // END YoKaiCode.Stat

    /**
     * Get the final value of the stat. Returns 0 is the stat is negative.
     * @return the final value of the stat
     */
    public int getValue() {
        int value = baseValue + temporaryModifier;
        if (value < 0) {
            value = 0;
        }
        if (value > MAX_VALUE) {
            value = MAX_VALUE;
        }
        return value;
    } // END getValue

    /**
     * Set the base value of the stat.
     * @param value the new base value
     * @throws IllegalArgumentException if the value is negative
     */
    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("YoKaiCode.Stat value cannot be negative.");
        }
        baseValue = value;
    } // END setValue

    /**
     * Increase the base value of the stat by a certain amount.
     * @param amount the amount to increase by
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void increase(int amount) {
        if (amount > 0) {
            baseValue += amount;
        } else {
            throw new IllegalArgumentException("Increase amount must be positive.");
        }
    } // END increase

    /**
     * Decrease the base value of the stat by a certain amount.
     * @param amount the amount to decrease by
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void decrease(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Decrease amount must be positive.");
        }
        baseValue -= amount;
        if (baseValue < 0) {
            baseValue = 0; // Prevent the stat from dropping below 0
        }
    } // END decrease

    /**
     * sets amount to temporarily modify the stat by
     * @param modifier amount to modify the stat by
     */
    public void setTemporaryModifier(int modifier) {
        temporaryModifier = modifier;
    } // END setTemporaryModifier

    /**
     * clears the temporary modifier
     */
    public void clearModifier() {
        temporaryModifier = 0;
    } // END clearModifier
}

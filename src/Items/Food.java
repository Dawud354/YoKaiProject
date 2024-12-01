package Items;
import GeneralMethods.BaseTextProgram;
/**
 * This is the food class for my project
 * @author dawud
 * @version 1.0
 * @since 13/11/2024
 */
public class Food extends BaseItem {

    private int healingPoints;
    public FoodTypes foodType;

    /**
     * @since 1.0
     * Constructor
     * @param name the name of the food
     * @param healingPoints how much healing power it gives
     * @param foodType what food type it belongs to
     * @param description description of the food for player to see
     */
    public Food(String name, int healingPoints, FoodTypes foodType, String description) {
        super(name, description);
        setHealingPoints(healingPoints);
        setFoodType(foodType);
    } // end Items.Food

    /**
     * @since 1.0
     * @return healingPoints
     */
    public int getHealingPoints() {
        return healingPoints;
    } // end getHealingPoints

    /**
     * @since 1.0
     * sets how much hp food should give. Only allows values between 1 and 999
     * Defaults to 0 if not in range
     * @param healingPoints this is how much hp the food should give when fed
     */
    public void setHealingPoints(int healingPoints) {
        if (healingPoints > 0 && healingPoints <= 999) {
            this.healingPoints = healingPoints;
        }
        else {
            BaseTextProgram.print("Healing points must be between 1 and 999. Defaulting to 0");
            this.healingPoints = 0;
        }
    } // end setHealingPoints

    /**
     * @since 1.0
     * Returns what food type the object is
     * @return what type of food the object is
     */
    public FoodTypes getFoodType() {
        return foodType;
    } // end getFoodType

    /**
     * @since 1.0
     * @return a string representation of the food object
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nDescription: " + getDescription() + "\nHealing Points: " + healingPoints + "\nFood Type: " + foodType;
    } // end toString

    /**
     * @since 1.0
     * Checks if the food type passed in is a valid type before setting
     * @throws IllegalArgumentException if foodType is null
     * @param foodType type of food
     */
    public void setFoodType(FoodTypes foodType) {
        if (foodType == null ) {
            throw new IllegalArgumentException("Items.Food type cannot be null");
        }
        this.foodType = foodType;
    } // end setFoodType




} // end Items.Food

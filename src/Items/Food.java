package Items;
import GeneralMethods.BaseTextProgram;
/**
 * This is the food class for my project
 * @author dawud
 * @version 1.0
 * @since 13/11/2024
 */
public class Food extends BaseTextProgram {

    private String name;
    private int healingPoints;
    private String description;
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
        setName(name);
        setHealingPoints(healingPoints);
        setFoodType(foodType);
        setDescription(description);
    } // end Items.Food

    /**
     * @since 1.0
     * @return name of food
     */
    public String getName() {
        return name;
    } // end getName

    /**
     * Set the name of the food. Checks if it is alphanumeric
     * @throws IllegalArgumentException if name is not alphanumeric
     * @since 1.0
     * @param name new name of food
     */
    public void setName(String name) {
        if (!BaseTextProgram.isAlphanumeric(name)) {
            throw new IllegalArgumentException("Name must be alphanumeric");
        }
        this.name = name;
    } // end setName

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

    public String getFoodTypeString() {
        return foodType.toString();
    }

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

    /**
     * @since 1.0
     * @return description of the food for the user
     */
    public String getDescription() {
        return description;
    } // end getDescription

    /**
     * @since 1.0
     * Checks if the parameter is alphanumeric and less than 200 characters
     * @throws IllegalArgumentException if not in range
     * @param description description of the food
     */
    public void setDescription(String description) {
        if (!BaseTextProgram.isAlphanumeric(description) && description.length() > 200) {
            throw new IllegalArgumentException("Description must be alphanumeric and less than 200 characters");
        }
        this.description = description;
    } // end setDescription

} // end Items.Food

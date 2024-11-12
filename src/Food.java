/**
 * This is the food class for my project
 * @author dawud
 * @version 1.0
 */
public class Food extends BaseTextProgram {

    private String name;
    private int healingPoints;
    private String foodType;
    private String description;
    // need coding at later stage
    private String secondaryEffects;
    private int secondaryEffectPoints;
    public int test;
    /**
     *
     * @param name the name of the food
     * @param healingPoints how much healing power it gives
     * @param foodType what food type it belongs to
     * @param description description of the food for player to see
     * @since 1.0
     */
    public Food(String name, int healingPoints, String foodType, String description) {
        setName(name);
        setHealingPoints(healingPoints);
        setFoodType(foodType);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isAlphanumeric(name)) {
            this.name = name;
        }
        this.name = name;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getSecondaryEffects() {
        return secondaryEffects;
    }

    public void setSecondaryEffects(String secondaryEffects) {
        this.secondaryEffects = secondaryEffects;
    }

    public int getSecondaryEffectPoints() {
        return secondaryEffectPoints;
    }

    public void setSecondaryEffectPoints(int secondaryEffectPoints) {
        this.secondaryEffectPoints = secondaryEffectPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


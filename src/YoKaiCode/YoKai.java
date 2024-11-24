package YoKaiCode;

import Items.Food;
import Items.FoodTypes;
import GeneralMethods.BaseTextProgram;
/**
 * This is the Yo Kai class for my program
 * @author dawud
 * @version 1.1
 * @since 16/11/2024
 */
public class YoKai extends BaseTextProgram {
    private String name;
    private FoodTypes favouriteFoodType;
    private FoodTypes dislikedFoodType;
    private YoKaiTribes tribe;
    private final HealthStat health;
    private final Stat strength;
    private final Stat spirit;
    private final Stat speed;
    private final Stat defence;
    private final Stat friendshipValue;
    private final FoodPreferences foodPreferences;

    /**
     * @param name              name of the Yo Kai
     * @param maxHP             max hp of Yo Kai
     * @param currentHP         how much hp Yo Kai has, must be less than or equal to  maxHP
     * @param strength          how much hit power Yo Kai has
     * @param favouriteFoodType what type of food it likes
     * @param dislikedFoodType  what type of food it dislikes
     * @since 1.0
     * Constructor for the class
     */
    YoKai(String name, int maxHP, int currentHP, int strength, int spirit, int speed, int defence, int friendshipValue, FoodTypes favouriteFoodType, FoodTypes dislikedFoodType, YoKaiTribes tribe) {
        setName(name);
        health = new HealthStat(maxHP, currentHP);
        this.strength = new Stat(strength);
        this.spirit = new Stat(spirit);
        this.speed = new Stat(speed);
        this.defence = new Stat(defence);
        this.friendshipValue = new Stat(friendshipValue);
        foodPreferences = new FoodPreferences(favouriteFoodType, dislikedFoodType);
        setTribe(tribe);

    } // END YoKaiCode.YoKai

    /**
     * @param name new name of Yo Kai
     * @since 1.0
     * Set the name of the Yo Kai. Checks if it is alphanumeric
     */
    private void setName(String name) {
        if (BaseTextProgram.isAlphanumeric(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be alphanumeric");
        }
    } // END setName

    /**
     * @return name of Yo Kai
     * @since 1.0
     */
    public String getName() {
        return name;
    } // END getName


    /**
     * @return Yo Kai as a string
     * @since 1.0
     * Returns name, likes food and disliked food
     */
    @Override
    public String toString() {
        String text = "My name is " + this.name + " and I am from the "+tribe+" tribe.I like to eat: " + foodPreferences.getFavouriteFood() + " and I do not like: " + foodPreferences.getDislikedFood();
        return text;
    } // End toString


    /**
     * @param food Items.Food object to pass in
     * @throws IllegalArgumentException if food is null
     * @since 1.0
     * Changes healing amount depending on whether Yo Kai likes the food or not
     */
    public void feed(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Not a valid food type.");
        }
        int healing = food.getHealingPoints();
        if (foodPreferences.likesFood(food.getFoodType())) {
            BaseTextProgram.print(this.name + " loved that");
            healing = (int) (healing * 1.2);
        } else if (foodPreferences.dislikesFood(food.getFoodType())) {
            BaseTextProgram.print(this.name + " did not like that");
            healing = (int) (healing * 0.8);
        } else {
            BaseTextProgram.print(this.name + " found the food o.k");
        }
        health.adjustCurrentHP(healing);
    }// END Feed

    /**
     * @return what tribe the Yo Kai is in as a string
     * @since 1.0
     */
    public String getTribeAsString() {
        return tribe.toString();
    } // END getTribe

    /**
     * @return what tribe the Yo Kai is in
     * @since 1.0
     */
    public YoKaiTribes getTribe() {
        return tribe;
    } // END getTribe

    /**
     * @param tribe type of tribe
     * @since 1.0
     * Checks if the tribe passed in is a valid tribe before setting
     */
    private void setTribe(YoKaiTribes tribe) {
        if (tribe == null) {
            throw new IllegalArgumentException("Not a valid tribe.");
        }
        this.tribe = tribe;
    } // END setTribe

    /**
     * @return the current hp
     * @since 1.0
     */
    public int getHP() {
        return health.getCurrentHP();
    }// END getHP

    /**
     * @return the max hp
     * @since 1.0
     */
    public int getMaxHP() {
        return health.getMaxHP();
    }// END getMaxHP

    /**
     * @param amount the amount to adjust the health by
     * @since 1.0
     * Adjusts the health of the Yo Kai by the given amount
     */
    public void adjustHP(int amount) {
        health.adjustCurrentHP(amount);
    }

    /**
     * @param amount the amount to adjust the max health by
     * @since 1.0
     * Adjusts the max health of the Yo Kai by the given amount
     */
    public void adjustMaxHP(int amount) {
        health.adjustMaxHP(amount);
    }

    /**
     * @return the strength
     * @since 1.0
     */
    public int getStrength() {
        return strength.getValue();
    }// END getStrength

    /**
     * @param amount the amount to adjust the strength by
     * @since 1.0
     * Adjusts the strength of the Yo Kai by the given amount
     */
    public void adjustStrength(int amount) {
        strength.increase(amount);
    } // END adjustStrength

    /**
     * @return the spirit
     * @since 1.0
     */
    public int getSpirit() {
        return spirit.getValue();
    }// END getSpirit

    /**
     * @param amount the amount to adjust the spirit by
     * @since 1.0
     * Adjusts the spirit of the Yo Kai by the given amount
     */
    public void adjustSpirit(int amount) {
        spirit.increase(amount);
    } // END adjustSpirit


    /**
     * @return the speed
     * @since 1.0
     */
    public int getSpeed() {
        return speed.getValue();
    }// END getSpeed

    /**
     * @param amount the amount to adjust the speed by
     * @since 1.0
     * Adjusts the speed of the Yo Kai by the given amount
     */
    public void adjustSpeed(int amount) {
        speed.increase(amount);
    } // END adjustSpeed

    /**
     * @return the defence
     * @since 1.0
     */
    public int getDefence() {
        return defence.getValue();
    }// END getDefence

    /**
     * @param amount the amount to adjust the defence by
     * @since 1.0
     * Adjusts the defence of the Yo Kai by the given amount
     */
    public void adjustDefence(int amount) {
        defence.increase(amount);
    } // END adjustDefence


    /**
     * @return the friendship value
     * @since 1.0
     */
    public int getFriendshipValue() {
        return friendshipValue.getValue();
    }// END getFriendshipValue

    /**
     * @param amount the amount to increase the friendship value by
     * @since 1.0
     * increases the friendship value of the Yo Kai by the given amount
     */
    public void increaseFriendshipValue(int amount) {
        friendshipValue.increase(amount);
    } // END increaseFriendshipValue

    /**
     * @since 1.0
     * temporary increase in strength
     * @param amount to increase strength by
     */
    public void temporaryIncreaseStrength(int amount) {
        strength.setTemporaryModifier(amount);
    } // END temporaryIncreaseStrength

    /**
     * @since 1.0
     * temporary increase in spirit
     * @param amount to increase spirit by
     */
    public void temporaryIncreaseSpirit(int amount) {
        spirit.setTemporaryModifier(amount);
    } // END temporaryIncreaseSpirit

    /**
     * @since 1.0
     * temporary increase in speed
     * @param amount to increase speed by
     */
    public void temporaryIncreaseSpeed(int amount) {
        speed.setTemporaryModifier(amount);
    } // END temporaryIncreaseSpeed

    /**
     * @since 1.0
     * temporary increase in defence
     * @param amount to increase defence by
     */
    public void temporaryIncreaseDefence(int amount) {
        defence.setTemporaryModifier(amount);
    }// END temporaryIncreaseDefence

    /**
     * @since 1.0
     * temporary increase in friendship value
     * @param amount to increase friendship value by
     */
    public void temporaryIncreaseFriendshipValue(int amount) {
        friendshipValue.setTemporaryModifier(amount);
    } // END temporaryIncreaseFriendshipValue

    /**
     * @since 1.0
     * clears temporary modifiers
     */
    public void clearTemporaryModifiers() {
        strength.clearModifier();
        spirit.clearModifier();
        speed.clearModifier();
        defence.clearModifier();
        friendshipValue.clearModifier();
    } // END clearTemporaryModifiers

}


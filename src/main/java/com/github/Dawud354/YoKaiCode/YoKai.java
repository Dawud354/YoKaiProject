package com.github.Dawud354.YoKaiCode;

import com.github.Dawud354.Items.Food;
import com.github.Dawud354.Items.FoodTypes;
import com.github.Dawud354.GeneralMethods.BaseTextProgram;
import com.github.Dawud354.Items.Equipment;

import java.util.Map;

/**
 * This is the Yo Kai class for my program
 * @author dawud
 * @version 1.3
 * @since 03/12/2024
 */
public class YoKai extends BaseTextProgram {
    private String name;
    private YoKaiTribes tribe;
    private final HealthStat health;
    private final Stat strength;
    private final Stat spirit;
    private final Stat speed;
    private final Stat defence;
    private final Stat friendshipValue;
    private final FoodPreferences foodPreferences;
    private Equipment equipment;
    private PhysicalMove physicalMove;
    private SpecialMove specialMove;
    private SecondaryEffect statusEffect;

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
    public YoKai(String name, int maxHP, int currentHP, int strength, int spirit, int speed, int defence, int friendshipValue, FoodTypes favouriteFoodType,
                 FoodTypes dislikedFoodType, YoKaiTribes tribe, PhysicalMove physicalMove, SpecialMove specialMove) {
        setName(name);
        health = new HealthStat(maxHP, currentHP);
        this.strength = new Stat(strength);
        this.spirit = new Stat(spirit);
        this.speed = new Stat(speed);
        this.defence = new Stat(defence);
        this.friendshipValue = new Stat(friendshipValue);
        foodPreferences = new FoodPreferences(favouriteFoodType, dislikedFoodType);
        setTribe(tribe);
        setPhysicalMove(physicalMove);
        setSpecialMove(specialMove);
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
     * @return stats of yo kai
     */
    public String statsToString(){
        String text = "My name is " + this.name + " and I am from the "+tribe+" tribe.\nMy stats are:\nHP: " + health.getCurrentHP() + "/" + health.getMaxHP() + "\nStrength: " + strength.getValue() + "\nSpirit: " + spirit.getValue() + "\nSpeed: " + speed.getValue() + "\nDefence: " + defence.getValue() + "\nFriendship Value: " + friendshipValue.getValue();
        return text;
    } // End statsToString

    /**
     * @return the moves of the Yo Kai
     */
    public String movesToString(){
        String text = "My name is " + this.name + " and I am from the "+tribe+" tribe.\nMy moves are:\nPhysical Move: " + physicalMove.getName() + "\nSpecial Move: " + specialMove.getName();
        return text;
    } // End movesToString



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
     * @return the current hp as a string
     * @since 1.0
     */
    public String getHPAsString(){
        return health.getCurrentHP() + "/" + health.getMaxHP();
    } // END getHPAsString

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
     */
    public int getSpirit() {
        return spirit.getValue();
    }// END getSpirit

    /**
     * @param amount the amount to adjust the spirit by
     * Adjusts the spirit of the Yo Kai by the given amount
     */
    public void adjustSpirit(int amount) {
        spirit.increase(amount);
    } // END adjustSpirit

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed.getValue();
    }// END getSpeed

    /**
     * @param amount the amount to adjust the speed by
     * Adjusts the speed of the Yo Kai by the given amount
     */
    public void adjustSpeed(int amount) {
        speed.increase(amount);
    } // END adjustSpeed

    /**
     * @return the defence
     */
    public int getDefence() {
        return defence.getValue();
    }// END getDefence

    /**
     * @param amount the amount to adjust the defence by
     * Adjusts the defence of the Yo Kai by the given amount
     */
    public void adjustDefence(int amount) {
        defence.increase(amount);
    } // END adjustDefence


    /**
     * @return the friendship value
     */
    public int getFriendshipValue() {
        return friendshipValue.getValue();
    }// END getFriendshipValue

    /**
     * @param amount the amount to increase the friendship value by
     * increases the friendship value of the Yo Kai by the given amount
     */
    public void increaseFriendshipValue(int amount) {
        friendshipValue.increase(amount);
    } // END increaseFriendshipValue

    /**
     * temporary increase in strength
     * @param amount to increase strength by
     */
    public void temporaryIncreaseStrength(int amount) {
        strength.setTemporaryModifier(amount);
    } // END temporaryIncreaseStrength

    /**
     * temporary increase in spirit
     * @param amount to increase spirit by
     */
    public void temporaryIncreaseSpirit(int amount) {
        spirit.setTemporaryModifier(amount);
    } // END temporaryIncreaseSpirit

    /**
     * temporary increase in speed
     * @param amount to increase speed by
     */
    public void temporaryIncreaseSpeed(int amount) {
        speed.setTemporaryModifier(amount);
    } // END temporaryIncreaseSpeed

    /**
     * temporary increase in defence
     * @param amount to increase defence by
     */
    public void temporaryIncreaseDefence(int amount) {
        defence.setTemporaryModifier(amount);
    }// END temporaryIncreaseDefence

    /**
     * temporary increase in friendship value
     * @param amount to increase friendship value by
     */
    public void temporaryIncreaseFriendshipValue(int amount) {
        friendshipValue.setTemporaryModifier(amount);
    } // END temporaryIncreaseFriendshipValue

    /**
     * @since 1.1
     * clears temporary modifiers
     */
    public void clearTemporaryModifiers() {
        strength.clearModifier();
        spirit.clearModifier();
        speed.clearModifier();
        defence.clearModifier();
        friendshipValue.clearModifier();
    } // END clearTemporaryModifiers

    /**
     * @return the equipment
     */
    public Equipment getEquipment() {
        return equipment;
    } // END getEquipment

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        statChange();
    } // END setEquipment

    /**
     * @since 1.2
     * changes stats based on equipment
     */
    private void statChange() {
        if (equipment != null) {
            Map<ValidStats, Integer> statModifiers = equipment.getStatModifiers();
            // loops over the map and applies the modifiers to the stats
            for (Map.Entry<ValidStats, Integer> entry : statModifiers.entrySet()) {
                ValidStats key = entry.getKey();
                int value = entry.getValue();

                if (key == ValidStats.ALL) {
                    applyModifierToAll(value);
                } else {
                    applyModifierToStat(key, value);
                }
            }
        }
    }

    /**
     * This is to apply the modifier to the stat
     * @param stat  the stat to apply the modifier to
     * @param value the value of the modifier
     * @throws IllegalArgumentException if the stat is not valid
     */
    private void applyModifierToStat(ValidStats stat, int value) {
        switch (stat) {
            case STRENGTH:
                temporaryIncreaseStrength(value);
                break;
            case SPIRIT:
                temporaryIncreaseSpirit(value);
                break;
            case SPEED:
                temporaryIncreaseSpeed(value);
                break;
            case DEFENSE:
                temporaryIncreaseDefence(value);
                break;
            default:
                throw new IllegalArgumentException("Not a valid stat");
        }
    }

    /**
     * This is to apply the modifier to all stats
     * @param value the value of the modifier
     */
    private void applyModifierToAll(int value) {
        temporaryIncreaseStrength(value);
        temporaryIncreaseSpirit(value);
        temporaryIncreaseSpeed(value);
        temporaryIncreaseDefence(value);
        temporaryIncreaseFriendshipValue(value);
    }

    /**
     * removes equipment
     */
    public void removeEquipment() {
        this.equipment = null;
        clearTemporaryModifiers();
    } // END removeEquipment

    /**
     * @param physicalMove the physicalMove to set
     * @throws IllegalArgumentException if the physicalMove is not valid
     */
    private void setPhysicalMove(PhysicalMove physicalMove) {
        if (physicalMove == null) {
            throw new IllegalArgumentException("Not a valid physical move.");
        }
        this.physicalMove = physicalMove;
    } // END setPhysicalMove

    /**
     * @return the physicalMove
     */
    public PhysicalMove getPhysicalMove() {
        return physicalMove;
    } // END getPhysicalMove

    /**
     * @param specialMove the specialMove to set
     * @throws IllegalArgumentException if the specialMove is not valid
     */
    private void setSpecialMove(SpecialMove specialMove) {
        if (specialMove == null) {
            throw new IllegalArgumentException("Not a valid special move.");
        }
        this.specialMove = specialMove;
    } // END setSpecialMove

    /**
     * @return the specialMove
     */
    public SpecialMove getSpecialMove() {
        return specialMove;
    } // END getSpecialMove

    public boolean isMoveInMoveset(BaseMove move){
        return physicalMove.equals(move) || specialMove.equals(move);
    }

    /**
     * @return the statusEffect
     */
    public SecondaryEffect getStatusEffect() {
        return statusEffect;
    } // END getStatusEffect

    /**
     * @param statusEffect the statusEffect to set
     */
    public void setStatusEffect(SecondaryEffect statusEffect) {
        this.statusEffect = statusEffect;
    } // END setStatusEffect

    /**
     * Checks if the Yo Kai is defeated
     * @return true if the Yo Kai is defeated
     */
    public boolean isDefeated() {
        return health.getCurrentHP() <= 0;
    } // END isDefeated

    /**
     * Returns a random move
     */
    public BaseMove getRandomMove(){
        int random = BaseTextProgram.randomInt(1,2);
        if (random == 1){
            return physicalMove;
        }
        else {
            return specialMove;
        }
    } // END getRandomMove

}


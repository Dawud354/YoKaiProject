package com.github.Dawud354.YoKaiCode;

import com.github.Dawud354.Items.Equipment;

import java.util.Map;

/**
 * This is the Yo Kai class for my program
 * @author dawud
 * @version 1.3
 * @since 03/12/2024
 */
public class YoKai {
    private String name;
    private YoKaiTribes tribe;
    private Stats stats;
    private Equipment equipment;
    private PhysicalMove physicalMove;
    private SpecialMove specialMove;

    /**
     * @param name              name of the Yo Kai
     * @param maxHP             max hp of Yo Kai
     * @param currentHP         how much hp Yo Kai has, must be less than or equal to  maxHP
     * @param strength          how much hit power Yo Kai has
     * @since 1.0
     * Constructor for the class
     */
    public YoKai(String name, int maxHP, int currentHP, int strength, int spirit, int speed, int defence, int friendshipValue, YoKaiTribes tribe, PhysicalMove physicalMove, SpecialMove specialMove) {
        setName(name);
        setTribe(tribe);
        setPhysicalMove(physicalMove);
        setSpecialMove(specialMove);
        stats = new Stats(maxHP, currentHP, strength, spirit, speed, defence, friendshipValue);
    } // END YoKaiCode.YoKai

    /**
     * @param name  new name of Yo Kai
     * @since 1.0
     * Set the name of the Yo Kai. Checks if it is alphanumeric
     */
    private void setName(String name) {
        this.name = name;
        
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
        String text = "{\nName:" + name + "\nStrength: " + stats.getStrength() + "\nSpirit: " + stats.getSpirit() 
        + "\nDefence: " + stats.getDefence() + "\nSpeed: " + stats.getSpeed() + "\nHP: " + stats.getHealth() + "/" + stats.getMaxHealth()
        +"\nFriendship Value: " + stats.getFriendshipValue();
        if (equipment != null) {
            text += "\nEquipment: " + equipment.getName();
        }
        text += "\n}";
        return text;
    } // End toString

    /**
     * @return stats of yo kai
     */
    public String statsToString(){
        String text = "My name is " + this.name + " and I am from the "+tribe+" tribe.\nMy stats are:\nHP: " + stats.getHealth() + "/" + stats.getMaxHealth() + "\nStrength: " + stats.getStrength() + "\nSpirit: " + stats.getSpirit() + "\nSpeed: " + stats.getSpeed() + "\nDefence: " + stats.getDefence() + "\nFriendship Value: " + stats.getFriendshipValue();
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
        return stats.getHealth();
    }// END getHP

    /**
     * @return the max hp
     * @since 1.0
     */
    public int getMaxHP() {
        return stats.getMaxHealth();
    }// END getMaxHP

    /**
     * @param amount the amount to increase the health by
     * @since 1.0
     * Increase the health of the Yo Kai by the given amount
     */
    public void increaseHP(int amount) {
        stats.increaseHP(amount);
    }

    /**
     * @param amount the amount to decrease the health by
     * @since 1.0
     * Decrease the health of the Yo Kai by the given amount
     */
    public void decreaseHP(int amount) {
        stats.decreaseHP(amount);
    }

    /**
     * @param amount the amount to increase the max health by
     * @since 1.0
     * Increase the max health of the Yo Kai by the given amount
     */
    public void increaseMaxHP(int amount) {
        stats.increaseMaxHP(amount);
    }

    /**
     * @param amount the amount to decrease the max health by
     * @since 1.0
     * Decrease the max health of the Yo Kai by the given amount
     */
    public void decreaseMaxHP(int amount) {
        stats.decreaseMaxHP(amount);
    }

    /**
     * @return the strength
     * @since 1.0
     */
    public int getStrength() {
        return stats.getStrength();
    }// END getStrength

    /**
     * @param amount the amount to increase the strength by
     * @since 1.0
     * Increase the strength of the Yo Kai by the given amount
     */
    public void increaseStrength(int amount) {
        stats.increaseStrength(amount);
    }

    /**
     * @param amount the amount to decrease the strength by
     * @since 1.0
     * Decrease the strength of the Yo Kai by the given amount
     */
    public void decreaseStrength(int amount) {
        stats.decreaseStrength(amount);
    }

    /**
     * @return the spirit
     */
    public int getSpirit() {
        return stats.getSpirit();
    }// END getSpirit

    /**
     * @param amount the amount to increase the spirit by
     * @since 1.0
     * Increase the spirit of the Yo Kai by the given amount
     */
    public void increaseSpirit(int amount) {
        stats.increaseSpirit(amount);
    }

    /**
     * @param amount the amount to decrease the spirit by
     * @since 1.0
     * Decrease the spirit of the Yo Kai by the given amount
     */
    public void decreaseSpirit(int amount) {
        stats.decreaseSpirit(amount);
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return stats.getSpeed();
    }// END getSpeed

    /**
     * @param amount the amount to increase the speed by
     * @since 1.0
     * Increase the speed of the Yo Kai by the given amount
     */
    public void increaseSpeed(int amount) {
        stats.increaseSpeed(amount);
    }

    /**
     * @param amount the amount to decrease the speed by
     * @since 1.0
     * Decrease the speed of the Yo Kai by the given amount
     */
    public void decreaseSpeed(int amount) {
        stats.decreaseSpeed(amount);
    }

    /**
     * @return the defence
     */
    public int getDefence() {
        return stats.getDefence();
    }// END getDefence

    /**
     * @param amount the amount to increase the defence by
     * @since 1.0
     * Increase the defence of the Yo Kai by the given amount
     */
    public void increaseDefence(int amount) {
        stats.increaseDefence(amount);
    }

    /**
     * @param amount the amount to decrease the defence by
     * @since 1.0
     * Decrease the defence of the Yo Kai by the given amount
     */
    public void decreaseDefence(int amount) {
        stats.decreaseDefence(amount);
    }

    /**
     * @return the friendship value
     */
    public int getFriendshipValue() {
        return stats.getFriendshipValue();
    }// END getFriendshipValue

    /**
     * @param amount the amount to increase the friendship value by
     * @since 1.0
     * Increase the friendship value of the Yo Kai by the given amount
     */
    public void increaseFriendshipValue(int amount) {
        stats.increaseFriendshipValue(amount);
    }

    /**
     * @param amount the amount to decrease the friendship value by
     * @since 1.0
     * Decrease the friendship value of the Yo Kai by the given amount
     */
    public void decreaseFriendshipValue(int amount) {
        stats.decreaseFriendshipValue(amount);
    }

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
        applyEquipment();
    } // END setEquipment

    /**
     * removes equipment
     */
    public void removeEquipment() {
        removeEquipmentEffects();
        this.equipment = null;
    } // END removeEquipment

    /**
     * Applies the effects of the currently equipped equipment to the Yo Kai's stats.
     */
    private void applyEquipment() {
        ValidStats stat = equipment.getStatType();
        int amount = equipment.getAmount();
        switch (stat) {
            case STRENGTH -> increaseStrength(amount);
            case SPIRIT -> increaseSpirit(amount);
            case SPEED -> increaseSpeed(amount);
            case DEFENCE -> increaseDefence(amount);
            case FRIENDSHIP -> increaseFriendshipValue(amount);
            default -> throw new IllegalArgumentException("Invalid stat type");
        }
    }

    /**
     * Removes the effects of the currently equipped equipment from the Yo Kai's stats.
     */
    private void removeEquipmentEffects() {
        ValidStats stat = equipment.getStatType();
        int amount = equipment.getAmount();
        switch (stat) {
            case STRENGTH -> decreaseStrength(amount);
            case SPIRIT -> decreaseSpirit(amount);
            case SPEED -> decreaseSpeed(amount);
            case DEFENCE -> decreaseDefence(amount);
            case FRIENDSHIP -> decreaseFriendshipValue(amount);
            default -> throw new IllegalArgumentException("Invalid stat type");
        }
    }

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

    public boolean isMoveInMoveset(Move move){
        return physicalMove.equals(move) || specialMove.equals(move);
    }

    /**
     * Checks if the Yo Kai is defeated
     * @return true if the Yo Kai is defeated
     */
    public boolean isDefeated() {
        return stats.getHealth() <= 0;
    } // END isDefeated

}


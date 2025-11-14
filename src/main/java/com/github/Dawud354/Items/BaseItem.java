package com.github.Dawud354.Items;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;
/**
 * BaseInventoryItem is the base class for all items in the inventory
 * @author dawud
 * @version 1.0
 * @since 27/11/2024
 */
public abstract class BaseItem {
    private String name;
    private String description;

    /**
     * @since 1.0
     * Constructor for BaseInventoryItem
     * @param name name of the food
     * @param description description of the food
     */
    public BaseItem(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /**
     * Set the name of the food. Checks if it is alphanumeric
     * @throws IllegalArgumentException if name is not alphanumeric
     * @since 1.0
     * @param name new name of food
     */
    public void setName(String name) {
        if (!BaseTextProgram.isValidSentence(name)) {
            throw new IllegalArgumentException("Name must be alphanumeric");
        }
        this.name = name;
    } // end setName

    /**
     * @since 1.0
     * @return name of food
     */
    public String getName() {
        return name;
    } // end getName

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
        if (!BaseTextProgram.isValidSentence(description) && description.length() > 200) {
            throw new IllegalArgumentException("Description must be alphanumeric and less than 200 characters");
        }
        this.description = description;
    } // end setDescription


}

package com.github.Dawud354.Inventory;

import com.github.Dawud354.Items.BaseItem;

/**
 * InventoryItem class is used to store an item and its quantity in an inventory.
 * @author dawud
 * @version 1.0
 * @since 27/11/2024
 */
public class InventoryItem {
    private BaseItem item;
    private int quantity;
    public final int MAX_QUANTITY = 99;
    private final boolean isStackable;

    /**
     * @since 1.0
     * Constructor for InventoryItem
     * @param item the item to store
     * @param quantity the quantity of the item
     */
    public InventoryItem(BaseItem item, int quantity, boolean isStackable) {
        setItem(item);
        setQuantity(quantity);
        this.isStackable = isStackable;
    } // END InventoryItem

    /**
     * @since 1.0
     * @return the item
     */
    public BaseItem getItem() {
        return item;
    } // END getItem

    /**
     * @since 1.0
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    } // END getQuantity

    /**
     * @since 1.0
     * Set the item
     * @param item the item to set
     */
    private void setItem(BaseItem item) {
        this.item = item;
    } // END setItem

    /**
     * @since 1.0
     * Set the quantity. Quantity cannot be negative.
     * @param quantity the quantity to set
     * @throws IllegalArgumentException if quantity is negative
     * @throws IllegalArgumentException if quantity is more than 1 for non-stackable items
     */
    private void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        else if (!isStackable && quantity > 1) {
            throw new IllegalArgumentException("Quantity cannot be more than 1 for non-stackable items.");
        }
        else if (quantity > MAX_QUANTITY) {
            quantity = MAX_QUANTITY;
        }
        this.quantity = quantity;
    } // END setQuantity

    /**
     * @since 1.0
     * Increase quantity. If amount is negative, throw exception.
     * @param amount the amount to add
     * @throws IllegalArgumentException if amount is negative
     */
    public void addQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to add cannot be negative.");
        }
        this.quantity += amount;
        if (this.quantity > MAX_QUANTITY) {
            this.quantity = MAX_QUANTITY;
        }
    } // END addQuantity

    /**
     * @since 1.0
     * Decrease quantity. If amount is negative or more than available quantity, throw exception.
     * @param amount the amount to remove
     * @throws IllegalArgumentException if amount is negative
     */
    public void removeQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to remove cannot be negative.");
        }
        if (amount > this.quantity) {
            this.quantity = 0;
        }
        this.quantity -= amount;
    } // END removeQuantity

    @Override
    public String toString() {
        return "InventoryItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    } // END toString

    /**
     * @since 1.0
     * gets the value of isStackable
     * @return the value of isStackable
     */
    public boolean isStackable() {
        return isStackable;
    } // END isEmpty
}

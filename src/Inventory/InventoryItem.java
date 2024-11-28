package Inventory;

import Items.BaseItem;

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
    private boolean isEmpty = false;

    /**
     * @since 1.0
     * Constructor for InventoryItem
     * @param item the item to store
     * @param quantity the quantity of the item
     */
    public InventoryItem(BaseItem item, int quantity) {
        setItem(item);
        setQuantity(quantity);
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
     */
    private void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
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
     */
    public void removeQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to remove cannot be negative.");
        }
        if (amount > this.quantity) {
            this.quantity = 0;
            isEmpty = true;
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
     * gets the value of isEmpty
     * @return isEmpty
     */
    public boolean isEmpty() {
        return isEmpty;
    } // END isEmpty
}

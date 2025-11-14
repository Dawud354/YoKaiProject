package com.github.Dawud354.Inventory;

import com.github.Dawud354.Items.BaseItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class is used to store items in an inventory.
 * @author dawud
 * @version 1.0
 * @since 27/11/2024
 * @see InventoryItem
 */
public class Inventory {
    private static final int MAX_ITEMS = 30;
    final private List<InventoryItem> items;

    /**
     * @since 1.0
     * Constructor for Inventory
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * @since 1.0
     * Constructor for Inventory
     * @param items the list of items to store
     */
    public Inventory(List<InventoryItem> items) {
        this.items = items;
    }

    /**
     * @since 1.0
     * Add an item to the inventory
     * @param item the item to add
     * @param quantity the quantity of the item
     * @return true if the item was added, false if not added
     */
    public InventoryStatus addItem(BaseItem item, int quantity, boolean isStackable) {
        if (items.size() >= MAX_ITEMS) {
            return InventoryStatus.MAX_ITEMS_REACHED;
        }
        else if (quantity < 1) {
            return InventoryStatus.INVALID_QUANTITY;
        }
        else if (quantity > 1 && !isStackable) {
            return InventoryStatus.NON_STACKABLE_QUANTITY;
        }

        for (InventoryItem inventoryItem : items) {
            if (inventoryItem.getItem().equals(item)) {
                inventoryItem.addQuantity(quantity);
                return InventoryStatus.SUCCESS;
            }
        }

        items.add(new InventoryItem(item, quantity, isStackable));
        return InventoryStatus.SUCCESS;
    }

    /**
     * @since 1.0
     * Remove an item from the inventory
     * @param item the item to remove
     * @param quantity the quantity of the item to remove
     * @return true if the item was removed, false if the item was not found
     */
    public InventoryStatus removeItem(BaseItem item, int quantity) {
        for (InventoryItem inventoryItem : items) {
            if (inventoryItem.getItem().equals(item)) {
                // If the quantity to remove is more than the quantity in the inventory, removes all the quantity
                if (inventoryItem.getQuantity() < quantity) {
                    quantity = inventoryItem.getQuantity();
                }
                inventoryItem.removeQuantity(quantity);

                // If the quantity becomes 0, remove the item from the list
                if (inventoryItem.getQuantity() == 0) {
                    items.remove(inventoryItem);
                }
                // exists the loop if found item to remove
                return InventoryStatus.SUCCESS;
            }
        }
        return InventoryStatus.ITEM_NOT_FOUND;
    }

    /**
     * @since 1.0
     * Get the quantity of an item in the inventory
     * @return the amount of items in the inventory
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * @since 1.0
     * Check if the inventory is full
     * @return true if the inventory is full
     */
    public boolean isFull() {
        return items.size() >= MAX_ITEMS;
    }

    /**
     * @since 1.0
     * List all items in the inventory with their quantities
     * @return a string representation of the inventory
     */
    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Inventory is empty.";
        }

        StringBuilder result = new StringBuilder("Inventory contents:\n");
        for (InventoryItem inventoryItem : items) {
            result.append(inventoryItem.toString()).append("\n");
        }
        return result.toString();
    }
}


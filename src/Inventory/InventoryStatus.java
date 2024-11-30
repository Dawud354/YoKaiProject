package Inventory;

/**
 * InventoryStatus enum is used to represent the status of an inventory operation.
 * @author dawud
 * @version 1.0
 * @since 28/11/2024
 */
public enum InventoryStatus {
    SUCCESS,
    MAX_ITEMS_REACHED,
    INVALID_QUANTITY,
    NON_STACKABLE_QUANTITY,
    ITEM_NOT_FOUND
}

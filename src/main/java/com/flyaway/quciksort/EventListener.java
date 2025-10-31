package com.flyaway.quicksort;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.block.Barrel;
import org.bukkit.block.ShulkerBox;
import org.bukkit.block.Hopper;
import org.bukkit.block.Dropper;
import org.bukkit.block.Dispenser;

public class EventListener implements Listener {
    private final QuickSort plugin;
    private final SortManager sortManager;

    public EventListener(QuickSort plugin, SortManager sortManager) {
        this.plugin = plugin;
        this.sortManager = sortManager;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        // Only handle player clicks
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        // Check if it's Shift+Right-Click
        if (event.getClick() != ClickType.SHIFT_RIGHT) {
            return;
        }

        // Check if clicked on empty slot (air)
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem != null && clickedItem.getType() != Material.AIR) {
            return;
        }

        // Check permission
        if (!sortManager.canSort(player)) {
            return;
        }

        // Check cooldown
        if (sortManager.isOnCooldown(player)) {
            return;
        }

        // Determine which inventory to sort
        Inventory targetInventory = null;

        // Check if clicked in player inventory
        if (event.getClickedInventory() != null &&
            event.getClickedInventory().getType() == InventoryType.PLAYER) {
            targetInventory = player.getInventory();
        }
        // Check if clicked in an allowed container
        else if (event.getClickedInventory() != null &&
                 isAllowedContainer(event.getClickedInventory())) {
            targetInventory = event.getClickedInventory();
        }

        // If no valid inventory found, return
        if (targetInventory == null) {
            return;
        }

        // Cancel the click event
        event.setCancelled(true);

        // Perform the sorting
        sortManager.sortInventory(targetInventory);
        sortManager.setCooldown(player);
        player.sendMessage("§aИнвентарь отсортирован!");
    }

    private boolean isAllowedContainer(Inventory inventory) {
        InventoryHolder holder = inventory.getHolder();

        // Разрешенные контейнеры
        if (holder instanceof Chest ||
            holder instanceof DoubleChest ||
            holder instanceof Barrel ||
            holder instanceof ShulkerBox ||
            holder instanceof Hopper ||
            holder instanceof Dropper ||
            holder instanceof Dispenser) {
            return true;
        }

        InventoryType type = inventory.getType();
        if (type == InventoryType.ENDER_CHEST
            || type == InventoryType.SHULKER_BOX) {
            return true;
        }

        return false;
    }
}

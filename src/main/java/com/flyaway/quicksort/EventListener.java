package com.flyaway.quicksort;

import org.bukkit.Material;
import org.bukkit.entity.ChestBoat;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.HopperMinecart;
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

    public EventListener(QuickSort plugin) {
        this.plugin = plugin;
        this.sortManager = plugin.getSortManager();
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (event.getClick() != ClickType.SHIFT_RIGHT) {
            return;
        }

        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem != null && clickedItem.getType() != Material.AIR) {
            return;
        }

        if (!sortManager.canSort(player)) {
            return;
        }

        if (sortManager.isOnCooldown(player)) {
            return;
        }

        Inventory targetInventory = null;

        if (event.getClickedInventory() != null &&
            event.getClickedInventory().getType() == InventoryType.PLAYER) {
            targetInventory = player.getInventory();
        }

        else if (event.getClickedInventory() != null &&
                 isAllowedContainer(event.getClickedInventory())) {
            targetInventory = event.getClickedInventory();
        }

        if (targetInventory == null) {
            return;
        }

        event.setCancelled(true);

        sortManager.sortInventory(targetInventory);
        sortManager.setCooldown(player);
        plugin.sendMessage(player, "sorted");
    }

    private boolean isAllowedContainer(Inventory inventory) {
        InventoryHolder holder = inventory.getHolder();

        if (holder instanceof Chest ||
            holder instanceof DoubleChest ||
            holder instanceof ChestedHorse ||
            holder instanceof HopperMinecart ||
            holder instanceof ChestBoat ||
            holder instanceof Barrel ||
            holder instanceof ShulkerBox ||
            holder instanceof Hopper ||
            holder instanceof Dropper ||
            holder instanceof Dispenser) {
            return true;
        }

        InventoryType type = inventory.getType();
        return type == InventoryType.ENDER_CHEST || type == InventoryType.CHEST || type == InventoryType.BARREL
                || type == InventoryType.SHULKER_BOX;
    }
}

package com.flyaway.quicksort;

import org.bukkit.plugin.java.JavaPlugin;

public class QuickSort extends JavaPlugin {
    private CategoryManager categoryManager;
    private SortManager sortManager;
    private EventListener eventListener;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.categoryManager = new CategoryManager(this);
        this.sortManager = new SortManager(this);
        this.eventListener = new EventListener(this);

        getServer().getPluginManager().registerEvents(eventListener, this);
        getCommand("quicksort").setExecutor(new SortCommand(this));
        getLogger().info("QuickSort плагин включен!");
    }

    @Override
    public void onDisable() {
        getLogger().info("QuickSort плагин выключен!");
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        if (categoryManager != null) {
            categoryManager.reload();
        }
    }

    public CategoryManager getCategoryManager() {
        return categoryManager;
    }

    public SortManager getSortManager() {
        return sortManager;
    }
}

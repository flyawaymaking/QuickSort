package com.flyaway.quicksort;

import org.bukkit.plugin.java.JavaPlugin;

public class QuickSort extends JavaPlugin {
    private CategoryManager categoryManager;
    private SortManager sortManager;
    private EventListener eventListener;

    @Override
    public void onEnable() {
        this.categoryManager = new CategoryManager();
        this.sortManager = new SortManager(this, categoryManager);
        this.eventListener = new EventListener(this, sortManager);

        getServer().getPluginManager().registerEvents(eventListener, this);
        getLogger().info("QuickSort плагин включен!");
    }

    @Override
    public void onDisable() {
        getLogger().info("QuickSort плагин выключен!");
    }

    public SortManager getSortManager() {
        return sortManager;
    }
}

package com.flyaway.quicksort;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class CategoryManager {
    private final QuickSort plugin;
    private final Map<Material, Category> itemCategories = new HashMap<>();
    private final Map<Category, List<Material>> categoryItems = new EnumMap<>(Category.class);

    public CategoryManager(QuickSort plugin) {
        this.plugin = plugin;
        loadCategoriesFromConfig();
    }

    public void reload() {
        itemCategories.clear();
        categoryItems.clear();
        loadCategoriesFromConfig();
    }

    private void loadCategoriesFromConfig() {
        FileConfiguration config = plugin.getConfig();

        for (Category category : Category.values()) {
            if (category == Category.MISCELLANEOUS) continue;

            String categoryKey = category.name().toLowerCase();
            List<String> materialNames = config.getStringList("categories." + categoryKey);
            List<Material> materials = new ArrayList<>();

            for (String materialName : materialNames) {
                try {
                    Material material = Material.valueOf(materialName.toUpperCase());
                    materials.add(material);
                    itemCategories.put(material, category);
                } catch (IllegalArgumentException e) {
                    plugin.getLogger().warning("Неизвестный материал: " + materialName + " в категории " + categoryKey);
                }
            }

            categoryItems.put(category, materials);
        }

        plugin.getLogger().info("Загружено " + itemCategories.size() + " материалов в " + categoryItems.size() + " категорий");
    }

    public Category getCategory(Material material) {
        return itemCategories.getOrDefault(material, Category.MISCELLANEOUS);
    }

    public List<Material> getToolOrder() {
        return categoryItems.getOrDefault(Category.TOOLS, new ArrayList<>());
    }

    public List<Material> getArmorOrder() {
        return categoryItems.getOrDefault(Category.ARMOR, new ArrayList<>());
    }

    public List<Material> getWeaponOrder() {
        return categoryItems.getOrDefault(Category.WEAPONS, new ArrayList<>());
    }

    public List<Material> getOreOrder() {
        return categoryItems.getOrDefault(Category.ORES, new ArrayList<>());
    }

    public List<Material> getFoodOrder() {
        return categoryItems.getOrDefault(Category.FOOD, new ArrayList<>());
    }

    public List<Material> getBlocksOrder() {
        return categoryItems.getOrDefault(Category.BLOCKS, new ArrayList<>());
    }

    public List<Material> getDecorativeBlocksOrder() {
        return categoryItems.getOrDefault(Category.DECOR, new ArrayList<>());
    }

    public List<Material> getRedstoneOrder() {
        return categoryItems.getOrDefault(Category.REDSTONE, new ArrayList<>());
    }

    public List<Material> getBrewingOrder() {
        return categoryItems.getOrDefault(Category.BREWING, new ArrayList<>());
    }

    public List<Material> getFarmingOrder() {
        return categoryItems.getOrDefault(Category.FARMING, new ArrayList<>());
    }

    public List<Material> getEnchantedBooksOrder() {
        return categoryItems.getOrDefault(Category.ENCHANTED_BOOKS, new ArrayList<>());
    }

    public List<Material> getPotionsOrder() {
        return categoryItems.getOrDefault(Category.POTIONS, new ArrayList<>());
    }
}

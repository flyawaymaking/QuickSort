package com.flyaway.quicksort;

import java.util.*;

import org.bukkit.Material;

public class CategoryManager {
    private final Map<Material, Category> itemCategories = new HashMap<>();
    private final List<Material> toolOrder = new ArrayList<>();
    private final List<Material> armorOrder = new ArrayList<>();
    private final List<Material> weaponOrder = new ArrayList<>();
    private final List<Material> oreOrder = new ArrayList<>();
    private final List<Material> foodOrder = new ArrayList<>();
    private final List<Material> blocksOrder = new ArrayList<>();
    private final List<Material> redstoneOrder = new ArrayList<>();
    private final List<Material> brewingOrder = new ArrayList<>();
    private final List<Material> farmingOrder = new ArrayList<>();
    private final List<Material> enchantedBooksOrder = new ArrayList<>();
    private final List<Material> potionsOrder = new ArrayList<>();

    public CategoryManager() {
        setupCategories();
    }

    private void setupCategories() {
        // Tools
        toolOrder.add(Material.WOODEN_PICKAXE);
        toolOrder.add(Material.WOODEN_AXE);
        toolOrder.add(Material.WOODEN_SHOVEL);
        toolOrder.add(Material.WOODEN_HOE);
        toolOrder.add(Material.STONE_PICKAXE);
        toolOrder.add(Material.STONE_AXE);
        toolOrder.add(Material.STONE_SHOVEL);
        toolOrder.add(Material.STONE_HOE);
        toolOrder.add(Material.IRON_PICKAXE);
        toolOrder.add(Material.IRON_AXE);
        toolOrder.add(Material.IRON_SHOVEL);
        toolOrder.add(Material.IRON_HOE);
        toolOrder.add(Material.GOLDEN_PICKAXE);
        toolOrder.add(Material.GOLDEN_AXE);
        toolOrder.add(Material.GOLDEN_SHOVEL);
        toolOrder.add(Material.GOLDEN_HOE);
        toolOrder.add(Material.DIAMOND_PICKAXE);
        toolOrder.add(Material.DIAMOND_AXE);
        toolOrder.add(Material.DIAMOND_SHOVEL);
        toolOrder.add(Material.DIAMOND_HOE);
        toolOrder.add(Material.NETHERITE_PICKAXE);
        toolOrder.add(Material.NETHERITE_AXE);
        toolOrder.add(Material.NETHERITE_SHOVEL);
        toolOrder.add(Material.NETHERITE_HOE);
        toolOrder.add(Material.SHEARS);
        toolOrder.add(Material.FLINT_AND_STEEL);
        toolOrder.add(Material.FISHING_ROD);

        for (Material tool : toolOrder) {
            itemCategories.put(tool, Category.TOOLS);
        }

        // Weapons
        weaponOrder.add(Material.WOODEN_SWORD);
        weaponOrder.add(Material.STONE_SWORD);
        weaponOrder.add(Material.IRON_SWORD);
        weaponOrder.add(Material.GOLDEN_SWORD);
        weaponOrder.add(Material.DIAMOND_SWORD);
        weaponOrder.add(Material.NETHERITE_SWORD);
        weaponOrder.add(Material.BOW);
        weaponOrder.add(Material.CROSSBOW);
        weaponOrder.add(Material.TRIDENT);
        weaponOrder.add(Material.SHIELD);

        for (Material weapon : weaponOrder) {
            itemCategories.put(weapon, Category.WEAPONS);
        }

        // Armor
        armorOrder.add(Material.LEATHER_HELMET);
        armorOrder.add(Material.LEATHER_CHESTPLATE);
        armorOrder.add(Material.LEATHER_LEGGINGS);
        armorOrder.add(Material.LEATHER_BOOTS);
        armorOrder.add(Material.CHAINMAIL_HELMET);
        armorOrder.add(Material.CHAINMAIL_CHESTPLATE);
        armorOrder.add(Material.CHAINMAIL_LEGGINGS);
        armorOrder.add(Material.CHAINMAIL_BOOTS);
        armorOrder.add(Material.IRON_HELMET);
        armorOrder.add(Material.IRON_CHESTPLATE);
        armorOrder.add(Material.IRON_LEGGINGS);
        armorOrder.add(Material.IRON_BOOTS);
        armorOrder.add(Material.GOLDEN_HELMET);
        armorOrder.add(Material.GOLDEN_CHESTPLATE);
        armorOrder.add(Material.GOLDEN_LEGGINGS);
        armorOrder.add(Material.GOLDEN_BOOTS);
        armorOrder.add(Material.DIAMOND_HELMET);
        armorOrder.add(Material.DIAMOND_CHESTPLATE);
        armorOrder.add(Material.DIAMOND_LEGGINGS);
        armorOrder.add(Material.DIAMOND_BOOTS);
        armorOrder.add(Material.NETHERITE_HELMET);
        armorOrder.add(Material.NETHERITE_CHESTPLATE);
        armorOrder.add(Material.NETHERITE_LEGGINGS);
        armorOrder.add(Material.NETHERITE_BOOTS);

        for (Material armor : armorOrder) {
            itemCategories.put(armor, Category.ARMOR);
        }

        // Ores
        oreOrder.add(Material.COAL_ORE);
        oreOrder.add(Material.DEEPSLATE_COAL_ORE);
        oreOrder.add(Material.COAL);
        oreOrder.add(Material.COPPER_ORE);
        oreOrder.add(Material.DEEPSLATE_COPPER_ORE);
        oreOrder.add(Material.RAW_COPPER);
        oreOrder.add(Material.COPPER_INGOT);
        oreOrder.add(Material.IRON_ORE);
        oreOrder.add(Material.DEEPSLATE_IRON_ORE);
        oreOrder.add(Material.RAW_IRON);
        oreOrder.add(Material.IRON_INGOT);
        oreOrder.add(Material.GOLD_ORE);
        oreOrder.add(Material.DEEPSLATE_GOLD_ORE);
        oreOrder.add(Material.NETHER_GOLD_ORE);
        oreOrder.add(Material.RAW_GOLD);
        oreOrder.add(Material.GOLD_INGOT);
        oreOrder.add(Material.REDSTONE_ORE);
        oreOrder.add(Material.DEEPSLATE_REDSTONE_ORE);
        oreOrder.add(Material.REDSTONE);
        oreOrder.add(Material.LAPIS_ORE);
        oreOrder.add(Material.DEEPSLATE_LAPIS_ORE);
        oreOrder.add(Material.LAPIS_LAZULI);
        oreOrder.add(Material.DIAMOND_ORE);
        oreOrder.add(Material.DEEPSLATE_DIAMOND_ORE);
        oreOrder.add(Material.DIAMOND);
        oreOrder.add(Material.EMERALD_ORE);
        oreOrder.add(Material.DEEPSLATE_EMERALD_ORE);
        oreOrder.add(Material.EMERALD);
        oreOrder.add(Material.NETHER_QUARTZ_ORE);
        oreOrder.add(Material.QUARTZ);
        oreOrder.add(Material.ANCIENT_DEBRIS);
        oreOrder.add(Material.NETHERITE_SCRAP);
        oreOrder.add(Material.NETHERITE_INGOT);

        for (Material ore : oreOrder) {
            itemCategories.put(ore, Category.ORES);
        }

        // Food
        foodOrder.add(Material.APPLE);
        foodOrder.add(Material.BAKED_POTATO);
        foodOrder.add(Material.BEEF);
        foodOrder.add(Material.BEETROOT);
        foodOrder.add(Material.BEETROOT_SOUP);
        foodOrder.add(Material.BREAD);
        foodOrder.add(Material.CARROT);
        foodOrder.add(Material.CHICKEN);
        foodOrder.add(Material.CHORUS_FRUIT);
        foodOrder.add(Material.COD);
        foodOrder.add(Material.COOKED_BEEF);
        foodOrder.add(Material.COOKED_CHICKEN);
        foodOrder.add(Material.COOKED_COD);
        foodOrder.add(Material.COOKED_MUTTON);
        foodOrder.add(Material.COOKED_PORKCHOP);
        foodOrder.add(Material.COOKED_RABBIT);
        foodOrder.add(Material.COOKED_SALMON);
        foodOrder.add(Material.COOKIE);
        foodOrder.add(Material.DRIED_KELP);
        foodOrder.add(Material.ENCHANTED_GOLDEN_APPLE);
        foodOrder.add(Material.GOLDEN_APPLE);
        foodOrder.add(Material.GOLDEN_CARROT);
        foodOrder.add(Material.HONEY_BOTTLE);
        foodOrder.add(Material.MELON_SLICE);
        foodOrder.add(Material.MUSHROOM_STEW);
        foodOrder.add(Material.MUTTON);
        foodOrder.add(Material.POISONOUS_POTATO);
        foodOrder.add(Material.PORKCHOP);
        foodOrder.add(Material.POTATO);
        foodOrder.add(Material.PUFFERFISH);
        foodOrder.add(Material.PUMPKIN_PIE);
        foodOrder.add(Material.RABBIT);
        foodOrder.add(Material.RABBIT_STEW);
        foodOrder.add(Material.ROTTEN_FLESH);
        foodOrder.add(Material.SALMON);
        foodOrder.add(Material.SPIDER_EYE);
        foodOrder.add(Material.SUSPICIOUS_STEW);
        foodOrder.add(Material.SWEET_BERRIES);
        foodOrder.add(Material.TROPICAL_FISH);

        for (Material food : foodOrder) {
            itemCategories.put(food, Category.FOOD);
        }

        // Blocks
        blocksOrder.add(Material.STONE);
        blocksOrder.add(Material.GRANITE);
        blocksOrder.add(Material.DIORITE);
        blocksOrder.add(Material.ANDESITE);
        blocksOrder.add(Material.DIRT);
        blocksOrder.add(Material.GRASS_BLOCK);
        blocksOrder.add(Material.COBBLESTONE);
        blocksOrder.add(Material.OAK_PLANKS);
        blocksOrder.add(Material.SPRUCE_PLANKS);
        blocksOrder.add(Material.BIRCH_PLANKS);
        blocksOrder.add(Material.JUNGLE_PLANKS);
        blocksOrder.add(Material.ACACIA_PLANKS);
        blocksOrder.add(Material.DARK_OAK_PLANKS);
        blocksOrder.add(Material.SAND);
        blocksOrder.add(Material.GRAVEL);
        blocksOrder.add(Material.SANDSTONE);
        blocksOrder.add(Material.GLASS);
        blocksOrder.add(Material.BRICKS);
        blocksOrder.add(Material.OBSIDIAN);
        blocksOrder.add(Material.NETHERRACK);
        blocksOrder.add(Material.SOUL_SAND);
        blocksOrder.add(Material.BASALT);
        blocksOrder.add(Material.BLACKSTONE);
        blocksOrder.add(Material.END_STONE);

        for (Material block : blocksOrder) {
            itemCategories.put(block, Category.BLOCKS);
        }

        // Redstone
        redstoneOrder.add(Material.REDSTONE_TORCH);
        redstoneOrder.add(Material.REDSTONE_BLOCK);
        redstoneOrder.add(Material.REPEATER);
        redstoneOrder.add(Material.COMPARATOR);
        redstoneOrder.add(Material.PISTON);
        redstoneOrder.add(Material.STICKY_PISTON);
        redstoneOrder.add(Material.OBSERVER);
        redstoneOrder.add(Material.HOPPER);
        redstoneOrder.add(Material.DROPPER);
        redstoneOrder.add(Material.DISPENSER);
        redstoneOrder.add(Material.NOTE_BLOCK);
        redstoneOrder.add(Material.LEVER);
        redstoneOrder.add(Material.STONE_BUTTON);
        redstoneOrder.add(Material.STONE_PRESSURE_PLATE);

        for (Material redstone : redstoneOrder) {
            itemCategories.put(redstone, Category.REDSTONE);
        }

        // Brewing
        brewingOrder.add(Material.BREWING_STAND);
        brewingOrder.add(Material.BLAZE_POWDER);
        brewingOrder.add(Material.BLAZE_ROD);
        brewingOrder.add(Material.NETHER_WART);
        brewingOrder.add(Material.GLASS_BOTTLE);
        brewingOrder.add(Material.FERMENTED_SPIDER_EYE);
        brewingOrder.add(Material.GLISTERING_MELON_SLICE);
        brewingOrder.add(Material.GOLDEN_CARROT);
        brewingOrder.add(Material.MAGMA_CREAM);
        brewingOrder.add(Material.SUGAR);
        brewingOrder.add(Material.RABBIT_FOOT);
        brewingOrder.add(Material.GLOW_BERRIES);
        brewingOrder.add(Material.PHANTOM_MEMBRANE);

        for (Material brewing : brewingOrder) {
            itemCategories.put(brewing, Category.BREWING);
        }

        // Farming
        farmingOrder.add(Material.WHEAT_SEEDS);
        farmingOrder.add(Material.WHEAT);
        farmingOrder.add(Material.BEETROOT_SEEDS);
        farmingOrder.add(Material.MELON_SEEDS);
        farmingOrder.add(Material.PUMPKIN_SEEDS);
        farmingOrder.add(Material.BONE_MEAL);
        farmingOrder.add(Material.BONE);
        farmingOrder.add(Material.EGG);
        farmingOrder.add(Material.SUGAR_CANE);
        farmingOrder.add(Material.CACTUS);

        for (Material farming : farmingOrder) {
            itemCategories.put(farming, Category.FARMING);
        }

        // EnchantedBooks
        enchantedBooksOrder.add(Material.ENCHANTED_BOOK);

        for (Material enchantedBook : enchantedBooksOrder) {
            itemCategories.put(enchantedBook, Category.ENCHANTED_BOOKS);
        }

        // Potions
        potionsOrder.add(Material.POTION);
        potionsOrder.add(Material.SPLASH_POTION);
        potionsOrder.add(Material.LINGERING_POTION);
        potionsOrder.add(Material.TIPPED_ARROW);

        for (Material potion : potionsOrder) {
            itemCategories.put(potion, Category.POTIONS);
        }
    }

    public Category getCategory(Material material) {
        return itemCategories.getOrDefault(material, Category.MISCELLANEOUS);
    }

    public List<Material> getToolOrder() { return toolOrder; }
    public List<Material> getArmorOrder() { return armorOrder; }
    public List<Material> getWeaponOrder() { return weaponOrder; }
    public List<Material> getOreOrder() { return oreOrder; }
    public List<Material> getFoodOrder() { return foodOrder; }
    public List<Material> getBlocksOrder() { return blocksOrder; }
    public List<Material> getRedstoneOrder() { return redstoneOrder; }
    public List<Material> getBrewingOrder() { return brewingOrder; }
    public List<Material> getFarmingOrder() { return farmingOrder; }
    public List<Material> getEnchantedBooksOrder() { return enchantedBooksOrder; }
    public List<Material> getPotionsOrder() { return potionsOrder; }
}

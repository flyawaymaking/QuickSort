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
    private final List<Material> decorativeBlocksOrder = new ArrayList<>();
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
        toolOrder.add(Material.BUCKET);
        toolOrder.add(Material.WATER_BUCKET);
        toolOrder.add(Material.LAVA_BUCKET);
        toolOrder.add(Material.MILK_BUCKET);
        toolOrder.add(Material.POWDER_SNOW_BUCKET);
        toolOrder.add(Material.AXOLOTL_BUCKET);
        toolOrder.add(Material.TROPICAL_FISH_BUCKET);
        toolOrder.add(Material.SALMON_BUCKET);
        toolOrder.add(Material.COD_BUCKET);
        toolOrder.add(Material.PUFFERFISH_BUCKET);

        toolOrder.add(Material.BRUSH);
        toolOrder.add(Material.NAME_TAG);
        toolOrder.add(Material.LEAD);
        toolOrder.add(Material.BUNDLE);
        toolOrder.add(Material.SADDLE);
        toolOrder.add(Material.FIREWORK_ROCKET);
        toolOrder.add(Material.GOAT_HORN);
        toolOrder.add(Material.COMPASS);
        toolOrder.add(Material.RECOVERY_COMPASS);
        toolOrder.add(Material.CLOCK);
        toolOrder.add(Material.SPYGLASS);

        toolOrder.add(Material.OAK_BOAT);
        toolOrder.add(Material.SPRUCE_BOAT);
        toolOrder.add(Material.BIRCH_BOAT);
        toolOrder.add(Material.JUNGLE_BOAT);
        toolOrder.add(Material.ACACIA_BOAT);
        toolOrder.add(Material.DARK_OAK_BOAT);
        toolOrder.add(Material.MANGROVE_BOAT);
        toolOrder.add(Material.CHERRY_BOAT);
        toolOrder.add(Material.BAMBOO_RAFT);
        toolOrder.add(Material.PALE_OAK_BOAT);
        toolOrder.add(Material.OAK_CHEST_BOAT);
        toolOrder.add(Material.SPRUCE_CHEST_BOAT);
        toolOrder.add(Material.BIRCH_CHEST_BOAT);
        toolOrder.add(Material.JUNGLE_CHEST_BOAT);
        toolOrder.add(Material.ACACIA_CHEST_BOAT);
        toolOrder.add(Material.DARK_OAK_CHEST_BOAT);
        toolOrder.add(Material.MANGROVE_CHEST_BOAT);
        toolOrder.add(Material.CHERRY_CHEST_BOAT);
        toolOrder.add(Material.BAMBOO_CHEST_RAFT);
        toolOrder.add(Material.PALE_OAK_CHEST_BOAT);

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
        weaponOrder.add(Material.ARROW);
        weaponOrder.add(Material.TIPPED_ARROW);
        weaponOrder.add(Material.SPECTRAL_ARROW);
        weaponOrder.add(Material.WIND_CHARGE);
        weaponOrder.add(Material.SHIELD);
        weaponOrder.add(Material.WOODEN_SWORD);
        weaponOrder.add(Material.STONE_SWORD);
        weaponOrder.add(Material.IRON_SWORD);
        weaponOrder.add(Material.GOLDEN_SWORD);
        weaponOrder.add(Material.DIAMOND_SWORD);
        weaponOrder.add(Material.NETHERITE_SWORD);
        weaponOrder.add(Material.BOW);
        weaponOrder.add(Material.CROSSBOW);
        weaponOrder.add(Material.MACE);
        weaponOrder.add(Material.TRIDENT);
        weaponOrder.add(Material.TOTEM_OF_UNDYING);

        for (Material weapon : weaponOrder) {
            itemCategories.put(weapon, Category.WEAPONS);
        }

        // Armor
        armorOrder.add(Material.LEATHER_HORSE_ARMOR);
        armorOrder.add(Material.IRON_HORSE_ARMOR);
        armorOrder.add(Material.GOLDEN_HORSE_ARMOR);
        armorOrder.add(Material.DIAMOND_HORSE_ARMOR);
        armorOrder.add(Material.WOLF_ARMOR);
        armorOrder.add(Material.TURTLE_HELMET);
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
        armorOrder.add(Material.ELYTRA);

        for (Material armor : armorOrder) {
            itemCategories.put(armor, Category.ARMOR);
        }

        // Ores
        oreOrder.add(Material.LEATHER);
        oreOrder.add(Material.SHULKER_SHELL);
        oreOrder.add(Material.NETHER_QUARTZ_ORE);
        oreOrder.add(Material.QUARTZ);
        oreOrder.add(Material.REDSTONE_ORE);
        oreOrder.add(Material.DEEPSLATE_REDSTONE_ORE);
        oreOrder.add(Material.REDSTONE);
        oreOrder.add(Material.REDSTONE_BLOCK);
        oreOrder.add(Material.LAPIS_ORE);
        oreOrder.add(Material.DEEPSLATE_LAPIS_ORE);
        oreOrder.add(Material.LAPIS_LAZULI);
        oreOrder.add(Material.LAPIS_BLOCK);
        oreOrder.add(Material.COAL_ORE);
        oreOrder.add(Material.DEEPSLATE_COAL_ORE);
        oreOrder.add(Material.CHARCOAL);
        oreOrder.add(Material.COAL);
        oreOrder.add(Material.COAL_BLOCK);
        oreOrder.add(Material.COPPER_ORE);
        oreOrder.add(Material.DEEPSLATE_COPPER_ORE);
        oreOrder.add(Material.RAW_COPPER);
        oreOrder.add(Material.COPPER_INGOT);
        oreOrder.add(Material.COPPER_BLOCK);
        oreOrder.add(Material.IRON_ORE);
        oreOrder.add(Material.DEEPSLATE_IRON_ORE);
        oreOrder.add(Material.RAW_IRON);
        oreOrder.add(Material.IRON_NUGGET);
        oreOrder.add(Material.IRON_INGOT);
        oreOrder.add(Material.IRON_BLOCK);
        oreOrder.add(Material.GOLD_ORE);
        oreOrder.add(Material.DEEPSLATE_GOLD_ORE);
        oreOrder.add(Material.NETHER_GOLD_ORE);
        oreOrder.add(Material.RAW_GOLD);
        oreOrder.add(Material.GOLD_NUGGET);
        oreOrder.add(Material.GOLD_INGOT);
        oreOrder.add(Material.GOLD_BLOCK);
        oreOrder.add(Material.DIAMOND_ORE);
        oreOrder.add(Material.DEEPSLATE_DIAMOND_ORE);
        oreOrder.add(Material.DIAMOND);
        oreOrder.add(Material.DIAMOND_BLOCK);
        oreOrder.add(Material.EMERALD_ORE);
        oreOrder.add(Material.DEEPSLATE_EMERALD_ORE);
        oreOrder.add(Material.EMERALD);
        oreOrder.add(Material.EMERALD_BLOCK);
        oreOrder.add(Material.ANCIENT_DEBRIS);
        oreOrder.add(Material.NETHERITE_SCRAP);
        oreOrder.add(Material.NETHERITE_INGOT);
        oreOrder.add(Material.NETHERITE_BLOCK);

        for (Material ore : oreOrder) {
            itemCategories.put(ore, Category.ORES);
        }

        // Food
        foodOrder.add(Material.PUFFERFISH);          // 1 голод (яд)
        foodOrder.add(Material.SPIDER_EYE);          // 2 голода (яд)
        foodOrder.add(Material.POISONOUS_POTATO);    // 2.5 голода (и яд)
        foodOrder.add(Material.ROTTEN_FLESH);        // 4 голода (яд)
        foodOrder.add(Material.DRIED_KELP);          // 1 голод
        foodOrder.add(Material.TROPICAL_FISH);       // 1 голод
        foodOrder.add(Material.POTATO);              // 1 голод
        foodOrder.add(Material.BEETROOT);            // 1 голод
        foodOrder.add(Material.CHICKEN);             // 2 голода (сырая, шанс отравления)
        foodOrder.add(Material.MELON_SLICE);         // 2 голода
        foodOrder.add(Material.SWEET_BERRIES);       // 2 голода
        foodOrder.add(Material.GLOW_BERRIES);        // 2 голода
        foodOrder.add(Material.COOKIE);              // 2 голода
        foodOrder.add(Material.COD);                 // 2 голода
        foodOrder.add(Material.SALMON);              // 2 голода
        foodOrder.add(Material.MUTTON);              // 2 голода
        foodOrder.add(Material.RABBIT);              // 3 голода
        foodOrder.add(Material.BEEF);                // 3 голода
        foodOrder.add(Material.CARROT);              // 3 голода
        foodOrder.add(Material.PORKCHOP);            // 3 голода
        foodOrder.add(Material.APPLE);               // 4 голода
        foodOrder.add(Material.BREAD);               // 5 голода
        foodOrder.add(Material.BAKED_POTATO);        // 5 голода
        foodOrder.add(Material.COOKED_COD);          // 5 голода
        foodOrder.add(Material.COOKED_RABBIT);       // 5 голода
        foodOrder.add(Material.COOKED_SALMON);       // 6 голода
        foodOrder.add(Material.COOKED_CHICKEN);      // 6 голода
        foodOrder.add(Material.COOKED_MUTTON);       // 6 голода
        foodOrder.add(Material.MUSHROOM_STEW);       // 6 голода
        foodOrder.add(Material.BEETROOT_SOUP);       // 6 голода
        foodOrder.add(Material.SUSPICIOUS_STEW);     // зависит от варианта, средне 6 голода
        foodOrder.add(Material.PUMPKIN_PIE);         // 8 голода
        foodOrder.add(Material.COOKED_PORKCHOP);     // 8 голода
        foodOrder.add(Material.COOKED_BEEF);         // 8 голода
        foodOrder.add(Material.RABBIT_STEW);         // 10 голода
        foodOrder.add(Material.CAKE);                // 14 кусочков = 2×7 = 14 голода суммарно

        foodOrder.add(Material.HONEY_BOTTLE);        // 6 голода, снимает яд
        foodOrder.add(Material.CHORUS_FRUIT);        // 4 голода + телепорт
        foodOrder.add(Material.GOLDEN_CARROT);       // 6 голода + высокая насыщенность
        foodOrder.add(Material.GOLDEN_APPLE);        // 4 голода + эффекты
        foodOrder.add(Material.ENCHANTED_GOLDEN_APPLE); // 4 голода + сильные эффекты


        for (Material food : foodOrder) {
            itemCategories.put(food, Category.FOOD);
        }

        // Blocks
        blocksOrder.add(Material.STONE);
        blocksOrder.add(Material.DIORITE);
        blocksOrder.add(Material.GRANITE);
        blocksOrder.add(Material.ANDESITE);
        blocksOrder.add(Material.COBBLESTONE);
        blocksOrder.add(Material.SMOOTH_STONE);
        blocksOrder.add(Material.DIRT);
        blocksOrder.add(Material.GRASS_BLOCK);
        blocksOrder.add(Material.COARSE_DIRT);
        blocksOrder.add(Material.PODZOL);
        blocksOrder.add(Material.MYCELIUM);
        blocksOrder.add(Material.SAND);
        blocksOrder.add(Material.RED_SAND);
        blocksOrder.add(Material.GRAVEL);
        blocksOrder.add(Material.SANDSTONE);
        blocksOrder.add(Material.CUT_SANDSTONE);
        blocksOrder.add(Material.CHISELED_SANDSTONE);
        blocksOrder.add(Material.SNOW_BLOCK);
        blocksOrder.add(Material.ICE);
        blocksOrder.add(Material.PACKED_ICE);
        blocksOrder.add(Material.BLUE_ICE);
        blocksOrder.add(Material.CLAY);
        blocksOrder.add(Material.STONE_BRICKS);
        blocksOrder.add(Material.CRACKED_STONE_BRICKS);
        blocksOrder.add(Material.MOSSY_STONE_BRICKS);
        blocksOrder.add(Material.CHISELED_STONE_BRICKS);
        blocksOrder.add(Material.BRICKS);
        blocksOrder.add(Material.OBSIDIAN);
        blocksOrder.add(Material.NETHERRACK);
        blocksOrder.add(Material.SOUL_SAND);
        blocksOrder.add(Material.SOUL_SOIL);
        blocksOrder.add(Material.BASALT);
        blocksOrder.add(Material.POLISHED_BASALT);
        blocksOrder.add(Material.BLACKSTONE);
        blocksOrder.add(Material.POLISHED_BLACKSTONE);
        blocksOrder.add(Material.POLISHED_BLACKSTONE_BRICKS);
        blocksOrder.add(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        blocksOrder.add(Material.CHISELED_POLISHED_BLACKSTONE);
        blocksOrder.add(Material.END_STONE);

        for (Material block : blocksOrder) {
            itemCategories.put(block, Category.BLOCKS);
        }

        // Decor
        decorativeBlocksOrder.add(Material.OAK_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_OAK_LOG);
        decorativeBlocksOrder.add(Material.OAK_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_OAK_WOOD);
        decorativeBlocksOrder.add(Material.SPRUCE_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_SPRUCE_LOG);
        decorativeBlocksOrder.add(Material.SPRUCE_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_SPRUCE_WOOD);
        decorativeBlocksOrder.add(Material.BIRCH_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_BIRCH_LOG);
        decorativeBlocksOrder.add(Material.BIRCH_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_BIRCH_WOOD);
        decorativeBlocksOrder.add(Material.JUNGLE_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_JUNGLE_LOG);
        decorativeBlocksOrder.add(Material.JUNGLE_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_JUNGLE_WOOD);
        decorativeBlocksOrder.add(Material.ACACIA_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_ACACIA_LOG);
        decorativeBlocksOrder.add(Material.ACACIA_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_ACACIA_WOOD);
        decorativeBlocksOrder.add(Material.DARK_OAK_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_DARK_OAK_LOG);
        decorativeBlocksOrder.add(Material.DARK_OAK_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_DARK_OAK_WOOD);
        decorativeBlocksOrder.add(Material.MANGROVE_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_MANGROVE_LOG);
        decorativeBlocksOrder.add(Material.MANGROVE_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_MANGROVE_WOOD);
        decorativeBlocksOrder.add(Material.CHERRY_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_CHERRY_LOG);
        decorativeBlocksOrder.add(Material.CHERRY_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_CHERRY_WOOD);
        decorativeBlocksOrder.add(Material.BAMBOO_BLOCK);
        decorativeBlocksOrder.add(Material.STRIPPED_BAMBOO_BLOCK);
        decorativeBlocksOrder.add(Material.CRIMSON_STEM);
        decorativeBlocksOrder.add(Material.STRIPPED_CRIMSON_STEM);
        decorativeBlocksOrder.add(Material.CRIMSON_HYPHAE);
        decorativeBlocksOrder.add(Material.STRIPPED_CRIMSON_HYPHAE);
        decorativeBlocksOrder.add(Material.WARPED_STEM);
        decorativeBlocksOrder.add(Material.STRIPPED_WARPED_STEM);
        decorativeBlocksOrder.add(Material.WARPED_HYPHAE);
        decorativeBlocksOrder.add(Material.STRIPPED_WARPED_HYPHAE);
        decorativeBlocksOrder.add(Material.PALE_OAK_LOG);
        decorativeBlocksOrder.add(Material.STRIPPED_PALE_OAK_LOG);
        decorativeBlocksOrder.add(Material.PALE_OAK_WOOD);
        decorativeBlocksOrder.add(Material.STRIPPED_PALE_OAK_WOOD);
        decorativeBlocksOrder.add(Material.OAK_LEAVES);
        decorativeBlocksOrder.add(Material.SPRUCE_LEAVES);
        decorativeBlocksOrder.add(Material.BIRCH_LEAVES);
        decorativeBlocksOrder.add(Material.JUNGLE_LEAVES);
        decorativeBlocksOrder.add(Material.ACACIA_LEAVES);
        decorativeBlocksOrder.add(Material.DARK_OAK_LEAVES);
        decorativeBlocksOrder.add(Material.MANGROVE_LEAVES);
        decorativeBlocksOrder.add(Material.CHERRY_LEAVES);
        decorativeBlocksOrder.add(Material.AZALEA_LEAVES);
        decorativeBlocksOrder.add(Material.FLOWERING_AZALEA_LEAVES);
        decorativeBlocksOrder.add(Material.OAK_PLANKS);
        decorativeBlocksOrder.add(Material.SPRUCE_PLANKS);
        decorativeBlocksOrder.add(Material.BIRCH_PLANKS);
        decorativeBlocksOrder.add(Material.JUNGLE_PLANKS);
        decorativeBlocksOrder.add(Material.ACACIA_PLANKS);
        decorativeBlocksOrder.add(Material.DARK_OAK_PLANKS);
        decorativeBlocksOrder.add(Material.MANGROVE_PLANKS);
        decorativeBlocksOrder.add(Material.CHERRY_PLANKS);
        decorativeBlocksOrder.add(Material.BAMBOO_PLANKS);
        decorativeBlocksOrder.add(Material.CRIMSON_PLANKS);
        decorativeBlocksOrder.add(Material.WARPED_PLANKS);
        decorativeBlocksOrder.add(Material.CRAFTING_TABLE);
        decorativeBlocksOrder.add(Material.LADDER);
        decorativeBlocksOrder.add(Material.OAK_FENCE);
        decorativeBlocksOrder.add(Material.SPRUCE_FENCE);
        decorativeBlocksOrder.add(Material.BIRCH_FENCE);
        decorativeBlocksOrder.add(Material.JUNGLE_FENCE);
        decorativeBlocksOrder.add(Material.ACACIA_FENCE);
        decorativeBlocksOrder.add(Material.DARK_OAK_FENCE);
        decorativeBlocksOrder.add(Material.MANGROVE_FENCE);
        decorativeBlocksOrder.add(Material.CHERRY_FENCE);
        decorativeBlocksOrder.add(Material.BAMBOO_FENCE);
        decorativeBlocksOrder.add(Material.CRIMSON_FENCE);
        decorativeBlocksOrder.add(Material.WARPED_FENCE);
        decorativeBlocksOrder.add(Material.OAK_FENCE_GATE);
        decorativeBlocksOrder.add(Material.SPRUCE_FENCE_GATE);
        decorativeBlocksOrder.add(Material.BIRCH_FENCE_GATE);
        decorativeBlocksOrder.add(Material.JUNGLE_FENCE_GATE);
        decorativeBlocksOrder.add(Material.ACACIA_FENCE_GATE);
        decorativeBlocksOrder.add(Material.DARK_OAK_FENCE_GATE);
        decorativeBlocksOrder.add(Material.MANGROVE_FENCE_GATE);
        decorativeBlocksOrder.add(Material.CHERRY_FENCE_GATE);
        decorativeBlocksOrder.add(Material.BAMBOO_FENCE_GATE);
        decorativeBlocksOrder.add(Material.CRIMSON_FENCE_GATE);
        decorativeBlocksOrder.add(Material.WARPED_FENCE_GATE);
        decorativeBlocksOrder.add(Material.OAK_STAIRS);
        decorativeBlocksOrder.add(Material.SPRUCE_STAIRS);
        decorativeBlocksOrder.add(Material.BIRCH_STAIRS);
        decorativeBlocksOrder.add(Material.JUNGLE_STAIRS);
        decorativeBlocksOrder.add(Material.ACACIA_STAIRS);
        decorativeBlocksOrder.add(Material.DARK_OAK_STAIRS);
        decorativeBlocksOrder.add(Material.MANGROVE_STAIRS);
        decorativeBlocksOrder.add(Material.CHERRY_STAIRS);
        decorativeBlocksOrder.add(Material.BAMBOO_STAIRS);
        decorativeBlocksOrder.add(Material.CRIMSON_STAIRS);
        decorativeBlocksOrder.add(Material.WARPED_STAIRS);
        decorativeBlocksOrder.add(Material.STONE_BRICK_STAIRS);
        decorativeBlocksOrder.add(Material.COBBLESTONE_STAIRS);
        decorativeBlocksOrder.add(Material.SANDSTONE_STAIRS);
        decorativeBlocksOrder.add(Material.BRICK_STAIRS);
        decorativeBlocksOrder.add(Material.NETHER_BRICK_STAIRS);
        decorativeBlocksOrder.add(Material.POLISHED_BLACKSTONE_STAIRS);
        decorativeBlocksOrder.add(Material.OAK_SLAB);
        decorativeBlocksOrder.add(Material.SPRUCE_SLAB);
        decorativeBlocksOrder.add(Material.BIRCH_SLAB);
        decorativeBlocksOrder.add(Material.JUNGLE_SLAB);
        decorativeBlocksOrder.add(Material.ACACIA_SLAB);
        decorativeBlocksOrder.add(Material.DARK_OAK_SLAB);
        decorativeBlocksOrder.add(Material.MANGROVE_SLAB);
        decorativeBlocksOrder.add(Material.CHERRY_SLAB);
        decorativeBlocksOrder.add(Material.BAMBOO_SLAB);
        decorativeBlocksOrder.add(Material.CRIMSON_SLAB);
        decorativeBlocksOrder.add(Material.WARPED_SLAB);
        decorativeBlocksOrder.add(Material.STONE_BRICK_SLAB);
        decorativeBlocksOrder.add(Material.COBBLESTONE_SLAB);
        decorativeBlocksOrder.add(Material.SANDSTONE_SLAB);
        decorativeBlocksOrder.add(Material.BRICK_SLAB);
        decorativeBlocksOrder.add(Material.NETHER_BRICK_SLAB);
        decorativeBlocksOrder.add(Material.POLISHED_BLACKSTONE_SLAB);
        decorativeBlocksOrder.add(Material.CAMPFIRE);
        decorativeBlocksOrder.add(Material.SOUL_CAMPFIRE);
        decorativeBlocksOrder.add(Material.LANTERN);
        decorativeBlocksOrder.add(Material.SOUL_LANTERN);
        decorativeBlocksOrder.add(Material.BOOKSHELF);
        decorativeBlocksOrder.add(Material.BARREL);
        decorativeBlocksOrder.add(Material.SMOKER);
        decorativeBlocksOrder.add(Material.BLAST_FURNACE);
        decorativeBlocksOrder.add(Material.FLETCHING_TABLE);
        decorativeBlocksOrder.add(Material.LOOM);
        decorativeBlocksOrder.add(Material.CAULDRON);
        decorativeBlocksOrder.add(Material.WATER_CAULDRON);
        decorativeBlocksOrder.add(Material.LAVA_CAULDRON);
        decorativeBlocksOrder.add(Material.POWDER_SNOW_CAULDRON);
        decorativeBlocksOrder.add(Material.BELL);
        decorativeBlocksOrder.add(Material.ITEM_FRAME);
        decorativeBlocksOrder.add(Material.PAINTING);
        decorativeBlocksOrder.add(Material.CHEST);
        decorativeBlocksOrder.add(Material.TRAPPED_CHEST);
        decorativeBlocksOrder.add(Material.ENDER_CHEST);
        decorativeBlocksOrder.add(Material.SHULKER_BOX);
        decorativeBlocksOrder.add(Material.WHITE_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.ORANGE_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.MAGENTA_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.LIGHT_BLUE_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.YELLOW_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.LIME_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.PINK_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.GRAY_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.LIGHT_GRAY_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.CYAN_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.PURPLE_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.BLUE_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.BROWN_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.GREEN_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.RED_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.BLACK_SHULKER_BOX);
        decorativeBlocksOrder.add(Material.BEACON);
        decorativeBlocksOrder.add(Material.CANDLE);
        decorativeBlocksOrder.add(Material.WHITE_CANDLE);
        decorativeBlocksOrder.add(Material.ORANGE_CANDLE);
        decorativeBlocksOrder.add(Material.MAGENTA_CANDLE);
        decorativeBlocksOrder.add(Material.LIGHT_BLUE_CANDLE);
        decorativeBlocksOrder.add(Material.YELLOW_CANDLE);
        decorativeBlocksOrder.add(Material.LIME_CANDLE);
        decorativeBlocksOrder.add(Material.PINK_CANDLE);
        decorativeBlocksOrder.add(Material.GRAY_CANDLE);
        decorativeBlocksOrder.add(Material.LIGHT_GRAY_CANDLE);
        decorativeBlocksOrder.add(Material.CYAN_CANDLE);
        decorativeBlocksOrder.add(Material.PURPLE_CANDLE);
        decorativeBlocksOrder.add(Material.BLUE_CANDLE);
        decorativeBlocksOrder.add(Material.BROWN_CANDLE);
        decorativeBlocksOrder.add(Material.GREEN_CANDLE);
        decorativeBlocksOrder.add(Material.RED_CANDLE);
        decorativeBlocksOrder.add(Material.BLACK_CANDLE);
        decorativeBlocksOrder.add(Material.POTTED_ACACIA_SAPLING);
        decorativeBlocksOrder.add(Material.POTTED_BIRCH_SAPLING);
        decorativeBlocksOrder.add(Material.POTTED_DARK_OAK_SAPLING);
        decorativeBlocksOrder.add(Material.POTTED_JUNGLE_SAPLING);
        decorativeBlocksOrder.add(Material.POTTED_OAK_SAPLING);
        decorativeBlocksOrder.add(Material.POTTED_SPRUCE_SAPLING);
        decorativeBlocksOrder.add(Material.EXPOSED_COPPER);
        decorativeBlocksOrder.add(Material.WEATHERED_COPPER);
        decorativeBlocksOrder.add(Material.OXIDIZED_COPPER);
        decorativeBlocksOrder.add(Material.CUT_COPPER);
        decorativeBlocksOrder.add(Material.EXPOSED_CUT_COPPER);
        decorativeBlocksOrder.add(Material.WEATHERED_CUT_COPPER);
        decorativeBlocksOrder.add(Material.OXIDIZED_CUT_COPPER);
        decorativeBlocksOrder.add(Material.CUT_COPPER_SLAB);
        decorativeBlocksOrder.add(Material.CUT_COPPER_STAIRS);
        decorativeBlocksOrder.add(Material.GLASS);
        decorativeBlocksOrder.add(Material.WHITE_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.ORANGE_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.MAGENTA_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.LIGHT_BLUE_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.YELLOW_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.LIME_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.PINK_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.GRAY_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.LIGHT_GRAY_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.CYAN_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.PURPLE_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.BLUE_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.BROWN_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.GREEN_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.RED_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.BLACK_STAINED_GLASS);
        decorativeBlocksOrder.add(Material.SKELETON_SKULL);
        decorativeBlocksOrder.add(Material.CREEPER_HEAD);
        decorativeBlocksOrder.add(Material.PIGLIN_HEAD);
        decorativeBlocksOrder.add(Material.ZOMBIE_HEAD);
        decorativeBlocksOrder.add(Material.WITHER_SKELETON_SKULL);
        decorativeBlocksOrder.add(Material.DRAGON_HEAD);
        decorativeBlocksOrder.add(Material.PLAYER_HEAD);

        for (Material decor : decorativeBlocksOrder) {
            itemCategories.put(decor, Category.DECOR);
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
        redstoneOrder.add(Material.OAK_BUTTON);
        redstoneOrder.add(Material.SPRUCE_BUTTON);
        redstoneOrder.add(Material.BIRCH_BUTTON);
        redstoneOrder.add(Material.JUNGLE_BUTTON);
        redstoneOrder.add(Material.ACACIA_BUTTON);
        redstoneOrder.add(Material.DARK_OAK_BUTTON);
        redstoneOrder.add(Material.MANGROVE_BUTTON);
        redstoneOrder.add(Material.CHERRY_BUTTON);
        redstoneOrder.add(Material.BAMBOO_BUTTON);
        redstoneOrder.add(Material.CRIMSON_BUTTON);
        redstoneOrder.add(Material.WARPED_BUTTON);
        redstoneOrder.add(Material.POLISHED_BLACKSTONE_BUTTON);
        redstoneOrder.add(Material.STONE_PRESSURE_PLATE);
        redstoneOrder.add(Material.OAK_PRESSURE_PLATE);
        redstoneOrder.add(Material.SPRUCE_PRESSURE_PLATE);
        redstoneOrder.add(Material.BIRCH_PRESSURE_PLATE);
        redstoneOrder.add(Material.JUNGLE_PRESSURE_PLATE);
        redstoneOrder.add(Material.ACACIA_PRESSURE_PLATE);
        redstoneOrder.add(Material.DARK_OAK_PRESSURE_PLATE);
        redstoneOrder.add(Material.MANGROVE_PRESSURE_PLATE);
        redstoneOrder.add(Material.CHERRY_PRESSURE_PLATE);
        redstoneOrder.add(Material.BAMBOO_PRESSURE_PLATE);
        redstoneOrder.add(Material.CRIMSON_PRESSURE_PLATE);
        redstoneOrder.add(Material.WARPED_PRESSURE_PLATE);
        redstoneOrder.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
        redstoneOrder.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        redstoneOrder.add(Material.TRIPWIRE_HOOK);
        redstoneOrder.add(Material.TRIPWIRE);
        redstoneOrder.add(Material.TARGET);
        redstoneOrder.add(Material.DAYLIGHT_DETECTOR);
        redstoneOrder.add(Material.SCULK_SENSOR);
        redstoneOrder.add(Material.RAIL);
        redstoneOrder.add(Material.POWERED_RAIL);
        redstoneOrder.add(Material.DETECTOR_RAIL);
        redstoneOrder.add(Material.ACTIVATOR_RAIL);

        for (Material redstone : redstoneOrder) {
            itemCategories.put(redstone, Category.REDSTONE);
        }

        // Brewing
        brewingOrder.add(Material.BREWING_STAND);
        brewingOrder.add(Material.BLAZE_ROD);
        brewingOrder.add(Material.BLAZE_POWDER);
        brewingOrder.add(Material.NETHER_WART);
        brewingOrder.add(Material.GLASS_BOTTLE);
        brewingOrder.add(Material.FERMENTED_SPIDER_EYE);
        brewingOrder.add(Material.GLISTERING_MELON_SLICE);
        brewingOrder.add(Material.MAGMA_CREAM);
        brewingOrder.add(Material.SUGAR);
        brewingOrder.add(Material.RABBIT_FOOT);
        brewingOrder.add(Material.PHANTOM_MEMBRANE);
        brewingOrder.add(Material.GLOWSTONE_DUST);
        brewingOrder.add(Material.GUNPOWDER);
        brewingOrder.add(Material.DRAGON_BREATH);

        for (Material brewing : brewingOrder) {
            itemCategories.put(brewing, Category.BREWING);
        }

        // Farming
        farmingOrder.add(Material.WHEAT_SEEDS);
        farmingOrder.add(Material.WHEAT);
        farmingOrder.add(Material.HAY_BLOCK);
        farmingOrder.add(Material.BEETROOT_SEEDS);
        farmingOrder.add(Material.MELON_SEEDS);
        farmingOrder.add(Material.MELON);
        farmingOrder.add(Material.PUMPKIN_SEEDS);
        farmingOrder.add(Material.PUMPKIN);
        farmingOrder.add(Material.SUGAR_CANE);
        farmingOrder.add(Material.CACTUS);
        farmingOrder.add(Material.KELP);
        farmingOrder.add(Material.BONE);
        farmingOrder.add(Material.BONE_MEAL);
        farmingOrder.add(Material.EGG);
        farmingOrder.add(Material.BROWN_EGG);
        farmingOrder.add(Material.BLUE_EGG);
        farmingOrder.add(Material.FEATHER);

        for (Material farming : farmingOrder) {
            itemCategories.put(farming, Category.FARMING);
        }

        // EnchantedBooks
        enchantedBooksOrder.add(Material.BOOK);
        enchantedBooksOrder.add(Material.ENCHANTED_BOOK);

        for (Material enchantedBook : enchantedBooksOrder) {
            itemCategories.put(enchantedBook, Category.ENCHANTED_BOOKS);
        }

        // Potions
        potionsOrder.add(Material.POTION);
        potionsOrder.add(Material.SPLASH_POTION);
        potionsOrder.add(Material.LINGERING_POTION);
        potionsOrder.add(Material.OMINOUS_BOTTLE);
        potionsOrder.add(Material.EXPERIENCE_BOTTLE);

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
    public List<Material> getDecorativeBlocksOrder() { return decorativeBlocksOrder; }
    public List<Material> getRedstoneOrder() { return redstoneOrder; }
    public List<Material> getBrewingOrder() { return brewingOrder; }
    public List<Material> getFarmingOrder() { return farmingOrder; }
    public List<Material> getEnchantedBooksOrder() { return enchantedBooksOrder; }
    public List<Material> getPotionsOrder() { return potionsOrder; }
}

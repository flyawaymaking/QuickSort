package com.flyaway.quicksort;

import java.util.*;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class SortManager {
    private final QuickSort plugin;
    private final CategoryManager categoryManager;
    private final Map<UUID, Long> sortCooldowns = new HashMap<>();
    private static final List<Material> EMPTY_ORDER = Collections.emptyList();

    public SortManager(QuickSort plugin, CategoryManager categoryManager) {
        this.plugin = plugin;
        this.categoryManager = categoryManager;
    }

    public boolean canSort(Player player) {
        return player.hasPermission("quicksort.sort");
    }

    public boolean isOnCooldown(Player player) {
        long cooldownTime = 1000L; // 1 second cooldown
        if (cooldownTime <= 0L) {
            return false;
        }

        Long lastSort = sortCooldowns.get(player.getUniqueId());
        if (lastSort == null) {
            return false;
        }

        return System.currentTimeMillis() - lastSort < cooldownTime;
    }

    public void setCooldown(Player player) {
        sortCooldowns.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public void sortInventory(Inventory inventory) {
        if (inventory instanceof PlayerInventory) {
            sortPlayerInventory((PlayerInventory) inventory);
        } else {
            sortContainerInventory(inventory);
        }
    }

    private void sortPlayerInventory(PlayerInventory playerInventory) {
        // Sort only the top 3 rows (slots 9-35)
        ItemStack[] mainInventory = new ItemStack[27];
        for (int i = 9; i < 36; i++) {
            mainInventory[i - 9] = playerInventory.getItem(i);
        }

        // Sort the main inventory
        List<ItemStack> itemsList = new ArrayList<>();
        for (ItemStack item : mainInventory) {
            if (item != null) {
                itemsList.add(item);
            }
        }

        // Clear the main inventory slots
        for (int i = 9; i < 36; i++) {
            playerInventory.setItem(i, null);
        }

        // Sort and place back
        Map<Category, List<ItemStack>> categorizedItems = categorizeItems(itemsList);
        placeItemsInInventory(playerInventory, categorizedItems, 9);
    }

    private void sortContainerInventory(Inventory inventory) {
        ItemStack[] contents = inventory.getContents();
        List<ItemStack> itemsList = new ArrayList<>();

        for (ItemStack item : contents) {
            if (item != null) {
                itemsList.add(item);
            }
        }

        inventory.clear();
        Map<Category, List<ItemStack>> categorizedItems = categorizeItems(itemsList);
        placeItemsInInventory(inventory, categorizedItems, 0);
    }

    private void placeItemsInInventory(Inventory inventory, Map<Category, List<ItemStack>> categorizedItems, int startSlot) {
        int slot = startSlot;

        for (Category category : Category.values()) {
            List<ItemStack> categoryItems = categorizedItems.get(category);

            for (ItemStack item : categoryItems) {
                if (slot < inventory.getSize()) {
                    inventory.setItem(slot, item);
                    slot++;
                } else {
                    break;
                }
            }
        }
    }

    private Map<Category, List<ItemStack>> categorizeItems(List<ItemStack> items) {
        Map<Category, List<ItemStack>> categorizedItems = new EnumMap<>(Category.class);

        // Initialize all categories
        for (Category category : Category.values()) {
            categorizedItems.put(category, new ArrayList<>());
        }

        // Categorize items
        for (ItemStack item : items) {
            if (item != null) {
                Category category = categoryManager.getCategory(item.getType());
                categorizedItems.get(category).add(item);
            }
        }

        // Sort categories by predefined order
        sortCategoryByOrder(categorizedItems.get(Category.WEAPONS), categoryManager.getWeaponOrder());
        sortCategoryByOrder(categorizedItems.get(Category.ARMOR), categoryManager.getArmorOrder());
        sortCategoryByOrder(categorizedItems.get(Category.TOOLS), categoryManager.getToolOrder());
        sortCategoryByOrder(categorizedItems.get(Category.ORES), categoryManager.getOreOrder());
        sortCategoryByOrder(categorizedItems.get(Category.FOOD), categoryManager.getFoodOrder());
        sortCategoryByOrder(categorizedItems.get(Category.BLOCKS), categoryManager.getBlocksOrder());
        sortCategoryByOrder(categorizedItems.get(Category.REDSTONE), categoryManager.getRedstoneOrder());
        sortCategoryByOrder(categorizedItems.get(Category.BREWING), categoryManager.getBrewingOrder());
        sortCategoryByOrder(categorizedItems.get(Category.FARMING), categoryManager.getFarmingOrder());
        sortCategoryByOrder(categorizedItems.get(Category.ENCHANTED_BOOKS), categoryManager.getEnchantedBooksOrder());
        sortPotions(categorizedItems.get(Category.POTIONS), categoryManager.getPotionsOrder());
        sortCategoryByOrder(categorizedItems.get(Category.MISCELLANEOUS), EMPTY_ORDER);

        return categorizedItems;
    }

    private void sortCategoryByOrder(List<ItemStack> items, List<Material> order) {
        items.sort((item1, item2) -> {
            int index1 = order.indexOf(item1.getType());
            int index2 = order.indexOf(item2.getType());

            // Если оба предмета в порядке сортировки - сначала по порядку
            if (index1 != -1 && index2 != -1) {
                int orderCompare = Integer.compare(index2, index1);
                if (orderCompare != 0) {
                    return orderCompare;
                }
                // Если порядок одинаковый, продолжаем сравнение
            }
            // Если один в порядке, а другой нет - тот что в порядке идет первым
            else if (index1 != -1 && index2 == -1) {
                return -1;
            } else if (index1 == -1 && index2 != -1) {
                return 1;
            }
            // Если оба не в порядке или порядок одинаковый - сравниваем дальше

            // Сначала по названию
            int nameCompare = item1.getType().toString().compareTo(item2.getType().toString());
            if (nameCompare != 0) {
                return nameCompare;
            }
            // Если названия одинаковые - по количеству (убывание)
            int amountCompare = Integer.compare(item2.getAmount(), item1.getAmount());
            if (amountCompare != 0) {
                return amountCompare;
            }
            // Если количество одинаковое - по зачарованиям
            return compareByEnchantments(item1, item2);
        });
    }

    private int compareByEnchantments(ItemStack item1, ItemStack item2) {
        Map<org.bukkit.enchantments.Enchantment, Integer> enchants1 = getAllEnchantments(item1);
        Map<org.bukkit.enchantments.Enchantment, Integer> enchants2 = getAllEnchantments(item2);

        // Сначала по количеству зачарований (убывание)
        int enchantCount1 = enchants1.size();
        int enchantCount2 = enchants2.size();
        if (enchantCount1 != enchantCount2) {
            return Integer.compare(enchantCount2, enchantCount1);
        }

        // Если количество одинаковое — сравниваем по названию и уровню первого зачарования
        if (enchantCount1 > 0 && enchantCount2 > 0) {
            Map.Entry<org.bukkit.enchantments.Enchantment, Integer> enchant1 = enchants1.entrySet().iterator().next();
            Map.Entry<org.bukkit.enchantments.Enchantment, Integer> enchant2 = enchants2.entrySet().iterator().next();

            String name1 = enchant1.getKey().getKey().getKey();
            String name2 = enchant2.getKey().getKey().getKey();
            int nameCompare = name1.compareTo(name2);
            if (nameCompare != 0) {
                return nameCompare;
            }

            return Integer.compare(enchant2.getValue(), enchant1.getValue());
        }

        return 0;
    }

    /**
     * Возвращает зачарования для любого предмета, включая зачарованные книги.
     */
    private Map<org.bukkit.enchantments.Enchantment, Integer> getAllEnchantments(ItemStack item) {
        if (item == null) {
            return Collections.emptyMap();
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return Collections.emptyMap();
        }

        if (meta instanceof EnchantmentStorageMeta storageMeta) {
            return storageMeta.getStoredEnchants();
        }

        return meta.getEnchants();
    }


    private void sortPotions(List<ItemStack> potions, List<Material> order) {
        potions.sort((item1, item2) -> {
            int index1 = order.indexOf(item1.getType());
            int index2 = order.indexOf(item2.getType());

            // Если оба зелья в порядке сортировки - сначала по порядку
            if (index1 != -1 && index2 != -1) {
                int orderCompare = Integer.compare(index2, index1);
                if (orderCompare != 0) {
                    return orderCompare;
                }
                // Если порядок одинаковый, продолжаем сравнение
            }
            // Если одно в порядке, а другое нет - то что в порядке идет первым
            else if (index1 != -1 && index2 == -1) {
                return -1;
            } else if (index1 == -1 && index2 != -1) {
                return 1;
            }
            // Если оба не в порядке или порядок одинаковый - сравниваем дальше

            // Если тип одинаковый, то по названию эффекта
            String effect1 = getPotionEffectName(item1);
            String effect2 = getPotionEffectName(item2);
            int effectCompare = effect1.compareTo(effect2);
            if (effectCompare != 0) {
                return effectCompare;
            }

            // Если эффект одинаковый, то по уровню (убывание)
            int level1 = getPotionLevel(item1);
            int level2 = getPotionLevel(item2);
            int levelCompare = Integer.compare(level2, level1);
            if (levelCompare != 0) {
                return levelCompare;
            }

            // Если уровень одинаковый, то по длительности (убывание)
            int duration1 = getPotionDuration(item1);
            int duration2 = getPotionDuration(item2);
            int durationCompare = Integer.compare(duration2, duration1);
            if (durationCompare != 0) {
                return durationCompare;
            }

            // Если все одинаково, то по количеству (убывание)
            return Integer.compare(item2.getAmount(), item1.getAmount());
        });
    }

    private String getPotionEffectName(ItemStack potion) {
        if (potion.getItemMeta() instanceof org.bukkit.inventory.meta.PotionMeta) {
            org.bukkit.inventory.meta.PotionMeta meta = (org.bukkit.inventory.meta.PotionMeta) potion.getItemMeta();
            if (meta.hasCustomEffects()) {
                return meta.getCustomEffects().get(0).getType().getName();
            }
            if (meta.getBasePotionData() != null) {
                return meta.getBasePotionData().getType().name();
            }
        }
        return potion.getType().name();
    }

    private int getPotionLevel(ItemStack potion) {
        if (potion.getItemMeta() instanceof org.bukkit.inventory.meta.PotionMeta) {
            org.bukkit.inventory.meta.PotionMeta meta = (org.bukkit.inventory.meta.PotionMeta) potion.getItemMeta();
            if (meta.hasCustomEffects()) {
                return meta.getCustomEffects().get(0).getAmplifier() + 1;
            }
        }
        return 1;
    }

    private int getPotionDuration(ItemStack potion) {
        if (potion.getItemMeta() instanceof org.bukkit.inventory.meta.PotionMeta) {
            org.bukkit.inventory.meta.PotionMeta meta = (org.bukkit.inventory.meta.PotionMeta) potion.getItemMeta();
            if (meta.hasCustomEffects()) {
                return meta.getCustomEffects().get(0).getDuration();
            }
        }
        return 0;
    }
}

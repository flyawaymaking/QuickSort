package com.flyaway.quicksort;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.*;

public class ItemStackManager {

    /**
     * Объединяет список предметов в максимальные стаки
     */
    public List<ItemStack> combineStacks(List<ItemStack> items) {
        Map<ItemKey, Integer> combinedAmounts = new HashMap<>();

        // Собираем общее количество для каждого уникального предмета
        for (ItemStack item : items) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            ItemKey key = new ItemKey(item);
            combinedAmounts.merge(key, item.getAmount(), Integer::sum);
        }

        // Создаем максимальные стаки
        List<ItemStack> result = new ArrayList<>();
        for (Map.Entry<ItemKey, Integer> entry : combinedAmounts.entrySet()) {
            ItemKey key = entry.getKey();
            int totalAmount = entry.getValue();
            int maxStackSize = key.getMaxStackSize();

            while (totalAmount > 0) {
                int amount = Math.min(totalAmount, maxStackSize);
                ItemStack stack = key.createItemStack(amount);
                result.add(stack);
                totalAmount -= amount;
            }
        }

        return result;
    }

    /**
     * Объединяет массив предметов в максимальные стаки
     */
    public List<ItemStack> combineStacks(ItemStack[] items) {
        return combineStacks(Arrays.asList(items));
    }

    /**
     * Проверяет, можно ли объединить два предмета в один стак
     */
    public boolean canStack(ItemStack item1, ItemStack item2) {
        if (item1 == null || item2 == null) {
            return false;
        }

        ItemKey key1 = new ItemKey(item1);
        ItemKey key2 = new ItemStackManager.ItemKey(item2);

        return key1.equals(key2) && (item1.getAmount() + item2.getAmount() <= item1.getMaxStackSize());
    }

    /**
     * Объединяет два предмета в один стак (если возможно)
     */
    public ItemStack mergeStacks(ItemStack item1, ItemStack item2) {
        if (!canStack(item1, item2)) {
            return null;
        }

        ItemStack result = item1.clone();
        result.setAmount(item1.getAmount() + item2.getAmount());
        return result;
    }

    /**
     * Разбивает стак на несколько стаков указанного размера
     */
    public List<ItemStack> splitStack(ItemStack stack, int splitSize) {
        if (stack == null || splitSize <= 0) {
            return Collections.emptyList();
        }

        List<ItemStack> result = new ArrayList<>();
        int totalAmount = stack.getAmount();
        int maxStackSize = stack.getMaxStackSize();
        int actualSplitSize = Math.min(splitSize, maxStackSize);

        while (totalAmount > 0) {
            int amount = Math.min(totalAmount, actualSplitSize);
            ItemStack newStack = stack.clone();
            newStack.setAmount(amount);
            result.add(newStack);
            totalAmount -= amount;
        }

        return result;
    }

    /**
     * Проверяет, является ли стак полным (максимального размера)
     */
    public boolean isFullStack(ItemStack stack) {
        return stack != null && stack.getAmount() >= stack.getMaxStackSize();
    }

    /**
     * Возвращает свободное место в стаке
     */
    public int getFreeStackSpace(ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        return stack.getMaxStackSize() - stack.getAmount();
    }

    /**
     * Класс для сравнения предметов по всем характеристикам кроме количества
     */
    public static class ItemKey {
        private final Material material;
        private final ItemMeta meta;
        private final Map<org.bukkit.enchantments.Enchantment, Integer> enchantments;
        private final int maxStackSize;

        public ItemKey(ItemStack item) {
            this.material = item.getType();
            this.meta = item.getItemMeta();
            this.enchantments = getAllEnchantments(item);
            this.maxStackSize = item.getMaxStackSize();
        }

        public ItemStack createItemStack(int amount) {
            ItemStack stack = new ItemStack(material, amount);
            if (meta != null) {
                stack.setItemMeta(meta.clone());
            }
            return stack;
        }

        public int getMaxStackSize() {
            return maxStackSize;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ItemKey itemKey = (ItemKey) o;

            if (material != itemKey.material) return false;

            // Сравниваем зачарования
            if (!enchantments.equals(itemKey.enchantments)) return false;

            // Сравниваем остальные метаданные
            return Objects.equals(meta, itemKey.meta);
        }

        @Override
        public int hashCode() {
            return Objects.hash(material, enchantments, meta);
        }
    }

    /**
     * Возвращает зачарования для любого предмета, включая зачарованные книги.
     */
    public static Map<org.bukkit.enchantments.Enchantment, Integer> getAllEnchantments(ItemStack item) {
        if (item == null) {
            return Collections.emptyMap();
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return Collections.emptyMap();
        }

        if (meta instanceof EnchantmentStorageMeta storageMeta) {
            return new HashMap<>(storageMeta.getStoredEnchants());
        }

        return new HashMap<>(meta.getEnchants());
    }
}

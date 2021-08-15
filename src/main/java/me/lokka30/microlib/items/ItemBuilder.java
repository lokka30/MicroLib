/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.items;

import me.lokka30.microlib.messaging.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

/**
 * This class allows you to create an ItemStack object,
 * with as little as 1 line of code.
 *
 * @author lokka30
 * @since unknown
 */
@SuppressWarnings("unused")
public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private String displayName;
    private Material material;
    private int amount = 1;
    private int damage = 0;
    private Map<Enchantment, Integer> enchantments = new HashMap<>();
    private final List<String> lore = new ArrayList<>();
    private final List<ItemFlag> itemFlags = new ArrayList<>();

    public ItemBuilder(Material material) {
        this.material = material;
    }

    public ItemBuilder(Material material, int amount) {
        this.material = material;
        this.amount = amount;

        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.material = itemStack.getType();
        this.amount = itemStack.getAmount();

        itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        if (itemMeta.hasDisplayName()) {
            displayName = itemMeta.getDisplayName();
        }

        itemFlags.addAll(itemStack.getItemMeta().getItemFlags());

        if (itemMeta instanceof Damageable) {
            Damageable damageable = (Damageable) itemMeta;
            damage = damageable.getDamage();
        }

        if (itemMeta.hasEnchants()) {
            enchantments = itemMeta.getEnchants();
        }
    }

    /**
     * Set the amount of the ItemStack
     *
     * @param amount the amount of the item stack
     * @return ItemBuilder
     */
    public ItemBuilder withAmount(int amount) {
        this.amount = amount;
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * Set the damage of the ItemStack (how much durability is removed)
     *
     * @param damage the amount of damage
     * @return ItemBuilder
     */
    public ItemBuilder withDamage(int damage) {
        this.damage = damage;
        return this;
    }

    /**
     * Set the material of the ItemStack (aka Type)
     *
     * @param material the material
     * @return ItemBuilder
     */
    public ItemBuilder withMaterial(Material material) {
        this.material = material;
        itemStack.setType(material);
        return this;
    }

    /**
     * Set the ItemMeta of the ItemStack
     *
     * @param itemMeta the item meta
     * @return ItemBuilder
     */
    public ItemBuilder withMeta(ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add an enchant to the enchants list
     *
     * @param enchantment the enchantment
     * @param level       the level of the enchantment
     * @return ItemBuilder
     */
    public ItemBuilder withEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    /**
     * Set the enchantments of the ItemStack
     *
     * @param enchantments the enchantments map
     * @return ItemBuilder
     */
    public ItemBuilder withEnchants(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    /**
     * Set the display name of the ItemStack, it will translate color codes for you
     *
     * @param displayName the display name
     * @return ItemBuilder
     */
    public ItemBuilder withDisplayName(String displayName) {
        this.displayName = MessageUtils.colorizeAll(displayName);
        return this;
    }

    /**
     * Add a line to the lore of the ItemStack, it will translate color codes for you
     *
     * @param lore the line to add
     * @return ItemBuilder
     */
    public ItemBuilder withLore(String lore) {
        this.lore.add(MessageUtils.colorizeAll(lore));
        return this;
    }

    /**
     * Set the lore of the ItemStack, it will translate color codes for you
     *
     * @param lore the line to add
     * @return ItemBuilder
     */
    public ItemBuilder withLore(List<String> lore) {
        for (String line : lore) {
            this.lore.add(MessageUtils.colorizeAll(line));
        }
        return this;
    }

    /**
     * Set the lore of the ItemStack, it will translate color codes for you
     *
     * @param lore the line to add
     * @return ItemBuilder
     */
    public ItemBuilder withLore(String[] lore) {
        for (String line : lore) {
            this.lore.add(MessageUtils.colorizeAll(line));
        }
        return this;
    }

    /**
     * Set a specific line of the lore of the ItemStack, it will translate color codes for you
     *
     * @param lore  the line
     * @param index the line number that will be changed
     * @return ItemBuilder
     */
    public ItemBuilder withLore(String lore, int index) {
        this.lore.set(index, MessageUtils.colorizeAll(lore));
        return this;
    }

    /**
     * Add an item flag to the ItemStack
     *
     * @param itemFlag the item flag to add
     * @return ItemBuilder
     */
    public ItemBuilder withFlag(ItemFlag itemFlag) {
        itemFlags.add(itemFlag);
        return this;
    }

    /**
     * Set the item flags of the ItemStack
     *
     * @param itemFlags the item flags list
     * @return ItemBuilder
     */
    public ItemBuilder withFlags(List<ItemFlag> itemFlags) {
        this.itemFlags.addAll(itemFlags);
        return this;
    }

    /**
     * Set the item flags of the ItemStack
     *
     * @param itemFlags the item flags array
     * @return ItemBuilder
     */
    public ItemBuilder withFlags(ItemFlag[] itemFlags) {
        this.itemFlags.addAll(Arrays.asList(itemFlags));
        return this;
    }

    /**
     * Set the unbreakability state of the ItemStack
     *
     * @param isUnbreakable if the item stack should be unbreakable
     * @return ItemBuilder
     */
    public ItemBuilder setUnbreakable(boolean isUnbreakable) {
        itemMeta.setUnbreakable(isUnbreakable);
        return this;
    }

    /**
     * Make the item stack glow like it has an enchantment
     * Note: All enchantments on the item will be hidden!
     *
     * @return ItemBuilder
     */
    public ItemBuilder withGlow() {
        if (material == Material.BOW) {
            enchantments.put(Enchantment.LUCK, 1);
        } else {
            enchantments.put(Enchantment.ARROW_INFINITE, 1);
        }
        if (!itemFlags.contains(ItemFlag.HIDE_ENCHANTS)) {
            itemFlags.add(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    /**
     * Set the skull owner of the player head
     *
     * @param skullOwner the username behind the skin used on the player head
     * @return ItemBuilder
     */
    @SuppressWarnings("deprecation")
    public ItemBuilder withSkullOwner(String skullOwner) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwner(skullOwner);
        itemStack.setItemMeta(skullMeta);
        return this;
    }

    /**
     * Set the skull owner of the player head
     *
     * @param skullOwner the offline player behind the skin used on the player head
     * @return ItemBuilder
     */
    public ItemBuilder withSkullOwner(OfflinePlayer skullOwner) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwningPlayer(skullOwner);
        itemStack.setItemMeta(skullMeta);
        return this;
    }

    /**
     * Set the skull owner of the player head
     *
     * @param uuid the uuid of an offline player behind the skin used on the player head
     * @return ItemBuilder
     */
    public ItemBuilder withSkullOwner(UUID uuid) {
        return withSkullOwner(Bukkit.getOfflinePlayer(uuid));
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAmount() {
        return amount;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public int getDamage() {
        return damage;
    }

    public List<String> getLore() {
        return lore;
    }

    public ItemFlag[] getItemFlags() {
        return (ItemFlag[]) itemFlags.toArray();
    }

    public Material getMaterial() {
        return material;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    /**
     * Return the final ItemStack
     *
     * @return ItemStack
     */
    public ItemStack buildItemStack() {
        if (displayName != null) {
            itemMeta.setDisplayName(displayName);
        }
        if (!enchantments.isEmpty()) {
            itemStack.addEnchantments(enchantments);
        }
        if (itemFlags.size() != 0) {
            ItemFlag[] itemFlagsArray = (ItemFlag[]) itemFlags.toArray();
            itemMeta.addItemFlags(itemFlagsArray);
        }
        if (lore.size() != 0) {
            itemMeta.setLore(lore);
        }
        if (damage != 0 && itemStack.getItemMeta() instanceof Damageable) {
            Damageable damageable = (Damageable) itemStack.getItemMeta();
            damageable.setDamage(damage);
        }

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
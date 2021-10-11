/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.items;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author lokka30
 * @since unknown
 * This class allows you to easily create ItemStacks.
 * @see ItemStack
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ItemBuilder {

    /**
     * @since v3.1.0
     * The current ItemStack in the ItemBuilder, as
     * set in the constructor and modified thereon.
     */
    @NotNull private final ItemStack itemStack;

    /**
     * @author lokka30
     * @since v3.1.0
     * Starts off the ItemBuilder using an existing ItemStack.
     * @param itemStack to begin the ItemBuilder with.
     */
    public ItemBuilder(@NotNull final ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * Starts off the ItemBuilder with a new ItemStack of specified material.
     * @param type (Material) of the new ItemStack.
     */
    public ItemBuilder(@NotNull final Material type) {
        this.itemStack = new ItemStack(type);
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * Get the current ItemStack (the built item).
     * @return the current ItemStack.
     */
    @NotNull
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param amount to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setAmount(final int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param type (Material) to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setType(@NotNull final Material type) {
        itemStack.setType(type);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * This method is an alias of the method `setType`.
     * @param material to set on the item.
     * @return ItemBuilder
     * @see ItemBuilder#setType(Material)
     */
    @NotNull
    public ItemBuilder setMaterial(@NotNull final Material material) {
        return setType(material);
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * Replaces the existing ItemMeta of the ItemStack.
     * @param itemMeta to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setItemMeta(@NotNull final ItemMeta itemMeta) {
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param displayName to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setDisplayName(@NotNull final String displayName) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param lines of the lore to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setLore(@NotNull final List<String> lines) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.setLore(lines);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param line of the lore to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setLore(@NotNull final String line) {
        return setLore(Collections.singletonList(line));
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param lines of the lore to add on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addLore(@NotNull final List<String> lines) {
        ArrayList<String> newLore = new ArrayList<>();

        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        newLore.addAll(itemMeta.getLore());
        newLore.addAll(lines);

        itemMeta.setLore(newLore);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param line of the lore to add on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addLore(@NotNull final String line) {
        return addLore(Collections.singletonList(line));
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param damage to set on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setDamage(final int damage) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        if(!(itemMeta instanceof Damageable)) return this;

        ((Damageable) itemMeta).setDamage(damage);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param enchantmentLevelsMap to add on the item, a map of Enchantments with each of their corresponding levels.
     * @param ignoreLevelRestriction if set to 'true', levels may be higher than their maximum obtainable limits (e.g. Sharpness V).
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addEnchantments(@NotNull final HashMap<Enchantment, Integer> enchantmentLevelsMap, final boolean ignoreLevelRestriction) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        enchantmentLevelsMap.forEach(((enchantment, level) -> itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction)));

        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param enchantment to add on the item.
     * @param level of the specified enchantment.
     * @param ignoreLevelRestriction if set to 'true', the level may be higher than the enchantment's maximum obtainable limit (e.g. Sharpness V).
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addEnchantment(@NotNull final Enchantment enchantment, final int level, final boolean ignoreLevelRestriction) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);

        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param itemFlags to add on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addItemFlags(@NotNull final ItemFlag[] itemFlags) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.addItemFlags(itemFlags);

        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param itemFlags to add on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addItemFlags(@NotNull final List<ItemFlag> itemFlags) {
        return addItemFlags(itemFlags.toArray(new ItemFlag[0]));
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param itemFlag to add on the item.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder addItemFlag(@NotNull final ItemFlag itemFlag) {
        return addItemFlags(Collections.singletonList(itemFlag));
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param state whether the item should be unbreakable or not.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setUnbreakable(final boolean state) {

        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.setUnbreakable(state);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * Adds a 'glowing' effect to the item by
     * adding a useless enchantment.
     * This will hide ALL enchantments on the item,
     * even enchantments that are not applied by this method.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setGlowing() {
        Enchantment enchantment;

        if(itemStack.getType() == Material.BOW) {
            enchantment = Enchantment.LURE;
        } else {
            enchantment = Enchantment.ARROW_INFINITE;
        }

        addEnchantment(enchantment, 0, true);
        addItemFlag(ItemFlag.HIDE_ENCHANTS);

        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * @param offlinePlayer to set the skull texture of.
     * @return ItemBuilder
     */
    @NotNull
    public ItemBuilder setSkullOwner(@NotNull final OfflinePlayer offlinePlayer) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        if(!(itemMeta instanceof SkullMeta)) return this;

        ((SkullMeta) itemMeta).setOwningPlayer(offlinePlayer);
        return this;
    }

    /**
     * @author lokka30
     * @since v3.1.0
     * `setSkullOwner(OfflinePlayer)` should be used wherever possible,
     * I am unsure whether that method supports the old versions.
     * Thus, this only exists for legacy compatibility.
     * @param username to set the skull texture of.
     * @return ItemBuilder
     */
    @NotNull
    @Deprecated
    public ItemBuilder setSkullOwner(@NotNull final String username) {
        if(!itemStack.hasItemMeta()) return this;
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        if(!(itemMeta instanceof SkullMeta)) return this;

        ((SkullMeta) itemMeta).setOwner(username);
        return this;
    }

}
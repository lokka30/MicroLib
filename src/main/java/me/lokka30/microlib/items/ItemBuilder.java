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
 * ItemBuilder class allows you to easily create ItemStacks.
 *
 * @author lokka30
 * @see ItemStack
 * @since 1.0.3
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ItemBuilder {

    /**
     * The current ItemStack in the ItemBuilder, as
     * set in the constructor and modified thereon.
     *
     * @since 3.1.0
     */
    @NotNull private final ItemStack itemStack;

    /**
     * Starts off the ItemBuilder using an existing ItemStack.
     *
     * @param itemStack to begin the ItemBuilder with.
     * @since 3.1.0
     */
    public ItemBuilder(@NotNull final ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * Starts off the ItemBuilder with a new ItemStack of specified material.
     *
     * @param type (Material type) of the new ItemStack.
     * @since 3.1.0
     */
    public ItemBuilder(@NotNull final Material type) {
        this.itemStack = new ItemStack(type);
    }

    /**
     * Gets the current ItemStack (the built item).
     *
     * @return the current ItemStack.
     * @since 3.1.0
     */
    @NotNull
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * Sets amount of item stack.
     *
     * @param amount to set on the item.
     * @return the amount
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder setAmount(final int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * Sets material type to ItemStack.
     *
     * @param type (Material) to set on the item.
     * @return the type
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder setType(@NotNull final Material type) {
        itemStack.setType(type);
        return this;
    }

    /**
     * Sets material type to ItemStack.
     * This method is an alias of the method {@link #setType(Material)}.
     *
     * @param material to set on the item.
     * @return Material to set.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder setMaterial(@NotNull final Material material) {
        return setType(material);
    }

    /**
     * Replaces the existing ItemMeta of the ItemStack.
     *
     * @param itemMeta to set on the item.
     * @return The ItemMeta of this ItemStack.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder setItemMeta(@NotNull final ItemMeta itemMeta) {
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Sets display name to ItemStack.
     *
     * @param displayName to set on the item.
     * @return Display name of ItemStack.
     * @since 3.1.0
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
     * Sets lore to ItemStack.
     *
     * @param lines of the lore to set on the item.
     * @return Lore of ItemStack.
     * @since 3.1.0
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
     * Sets lore to ItemStack.
     *
     * @param line of the lore to set on the item.
     * @return Lore of ItemStack to be set.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder setLore(@NotNull final String line) {
        return setLore(Collections.singletonList(line));
    }

    /**
     * Adds lore to ItemStack.
     *
     * @param lines of the lore to add on the item.
     * @return Lore of ItemStack to be added.
     * @since 3.1.0
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
     * Adds lore to ItemStack.
     *
     * @param line of the lore to add on the item.
     * @return Lore of item.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder addLore(@NotNull final String line) {
        return addLore(Collections.singletonList(line));
    }

    /**
     * Sets damage to item in ItemStack.
     *
     * @param damage to set on the item.
     * @return Damage of item in ItemStack.
     * @since 3.1.0
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
     * Adds enchantments to item in ItemStack.
     *
     * @param enchantmentLevelsMap   to add on the item, a map of Enchantments with each of their corresponding levels.
     * @param ignoreLevelRestriction if set to 'true', levels may be higher than their maximum obtainable limits (e.g. Sharpness V).
     * @return The enchantments on item in ItemStack.
     * @since 3.1.0
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
     * Adds enchantment to item in ItemStack.
     *
     * @param enchantment            to add on the item.
     * @param level                  of the specified enchantment.
     * @param ignoreLevelRestriction if set to 'true', the level may be higher than the enchantment's maximum obtainable limit (e.g. Sharpness V).
     * @return The enchantment on item in ItemStack.
     * @since 3.1.0
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
     * Adds item flags on item in ItemStack.
     *
     * @param itemFlags to add on the item.
     * @return Item flags on item.
     * @since 3.1.0
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
     * Adds item flags on item in ItemStack.
     *
     * @param itemFlags to add on the item.
     * @return Item flags on item.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder addItemFlags(@NotNull final List<ItemFlag> itemFlags) {
        return addItemFlags(itemFlags.toArray(new ItemFlag[0]));
    }

    /**
     * Adds item flag on item in ItemStack.
     *
     * @param itemFlag to add on the item.
     * @return Item flag on item.
     * @since 3.1.0
     */
    @NotNull
    public ItemBuilder addItemFlag(@NotNull final ItemFlag itemFlag) {
        return addItemFlags(Collections.singletonList(itemFlag));
    }

    /**
     * Sets unbreakable state of item in ItemStack.
     *
     * @param state whether the item should be unbreakable or not.
     * @return the unbreakable state of item.
     * @since 3.1.0
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
     * Adds a 'glowing' effect to the item by adding a useless enchantment.
     * This will hide ALL enchantments on the item, even enchantments that are not applied by this method.
     *
     * @return the glowing
     * @since 3.1.0
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
     * Sets skull owner.
     *
     * @param offlinePlayer Offline player to set the skull texture of.
     * @return the skull owner
     * @since 3.1.0
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
     * Sets skull owner.
     *
     * @param username to set the skull texture of.
     * @return the skull owner
     * @since 3.1.0
     * @deprecated {@link #setSkullOwner(OfflinePlayer)} should be used wherever possible, this only exists for legacy compatibility.
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
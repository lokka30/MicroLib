/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.other;

import com.google.common.annotations.Beta;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;

/**
 * This class is used to check the major minecraft version of the server.
 * It does this by checking if the server accepts required blocks or
 * entities that were added in these updates.
 *
 * @author lokka30, stumper66
 * @since 2.2.0
 */
@SuppressWarnings("unused")
public class VersionUtils {

    /**
     * If possible, use one of the individual methods e.g. isOneTwelve(), since they are quicker calculations.
     *
     * @return the latest supported MajorMinecraftVersion by MicroLib. It will return UNKNOWN if the server is older than 1.6.
     * @see MajorMinecraftVersion
     * @since 2.2.0
     */
    public static MajorMinecraftVersion getMajorMinecraftVersion() {
        if (isOneNineteen()) return MajorMinecraftVersion.ONE_NINETEEN;
        if (isOneEighteen()) return MajorMinecraftVersion.ONE_EIGHTEEN;
        if (isOneSeventeen()) return MajorMinecraftVersion.ONE_SEVENTEEN;
        if (isOneSixteen()) return MajorMinecraftVersion.ONE_SIXTEEN;
        if (isOneFifteen()) return MajorMinecraftVersion.ONE_FIFTEEN;
        if (isOneFourteen()) return MajorMinecraftVersion.ONE_FOURTEEN;
        if (isOneThirteen()) return MajorMinecraftVersion.ONE_THIRTEEN;
        if (isOneTwelve()) return MajorMinecraftVersion.ONE_TWELVE;
        if (isOneEleven()) return MajorMinecraftVersion.ONE_ELEVEN;
        if (isOneTen()) return MajorMinecraftVersion.ONE_TEN;
        if (isOneNine()) return MajorMinecraftVersion.ONE_NINE;
        if (isOneEight()) return MajorMinecraftVersion.ONE_EIGHT;
        if (isOneSeven()) return MajorMinecraftVersion.ONE_SEVEN;
        if (isOneSix()) return MajorMinecraftVersion.ONE_SIX;
        return MajorMinecraftVersion.UNKNOWN;
    }

    /**
     * Checks whether the server is running on MC 1.19 or newer version.
     *
     * This works by checking if server has entity type "WARDEN"
     *
     * @return If the server is MC 1.19 or newer.
     * @since 3.1.3
     */
    @Beta
    public static boolean isOneNineteen() {
        return hasEntityType("WARDEN");
    }

    /**
     * Checks whether the server is running on MC 1.18 or newer version.
     *
     * This works by checking if server has biome called "GROVE"
     *
     * @return if the server is MC 1.18 or newer.
     * @since 2.2.4
     */
    public static boolean isOneEighteen() {
        return hasBiome("GROVE");
    }

    /**
     * Checks whether the server is running on MC 1.17 or newer version.
     *
     * This works by checking if server has entity type "AXOLOTL"
     *
     * @return if the server is MC 1.17 or newer.
     * @since 2.2.4
     */
    public static boolean isOneSeventeen() {
        return hasEntityType("AXOLOTL");
    }

    /**
     * Checks whether the server is running on MC 1.16 or newer version.
     *
     * This works by checking if server has entity type "PIGLIN"
     *
     * @return if the server is MC 1.16 or newer.
     * @since 2.2.0
     */
    public static boolean isOneSixteen() {
        return hasEntityType("PIGLIN");
    }

    /**
     * Checks whether the server is running on MC 1.15 or newer version.
     *
     * This works by checking if server has entity type "BEE"
     *
     * @return if the server is MC 1.15 or newer.
     * @since 2.2.0
     */
    public static boolean isOneFifteen() {
        return hasEntityType("BEE");
    }

    /**
     * Checks whether the server is running on MC 1.14 or newer version.
     *
     * This works by checking if server has entity type "PILLAGER"
     *
     * @return if the server is MC 1.14 or newer.
     * @since 2.2.0
     */
    public static boolean isOneFourteen() {
        return hasEntityType("PILLAGER");
    }

    /**
     * Checks whether the server is running on MC 1.13 or newer version.
     *
     * This works by checking if server has entity type "TURTLE"
     *
     * @return if the server is MC 1.13 or newer.
     * @since 2.2.0
     */
    public static boolean isOneThirteen() {
        return hasEntityType("TURTLE");
    }

    /**
     * Checks whether the server is running on MC 1.12 or newer version.
     *
     * This works by checking if server has material "WHITE_CONCRETE"
     *
     * @return if the server is MC 1.12 or newer.
     * @since 2.2.0
     */
    public static boolean isOneTwelve() {
        return hasMaterial("WHITE_CONCRETE");
    }

    /**
     * Checks whether the server is running on MC 1.11 or newer version.
     *
     * This works by checking if server has material "OBSERVER"
     *
     * @return if the server is MC 1.11 or newer.
     * @since 2.2.0
     */
    public static boolean isOneEleven() {
        return hasMaterial("OBSERVER");
    }

    /**
     * Checks whether the server is running on MC 1.10 or newer version.
     *
     * This works by checking if server has material "MAGMA_BLOCK"
     *
     * @return if the server is MC 1.10 or newer.
     * @since 2.2.0
     */
    public static boolean isOneTen() {
        return hasMaterial("MAGMA_BLOCK");
    }

    /**
     * Checks whether the server is running on MC 1.9 or newer version.
     *
     * This works by checking if server has material "END_ROD"
     *
     * @return if the server is MC 1.9 or newer.
     * @since 2.2.0
     */
    public static boolean isOneNine() {
        return hasMaterial("END_ROD");
    }

    /**
     * Checks whether the server is running on MC 1.8 or newer version.
     *
     * This works by checking if server has material "PRISMARINE"
     *
     * @return if the server is MC 1.8 or newer.
     * @since 2.2.0
     */
    public static boolean isOneEight() {
        return hasMaterial("PRISMARINE");
    }

    /**
     * Checks whether the server is running on MC 1.7 or newer version.
     *
     * This works by checking if server has material "WHITE_STAINED_GLASS"
     *
     * @return if the server is MC 1.7 or newer.
     * @since 2.2.0
     */
    public static boolean isOneSeven() {
        return hasMaterial("WHITE_STAINED_GLASS");
    }

    /**
     * Checks whether the server is running on MC 1.6 or newer version.
     *
     * This works by checking if server has entity type "HORSE"
     *
     * @return if the server is MC 1.6 or newer.
     * @since 2.2.0
     */
    public static boolean isOneSix() {
        return hasEntityType("HORSE");
    }

    /**
     * Checks whether the server is running on SpigotMC (or based) software.
     *
     * @return if the server is running SpigotMC or any SpigotMC derivative such as PaperMC, Airplane, Purpur, and so on.
     * @since 2.4.0
     */
    public static boolean isRunningSpigot() {
        try {
            Class.forName("net.md_5.bungee.api.ChatColor");
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }

    /**
     * Checks whether the server is running on PaperMC (or based) software.
     * Credit to <a href="https://www.spigotmc.org/threads/how-do-i-detect-if-a-server-is-running-paper.499064/#post-4130735">this</a> post.
     *
     * @return if the server is running PaperMC or any PaperMC derivative such as Airplane, Purpur, and so on.
     * @since 3.1.2
     */
    public static boolean isRunningPaper() {
        try {
            Class.forName("com.destroystokyo.paper.ParticleBuilder");
            return true;
        } catch(ClassNotFoundException ignored) {
            return false;
        }
    }

    /**
     * Check whether the server is running on specific version, e.g. {@code 1.16}.
     * <p>
     * Does so by simply checking if the server's version contains the specified {@code version}.
     *
     * @param version The server version to check.
     * @return True if yes, otherwise false.
     * @since 3.2.0
     */
    public static boolean isSpecific(final String version) {
        return Bukkit.getServer().getVersion().contains(version);
    }

    /**
     * Checks whether the server has entity type.
     *
     * @param entityTypeStr Type to check if exists.
     * @return If the type is valid with the current server version.
     * @see EntityType
     * @since 2.4.0
     */
    public static boolean hasEntityType(final String entityTypeStr) {
        try {
            EntityType.valueOf(entityTypeStr);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * Checks whether the server has material.
     *
     * @param materialStr Type to check if exists.
     * @return If the type is valid with the current server version.
     * @see Material
     * @since 2.4.0
     */
    public static boolean hasMaterial(final String materialStr) {
        try {
            Material.valueOf(materialStr);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * Checks whether the server has biome.
     *
     * @param biome Type to check if exists.
     * @return If the type is valid with the current server version.
     * @see Biome
     * @since 3.2.0
     */
    public static boolean hasBiome(final String biome) {
        try {
            Biome.valueOf(biome);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * This enum contains all major Minecraft versions (1.6 and newer).
     * If the server is older than 1.6 then the UNKNOWN value should be used.
     *
     * @since 2.4.0
     */
    public enum MajorMinecraftVersion {

        /**
         * Minecraft 1.19
         */
        @Beta
        ONE_NINETEEN,

        /**
         * Minecraft 1.18
         */
        ONE_EIGHTEEN,

        /**
         * Minecraft 1.17
         */
        ONE_SEVENTEEN,

        /**
         * Minecraft 1.16
         */
        ONE_SIXTEEN,

        /**
         * Minecraft 1.15
         */
        ONE_FIFTEEN,

        /**
         * Minecraft 1.14
         */
        ONE_FOURTEEN,

        /**
         * Minecraft 1.13
         */
        ONE_THIRTEEN,

        /**
         * Minecraft 1.12
         */
        ONE_TWELVE,

        /**
         * Minecraft 1.11
         */
        ONE_ELEVEN,

        /**
         * Minecraft 1.10
         */
        ONE_TEN,

        /**
         * Minecraft 1.8
         */
        ONE_NINE,

        /**
         * Minecraft 1.8
         */
        ONE_EIGHT,

        /**
         * Minecraft 1.7
         */
        ONE_SEVEN,

        /**
         * Minecraft 1.6
         */
        ONE_SIX,

        /**
         * Unknown Minecraft Verison - pre-1.6?
         */
        UNKNOWN
    }
}

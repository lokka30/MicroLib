/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.other;

import org.bukkit.Material;
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
     * @return if the server is MC 1.18 or newer.
     */
    public static boolean isOneEighteen() {
        return hasEntityType("WARDEN");
    }

    /**
     * @return if the server is MC 1.17 or newer.
     */
    public static boolean isOneSeventeen() {
        return hasEntityType("AXOLOTL");
    }

    /**
     * @return if the server is MC 1.16 or newer.
     */
    public static boolean isOneSixteen() {
        return hasEntityType("PIGLIN");
    }

    /**
     * @return if the server is MC 1.15 or newer.
     */
    public static boolean isOneFifteen() {
        return hasEntityType("BEE");
    }

    /**
     * @return if the server is MC 1.14 or newer.
     */
    public static boolean isOneFourteen() {
        return hasEntityType("PILLAGER");
    }

    /**
     * @return if the server is MC 1.13 or newer.
     */
    public static boolean isOneThirteen() {
        return hasEntityType("TURTLE");
    }

    /**
     * @return if the server is MC 1.12 or newer.
     */
    public static boolean isOneTwelve() {
        return hasMaterial("WHITE_CONCRETE");
    }

    /**
     * @return if the server is MC 1.11 or newer.
     */
    public static boolean isOneEleven() {
        return hasMaterial("OBSERVER");
    }

    /**
     * @return if the server is MC 1.10 or newer.
     */
    public static boolean isOneTen() {
        return hasMaterial("MAGMA_BLOCK");
    }

    /**
     * @return if the server is MC 1.9 or newer.
     */
    public static boolean isOneNine() {
        return hasMaterial("END_ROD");
    }

    /**
     * @return if the server is MC 1.8 or newer.
     */
    public static boolean isOneEight() {
        return hasMaterial("PRISMARINE");
    }

    /**
     * @return if the server is MC 1.7 or newer.
     */
    public static boolean isOneSeven() {
        return hasMaterial("WHITE_STAINED_GLASS");
    }

    /**
     * @return if the server is MC 1.6 or newer.
     */
    public static boolean isOneSix() {
        return hasEntityType("HORSE");
    }

    /**
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
     * @param entityTypeStr type to check
     * @return if the type is valid with the current server version
     * @see EntityType
     * @since 2.4.0
     */
    public static boolean hasEntityType(String entityTypeStr) {
        try {
            EntityType.valueOf(entityTypeStr);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * @param materialStr type to check
     * @return if the type is valid with the current server version
     * @see Material
     * @since 2.4.0
     */
    public static boolean hasMaterial(String materialStr) {
        try {
            Material.valueOf(materialStr);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    /**
     * This enum contains all major Minecraft versions (1.6 and newer).
     * If the server is older than 1.7 then the UNKNOWN value should be used.
     * @since 2.4.0
     */
    public enum MajorMinecraftVersion {
        ONE_EIGHTEEN,
        ONE_SEVENTEEN,
        ONE_SIXTEEN,
        ONE_FIFTEEN,
        ONE_FOURTEEN,
        ONE_THIRTEEN,
        ONE_TWELVE,
        ONE_ELEVEN,
        ONE_TEN,
        ONE_NINE,
        ONE_EIGHT,
        ONE_SEVEN,
        ONE_SIX,
        UNKNOWN
    }
}

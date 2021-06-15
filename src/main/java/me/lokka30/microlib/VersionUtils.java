package me.lokka30.microlib;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

/**
 * This class is used to check the major minecraft version of the server. It does this by checking if the server accepts required blocks or entities that were added in these updates.
 *
 * @author lokka30
 * @since MicroLib v2.2.0
 */
@SuppressWarnings("unused")
public class VersionUtils {

    /**
     * If possible, use one of the individual methods e.g. isOneTwelve(), since they are quicker calculations.
     *
     * @return the latest supported MajorMinecraftVersion by MicroLib. It will return UNKNOWN if the server is older than 1.6.
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
     * @return if the server is MC 1.17 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneEighteen() {
        try {
            EntityType.valueOf("WARDEN");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.17 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneSeventeen() {
        try {
            EntityType.valueOf("AXOLOTL");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.16 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneSixteen() {
        try {
            EntityType.valueOf("PIGLIN");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.15 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneFifteen() {
        try {
            EntityType.valueOf("BEE");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.14 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneFourteen() {
        try {
            EntityType.valueOf("PILLAGER");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.13 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneThirteen() {
        try {
            EntityType.valueOf("TURTLE");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.12 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneTwelve() {
        try {
            Material.valueOf("WHITE_CONCRETE");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.11 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneEleven() {
        try {
            Material.valueOf("OBSERVER");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.10 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneTen() {
        try {
            Material.valueOf("MAGMA_BLOCK");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.9 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneNine() {
        try {
            Material.valueOf("END_ROD");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.8 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneEight() {
        try {
            Material.valueOf("PRISMARINE");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.7 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneSeven() {
        try {
            Material.valueOf("WHITE_STAINED_GLASS");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * @return if the server is MC 1.6 or newer.
     */
    @SuppressWarnings("unused")
    public static boolean isOneSix() {
        try {
            EntityType.valueOf("HORSE");
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * This enum contains all major Minecraft versions (1.6 and newer).
     * If the server is older than 1.7 then the UNKNOWN value should be used.
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

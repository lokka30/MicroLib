package me.lokka30.microlib.other;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * Utility class to help with reflection & NMS.
 *
 * @author _ProfliX_
 * @version 3.1.3
 * @since 3.1.3
 */
public class Reflection {

    /**
     * Do not instantiate a utility class.
     *
     * @since 3.1.3
     */
    private Reflection() {
        throw new UnsupportedOperationException();
    }

    /**
     * Send a packet to player.
     *
     * @param player The player to which packet will be sent.
     * @param packet The packet which will be used.
     * @since 3.1.3
     */
    public static void sendPacket(final Player player, final Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception ignored) {
        }
    }

    /**
     * Gets NMS class.
     *
     * @param name The name of NMS class.
     * @return The NMS class.
     * @since 3.1.3
     */
    public static @Nullable Class<?> getNMSClass(final String name) {
        try {
            return Class.forName("net.minecraft.server" + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
        } catch (ClassNotFoundException ignored) {}
        return null;
    }
}

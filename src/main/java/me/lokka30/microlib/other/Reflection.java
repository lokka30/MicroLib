/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.other;

import com.google.common.annotations.Beta;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * Utility class to help with reflection & NMS.
 *
 * @author _ProfliX_
 * @since 3.2.0
 */
@Beta
public class Reflection {

    /**
     * Do not instantiate a utility class.
     *
     * @since 3.2.0
     */
    private Reflection() {
        throw new UnsupportedOperationException();
    }

    /**
     * Send a packet to player.
     *
     * @param player The player to which packet will be sent.
     * @param packet The packet which will be used.
     * @since 3.2.0
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
     * @since 3.2.0
     */
    public static @Nullable Class<?> getNMSClass(final String name) {
        try {
            return Class.forName("net.minecraft.server" + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
        } catch (ClassNotFoundException ignored) {}
        return null;
    }
}

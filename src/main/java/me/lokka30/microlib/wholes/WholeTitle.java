/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.wholes;

import me.lokka30.microlib.messaging.MessageUtils;
import me.lokka30.microlib.other.Reflection;
import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Objects;

/**
 * An object that makes it easier to store and send titles.
 *
 * @author lokka30
 * @version 3.2.0
 * @since 1.0.3 -ALPHA
 */
@SuppressWarnings({"unused", "deprecation"})
public class WholeTitle {

    final String title;
    final String subtitle;
    final int fadeIn;
    final int stay;
    final int fadeOut;

    /**
     * Instantiates a new whole title.
     *
     * @param title    The title to be sent.
     * @param subtitle The subtitle to be sent.
     * @param fadeIn   The fade in of title.
     * @param stay     The stay of title.
     * @param fadeOut  The fade out of title.
     * @since 1.0.3 -ALPHA
     */
    public WholeTitle(final String title, final String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = MessageUtils.colorizeAll(title);
        this.subtitle = MessageUtils.colorizeAll(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    /**
     * Sends a title to player with NMS reflection.
     *
     * @param player The player which will receive a title.
     * @since 3.1.3
     */
    public void sendWithNMS(final Player player) {
        try {
            Object chatTitle = Objects.requireNonNull(Reflection.getNMSClass("IChatBaseComponent"))
                    .getDeclaredClasses()[0]
                    .getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + title + "\"}");

            Constructor<?> titleConstructor = Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                    .getConstructor(Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                    .getDeclaredClasses()[0],
                    Reflection.getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);

            Object packet = titleConstructor.newInstance(Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                     .getDeclaredClasses()[0]
                     .getField("TITLE")
                     .get(null), chatTitle,
                    fadeIn, stay, fadeOut);

            Object chatsTitle = Objects.requireNonNull(Reflection.getNMSClass("IChatBaseComponent"))
                    .getDeclaredClasses()[0]
                    .getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + subtitle + "\"}");

            Constructor<?> stitleConstructor = Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                    .getConstructor(Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                    .getDeclaredClasses()[0],
                    Reflection.getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);

            Object spacket = stitleConstructor
                    .newInstance(Objects.requireNonNull(Reflection.getNMSClass("PacketPlayOutTitle"))
                    .getDeclaredClasses()[0]
                    .getField("SUBTITLE")
                    .get(null), chatsTitle,
                    fadeIn, stay, fadeOut);

            Reflection.sendPacket(player, packet);
            Reflection.sendPacket(player, spacket);
        } catch (Exception ignored) {}
    }

    /**
     * Sends a title to player.
     *
     * @param player The player which will receive a title.
     * @since 1.0.3 -ALPHA
     */
    public void send(final @NotNull Player player) {
        // 1.8 and possibly 1.7
        if (!VersionUtils.isOneNine()) {
            sendWithNMS(player);
            return;
        }
        // 1.9 & 1.10
        if (VersionUtils.isSpecific("1.9") || VersionUtils.isSpecific("1.10")) {
            player.sendTitle(title, subtitle);
            return;
        }
        // 1.11 +
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    /**
     * Sends a title to players.
     *
     * @param players The players which will receive a title.
     * @since 1.0.3 -ALPHA
     */
    public void send(final Player @NotNull [] players) {
        for (Player player : players) {
            send(player);
        }
    }

    /**
     * Sends a title to player.
     *
     * @param players The players which will receive a title.
     * @since 1.0.3 -ALPHA
     */
    public void send(final @NotNull List<Player> players) {
        for (Player player : players) {
            send(player);
        }
    }

    /**
     * Sends a title to all online players.
     *
     * @since 1.0.3 -ALPHA
     */
    public void sendToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(player);
        }
    }
}

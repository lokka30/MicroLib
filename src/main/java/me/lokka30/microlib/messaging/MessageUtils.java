/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.messaging;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class contains a bunch of methods which
 * make it very easy to translate color
 * codes in messages. You can colorize standard codes
 * ({@code &a, &b, &1, &2, etc}), and even hex codes ({@code &#abccdef}),
 * and also both in one method. :)
 *
 * @author lokka30, Sullivan_Bognar, imDaniX, stumper66
 * @since 2.2.0
 */
public class MessageUtils {

    /**
     * Colorize a message, using {@code &} color codes - e.g. {@code &a} for ChatColor.GREEN.
     * If the server is 1.16 or newer, then it will also translate hex codes - e.g. {@code &#abcdef}.
     *
     * If the msg parameter is null, it will return an empty string.
     *
     * @param msg the message to translate color codes from.
     * @return the color-translated message.
     * @since 2.2.0
     */
    public static @NotNull String colorizeAll(@Nullable final String msg) {
        if(msg == null || msg.isEmpty()) {
            return "";
        }

        return colorizeStandardCodes(colorizeHexCodes(msg));
    }

    /**
     * This defaults the {@code startTag} to {@code &#} and {@code endTag} to an empty string (nothing) to {@link MessageUtils#colorizeHexCodes(String, String, String)}.
     *
     * If the msg parameter is null, it will return an empty string.
     *
     * @param msg message to translate
     * @return the translated string
     * @since 2.2.0
     */
    public static String colorizeHexCodes(@Nullable final String msg) {
        if(msg == null || msg.isEmpty()) {
            return "";
        }

        return colorizeHexCodes("&#", "", msg);
    }

    /**
     * This translates all hex codes in a message. Hex codes are prefixed by {@code &#}, e.g. {@code &#abcdef}.
     * This method ensures the version is 1.16 or newer before translating - else, it will not translate the message.
     *
     * This does NOT colorize standard codes, ONLY hex codes.
     *
     * If the msg parameter is null, it will return an empty string.
     *
     * @param startTag what the tag should begin with - {@code &#} is recommended
     * @param endTag   what the tag should end with - an empty string is recommended
     * @param msg  the message that should be translated
     * @return the translated string
     * @author Elementeral and imDaniX on SpigotMC.org via <a href="https://www.spigotmc.org/threads/hex-color-code-translate.449748/#post-3867804">this</a> thread.
     * @since 2.2.0
     */
    public static String colorizeHexCodes(@NotNull final String startTag, @NotNull final String endTag, @Nullable final String msg) {
        if(msg == null || msg.isEmpty()) {
            return "";
        }

        if (!VersionUtils.isOneSixteen() || !VersionUtils.isRunningSpigot()) return msg;

        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        Matcher matcher = hexPattern.matcher(msg);
        StringBuffer buffer = new StringBuffer(msg.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }

    /**
     * This does NOT colorize hex codes, ONLY standard codes.
     * This translated all standard codes in a message.
     * Standard codes are prefixed by {@code &}, e.g. {@code &a}.
     *
     * If the msg parameter is null, it will return an empty string.
     *
     * @param msg the message to translate standard color codes from.
     * @return the color-translated message.
     * @since 2.2.0
     */
    public static @NotNull String colorizeStandardCodes(@Nullable final String msg) {
        if(msg == null || msg.isEmpty()) {
            return "";
        }

        if (Bukkit.getName().equalsIgnoreCase("CraftBukkit")) {
            return org.bukkit.ChatColor.translateAlternateColorCodes('&', msg);
        } else {
            return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', msg);
        }
    }
}

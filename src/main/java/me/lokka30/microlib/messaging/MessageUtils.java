/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.messaging;

import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

/**
 * This class contains a bunch of methods which
 * make it very easy to translate '&'-based color
 * codes in messages. You can colorize standard codes
 * (&a, &b, &1, &2, etc), and even hex codes (&#abccdef),
 * and also both in one method :)
 *
 * @author lokka30, Sullivan_Bognar, imDaniX
 * @since 2.2.0
 */
public class MessageUtils {

    /**
     * Colorize a message, using '&' color codes - e.g. '&a' for ChatColor.GREEN.
     * If the server is 1.16 or newer, then it will also translate hex codes - e.g. '&#abcdef'.
     *
     * @param msg the message to translate color codes from.
     * @return the color-translated message.
     * @since 2.2.0
     */
    public static @NotNull String colorizeAll(final String msg) {
        return colorizeStandardCodes(colorizeHexCodes(msg));
    }

    /**
     * This defaults the 'startTag' to '&#' and endTag to '' (nothing) to colorizeHexCodes.
     *
     * @param msg message to translate
     * @return the translated string
     * @since 2.2.0
     */
    public static String colorizeHexCodes(final String msg) {
        return colorizeHexCodes("&#", "", msg);
    }

    /**
     * This translates all hex codes in a message. Hex codes are prefixed by '&#', e.g. '&#abcdef'.
     * This method ensures the version is 1.16 or newer before translating - else, it will not translate the message.
     *
     * @apiNote This does NOT colorize standard codes, ONLY hex codes.
     * @param startTag what the tag should begin with - '&#' is recommended
     * @param endTag   what the tag should end with - '' (nothing) is recommended
     * @param message  the message that should be translated
     * @return the translated string
     * @author Elementeral and imDaniX on SpigotMC.org via <a href="https://www.spigotmc.org/threads/hex-color-code-translate.449748/#post-3867804">this</a> thread.
     * @since 2.2.0
     */
    public static String colorizeHexCodes(final String startTag, final String endTag, final String message) {
        if (!VersionUtils.isOneSixteen() || !VersionUtils.isRunningSpigot()) return message;

        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
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
     * This translated all standard codes in a message. Standard codes are prefixed by '&', e.g. '&a'.
     *
     * @param msg the message to translate standard color codes from.
     * @return the color-translated message.
     * @since 2.2.0
     */
    public static @NotNull String colorizeStandardCodes(final String msg) {
        if (Bukkit.getName().equalsIgnoreCase("CraftBukkit"))
            return org.bukkit.ChatColor.translateAlternateColorCodes('&', msg);
        else
            return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', msg);
    }
}

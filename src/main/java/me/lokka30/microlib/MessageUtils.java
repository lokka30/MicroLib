package me.lokka30.microlib;

import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

/**
 * @author lokka30
 * @contributors Sullivan_Bognar, imDaniX
 * @since MicroLib v2.2.0
 */
public class MessageUtils {

    /**
     * Colorize a message, using '&' color codes - e.g. '&a' for ChatColor.GREEN.
     * If the server is 1.16 or newer, then it will also translate hex codes - e.g. '&#abcdef'.
     *
     * @param msg the message to translate color codes from.
     * @return the color-translated message.
     */
    public static String colorizeAll(String msg) {
        return colorizeStandardCodes(colorizeHexCodes(msg));
    }

    /**
     * This defaults the 'startTag' to '&#' and endTag to '' (nothing) to colorizeHexCodes.
     * See javadoc for colorizeHexCodes(String, String, String) for more info.
     *
     * @param msg message to translate
     * @return the translated string
     */
    public static String colorizeHexCodes(String msg) {
        return colorizeHexCodes("&#", "", msg);
    }

    /**
     * (WARNING!) This does NOT colorize standard codes, ONLY hex codes.
     * This translates all hex codes in a message. Hex codes are prefixed by '&#', e.g. '&#abcdef'.
     * This method ensures the version is 1.16 or newer before translating - else, it will not translate the message.
     * Full credit to Sullivan_Bognar and imDaniX on SpigotMC for creating this method.
     *
     * @param startTag what the tag should begin with - '&#' is recommended
     * @param endTag   what the tag should end with - '' (nothing) is recommended
     * @param message  the message that should be translated
     * @return the translated string
     * @author Elementeral @SpigotMC.org and imDaniX @ SpigotMC.org ~ https://www.spigotmc.org/threads/hex-color-code-translate.449748/#post-3867804
     */
    public static String colorizeHexCodes(String startTag, String endTag, String message) {
        if (!VersionUtils.isOneSixteen()) return message;

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
     * (WARNING!) This does NOT colorize hex codes, ONLY standard codes.
     * This translated all standard codes in a message. Standard codes are prefixed by '&', e.g. '&a'.
     *
     * @param msg the message to translate standard color codes from.
     * @return the color-translated message.
     */
    public static String colorizeStandardCodes(String msg) {
        boolean hasMD5 = false;
        try{
            Class.forName("net.md_5.bungee.api.ChatColor");
            hasMD5 = true;
        }
        catch (ClassNotFoundException ignored){ }

        if (hasMD5)
            return BukkitCompat.colorizeStandardCodes(msg);
        else
            return org.bukkit.ChatColor.translateAlternateColorCodes('&', msg);
    }
}

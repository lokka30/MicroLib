package me.lokka30.microlib;

/**
 * Minor useful utilities.
 *
 * @author lokka30
 * @deprecated since v2.2.0 - use MessageUtils#colorizeAll instead.
 */
public class MicroUtils {

    /**
     * WARNING: DEPRECATED - Use MessageUtils#colorizeAll(str) instead!
     * <p>
     * Colorizes text using & color codes.
     *
     * @param msg msg to translate
     * @return translated msg
     * @deprecated Use MessageUtils#colorizeAll(str) instead. This class will be removed soon.
     */
    @Deprecated
    public static String colorize(String msg) {
        return MessageUtils.colorizeAll(msg);
    }
}

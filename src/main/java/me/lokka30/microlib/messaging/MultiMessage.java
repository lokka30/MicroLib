/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.messaging;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * This class makes it easier and cleaner to get and send colorized multi-placeholder multi-line messages.
 * Reduces 2-3 lines of code and removes a lot of repeating code as if it was not used.
 *
 * @author lokka30
 * @since 3.0.0
 */
@SuppressWarnings("unused")
public class MultiMessage {

    public List<String> content;
    public List<Placeholder> placeholders;

    /**
     * Instantiates a new multi message.
     *
     * @param content      what messages should be sent.
     * @param placeholders what placeholders can be replaced in the content.
     * @since 3.0.0
     */
    public MultiMessage(final List<String> content, final List<Placeholder> placeholders) {
        this.content = content;
        this.placeholders = placeholders;
    }

    /**
     * Gets translated content.
     *
     * @return The final message, all placeholders translated.
     * @since 3.0.0
     */
    public List<String> getTranslatedContent() {
        ArrayList<String> translated = new ArrayList<>();

        for (String line : content) {
            String translatedLine = MessageUtils.colorizeAll(line);

            for (Placeholder placeholder : placeholders) {
                translatedLine = placeholder.translateInMessage(translatedLine);
            }

            translated.add(translatedLine);
        }

        return translated;
    }

    /**
     * Gets untranslated content.
     *
     * @return unmodified starting content.
     * @since 3.0.0
     */
    public List<String> getUntranslatedContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content What to change the starting content to.
     * @since 3.0.0
     */
    public void setContent(final List<String> content) {
        this.content = content;
    }

    /**
     * Gets placeholders.
     *
     * @return all the placeholders the MultiMessage currently has
     * @since 3.0.0
     */
    public List<Placeholder> getPlaceholders() {
        return placeholders;
    }

    /**
     * Sets placeholders.
     *
     * @param placeholders what placeholders should be in the message
     * @since 3.0.0
     */
    public void setPlaceholders(final List<Placeholder> placeholders) {
        this.placeholders = placeholders;
    }

    /**
     * Sends translated content.
     *
     * @param sender who to send the translated content to.
     * @since 3.0.0
     */
    public void send(final @NotNull CommandSender sender) {
        getTranslatedContent().forEach(sender::sendMessage);
    }

    /**
     * Sends translated content to player.
     *
     * @param player Player to which you will send the translated content.
     * @since 3.0.0
     */
    public void send(final @NotNull Player player) {
        getTranslatedContent().forEach(player::sendMessage);
    }

    /**
     * This class allows you to translate placeholders in the message content provided using the '%' symbol as starting/ending markers.
     * Placeholder values can be colorized or non-colorized at an individual level,
     * e.g. maybe you do not want an invalid user input placeholder to format colors.
     *
     * @since 3.0.0
     */
    public static class Placeholder {
        public final String id;
        public final String value;
        public final boolean colorizeValue;

        /**
         * Create a new placeholder.
         *
         * @param id            what placeholder is: e.g. `%player_name%`, but without the % symbols, so `player_name`.
         * @param value         what the placeholder should be replaced with.
         * @param colorizeValue if the value should be colorized or not.
         * @since 3.0.0
         */
        public Placeholder(final String id, final String value, boolean colorizeValue) {
            this.id = id;
            this.value = value;
            this.colorizeValue = colorizeValue;
        }

        /**
         * Translates placeholder in message.
         *
         * @param msg The original message.
         * @return Original message but with all occurrences of the placeholder translated to its value.
         * @since 3.0.0
         */
        public String translateInMessage(final String msg) {
            if (colorizeValue) {
                return msg.replace("%" + id + "%", MessageUtils.colorizeAll(value));
            } else {
                return msg.replace("%" + id + "%", value);
            }
        }
    }
}
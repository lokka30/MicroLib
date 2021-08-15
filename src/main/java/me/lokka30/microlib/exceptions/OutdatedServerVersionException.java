/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.exceptions;

import me.lokka30.microlib.other.VersionUtils;

/**
 * This exception should be thrown when a feature in a plugin
 * requires a certain server version, but the server running
 * the plugin isn't running a recent enough Minecraft version to do so.
 *
 * @author lokka30
 * @see VersionUtils
 * @since 2.4.0
 */
public class OutdatedServerVersionException extends Exception {

    public OutdatedServerVersionException(String errorMsg) {
        super(errorMsg);
    }
}

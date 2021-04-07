# Changelog

This is MicroLib's changelog file, where changes in each version are noted.

***

## v1.0.0-ALPHA

* 15 September 2020 @ 8:45 PM
* Initial version ~ no changes.

***

## v1.0.1-ALPHA

* 15 September 2020 @ 9:00 PM
* Modified the startup banner.

***

## v1.0.2-ALPHA

* 19 September @ 4:55 PM
* Added bStats id
* Trying a new way of copying default config files.
* Changes to README.md, TODO.md
* Modified the startup and shutdown banner once again.

***

## v1.0.3-ALPHA

* Various minor undocumented changes.

***

## v1.0.4-ALPHA

* Changes to file loading on enable.

***

## v1.0.5-ALPHA

* Fix to the file loading on enable error.

***

## v1.0.6-ALPHA

* Code Cleanup

***

## v1.0.7-ALPHA

* Update checker now available
* Changed logging method in UpdateChecker
* Updated README.md (Spigot link added)

***

## v1.0.8-ALPHA b8

* **Important Information**
    * `messages.yml` updated to version `3`. Reset or merge your current file with a newly generated file.
    * This release was not tested.
* Added customisable main command message to `messages.yml`.
* Added `setFrom` and `setTo` to movement events.
* Modified startup banner.
* Removed disable banner.
* Various minor changes.

***

## v1.0.9

* Removed unused message from `messages.yml` (no file update is required, file version unchanged)
* Added functionality to `/microlib reload`.
* Versioning changed again, removed build number. Also, ML is no longer in alpha.

***

## v2.0.0

**Server owners, you *must* read the entire changelog (except for the all changes section at the bottom). Major changes
have occured with the resource, and if you are unfamiliar with them, then there is a pretty high chance that you will
start experiencing errors.**

* MicroLib is now designed to be moreso shaded into plugins rather than be a plugin in the plugins folder.
    * This means that resources don't have to force you to install MicroLib in the plugins folder anymore, since it can
      be silently included inside the plugin jar.
    * Of course, if the developer uses MicroLib's methods but doesn't want to shade it in to their resource, the server
      owner will need to put MicroLib in their plugins folder.
* All plugin-like functionality from MicroLib has been completely removed. There are no commands, events, anything, just
  the code sitting there waiting to be utilised by other plugins. You won't even notice it's installed.
* **MAKE SURE:**
    * **Do not use MicroLib v1 plugins with MicroLib v2 installed. Do not use MicroLib v2 plugins with MicroLib v1
      installed.** Significant changes have occured in the code which causes this.
* All changes (Server owners, you don't have to read this section)
    * Major changes:
        * Removed listeners and events from the resource. You can now use PlayerMoveEventUtils' static methods to
          achieve the exact same functionality and ease of use.
        * Removed the contents of the MicroLib class as they are no longer required.
    * Minute changes:
        * ItemBuilder
        * UpdateChecker
        * WholeSound
        * WholeTitle
    * Other things:
        * Removed bStats as it is not suitable for this resource anymore.

***

## v2.1.0

* **IMPORTANT:** Removed old UpdateChecker#getLatestVersion method.
* **IMPORTANT:** Renamed old UpdateChecker#retrieveLatestVersion method to UpdateChecker#getLatestVersion
* Added the `YamlConfigFile` class for easier YAML config file management
* Added the `QuickTimer` class for easy timing with no repeating tasks. Useful for timing start-up and shut-down times,
  etc.
* Code improvements.

***

## v2.1.1

* Fixed `UpdateChecker#getLatestVersion`'s visibility (`private` -> `public`).

***

## v2.2.0

### Notes:

* Developers, **MicroUtils#colorize** is now **deprecated** and you should use **MessageUtils#colorizeAll** instead.
* This update was not tested.

### Changes:

#### New Classes

* `MessageUtils.java`
    * This is a replacement to MicroUtils#colorize, allowing developers to translate standard color codes, hex color
      codes (if supported), and both at once!
    * All plugins using MicroUtils' colorize method will automatically redirect to the colorizeAll method! (Developers,
      please switch anyways - MicroUtils is deprecated now!)
    * Thanks to @Elementeral and @imDaniX for providing the code for hex code translation
      in [this](https://www.spigotmc.org/threads/hex-color-code-translate.449748/#post-3867804) thread!
* `VersionUtils.java`
    * This allows developers to check what major Minecraft version a server is running.
    * Contains simple methods such as `isOneSixteen()` and more complex (calculations-wise)
      , `getMajorMinecraftVersion()`.
    * This covers all major Minecraft versions (1.6 to 1.16, and future versions will come).

#### Upgraded Classes

* `QuickTimer.java`
    * Now uses far simpler code, and also allows developers to specify a starting time.

#### Removed / Deprecated Classes

* `MicroUtils.java`
    * The features of `MicroUtils.java` have been moved to and been expanded upon in `MessageUtils.java`.

#### Insignificant Improvements

* `ItemBuilder.java`: added final modifiers on two lists
* Added method `isInstalledAsPlugin` to `MicroLib.java`.
* Replaced unnecessary suppressions in `MicroLogger.java` and also instead utilising new `MessageUtils.java` class.
* Better YAML structure in inbuilt `plugin.yml`.
* Upgraded severity of update check failure from `warning` to `severe` in `UpdateChecker.java`.
* Replaced `Objects#requireNonNull(object)` in `WholeSound.java` to `assert object != null`.
* Replaced internal colorize method in `WholeTitle.java` (unsure why it still remained), now using
  new `MessageUtils.java` class.
* Improved javadocs in most classes.
* Now compiled with MC 1.16.5 instead of MC 1.16.3

***

# v2.2.1

## Notes:

* This version has not been tested.
* Developers, the deprecated **MicroUtils** class will be **removed** in the next MicroLib update. Please switch to **
  MessageUtils#colorizeAll** as soon as possible. You have had a long notice :)

## Changelog

* Attempted fix for ItemBuilder's item meta systems not working properly
* Small improvements to ItemBuilder
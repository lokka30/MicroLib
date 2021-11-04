# Welcome to the MicroLib Changelog

* This is MicroLib's changelog file, where changes in each version are noted.
* Sometimes I forget to add the changelog for some versions here. However, **all** changelogs are available on the
  SpigotMC page for MicroLib.

***

# MicroLib v3.1.2

* (@lokka30) MicroLib now uses the `Consumer` class from `java.util.function`, not Bukkit. This only affects the **Update Checker** class. If you are using the update checker please simply change the import you are using to the Java one when you update to MicroLib 3.1.2.
* (@lokka30) MicroLib now contains a method to check if the server is running PaperMC or any derivative of it such as Airplane and Purpur: simply assert `VersionUtils.isRunningPaper()` before running any Paper-dependent code.

***

# MicroLib v3.1.0

* I (@lokka30) re-programmed the [ItemBuilder](https://github.com/lokka30/MicroLib/blob/master/src/main/java/me/lokka30/microlib/items/ItemBuilder.java) class! It should work great now.
  * **Note:** The new ItemBuilder class has not been tested, please let me know if you use it and run into any issues.
  * **Note:** Any plugins using the old ItemBuilder will need to update their code.

***

# MicroLib v3.0.1

* @lokka30 made the `MultiMessage.Placeholder` class static, fixed inability to use the `MultiMessage` class.

***

# MicroLib v3.0.0

## Important

**Server owners!** Nothing of your concern this update. Only update if the plugin(s) that use MicroLib have updated to
use this version.

**Developers!** A lot of upgradeshave been done to the library, check the changelog before updating. Almost all classes
have been moved to separate packages in an organisation effort for future-proofing.

## Changelog

* Added `MultiMessage` class at `me.lokka30.microlib.messaging.MultiMessage`.
  * Makes it far easier to send colored multi-line messages with multiple placeholders.
  * Has already been tested in PhantomWorlds 2 and is working really well. Will be implemented in my other plugins over
    time.
* Moved a lot of classes into separate sub-packages for organisation purposes. The location after 'Moved <...>' is the
  new location of the class.
  * Moved `me.lokka30.microlib.MessageUtils`
  * Moved `me.lokka30.microlib.MicroLogger`
  * Moved `me.lokka30.microlib.items.ItemBuilder`
  * Moved `me.lokka30.microlib.maths.QuickTimer`
  * Moved `me.lokka30.microlib.other.UpdateChecker`
  * Moved `me.lokka30.microlib.other.VersionUtils`
  * Moved `me.lokka30.microlib.wholes.WholeSound`
  * Moved `me.lokka30.microlib.wholes.WholeTitle`
  * Moved `me.lokka30.microlib.files.YamlConfigFile`
* Events!
  * Removed `PlayerMoveEventUtils`, replaced by two new events, see below.
  * Added `PlayerMoveFullXYZEvent`, derived from `PlayerMoveEvent`. Only fires when a player moves to a different X, Y
    or Z coordinate as an integer (e.g. 1 to 2 yes, 1.9 to 2.0 yes, not 1.8 to 1.9 or 1.0 to 1.9)
  * Added `PlayerMoveXYZEvent`, derived from `PlayerMoveEvent`. Only fires when a player moves on the X, Y or Z axis in
    any amount. Head rotations do not fire this event.
  * **These events are only fired if MicroLib is installed as a plugin. If it is shaded into your plugin then these
    events will not fire.**
  * **These events have not been tested. If you are using one or both of these events then please let me know how it
    goes. :)**

## Note

* I would not recommend using `ItemBuilder` at the moment, it seems to be quite broken. I will fix it in the future, but
  it is very low on my priorities.

***

# MicroLib v2.4.0

## Important

* Developers: please ensure you don't skip past the bold '**IMPORTANT**' lines in the changelog. There are only 2.
* This version has not been tested. Please let me know if you have any issues with it and I will attempt to address it
  as soon as possible.

## Changelog

* Maths Classes:
  * Added `Randoms` class:
    * Contains a bunch of methods based on `ThreadLocalRandom`, such as 'generate random int' and 'chance' to make it
      easier to program chances into your plugins.
  * Direction Utilities:
    * **IMPORTANT** Removed `DirectionUtils` class - replaced with 3 new enums, as stated below.
    * Added `Direction4`, `Direction8`, and the `Direction16` classes. See its source code to learn more.
* **IMPORTANT** Moved `MicroLib` main class into subpackage `plugin`. This will only affect you if you are not using
  Maven/Gradle. Just update your import and it's sorted :)
* Minor improvements to MicroLogger:
  * Better method for checking if Spigot is installed.
  * Added stumper66 to authors of class.
* Code cleanup in the Update Checker.
* Improved javadocs in many places.
* Added copyright notice above all MicroLib classes.
* Maven (`pom.xml`) changes:
  * Updated annotations to `21.0.1`.
  * Updated spigot-api to `1.17.1`.
* Updated website in plugin.yml to remove versioning from link.

***

End of the file! For older changelogs, please see the 'Updates' tab on MicroLib's SpigotMC resource page.
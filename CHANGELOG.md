# Welcome to the MicroLib Changelog

* This is MicroLib's changelog file, where changes in each version are noted.
* Sometimes I forget to add the changelog for some versions here. However, **all** changelogs are available on the
  SpigotMC page for MicroLib.

***

# v3.2.0

A new MicroLib update, presented to you by [ProfliX](https://github.com/ProfliX) and I! :)

* [ProfliX](https://github.com/ProfliX) and I improved the `WholeTitle` class:
  * no longer throws errors on 1.7 servers
    * 1.7 servers don't have titles, so MicroLib just skips the request instead of throwing an error. 
  * now supports 1.8, 1.9 and 1.10 servers
    * these versions didn't have the newer `Player#sendTitle` method in the Spigot API, so we are using a deprecated method to fix this without using NMS.
* [ProfliX](https://github.com/ProfliX) added the `JsonConfigFile` class.
  * Just like the YamlConfigFile class, but in the `json` format ;) 
* [ProfliX](https://github.com/ProfliX) added random float number generation to the `Randoms` class.
* [ProfliX](https://github.com/ProfliX) and I changed almost all of the `QuickTimer` class.
  * You can now record time in different units - from *nanoseconds*, all the way up to *days*! 
  * New instantiation of QuickTimer utilising the desired time unit and an optional start-time parameter.
* The `VersionUtils` class was improved:
  * [ProfliX](https://github.com/ProfliX) added a method to check if the server is running a specific version, using a `String#contains` check.
  * [ProfliX](https://github.com/ProfliX) added the ability for the version checker to also check if the server has certain biomes available. This is utilised with the new 1.18 checker.
  * [ProfliX](https://github.com/ProfliX) fixed the 1.18 version checker and also added a 1.19 version checker. As both versions are not released, we are predicting certain names of biomes and mobs being added, so please be careful if you use these and notify us if they don't work properly.
* [ProfliX](https://github.com/ProfliX) and I improved the javadocs.

I would be grateful if you could leave a review on MicroLib so both me and the Spigot community can see what the advantages and disadvantages of MicroLib are. I'm much interested to hear what your thoughts are.

Thank you for using MicroLib. ;)

***

# v3.1.2

* @lokka30 changed the `Consumer` import on the update checker.
  * It now uses the `Consumer` class from `java.util.function`, not Bukkit's one.
  * If you are using the update checker, **you must change your previous import** to the Java one when you update to MicroLib 3.1.2.
  * This also means that the update checker no longer requires Minecraft 1.11 to run, you can run it on any version! :)
  * The last outcome of this is that the method no longer throws OutdatedServerVersionException, no need for the try/catch anymore.
* @lokka30 added a method to check if the server is running PaperMC or any derivative of it such as Airplane and Purpur. 
  * Simply assert `VersionUtils.isRunningPaper()` before running any Paper-dependent code.
* [ProfliX](https://github.com/ProfliX) kindly contributed various minor code improvements, such as the addition of nullability annotations.
* @lokka30 made the `OutdatedServerVersionException` now extend `RuntimeException` instead.

***

# v3.1.0

* I (@lokka30) re-programmed the [ItemBuilder](https://github.com/lokka30/MicroLib/blob/master/src/main/java/me/lokka30/microlib/items/ItemBuilder.java) class! It should work great now.
  * **Note:** The new ItemBuilder class has not been tested, please let me know if you use it and run into any issues.
  * **Note:** Any plugins using the old ItemBuilder will need to update their code.

***

# v3.0.1

* @lokka30 made the `MultiMessage.Placeholder` class static, fixed inability to use the `MultiMessage` class.

***

# v3.0.0

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

# v2.4.0

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
# Welcome to the MicroLib Changelog

* This is MicroLib's changelog file, where changes in each version are noted.
* Sometimes I forget to add the changelog for some versions here. However, **all** changelogs are available on the
  SpigotMC page for MicroLib.

***

# 2.4.0

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
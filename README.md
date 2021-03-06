[![Discord](https://discordapp.com/api/guilds/346695724253184014/embed.png?style=banner2)](http://discord.gg/se7zJsU)  
 [ ![Download](https://api.bintray.com/packages/roccodev/hive-api-wrapper/hive-api-wrapper/images/download.svg) ](https://bintray.com/roccodev/hive-api-wrapper/hive-api-wrapper/_latestVersion)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/Beezig/hive-api-wrapper.svg)
[![Travis Master](https://travis-ci.org/Beezig/hive-api-wrapper.svg?branch=master)](http://travis-ci.org/Beezig/hive-api-wrapper)
# Beezig API Wrapper
A simple yet functional API wrapper written in Java, used by [Beezig](https://github.com/Beezig/Beezig), the Hive plugin for 5zig.

## Download

(Replace `VERSION_ID` with the version shown here)    [ ![Download](https://api.bintray.com/packages/roccodev/hive-api-wrapper/hive-api-wrapper/images/download.svg) ](https://bintray.com/roccodev/hive-api-wrapper/hive-api-wrapper/_latestVersion)

**For Gradle builds**:  
```java
repositories {
  jcenter()
}

dependencies {
  compile 'pw.roccodev.beezig:hive-api-wrapper:VERSION_ID'
}

```
**For Maven builds**:  
```xml
<repositories>
    <repository>
      <id>jcenter</id>
      <url>https://jcenter.bintray.com/</url>
    </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>pw.roccodev.beezig</groupId> 
    <artifactId>hive-api-wrapper</artifactId> 
    <version>VERSION_ID</version>
  </dependency>
</dependencies>

```
**For Ant builds**: You can find the latest version in the [Releases tab](https://github.com/Beezig/hive-api-wrapper/releases/latest).

## Features

### Hive API Coverage
- [x] Global player stats
- [x] Gamemode stats
- [x] Full player game stats
- [x] Game leaderboards
- [x] Game maps
- [x] Server stats
- [ ] GameData

### Monthlies
This wrapper supports [Maxthat](https://github.com/Maxthat)'s DeathRun and TIMV Monthly Leaderboards, as well as [RoccoDev](https://github.com/RoccoDev)'s Bedwars Toolkit.


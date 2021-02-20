# NOXUS - Riot API Java client

Noxus project is a Java client based in Riot API for League of Legends game. The focus of the project of simple way is provide data of `active games`, `game history` and `classified statistics` in a customized way.

## So what can I do with Noxus?

All of the following Riot API informations can be extracted:

* Champion masteries
* Player scored
* Champion rotations
* Leagues:
  * Challenger
  * Grandmaster
  * Master
  * Others
* Status data shards
* Matches
* Timeline matches
* Featured games
* Active summoner games
* Summoner

## How do I use it?

You can use it as a dependency:

### Official Realeases

* Maven:
```xml
<!-- https://mvnrepository.com/artifact/com.github.antonioazambuja/noxus -->
<dependency>
    <groupId>com.github.antonioazambuja</groupId>
    <artifactId>noxus</artifactId>
    <version>0.0.1</version>
</dependency>
```

* Gradle:
```groovy
// https://mvnrepository.com/artifact/com.github.antonioazambuja/noxus
implementation group: 'com.github.antonioazambuja', name: 'noxus', version: '0.0.1'
```

To use it just:
```java
Noxus noxus = new Noxus(new Config("your-riot-api-key"), Regions.BR1);
SummonerDTO summonerDTO = noxus.getSummonerByName("BlackPr1de");
```
And you are done!

### Thanks!

# World Map
![alt text](https://github.com/Urja/worldMap/blob/master/resources/map.jpg)

* World map is a game about learning new words from different languages.
* Game has its own map with predefined countries.
* Each country has multiple cities.
* To win the game, player should win all the countries.
* And to win a country, player should win all the cities available in that country.
* Player can win the city by giving a correct English translation
for a given word of the native language of that country.
* For example: If you are in Germany, German is the native language.
* So a word could be "Danke". Now the player should provide a correct translation, which is "Thanks".
* If the answer is correct then player has won that city and 5 points will be added to player's experience.
* After winning one city, player can move to the next city of the same country.
* When player provides all the correct answers for all the cities then player win that particular country.
* After winning one country, player can move to the next county.
* Each next country will bring a new set of cities and a new language to learn.
* Once a player wins all the countries, player is now the winner of the game.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

What things you need to install the software and how to install them

```
jdk 1.8
maven
git
```

### Installing

To Install project follow the below steps:

Open Command prompt and run the following command to checkout the project.

```
git clone https://github.com/Urja/worldMap.git
 ```
  Go to project directory 
  
 ```
 cd worldMap
 ```
Now build and run application by using following command

```
mvn
```

# Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Future scope

* Validation of XML file like duplicate country or city will not allow.
* XML tags validation
* Order number validation also could be done, because XML reading works on order number
* If user do not want answer the question or do not know the answer than skip question should be there.
* User and Atlas data could be move to Json or database instead of xml file.

## Limitation
* Non Latin characters are not allowed on console, therefore,
Atlas.xml will not support words in Hindi or Arabic.

## External Library
* Maven - For application build.
* Junit, Mockito, Powermock - For write test cases.
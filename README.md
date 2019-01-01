
# World Map
![alt text](https://github.com/Urja/worldMap/blob/master/resources/map.jpg)

* World map is a game about learning new words from different languages.
* Game has its own map with predefined countries.
* Each country has multiple cities.
* To win the game player should win all the countries.
* And to win country player should win cities available in that country.
* Player can win the city by giving correct English translation of ask word.
* World which will asked by game will be in the language of that particular country.
* For example: You are in Germany, German is the language spoken in Germany.
* So word could be "Danke" , now player should provide correct translation which is "Thanks".
* If answer is correct then player won that city and 5 points will be added to player's experience point.
* Now player can move to next city and so on.
* When player provide all the correct answer for all the city then player win a particular country.
* Then player will be in the next country with different language and different cities.
* Once player win all the country, it will be now winner of the game.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

What things you need to install the software and how to install them

```
jdk 1.8
maven
```

### Installing

To Install project follow the below steps:

Open Command line and run the following to checkout the project.

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

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Future scope

* Validation of XML file like duplicate country or city will not allow.
* XML tags validation
* XML reading works on order number, so order number validation also could be done.
* If user do not want answer the question or do not know the answer than skip question should be there.

## Limitation
* Non Latin characters are not allowed, therefore, Atlas.xml will not support words in Hindi or Arabic.
* Used XML for data read and write because of library constraint. Json could be easy but it require a library.

## External Library
* Maven - For application build.
* Junit, Mockito, Powermock - For write test cases.
* jacoco - For code coverage.
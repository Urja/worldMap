package org.worldmap.service.impl;

import org.worldmap.exception.UserException;
import org.worldmap.model.Atlas;
import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.User;
import org.worldmap.service.GameEngineService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.util.InputUtils;

public class GameEngineServiceImpl implements GameEngineService {

    private PrintService printService;
    private UserService userService;

    public GameEngineServiceImpl(PrintService printService, UserService userService) {
        this.printService = printService;
        this.userService = userService;
    }

    public void startGame(User user, Atlas atlas) {
        int totalCountries = atlas.getCountries().size();
        atlas.getCountries().stream()
                .sorted()
                .filter(country -> country.getOrder() > user.getConqueredCountryOrder())
                .forEach(country -> {
                    playCountry(user, country);
                    if (totalCountries != country.getOrder())
                        printService.printNewLineMessage("country.conquered.message");
                });
        printService.printSingleLineMessage("game.won.message");
    }

    private void playCountry(User user, Country country) {
        printService.printNewLine("Now in: " + country.getName() + "(" + country.getLanguage() + ")");
        country.getCities().stream()
                .sorted()
                .filter(city -> city.getOrder() > user.getConqueredCityOrder())
                .forEach(city -> playCity(city, user));
        user.setConqueredCountryOrder(country.getOrder());
        user.setConqueredCityOrder(0);
        try {
            userService.updateUser(user);
        } catch (UserException e) {
            printService.printSingleLine(e.getMessage());
        }
    }

    /**
     * TODO : implement a way for user to skip playing this city (feature)
     */
    private void playCity(City city, User user) {

        printService.printSingleLineMessage("question.text");
        printService.printSingleLine(city.getName() + ".\n" + city.getWord() + ": ");
        if (InputUtils.getUserInput().equalsIgnoreCase(city.getTranslation())) {
            printService.printNewLine(city.getSuccessMessage());
            user.setConqueredCityOrder(city.getOrder());
            user.gainExperience();
            try {
                userService.updateUser(user);
            } catch (UserException e) {
                printService.printSingleLine(e.getMessage());
            }
        } else {
            printService.printNewLineMessage("wrong.translation.message");
            playCity(city, user);
        }
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

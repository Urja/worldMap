package org.worldmap.service.impl;

import org.worldmap.exception.UserException;
import org.worldmap.model.Atlas;
import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.User;
import org.worldmap.service.AtlasService;
import org.worldmap.service.GameEngineService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.util.InputUtils;

public class GameEngineServiceImpl implements GameEngineService {

	PrintService printService = new PrintServiceImpl();
	UserService userService = new UserServiceImpl();
	AtlasService atlasService = new AtlasServiceImpl();

	public void startGame(User user, Atlas atlas) {

		atlas.getCountries().stream().sorted().filter(c -> c.getOrder() > user.getConqueredCountryOrder())
				.forEach(country -> {
					playCountry(user, country);
					if (atlas.getCountries().size() != country.getOrder())
						printService.printMessage("country.conquered.message");
				});
		printService.printSingleLineMessage("game.won.message");
	}

	private void playCountry(User user, Country country) {

		printService.printNewLine("Now in: " + country.getName() + "(" + country.getLanguage() + ")");
		country.getCities().stream().sorted().filter(c -> c.getOrder() > user.getConqueredCityOrder())
				.forEach(city -> playCity(city, user));
		user.setConqueredCountryOrder(country.getOrder());
		user.setConqueredCityOrder(0);
		try {
			userService.updateUser(user);
		} catch (UserException e) {
			printService.print(e.getMessage());
		}
	}

	/**
	 * TODO : implement a way for user to skip playing this city (feature)
	 * @param city
	 * @param user
	 * @return
	 */
	private boolean playCity(City city, User user) {

		printService.printSingleLineMessage("question.text");
		printService.print(city.getName() + ".\n" + city.getWord() + ": ");
		if (InputUtils.getUserInput().equalsIgnoreCase(city.getTranslation())) {
			printService.printNewLine(city.getSuccessMessage());
			user.setConqueredCityOrder(city.getOrder());
			user.gainExperience();
			try {
				userService.updateUser(user);
			} catch (UserException e) {
				printService.print(e.getMessage());
			}
			return true;
		} else {
			printService.printMessage("wrong.translation.message");
			playCity(city, user);
		}
		return false;
	}

}
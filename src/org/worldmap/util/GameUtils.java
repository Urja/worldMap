package org.worldmap.util;

import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.CityService;
import org.worldmap.service.CountryService;
import org.worldmap.service.GameDataService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.CityServiceImpl;
import org.worldmap.service.impl.CountryServiceImpl;
import org.worldmap.service.impl.GameDataServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;

public class GameUtils {
	
	CountryService countryService = new CountryServiceImpl();
	CityService cityService = new CityServiceImpl();
	
	PrintService printService = new PrintServiceImpl();
	UserInputUtils userInputUtils = new UserInputUtils();
	 UserService userService = new UserServiceImpl();	
	
	public boolean validateAnswer(String userAnswer,String transalation) {
		return userAnswer.equalsIgnoreCase(transalation);
	}

	public void startGame(User user, GameData gameData) throws JAXBException {
		if (user.isWonWorldMap()) {
			printService.printWonGameMessage();
			user.getConqueredCountry().forEach(System.out::println);
			return;
		}
		Country country = countryService.getCurrentCountryByUser(gameData, user);

		if (country != null) {
			Optional<City> city = cityService.getCurrentCityByUser(country, user);

			if (city.isPresent()) {
				processGameQuestion(city.get(), user, gameData);
			} else {
				printService.printDataErrorMessage();
			}
		} else {
			printService.printDataErrorMessage();
		}
	}
		
	private void processGameQuestion(City city,User user, GameData gameData) throws JAXBException {
		printService.printQuestion(city.getWord(), city.getName());
		String userAnswer = userInputUtils.getAnswerFromUser();
		
		if(validateAnswer(userAnswer,city.getTranslation())) {
			
			printService.printMessage(city.getSuccessMessage());
			updateAndProcessNextQuestions(gameData, user);
		}
		else {
			
			printService.printErrorMessage();
			processGameQuestion(city,user,gameData);
		}
	}

	private void updateAndProcessNextQuestions(GameData gameData, User user) throws JAXBException {
		
		Country country = countryService.getCurrentCountryByUser(gameData, user);
		City city = cityService.getNextCityByUser(country,user);
		if(city!=null) {
			user.setLastConqueredCity(user.getCurrentCity());
			user.setCurrentCity(city.getName());
			user.setExperiencePoint(user.getExperiencePoint()+5);
			user = userService.updateUser(user);
			processGameQuestion(city, user, gameData);
		
		}
		else {
			
			Country nextCountry =  countryService.getNextCountryByUser(gameData, user);
			if(nextCountry!=null) {
				printService.printCountryConcouredMessage(nextCountry.getName());
				printService.printMessage("Language: "+ nextCountry.getLanguage());
				user.getConqueredCountry().add(user.getCurrentBattleCountry());
				user.setLastConqueredCity(user.getCurrentCity());
				user.setCurrentBattleCountry(nextCountry.getName());
				user.setCurrentCity(nextCountry.getCities().get(0).getName());
				user = userService.updateUser(user);
				processGameQuestion(nextCountry.getCities().get(0), user, gameData);
			}
			else {
				user.setWonWorldMap(true);
				user.setLastConqueredCity(user.getCurrentBattleCountry());
				user.setLastConqueredCity(user.getCurrentCity());
				
				user = userService.updateUser(user);
				printService.printWonGameMessage();
				user.getConqueredCountry().forEach(System.out::println);
			}
		}
		
		
	}
}

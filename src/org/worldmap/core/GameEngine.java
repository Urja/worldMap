package org.worldmap.core;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.service.MapService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.MapServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;
import org.worldmap.util.InputUtils;

public class GameEngine {

	PrintService printService = new PrintServiceImpl();
	InputUtils inputUtils = new InputUtils();
	 UserService userService = new UserServiceImpl();	
	MapService mapService = new MapServiceImpl();	
	
	public void startGame(User user, Map map) throws JAXBException {
		
		
		List<Country> countries = mapService.getCountriesToPlay(map.getMapInfo(), user);
		
		countries.forEach(country -> {
			
				printService.printStaticData("Now in: "+country.getName() +"("+country.getLanguage()+")\n");
				
				List<City> cities = mapService.getCitiesToPlay(country, user);
				
				cities.forEach(city -> {
					
					if(playCity(city)) {
						
						user.setConqueredCityOrder(city.getOrder());
						user.setExperiencePoint(user.getExperiencePoint()+5);
						
						try {
							userService.updateUser(user);
						} catch (JAXBException e) {
							e.printStackTrace();
						}
					}
					
				});
			user.getConqueredCountry().add(country.getOrder());
			user.setConqueredCityOrder(0);
			 try {
				userService.updateUser(user);
				
				if(countries.size()!=country.getOrder())
					printService.printMessage("country.conquered.message");
				
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
		});
		printService.printSingleLineMessage("game.won.message");
	}		
		
		
	private boolean playCity(City city) {
		
		printService.printSingleLineMessage("question.text");
		printService.printStaticData(city.getName() +".\n"+ city.getWord()+": ");
		
		String userAnswer = inputUtils.getAnswerFromUser();
		
		if(validateAnswer(userAnswer,city.getTranslation())) {
			printService.printStaticData(city.getSuccessMessage()+"\n");
			return true;
		}
		else {
			printService.printMessage("wrong.translation.message");
			playCity(city);
		}
		return false;
	}
	
	private boolean validateAnswer(String userAnswer,String transalation) {
		return userAnswer.equalsIgnoreCase(transalation);
	}


}

package org.worldmap.util;

import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.UserServiceImpl;

public class GameCore {
	UserService userService = new UserServiceImpl();
	public City displayQuestion(User user,boolean isFirstTime) throws JAXBException{
		
		LoadData loadData = new LoadData();
		GameData gameData= loadData.loadGameData();
		Optional<Country> country = gameData.getGameData().stream().filter(countryElement -> user.getCurrentBattleCountry().equals(countryElement.getName())).findFirst();

		if(user.getLastConqueredCity().equalsIgnoreCase("None") && isFirstTime) {
			user.setCurrentCity(country.get().getCities().get(0).getName());
			System.out.print("Your current battle country: "+country.get().getName()+" \nLanguage: " + country.get().getLanguage());
			userService.updateUser(user);
			return country.get().getCities().get(0);
		}
		else {
			
			for(int i=0; i< country.get().getCities().size();i++) {
				if(country.get().getCities().get(i).getName().equals(user.getCurrentCity())) {
					if((i+1)<country.get().getCities().size()) {
						user.setLastConqueredCity(user.getCurrentCity());
						user.setCurrentCity(country.get().getCities().get(i+1).getName());
						userService.updateUser(user);
						return country.get().getCities().get(i+1);
					}
					else {
		//TODO :check this where to put	System.out.print("\nCongrutulations!!! you won "+user.getCurrentBattleCountry() +" with experience point " + user.getExperiencePoint()); //How to put in printconsole class
						for(int j=0; j< gameData.getGameData().size();j++) {
							if(gameData.getGameData().get(j).getName().equals(user.getCurrentBattleCountry())) {
								user.getConqueredCountry().add(user.getCurrentBattleCountry());
								if((j+1)<gameData.getGameData().size()) {
									user.setCurrentBattleCountry(gameData.getGameData().get(j+1).getName());
									user.setLastConqueredCity(user.getCurrentCity()); 
									user.setCurrentCity(gameData.getGameData().get(j+1).getCities().get(0).getName());
									System.out.print("\nYour current battle country:"+user.getCurrentBattleCountry() +"\nLanguage: " + gameData.getGameData().get(j+1).getLanguage());
									userService.updateUser(user);
									return gameData.getGameData().get(j+1).getCities().get(0);
								}
								else {
									//TODO :display you won world map message
									user.setCurrentBattleCountry("none");
									user.setLastConqueredCity(user.getCurrentCity());
									user.setCurrentCity("none");
									user.setWonWorldMap(true);
									userService.updateUser(user);
									break;
								}
							}
						}
					}
				}
			}
		}
		/*Optional<Country> country = getCurrentQuestionsForUser(user);
		Optional<City> city  = country.get().getCities().stream().filter(cityElement -> user.getCurrentCity().equals(cityElement.getName())).findFirst();
	
		*/
		return null;
		
	}
}

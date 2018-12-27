package org.worldmap.service.impl;

import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.PrintService;
import org.worldmap.util.MessageUtils;

public class PrintServiceImpl implements PrintService{
	
	MessageUtils messageUtils = new MessageUtils();
	
	@Override
	public void displayWelcomeMessage() {
		printMessage(messageUtils.getWelcomeMessage());
	}

	@Override
	public void printCountryConcouredMessage(String countryName) {
		printMessage(messageUtils.getCountryConcouredMessage()+countryName);
	}

	@Override
	public void printQuestion(String question, String cityName) {
		printMessage(messageUtils.getQuestionText()+cityName);
		printSingleLineMessage(question+": ");
		
	}

	@Override
	public void printErrorMessage() {
		printMessage(messageUtils.getErrorMessage());
		
	}

	@Override
	public void printMessage(String message) {
		System.out.println(message);
		
	}
	@Override
	public void printSingleLineMessage(String message) {
		System.out.print(message);
		
	}

	@Override
	public void printUserDetail(User user) {
		System.out.println("**************************");
		System.out.println("Name: "+user.getName()+"\nCurrent battle country: "+user.getCurrentBattleCountry()+
				" \nCurrent battle city: "+user.getCurrentCity()+" \nPreiviously conquered country: "+String.join("\t", String.join(",", user.getConqueredCountry())) +
				" \nPriviously coonquered city: "+user.getLastConqueredCity()+"\nExperience point: "+user.getExperiencePoint());
		
		System.out.println("**************************");
	}

	@Override
	public void printExitMessage() {
		printMessage(messageUtils.getExitMessage());
	}

	@Override
	public void printDataErrorMessage() {
		printMessage(messageUtils.getDataErrorMessage());
	}

	@Override
	public void printWonGameMessage() {
		printMessage(messageUtils.getWonGameMessage());
		
		
	}

	@Override
	public void printWorldMap(GameData gameData) {
		System.out.print("You have to win all for win the world map");
		gameData.getGameData().forEach(country -> {
			System.out.print("\n||--->"+country.getName()+"("+country.getLanguage()+")");
			country.getCities().forEach(city -> System.out.print("   |--"+city.getName()));
		});
		System.out.print("\n");
	}

	

}

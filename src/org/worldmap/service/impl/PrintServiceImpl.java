package org.worldmap.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.worldmap.model.Country;
import org.worldmap.model.Atlas;
import org.worldmap.model.User;
import org.worldmap.service.PrintService;
import org.worldmap.util.WorldMapConstant;

public class PrintServiceImpl implements PrintService{
	
	Properties properties = new Properties();
	
	public PrintServiceImpl(){
		try {
			properties.load(new FileInputStream(WorldMapConstant.MESSAGE_PROPERTIES));
		} catch (IOException e) {
			print("Message property file not found.");
		}
	}
	
	@Override
	public void printCountryConcouredMessage(String countryName) {
		printMessage(properties.getProperty("country.conquered.message")+countryName);
	}

	@Override
	public void printMessage(String message) {
		System.out.println(properties.getProperty(message));
	}
	
	@Override
	public void printSingleLineMessage(String message) {
		System.out.print(properties.getProperty(message));
	}

	@Override
	public void printUserDetail(User user, List<Country> countries) {
		printNewLine("**************************");
		printNewLine("Name: "+user.getName()+"\nExperience point: "+user.getExperiencePoint());
		printNewLine("Conquered Countries:");
		countries.stream().sorted().filter(c -> c.getOrder() <= user.getConqueredCountryOrder())
		.forEach(country -> printNewLine(country.getName()));
		printNewLine("**************************");
	}
	
	@Override
	public void printWorldMap(Atlas atlas) {
		printNewLine("You have to concurred all countries to win the world map.");
		atlas.getCountries().forEach(country -> {
			printNewLine("))"+country.getName()+"("+country.getLanguage()+") O");
			country.getCities().forEach(city ->print("-->"+city.getName()));
		});
	}
	
	@Override
	public void print(String message) {
		System.out.print(message);
	}

	@Override
	public void printNewLine(String message) {
		System.out.println(message);
		
	}

	

}

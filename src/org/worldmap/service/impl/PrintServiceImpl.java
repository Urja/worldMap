package org.worldmap.service.impl;

import org.worldmap.model.Atlas;
import org.worldmap.model.Country;
import org.worldmap.model.User;
import org.worldmap.service.PrintService;
import org.worldmap.util.WorldMapConstant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PrintServiceImpl implements PrintService{
	
	private Properties properties = new Properties();
	
	public PrintServiceImpl(){
		try {
			properties.load(new FileInputStream(WorldMapConstant.MESSAGE_PROPERTIES));
		} catch (IOException e) {
			printSingleLine("Message property file not found.");
		}
	}

	@Override
	public void printNewLineMessage(String key) {
		System.out.println(properties.getProperty(key));
	}
	
	@Override
	public void printSingleLineMessage(String key) {
		System.out.print(properties.getProperty(key));
	}

	@Override
	public void printUserDetail(User user, List<Country> countries) {
		printNewLine("**************************");
		printNewLine("Name: "+user.getName()+"\nExperience point: "+user.getExperiencePoint());
		printNewLine("Conquered Countries:");
		countries.stream()
				.sorted()
				.filter(c -> c.getOrder() <= user.getConqueredCountryOrder())
				.forEach(country -> printNewLine(country.getName()));
		printNewLine("**************************");
	}
	
	@Override
	public void printWorldMap(Atlas atlas) {
		printNewLine("You have to concurred all countries to win the world map.");
		atlas.getCountries().forEach(country -> {
			printNewLine("))"+country.getName()+"("+country.getLanguage()+") O");
			country.getCities().forEach(city ->printSingleLine("-->"+city.getName()));
		});
	}
	
	@Override
	public void printSingleLine(String string) {
		System.out.print(string);
	}

	@Override
	public void printNewLine(String string) {
		System.out.println(string);
		
	}

	

}

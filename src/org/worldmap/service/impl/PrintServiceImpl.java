package org.worldmap.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.service.PrintService;

public class PrintServiceImpl implements PrintService{
	
Properties properties = new Properties();
	
	public PrintServiceImpl(){
		try {
			properties.load(new FileInputStream("resources/messages.properties"));
		} catch (IOException e) {
			e.printStackTrace();
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
	public void printUserDetail(User user) {
		System.out.println("**************************");
		/*System.out.println("Name: "+user.getName()+"\nCurrent battle country: "+user.getCurrentBattleCountry()+
				" \nCurrent battle city: "+user.getCurrentCity()+" \nPreiviously conquered country: "+String.join("\t", String.join(",", user.getConqueredCountry())) +
				" \nPriviously coonquered city: "+user.getLastConqueredCity()+"\nExperience point: "+user.getExperiencePoint());
		*///TODO
		System.out.println("**************************");
	}

	
	@Override
	public void printWorldMap(Map map) {
		System.out.print("You have to concurred all countries to win the world map.");
		map.getMapInfo().forEach(country -> {
			System.out.print("\n*))"+country.getName()+"("+country.getLanguage()+") O");
			country.getCities().forEach(city -> System.out.print("-->"+city.getName()));
		});
		System.out.print("\n");
	}
	@Override
	public void printStaticData(String data) {
		System.out.print(data);
		
	}

	

}

package org.worldmap.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.User;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.UserServiceImpl;

public class PrintConsole {

	Properties properties = new Properties();
	GameCore gameCore = new GameCore();
	 UserService userService = new UserServiceImpl();
	public void printQuestion(City city, User user) throws JAXBException {
		
		try {
			properties.load(new FileInputStream("resources/messages.properties"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
			System.out.print("\n"+properties.getProperty("question.text") + city.getName() + "\n" + city.getWord() + ":");
			Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			if (response.trim().equalsIgnoreCase(city.getTranslation().trim())) {
				printSingleMessage(city.getSuccessMessage()+"\n");
				user.setExperiencePoint(user.getExperiencePoint()+5); //TODO : increment amount configure
				city= gameCore.displayQuestion(user,false);
				if(city == null) {
					return;
				}
				printQuestion(city,user);
				
			} else {
				printSingleMessage(properties.getProperty("wrong.translation.message"));
				printQuestion(city,user);
			}
		
	}
	public void printProfile(User user) throws JAXBException {
		System.out.println("*********************");
		System.out.println("Name :"+user.getName());
		System.out.println("Current battle Country :"+user.getCurrentBattleCountry());
		System.out.println("Current battle City :"+user.getCurrentCity());
		System.out.println("Experience :"+user.getExperiencePoint());
		System.out.println("*********************");
		if(!user.isWonWorldMap()) {
			City city = gameCore.displayQuestion(user,true);
			if(city != null) {
				printQuestion(city,user);
			}
			else {
				return;
			}
		}
		else {
			System.out.println("\nYour won all the countries from world map."); //TODO :move to property
			return;
		}
		
	}

	public void printSingleMessage(String message) {
		System.out.print("\n"+message);
	}
	
	public void askUser(String name) throws JAXBException {
		try {
			properties.load(new FileInputStream("resources/messages.properties"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		printSingleMessage(properties.getProperty("newuser.message"));
		Scanner in = new Scanner(System.in); 
        String response = in.nextLine(); 
		boolean shouldCreateNewProfile=  response.equalsIgnoreCase("Y");
		if (shouldCreateNewProfile) {
			User newUser = userService.createUser(name);
			if(newUser!=null) {
				printProfile(newUser);
			}
		}else {
				printSingleMessage(properties.getProperty("exit.message"));
				return;
		}
	}
}

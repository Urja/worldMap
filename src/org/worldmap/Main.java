package org.worldmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.worldmap.model.User;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.UserServiceImpl;
import org.worldmap.util.PrintConsole;

public class Main {
	static UserService userService = new UserServiceImpl();
	static PrintConsole printConsole = new PrintConsole();
	static Properties properties = new Properties();
	
	public static void main(String[] args) {
		
		
		File file = new File("users.xml");
		try {
			properties.load(new FileInputStream("resources/messages.properties"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		printConsole.printSingleMessage(properties.getProperty("welcome.message"));
		Scanner in = new Scanner(System.in); 
        String name = in.nextLine(); 
		
		try {
			if (file.length() != 0) {
				Optional<User> user = userService.getUserProfile(name);
				if (!user.isPresent()) {
					printConsole.askUser(name);
				}
				else {
					printConsole.printProfile(user.get());
				}
			}
			else {
				printConsole.askUser(name);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

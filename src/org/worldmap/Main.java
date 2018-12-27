package org.worldmap;

import javax.xml.bind.JAXBException;

import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.GameDataService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.GameDataServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;
import org.worldmap.util.GameUtils;
import org.worldmap.util.UserInputUtils;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		PrintService printService = new PrintServiceImpl();
		GameDataService gameDataService = new GameDataServiceImpl();
		
		UserInputUtils userInputUtils = new UserInputUtils();
		GameUtils gameUtils = new GameUtils();

		try {

			printService.displayWelcomeMessage();

			String name = userInputUtils.askUserName();

			GameData gameData = gameDataService.loadGameData();
			printService.printWorldMap(gameData);
			User user = userService.getOrCreateUser(name, gameData);

			if (user != null) {
				printService.printUserDetail(user);
				gameUtils.startGame(user, gameData);
			} else {
				printService.printExitMessage();
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}

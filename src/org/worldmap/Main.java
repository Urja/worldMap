package org.worldmap;

import javax.xml.bind.JAXBException;

import org.worldmap.core.GameEngine;
import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.service.MapService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.MapServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;
import org.worldmap.util.InputUtils;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		PrintService printService = new PrintServiceImpl();
		MapService mapService = new MapServiceImpl();
		
		InputUtils inputUtils = new InputUtils();
		GameEngine gameEngine = new GameEngine();

		try {

			printService.printMessage("welcome.message");

			String name = inputUtils.askUserName();

			Map map = mapService.loadMap();
			printService.printWorldMap(map);
			User user = userService.getOrCreateUser(name, map);

			if (user != null) {
				printService.printUserDetail(user);
				gameEngine.startGame(user, map);
				
			} else {
				printService.printMessage("exit.message");
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}

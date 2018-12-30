package org.worldmap;

import org.worldmap.exception.AtlasDataException;
import org.worldmap.model.Atlas;
import org.worldmap.model.User;
import org.worldmap.service.AtlasService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.AtlasServiceImpl;
import org.worldmap.service.impl.GameEngineServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		PrintService printService = new PrintServiceImpl();
		UserService userService = new UserServiceImpl();
		AtlasService atlasService = new AtlasServiceImpl();
		GameEngineServiceImpl gameEngineService = new GameEngineServiceImpl();

		printService.printMessage("welcome.message");
		User user = userService.askAndGetUser();
		if (user != null) {
			Atlas atlas;
			try {
				atlas = atlasService.loadAtlas();
				if (atlas.getCountries().size() != user.getConqueredCountryOrder())
					printService.printWorldMap(atlas);

				printService.printUserDetail(user, atlas.getCountries());
				gameEngineService.startGame(user, atlas);
			} catch (AtlasDataException e) {
				printService.print(e.getMessage());
			}
		} else {
			printService.printMessage("exit.message");
		}
	}
}

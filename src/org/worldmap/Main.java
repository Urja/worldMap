package org.worldmap;

import java.util.Optional;

import org.worldmap.exception.AtlasDataException;
import org.worldmap.exception.UserException;
import org.worldmap.model.Atlas;
import org.worldmap.model.User;
import org.worldmap.service.AtlasService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.AtlasServiceImpl;
import org.worldmap.service.impl.GameEngineServiceImpl;
import org.worldmap.service.impl.PrintServiceImpl;
import org.worldmap.service.impl.UserServiceImpl;
import org.worldmap.util.InputUtils;

public class Main {
	static UserService userService = new UserServiceImpl();
	
	public static void main(String[] args) {
		AtlasService atlasService = new AtlasServiceImpl();
		PrintService printService = new PrintServiceImpl();
		GameEngineServiceImpl gameEngineService = new GameEngineServiceImpl();
		printService.printMessage("welcome.message");
		
		User user = askAndGetUser();
		if(user == null) {
			printService.printMessage("exit.message");
			return;
		}
		try {
			Atlas atlas = atlasService.loadAtlas();
			if (atlas.getCountries().size() != user.getConqueredCountryOrder())
				printService.printWorldMap(atlas);

			printService.printUserDetail(user, atlas.getCountries());
			gameEngineService.startGame(user, atlas);
		} catch (AtlasDataException e) {
			printService.print(e.getMessage());
		}
	}

	private static User askAndGetUser() {
		String name = InputUtils.askUserName();
		try {
			Optional<User> user = userService.getUser(name);
			if(!user.isPresent()) {
				if(InputUtils.askNewUserConfirmation()) {
					return userService.createUser(name);
				}
				else {
					return null;
				}
			}
			else {
				return user.get();
			}
		} catch (UserException e) {
			return askAndGetUser();
		}
		
	}
}

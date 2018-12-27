package org.worldmap.service.impl;

import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.CountryService;

public class CountryServiceImpl implements CountryService{

	@Override
	public Country getCurrentCountryByUser(GameData gameData, User user) {
		for(int i=0; i< gameData.getGameData().size();i++) {
			if(gameData.getGameData().get(i).getName().equalsIgnoreCase(user.getCurrentBattleCountry())){
				return gameData.getGameData().get(i);
			}
		}
		return null; //TODO:use stream and return optional
	}

	@Override
	public Country getNextCountryByUser(GameData gameData, User user) {
		for(int i=0; i< gameData.getGameData().size();i++) {
			if(gameData.getGameData().get(i).getName().equalsIgnoreCase(user.getCurrentBattleCountry())) {
				if(i+1 < gameData.getGameData().size()) {
					return gameData.getGameData().get(i+1);
				}
			}
		}
		return null;  //TODO:use stream and return optional
	}

}

package org.worldmap.service;

import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;

public interface CountryService {
	Country getCurrentCountryByUser(GameData gameData, User user);

	Country getNextCountryByUser(GameData gameData, User user);
}

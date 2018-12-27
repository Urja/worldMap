package org.worldmap.service;

import java.util.Optional;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;

public interface CityService {
	

	Optional<City> getCurrentCityByUser(Country country, User user);

	City  getNextCityByUser(Country country, User user);

}

package org.worldmap.service.impl;

import java.util.List;
import java.util.Optional;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.service.CityService;

public class CityServiceImpl implements CityService{


	@Override
	public Optional<City> getCurrentCityByUser(Country country, User user) {
		return country.getCities().stream().filter(city -> city.getName().equals(user.getCurrentCity())).findFirst();
	}
	
	@Override
	public City getNextCityByUser(Country country, User user) {
		for(int i=0; i< country.getCities().size();i++) {
			if(country.getCities().get(i).getName().equalsIgnoreCase(user.getCurrentCity())) {
				if(i+1 < country.getCities().size()) {
					return country.getCities().get(i+1);
				}
			}
		}
		return null;  //TODO:use stream and return optional
	}

}

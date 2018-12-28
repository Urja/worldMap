package org.worldmap.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.Map;
import org.worldmap.model.User;

public interface MapService {
	
	Map loadMap() throws JAXBException;
	List<City> getCitiesToPlay(Country country, User user);
	List<Country> getCountriesToPlay(List<Country> list, User user);
	
}

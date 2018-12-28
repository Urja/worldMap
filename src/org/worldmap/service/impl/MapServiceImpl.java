package org.worldmap.service.impl;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.service.MapService;

public class MapServiceImpl implements MapService{

	@Override
	public Map loadMap() throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Map.class);
		Unmarshaller un = context.createUnmarshaller();
		Map map = (Map) un.unmarshal(new File("map.xml"));
		return map;
	}

	@Override
	public List<City> getCitiesToPlay(Country country, User user) {
		return country.getCities().subList(user.getConqueredCityOrder(), country.getCities().size()); //TODO: Order issue
	}

	@Override
	public List<Country> getCountriesToPlay(List<Country> list, User user) {
		return list.subList(Collections.max(user.getConqueredCountry()), list.size());
	}

}

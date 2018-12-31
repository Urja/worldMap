package org.worldmap.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.worldmap.model.Atlas;
import org.worldmap.model.City;
import org.worldmap.model.Country;
import org.worldmap.model.User;
import org.worldmap.service.GameEngineService;
import org.worldmap.service.impl.GameEngineServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineServiceImplTest {

	GameEngineService gameEngineService = new GameEngineServiceImpl();
	User user =new User("test-User");
	Atlas atlas =new Atlas();
	
	@Before
	public void testSetup(){
		loadAtlasTestData();
	}

	@Test
	public void testStartGame() {
		gameEngineService.startGame(user, atlas);
		assertTrue(true);
	}
	
	private void loadAtlasTestData() {
		City city = new City();
		city.setName("TestCity");
		city.setOrder(1);
		city.setWord("testWord");
		city.setTranslation("testTranslation");
		city.setSuccessMessage("testSuccessMessage");
		List<City> cities = new ArrayList<>();
		cities.add(city);
		Country country =new Country();
		country.setName("testCountr");
		country.setOrder(1);
		country.setLanguage("testLanguage");
		country.setCities(cities);
		List<Country> countries = new ArrayList<>();
		countries.add(country);
		atlas.setCountries(countries);
		
	}

}

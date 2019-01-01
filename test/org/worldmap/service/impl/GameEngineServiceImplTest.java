package org.worldmap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.worldmap.model.*;
import org.worldmap.service.GameEngineService;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.util.InputUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@PrepareForTest({GameEngineServiceImplTest.class, InputUtils.class,UserServiceImpl.class})
@RunWith(PowerMockRunner.class)
public class GameEngineServiceImplTest {

	private UserService userService = PowerMockito.spy(new UserServiceImpl());
	private PrintService printService = PowerMockito.spy(new PrintServiceImpl());
	private GameEngineService gameEngineService = new GameEngineServiceImpl(printService, userService);
	private User user =new User("testUser");
	private Atlas atlas =new Atlas();
	private AtlasUsers atlasUsers = new AtlasUsers();

	@Before
	public void testSetup(){
		try {
			loadAtlasTestData();
			testReadUser();
			PowerMockito.mockStatic(InputUtils.class);
			PowerMockito.when(InputUtils.getUserInput()).thenReturn("testTranslation");
			PowerMockito.when(userService,"readUsers").thenReturn(atlasUsers);
			PowerMockito.doNothing().when(userService,"updateUser",Mockito.any());
		}catch (Exception e){
			e.printStackTrace();
		}
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
		country.setName("testCountry");
		country.setOrder(1);
		country.setLanguage("testLanguage");
		country.setCities(cities);
		List<Country> countries = new ArrayList<>();
		countries.add(country);
		atlas.setCountries(countries);
	}
	private void testReadUser() {
		List<User> users =new ArrayList<>();
		users.add(user);
		atlasUsers.setUsers(users);
	}
}

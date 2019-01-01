package org.worldmap.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.worldmap.exception.UserException;
import org.worldmap.model.AtlasUsers;
import org.worldmap.model.User;
import org.worldmap.service.UserService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@PrepareForTest({UserServiceImpl.class,Marshaller.class,JAXBContext.class,AtlasUsers.class})
@RunWith(PowerMockRunner.class)
public class UserServiceImplTest {

	private UserService userService = PowerMockito.spy(new UserServiceImpl());
	private String name= "testUser";
	private AtlasUsers atlasUsers = new AtlasUsers();

	@Before
	public void testSetup(){
		try {
			testReadUser();
			PowerMockito.when(userService,"readUsers").thenReturn(atlasUsers);
			PowerMockito.doNothing().when(userService,"writeUsers",Mockito.any());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateUser() {
		try {
			User user = userService.createUser(name);
			assertEquals(user.getName(),name);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testGetUserExistingUser() {
		try {
			Optional<User> user = userService.getUser(name);
			assert(user.isPresent());
		} catch (UserException e) {
			fail();
		}
	}
	
	@Test
	public void testGetUserUnknownUser() {
		try {
			Optional<User> user = userService.getUser("unknown-user");
			assert(!user.isPresent());
		} catch (UserException  e) {
			fail();
		}
	}

	@Test
	public void testGetUserWithInvalidName() {
		String invalidName = "<";
		try {
			Optional<User> user = userService.getUser(invalidName);
			assertFalse(user.isPresent());
		} catch (UserException e) {
			assertEquals("Invalid User Name '"+ invalidName +"'", e.getMessage());
		}
	}
	
	private void testReadUser() {
		User user =new User(name);
		List<User> users =new ArrayList<>();
		users.add(user);
		atlasUsers.setUsers(users);
	}
}

package org.worldmap.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.worldmap.exception.UserException;
import org.worldmap.model.AtlasUsers;
import org.worldmap.model.User;
import org.worldmap.service.UserService;
import org.worldmap.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	private UserService userService = new UserServiceImpl();
	
	private String name= "testUser";
	
	private String invalidName ="<";
	
	AtlasUsers atlasUsers = new AtlasUsers();
	
	@Mock
	Unmarshaller unmarshaller;
	
	@Mock
	File file;
	
	@Mock
	Marshaller marshaller;
	
	@Mock
	JAXBContext jaxbContext;
	
	
	@Test
	public void testCreateUser() {
		try {
			Mockito.when( jaxbContext.createUnmarshaller()).thenReturn(unmarshaller);
			Mockito.when( jaxbContext.createMarshaller()).thenReturn(marshaller);
			User user = userService.createUser(name);
			assertEquals(user.getName(),name);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testGetUserExistingUser() {
		try {
			Mockito.when(unmarshaller.unmarshal(file)).thenReturn(atlasUsers); 
			Optional<User> user = userService.getUser(name);
			assert(user.isPresent());
		} catch (UserException |JAXBException e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testGetUserUnknownUser() {
		try {
			Mockito.when(unmarshaller.unmarshal(file)).thenReturn(atlasUsers); 
			Optional<User> user = userService.getUser("unknown-user");
			assert(!user.isPresent());
		} catch (UserException | JAXBException e) {
			assertFalse(true);
		}
	}

	@Test
	public void testGetUserWithInvalidName() {
		try {
			Mockito.when(unmarshaller.unmarshal(file)).thenReturn(atlasUsers); 
			Optional<User> user = userService.getUser(invalidName);
			assertFalse(user.isPresent());
		} catch (UserException |JAXBException e) {
			assertEquals("Invalid User Name '"+invalidName+"'", e.getMessage());
		}
	}
	
	private AtlasUsers testReadUser() {
		User user =new User(name);
		List<User> users =new ArrayList<>();
		users.add(user);
		atlasUsers.setUsers(users);
		return atlasUsers;
	}
}

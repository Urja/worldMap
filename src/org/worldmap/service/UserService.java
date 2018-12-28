package org.worldmap.service;

import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.worldmap.model.City;
import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.model.Users;

public interface UserService {
	
	User getOrCreateUser(String name, Map map) throws JAXBException;
	User createUser(String name, Map map) throws JAXBException;
	void updateUser(User user) throws JAXBException;
	Users readUsers() throws JAXBException;
	void writeUsers(Users users) throws JAXBException;
}

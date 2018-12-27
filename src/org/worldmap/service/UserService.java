package org.worldmap.service;

import javax.xml.bind.JAXBException;

import org.worldmap.model.GameData;
import org.worldmap.model.User;
import org.worldmap.model.Users;

public interface UserService {
	
	User getOrCreateUser(String name, GameData gameData) throws JAXBException;
	User createUser(String name, GameData gameData) throws JAXBException;
	User updateUser(User user) throws JAXBException;
	Users readUsers() throws JAXBException;
	void writeUsers(Users users) throws JAXBException;
}

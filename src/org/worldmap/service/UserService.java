package org.worldmap.service;

import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.worldmap.model.User;
import org.worldmap.model.Users;

public interface UserService {
	User createUser(String name) throws JAXBException;
	void updateUser(User user) throws JAXBException;
	Optional<User>  getUserProfile(String name) throws JAXBException;
	//void askUser(String name) throws JAXBException;//Delete after testing
	Users readUserXml() throws JAXBException;
	void writeUserXml(Users users) throws JAXBException;
}

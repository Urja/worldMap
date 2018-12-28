package org.worldmap.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.worldmap.model.Map;
import org.worldmap.model.User;
import org.worldmap.model.Users;
import org.worldmap.service.UserService;
import org.worldmap.util.InputUtils;

public class UserServiceImpl implements UserService {

	File file = new File("users.xml");
	 InputUtils inputUtils = new InputUtils();
	 
	@Override
	public User createUser(String name, Map gameData) throws JAXBException {
		User user = new User(name);
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Users users;

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (file.length() != 0) {
				users = (Users) jaxbUnmarshaller.unmarshal(file);
				users.getUsers().add(user);
			} else {
				
				users = new Users();
				List<User> userList =new ArrayList<>();
				userList.add(user);
				users.setUsers(userList);
			}
			writeUsers(users);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return user;
	}

	
	@Override
	public User getOrCreateUser(String name, Map gameData) throws JAXBException {
		Users users = readUsers();
		if (users != null) {
			Optional<User> user = users.getUsers().stream().filter(x -> name.equals(x.getName())).findAny();
			if (user.isPresent()) {
				return user.get();
			} else {
				if (inputUtils.askNewUserConfirmation()) {
					User newUser = createUser(name,gameData);
					return newUser; //User instead of optional because User constructor returns user
				} else {
					return null;
				}
			}
		} else {
			if (inputUtils.askNewUserConfirmation()) {
				User newUser = createUser(name,gameData);
				return newUser;
			} else {
				return null;
			}
		}
	}
	@Override
	public void updateUser(User user) throws JAXBException {

		Users users = readUsers();
		users.getUsers().forEach(userElement -> {
			if (userElement.getName().equals(user.getName())) {
				userElement.setConqueredCityOrder(user.getConqueredCityOrder());
				userElement.setConqueredCountry(user.getConqueredCountry());
				userElement.setExperiencePoint(user.getExperiencePoint());
			}
			
		});
		writeUsers(users);
	}

	@Override
	public Users readUsers() throws JAXBException {
		if (file.length() != 0) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Users users = (Users) jaxbUnmarshaller.unmarshal(file);
			return users;
		}
		return null;
	}

	@Override
	public void writeUsers(Users users) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(users, file);
	}

}

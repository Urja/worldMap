package org.worldmap.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.worldmap.model.User;
import org.worldmap.model.Users;
import org.worldmap.service.UserService;

public class UserServiceImpl implements UserService {

	File file = new File("users.xml");
	Properties properties = new Properties();
	
	@Override
	public User createUser(String name) throws JAXBException {
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
			writeUserXml(users);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) throws JAXBException {

		Users users = readUserXml();
		users.getUsers().forEach(userElement -> {
			if (userElement.getName().equals(user.getName())) {
				userElement.setConqueredCountry(user.getConqueredCountry());
				userElement.setCurrentBattleCountry(user.getCurrentBattleCountry());
				userElement.setLastConqueredCity(user.getLastConqueredCity());
				userElement.setCurrentCity(user.getCurrentCity());
				userElement.setExperiencePoint(user.getExperiencePoint());
			}
		});
		writeUserXml(users);
	}

	@Override
	public Optional<User> getUserProfile(String name) throws JAXBException {
		Users users = readUserXml();
		Optional<User> user = users.getUsers().stream().filter(x -> name.equals(x.getName())).findAny();
		return user;
	}

	@Override
	public Users readUserXml() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Users users = (Users) jaxbUnmarshaller.unmarshal(file);
		return users;
	}

	@Override
	public void writeUserXml(Users users) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(users, file);

	}

}

package org.worldmap.service.impl;

import org.worldmap.exception.UserException;
import org.worldmap.model.AtlasUsers;
import org.worldmap.model.User;
import org.worldmap.service.PrintService;
import org.worldmap.service.UserService;
import org.worldmap.util.WorldMapConstant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

	File file = new File(WorldMapConstant.USER_FILE);
	PrintService printService = new PrintServiceImpl();

	@Override
	public void updateUser(User user) throws UserException {
		AtlasUsers atlasUsers = readUsers();
		atlasUsers.getUsers().forEach(userElement -> {
			if (userElement.getName().equals(user.getName())) {
				userElement.setConqueredCityOrder(user.getConqueredCityOrder());
				userElement.setConqueredCountryOrder(user.getConqueredCountryOrder());
				userElement.setExperiencePoint(user.getExperiencePoint());
			}
		});
		writeUsers(atlasUsers);
	}

	private AtlasUsers readUsers() throws UserException {
		if (file.length() == 0) {
			return null;
			// TODO throw exception
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AtlasUsers.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (AtlasUsers) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			throw new UserException("Read User :" + e.getLocalizedMessage());
		}
	}

	private void writeUsers(AtlasUsers atlasUsers) throws UserException {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(AtlasUsers.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(atlasUsers, file);
		} catch (JAXBException e) {
			throw new UserException("Write User :" + e.getLocalizedMessage());
		}
	}

	@Override
	public Optional<User> getUser(String name) throws UserException {
		if (name == null || name.isEmpty() || name.matches(WorldMapConstant.INVALID_CHARACTERS)) {
			throw new UserException("Invalid User Name '" + name + "'");
		}
		AtlasUsers atlasUsers = readUsers();
		if (atlasUsers != null) {
			return atlasUsers.getUsers().stream().filter(x -> name.equals(x.getName())).findAny();
		}
		return Optional.empty();
	}

	@Override
	public User createUser(String name) throws UserException {
		User user = new User(name);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AtlasUsers.class);
			AtlasUsers atlasUsers;
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (file.length() != 0) {
				atlasUsers = (AtlasUsers) jaxbUnmarshaller.unmarshal(file);
				atlasUsers.getUsers().add(user);
			} else {
				atlasUsers = new AtlasUsers();
				List<User> userList = new ArrayList<>();
				userList.add(user);
				atlasUsers.setUsers(userList);
			}
			writeUsers(atlasUsers);
		} catch (JAXBException e) {
			throw new UserException("Create User :" + e.getLocalizedMessage());
		}
		return user;
	}

}

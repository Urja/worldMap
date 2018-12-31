package org.worldmap.service;

import java.util.Optional;

import org.worldmap.exception.UserException;
import org.worldmap.model.AtlasUsers;
import org.worldmap.model.User;

/**
 * 
 * @author uramanan
 * User related operations
 */
public interface UserService {
	
	void updateUser(User user) throws UserException;
	Optional<User> getUser(String name) throws UserException;
	User createUser(String name) throws UserException;
}

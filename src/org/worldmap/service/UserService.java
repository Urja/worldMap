package org.worldmap.service;

import org.worldmap.exception.UserException;
import org.worldmap.model.User;

import java.util.Optional;

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

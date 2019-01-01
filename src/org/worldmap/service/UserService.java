package org.worldmap.service;

import org.worldmap.exception.UserException;
import org.worldmap.model.User;

import java.util.Optional;

/**
 * Use for user related operations.
 * @author uramanan
 */
public interface UserService {
	
	void updateUser(User user) throws UserException;
	Optional<User> getUser(String name) throws UserException;
	User createUser(String name) throws UserException;
}

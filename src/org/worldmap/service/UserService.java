package org.worldmap.service;

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
	AtlasUsers readUsers() throws UserException;
	User askAndGetUser();
}

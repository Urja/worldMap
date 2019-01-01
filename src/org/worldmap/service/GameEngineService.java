package org.worldmap.service;

import org.worldmap.model.Atlas;
import org.worldmap.model.User;

/**
 * 
 * @author uramanan 
 * Core game functions are handle by Game Engine by playCountry and playCity methods
 */
public interface GameEngineService {
	void startGame(User user, Atlas atlas);
}

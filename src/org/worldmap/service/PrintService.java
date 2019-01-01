package org.worldmap.service;

import org.worldmap.model.Atlas;
import org.worldmap.model.Country;
import org.worldmap.model.User;

import java.util.List;

/**
 * 
 * @author uramanan
 * Use service when any message needs to be print from application
 */
// TODO format javadoc
public interface PrintService {

	// TODO method name consistency
	// TODO remove ambiguity with "message"
	// TODO add javadoc explaining the difference between print() and printMessage()

	void printMessage(String message);
	void printUserDetail(User user, List<Country> countries);
	void printSingleLineMessage(String message);
	void printWorldMap(Atlas atlas);
	void print(String message);
	void printNewLine(String message);
	
}

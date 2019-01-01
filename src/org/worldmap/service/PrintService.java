package org.worldmap.service;

import org.worldmap.model.Atlas;
import org.worldmap.model.Country;
import org.worldmap.model.User;

import java.util.List;

/**
 * Use service when any message needs to be print from application.
 * @author uramanan
 */
public interface PrintService {

	/** Get message from property file and print message using println method. **/
	void printNewLineMessage(String key);
	/** Get message from property file and print message using print method. **/
	void printSingleLineMessage(String key);
	void printUserDetail(User user, List<Country> countries);
	void printWorldMap(Atlas atlas);
	/** Print string using print method. **/
	void printSingleLine(String string);
	/** Print string using println method. **/
	void printNewLine(String string);
	
}

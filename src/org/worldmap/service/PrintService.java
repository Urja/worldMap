package org.worldmap.service;

import java.util.List;

import org.worldmap.model.Country;
import org.worldmap.model.Atlas;
import org.worldmap.model.User;

/**
 * 
 * @author uramanan
 * Use service when any message needs to be print from application
 */
public interface PrintService {
	
	void printCountryConcouredMessage(String countryName);
	void printMessage(String message);
	void printUserDetail(User user, List<Country> countries);
	void printSingleLineMessage(String message);
	void printWorldMap(Atlas atlas);
	void print(String message);
	void printNewLine(String message);
	
}

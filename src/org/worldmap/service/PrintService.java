package org.worldmap.service;

import org.worldmap.model.Map;
import org.worldmap.model.User;

public interface PrintService {
	
	void printCountryConcouredMessage(String countryName);
	void printMessage(String message);
	void printUserDetail(User user);
	void printSingleLineMessage(String message);
	void printWorldMap(Map gameData);
	void printStaticData(String data);
	
}

package org.worldmap.service;

import org.worldmap.model.GameData;
import org.worldmap.model.User;

public interface PrintService {
	void displayWelcomeMessage();
	void printCountryConcouredMessage(String countryName);
	void printQuestion(String message, String cityName);
	void printErrorMessage();
	void printMessage(String message);
	void printUserDetail(User user);
	void printExitMessage();
	void printDataErrorMessage();
	void printWonGameMessage();
	void printSingleLineMessage(String message);
	void printWorldMap(GameData gameData);
}

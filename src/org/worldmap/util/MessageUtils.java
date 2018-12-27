package org.worldmap.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageUtils {

	Properties properties = new Properties();
	
	public MessageUtils(){
		try {
			properties.load(new FileInputStream("resources/messages.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getWelcomeMessage() {
		return properties.getProperty("welcome.message");
	}

	public String getUserNameInputMessage() {
		return properties.getProperty("username.input.message");
	}

	public String getNewUSerConfirmationMessage() {
		return properties.getProperty("newuser.message");
	}

	public String getInvalidInputMessage() {
		return properties.getProperty("invalid.input");
	}

	public String getExitMessage() {
		return properties.getProperty("exit.message");
		
	}

	public String getDataErrorMessage() {
		return properties.getProperty("data.error");
	}

	public String getQuestionText() {
		return properties.getProperty("question.text");
		
	}

	public String getErrorMessage() {
		return properties.getProperty("wrong.translation.message");
	}
	
	public String getWonGameMessage() {
		return properties.getProperty("game.won.message");
	}
	
	public String getCountryConcouredMessage() {
		return properties.getProperty("country.conquered.message");
	}
	
}

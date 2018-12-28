package org.worldmap.util;

import java.util.Scanner;

import org.worldmap.service.PrintService;
import org.worldmap.service.impl.PrintServiceImpl;

public class InputUtils {
	static PrintService printService = new PrintServiceImpl();
	
	public String askUserName() {

		printService.printSingleLineMessage("name.message");

		Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			return response;
		
	}
	public boolean askNewUserConfirmation() {

		printService.printSingleLineMessage("newuser.message");

		Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes") || response.isEmpty())
				return true;
			else if (response.equalsIgnoreCase("N") || response.equalsIgnoreCase("No"))
				return false;
			else {
				printService.printMessage("invalid.input");
				return false;
			}
		
	}
	public String getAnswerFromUser() {
		Scanner in = new Scanner(System.in);
			return in.nextLine();
	}

}

package org.worldmap.util;

import org.worldmap.service.PrintService;
import org.worldmap.service.impl.PrintServiceImpl;

import java.util.Scanner;

/**
 * Util used when ever any input is required from User.
 * @author uramanan
 */
public class InputUtils {
	private static PrintService printService = new PrintServiceImpl();
	private static Scanner in = new Scanner(System.in);

	private InputUtils() {}
	public static String askUserName() {
		printService.printSingleLineMessage("name.message");
		return getUserInput();
	}

	public static boolean askNewUserConfirmation() {
		printService.printSingleLineMessage("newuser.message");
		String response = getUserInput();
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes") || response.isEmpty())
			return true;
		else if (response.equalsIgnoreCase("N") || response.equalsIgnoreCase("No"))
			return false;
		else {
			printService.printNewLineMessage("invalid.input");
			return false;
		}
	}

	public static String getUserInput() {
		return in.nextLine();
	}

}

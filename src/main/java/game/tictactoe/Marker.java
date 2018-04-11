package game.tictactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

import game.tictactoe.enums.ConfigMarkers;

/**
 * @author vish Provides the user with the option to select his/her own board
 *         markers for the game. Default markers: X and O
 */
public class Marker {

	private Scanner scan = new Scanner(System.in);
	public static String marker1;
	public static String marker2;
	private char input;
	private boolean flag = true;
	private boolean inputSymbol = true;

	private String regex = "^[A-Z]+$";
	private Pattern pattern = Pattern.compile(regex);

	// takes input from the user
	public void markers() {
		System.out.println("Would you like to configure the symbols you want to play with?");
		System.out.print("Please enter \"y\" or \"Y\" for yes and \"n\" or \"N\" for no: ");
		while (flag) {
			checkInputDecision(scan.next().charAt(0));
		}
		System.out.println("Your symbols for the game are: " + marker1 + " and " + marker2);
	}

	// checks for user's input and gives prompts accordingly
	public void checkInputDecision(char input) {
		if (input == 'y' || input == 'Y') {
			while (inputSymbol) {
				System.out.println("Enter Marker 1: ");
				marker1 = scan.next();
				System.out.println("Enter Marker 2: ");
				marker2 = scan.next();
				validateMarker(marker1, marker2);
				flag = false;
			}
		} else if (input == 'n' || input == 'N') {
			marker1 = ConfigMarkers.CROSS.getMarker();
			marker2 = ConfigMarkers.NOUGHT.getMarker();
			inputSymbol = false;
			flag = false;
		} else {
			System.out.println("Enter your decision again. Should be y/Y or n/N");
		}
	}

	// validates the markers entered by the user
	public void validateMarker(String marker1, String marker2) {

		if (pattern.matcher(marker1).matches() != true || pattern.matcher(marker2).matches() != true) {
			System.out.println("Please enter only capital letters [A-Z]");
		} else if (marker1.equals(marker2)) {
			System.out.println("Both the symbols cannot be the same.");
		} else {
			inputSymbol = false;
		}
	}
}

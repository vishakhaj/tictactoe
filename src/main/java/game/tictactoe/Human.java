package game.tictactoe;

import java.util.Scanner;

import game.tictactoe.enums.Players;

/**
 * @author vish Allows the human makes his/her move on the board
 *
 */
public class Human extends Move {

	private Scanner scan = new Scanner(System.in);
	private boolean flag = true;
	private String input;
	private String playerSelection;
	private String regex = "\\d+,\\d+";

	// inputs user's move
	public String makeMove(Players currentPlayer) {
		flag = true;
		System.out.println(currentPlayer.toString() + ": Enter your move: ");
		while (flag) {
			input = scan.next();
			if (input.matches(regex)) {
				playerSelection = input.replaceAll(",", "");
				validatePlayerSelection(playerSelection);
			} else {
				System.err.println("Please enter in the correct format. For eg: 1,1 or 3,3");
			}
		}
		super.storeCurrentMove(playerSelection, currentPlayer);
		super.printAllMoves();
		return playerSelection;
	}

	// validates user's selection
	public void validatePlayerSelection(String playerSelection) {
		
		if (playerSelection == null) {
			throw new NullPointerException();
		}
		if (boardSet.contains(playerSelection)) {
			System.err.println("Cell already taken. Please select a different move.");
		} else {
			flag = false;
		}
	}

}

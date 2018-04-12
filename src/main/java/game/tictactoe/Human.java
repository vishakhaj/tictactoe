package game.tictactoe;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import game.tictactoe.enums.Players;

/**
 * @author vish Allows the human makes his/her move on the board
 *
 */
public class Human extends Move {

	Scanner scan = new Scanner(System.in);
	private String input;
	private String playerSelection;
	private boolean flag = true;
	private String regex = "[0-9, /,]+";
	private Pattern pattern = Pattern.compile(regex);

	// inputs user's move
	public String makeMove(Players currentPlayer, List<String> listOfIndex) {
		flag = true;

		while (flag) {
			System.out.println(currentPlayer.toString() + ": Enter your move: ");
			input = scan.next();
			playerSelection = input.replaceAll(",", "");
			validatePlayerSelection(playerSelection, listOfIndex);
		}
		super.storeCurrentMove(playerSelection, currentPlayer);
		super.printAllMoves();
		return playerSelection;
	}

	// validates user's selection
	public void validatePlayerSelection(String playerSelection, List<String> listOfIndex) {
		try {

			if (playerSelection == null || playerSelection.isEmpty()) {
				throw new NullPointerException();
			} else if (Integer.parseInt(playerSelection) < 11
					|| Integer.parseInt(playerSelection) > ((Board.boardSize * 10) + Board.boardSize)) {
				System.err.println("The input you have entered cannot be found on the board");
			} else if (listOfIndex.contains(playerSelection)) {
				System.err.println("Cell already taken. Please select a different move.");
			} else {
				flag = false;
			}

		} catch (NumberFormatException e) {
			System.err.println("The input must be a number on the board");
		}
	}

}

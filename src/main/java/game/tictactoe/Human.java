package game.tictactoe;

import java.util.Scanner;

import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

/**
 * @author vish Allows the human makes his/her move on the board
 *
 */
public class Human {

	Scanner scan = new Scanner(System.in);
	private String input;
	private String playerSelection;
	private boolean flag = true;

	// inputs user's move
	public String makeMove(Players currentPlayer) {
		flag = true;
		while (flag) {
			System.out.println(currentPlayer.toString() + ": Enter your move: ");
			input = scan.next();
			playerSelection = input.replaceAll(",", "");
			validatePlayerSelection(playerSelection);
		}
		storeCurrentMove();
		printAllMoves();
		return playerSelection;
	}

	// validates user's selection
	public void validatePlayerSelection(String playerSelection) {
		try {
			if (playerSelection == null || playerSelection.isEmpty()) {
				throw new NullPointerException();
			} else if (Integer.parseInt(playerSelection) < 11
					|| Integer.parseInt(playerSelection) > ((Board.boardSize * 10) + Board.boardSize)) {
				System.out.println("The input you have entered cannot be found on the board");
			} else {
				flag = false;
			}

		} catch (NumberFormatException e) {
			System.out.println("The input must be a number on the board");
		}
	}

	private void storeCurrentMove() {
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				if ((((i + 1) * 10) + (j + 1)) == Integer.parseInt(playerSelection)) {
					Game.boardSizeArray[i][j] = Seed.MARKER1;
				}
			}
		}
	}

	// prints the current selected move as well as all the previously played
	// moves
	private void printAllMoves() {
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				if (Game.boardSizeArray[i][j] == Seed.MARKER1) {
					System.out.print(Seed.MARKER1.getMarker() + "\t");
				} else if (Game.boardSizeArray[i][j] == Seed.MARKER2) {
					System.out.print(Seed.MARKER2.getMarker() + "\t");
				} else {
					System.out.print((i + 1) + "," + (j + 1) + "\t");
				}
			}
			System.out.println("");
		}
	}
}

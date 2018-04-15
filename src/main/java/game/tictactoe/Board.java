package game.tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author vish- Inputs board size from the user.
 */
public class Board {

	private Scanner scan = new Scanner(System.in);
	private boolean flag = true;

	public static int boardSize;
	public static Set<String> diagonalSet = new HashSet<>();

	public int inputBoardSize() {
		System.out.print("Enter the number of grids you want to play with:");
		while (flag) {
			try {
				boardSize = validateBoardSize(Integer.parseInt(scan.nextLine()));
			} catch (NumberFormatException e) {
				System.err.println("Please enter a number");
			}
		}
		printBoard(boardSize);
		return boardSize;
	}

	public int validateBoardSize(int input) {
		if (input < 3 || input > 10) {
			System.err.println("Please choose a board size between 3 and 10");
		} else {
			flag = false;
		}
		return input;
	}

	private void printBoard(int boardSize) {

		for (int i = 0, k = boardSize; i < boardSize; i++, k--) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print((i + 1) + "," + (j + 1) + "\t");
			}
			System.out.println("");
			diagonalSet.add(String.valueOf(i + 1) + String.valueOf(k));
		}
	}
}

package game.tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import game.tictactoe.enums.Seed;

/**
 * @author vish- Inputs board size from the user.
 */
public class Board {

	private Scanner scan = new Scanner(System.in);
	public static int boardSize;
	public static Set<String> diagonalSet = new HashSet<>();
	private boolean flag = true;

	public int inputBoardSize() {
		while (flag) {
			System.out.print("Enter the number of grids you want to play with:");
			boardSize = validateBoardSize(scan.next());
		}
		printBoard(boardSize);
		return boardSize;
	}

	public int validateBoardSize(String input) {
		try {
			boardSize = Integer.parseInt(input);
			if (boardSize < 3 || boardSize > 10) {
				System.err.println("Please choose a board size between 3 and 10");
			} else {
				flag = false;
				return Integer.parseInt(input);
			}
		} catch (NumberFormatException e) {
			e.getMessage();
			System.err.println("Please enter a number");
		}
		return 0;
	}

	private void printBoard(int boardSize) {

		for (int i = 0, k = boardSize; i < boardSize; i++, k--) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print((i + 1) + "," + (j + 1) + "\t");
				Game.boardSizeArray[i][j] = Seed.EMPTY;
			}
			diagonalSet.add(String.valueOf(i + 1) + String.valueOf(k));
			System.out.println("");
		}
	}
}

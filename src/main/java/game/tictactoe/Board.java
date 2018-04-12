package game.tictactoe;

import java.util.Scanner;

import game.tictactoe.enums.Seed;

/**
 * @author vish- Inputs board size from the user.
 */
public class Board {

	private Scanner scan = new Scanner(System.in);
	public static int boardSize;
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

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print((i + 1) + "," + (j + 1) + "\t");
				Game.boardSizeArray[i][j] = Seed.EMPTY;
			}
			System.out.println("");
		}
	}
}

package game.tictactoe;

import game.tictactoe.enums.GameState;
import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

public class Winner {

	public GameState checkWin(int boardSize, Seed boardSizeArray[][]) {
		int row = 0;
		int col = 0;
		int diagonalCountLTR_X = 0;
		int diagonalCountLTR_O = 0;
		int diagonalCountRTL_X = 0;
		int diagonalCountRTL_O = 0;

		while (row < boardSize) {
			int counthorX = 0;
			int counthorO = 0;
			for (int j = 0; j < boardSize; j++) {
				if (boardSizeArray[row][j] == Seed.MARKER1) {
					counthorX += 1;
				}
				if (boardSizeArray[row][j] == Seed.MARKER2) {
					counthorO += 1;
				}
			}
			row++;

			if (counthorX == 3) {
				System.out.println("Winner: " + Players.HUMAN);
				return GameState.WINNER;
			}

			if (counthorO == 3) {
				System.out.println("Winner:" + Players.COMPUTER);
				return GameState.WINNER;
			}
		}

		while (col < boardSize) {
			int countverX = 0;
			int countverO = 0;
			for (int i = 0; i < boardSize; i++) {
				if (boardSizeArray[i][col] == Seed.MARKER1) {
					countverX += 1;
				}
				if (boardSizeArray[i][col] == Seed.MARKER2) {
					countverO += 1;
				}
			}
			col++;

			if (countverX == 3) {
				System.out.println("Winner: " + Players.HUMAN);
				return GameState.WINNER;
			}

			if (countverO == 3) {
				System.out.println("Winner: " + Players.COMPUTER);
				return GameState.WINNER;
			}
		}

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (i == j && boardSizeArray[i][j] == Seed.MARKER1) {
					diagonalCountLTR_X += 1;
				}

				if (i == j && boardSizeArray[i][j] == Seed.MARKER2) {
					diagonalCountLTR_O += 1;
				}
			}
		}

		if (diagonalCountLTR_X == 3) {
			System.out.println("Winner: " + Players.HUMAN);
			return GameState.WINNER;
		}

		if (diagonalCountLTR_O == 3) {
			System.out.println("Winner: " + Players.HUMAN);
			return GameState.WINNER;
		}

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if ((i + j) == (boardSize - 1) && boardSizeArray[i][j] == Seed.MARKER1) {
					diagonalCountRTL_X += 1;
				}
				if ((i + j) == (boardSize - 1) && boardSizeArray[i][j] == Seed.MARKER2) {
					diagonalCountRTL_O += 1;
				}
			}
		}
		if (diagonalCountRTL_X == 3) {
			System.out.println("Winner: " + Players.HUMAN);
			return GameState.WINNER;
		}

		if (diagonalCountRTL_O == 3) {
			System.out.println("Winner: " + Players.HUMAN);
			return GameState.WINNER;
		}
		return GameState.PLAYING;
	}

}

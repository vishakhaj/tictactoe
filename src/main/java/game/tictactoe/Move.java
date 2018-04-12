package game.tictactoe;

import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

public abstract class Move {

	protected void storeCurrentMove(String playerSelection, Players currentPlayer) {
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				if ((((i + 1) * 10) + (j + 1)) == Integer.parseInt(playerSelection)) {
					Game.boardSizeArray[i][j] = currentPlayer == Players.HUMAN ? Seed.MARKER1 : Seed.MARKER2;
				}
			}
		}
	}

	protected void printAllMoves() {
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

package game.tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import game.tictactoe.enums.Cell;
import game.tictactoe.enums.Players;

public abstract class Move {

	private String cellMarker;
	private static Map<String, String> boardMap = new HashMap<>();
	protected Set<String> boardSet = new HashSet<>();

	protected void storeCurrentMove(String playerSelection, Players currentPlayer) {
		cellMarker = currentPlayer == Players.HUMAN ? Cell.MARKER1.getMarker() : Cell.MARKER2.getMarker();
		boardMap.put(playerSelection, cellMarker);
		boardSet = boardMap.keySet();
	}

	protected void printAllMoves() {

		for(int i = 0; i < Board.boardSize; i++) {
			for(int j = 0; j < Board.boardSize; j++) {
				int position = ((i + 1) * 10) + (j + 1);
				if (boardMap.containsKey((String.valueOf(position)))) {
					System.out.print(boardMap.get((String.valueOf(position))) + "\t");
				}else {
					System.out.print((i + 1) + "," + (j + 1) + "\t");
				}
			}
			System.out.println("");
		}
	}

}

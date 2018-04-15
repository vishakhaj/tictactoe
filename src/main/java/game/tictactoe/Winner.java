package game.tictactoe;

import java.util.HashMap;

import game.tictactoe.enums.Cell;
import game.tictactoe.enums.Players;

public class Winner {

	private HashMap<String, String> board = new HashMap<>();
	private String rowKey;
	private String columnKey;
	private String marker;
	private String diagonalKey;
	private String target;
	
	public void updateMap(String playerSelection, Players player) {
		rowKey = "row" + playerSelection.charAt(0);
		columnKey = "column" + playerSelection.charAt(1);
		marker = player == Players.HUMAN ? Cell.MARKER1.getMarker() : Cell.MARKER2.getMarker();

		if (board.containsKey(rowKey)) {
			// Get the row value and concatenate the new value at the end of the
			// string and put it back
			board.put(rowKey, board.get(rowKey) + marker);
		} else {
			board.put(rowKey, marker);
		}

		if (board.containsKey(columnKey)) {
			// Get the column value and concatenate the new value at the end of
			// the string and put it back
			board.put(columnKey, board.get(columnKey) + marker);
		} else {
			board.put(columnKey, marker);
		}

		if (playerSelection.charAt(0) == playerSelection.charAt(1)) {
			diagonalKey = "LtoR";
			if(board.containsKey(diagonalKey)){
				// Get the diagonal LtoR value and concatenate the new value at
				// the end of the string and put it back
				board.put(diagonalKey, board.get(diagonalKey) + marker);
			} else {
				board.put(diagonalKey, marker);
			}
		}

		if (Board.diagonalSet.contains(playerSelection)) {
			diagonalKey = "RtoL";
			if(board.containsKey(diagonalKey)){
				// Get the diagonal RtoL value and concatenate the new value at
				// the end of the string and put it back
				board.put(diagonalKey, board.get(diagonalKey) + marker);
			} else {
				board.put(diagonalKey, marker);
			}
		}
	}

	public Players checkDistinctMarkers(String playerSelection) {
		String human = Cell.MARKER1.getMarker();
		String computer = Cell.MARKER2.getMarker();
		rowKey = "row" + playerSelection.charAt(0);
		columnKey = "column" + playerSelection.charAt(1);

		// Gets the row value stores it in target. Example, row0 -> "XXX"
		target = board.get(rowKey);

		// checks if the target contains both the markers. If it does it adds it
		// to the flaggedSet
		if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			Game.flaggedSet.add(rowKey);
		}

		// checks for winner if target equals the length of the board size
		if (target.length() == Board.boardSize) {
			if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			} else if ((target.indexOf(human) > -1)) {
				return Players.HUMAN;
			} else {
				return Players.COMPUTER;
			}
		}

		// Gets the column value and stores it in target. Example, column0 ->
		// "XO"
		target = board.get(columnKey);

		// checks if the target contains both the markers. If it does it adds it
		// to the flaggedSet
		if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			Game.flaggedSet.add(columnKey);
		}

		if (target.length() == Board.boardSize) {
			if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			} else if ((target.indexOf(human) > -1)) {
				return Players.HUMAN;
			} else {
				return Players.COMPUTER;
			}
		}

		if (playerSelection.charAt(0) == playerSelection.charAt(1)) {
			target = board.get("LtoR");

			if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
				Game.flaggedSet.add("LtoR");
			}

			if (target.length() == Board.boardSize) {
				if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
				} else if ((target.indexOf(human) > -1)) {
					return Players.HUMAN;
				} else {
					return Players.COMPUTER;
				}
			}
		}

		if (Board.diagonalSet.contains(playerSelection)) {
			target = board.get("RtoL");

			if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
				Game.flaggedSet.add("RtoL");
			}

			if (target.length() == Board.boardSize) {
				if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
				} else if ((target.indexOf(human) > -1)) {
					return Players.HUMAN;
				} else {
					return Players.COMPUTER;
				}
			}
		}

		return Players.NONE;
	}

}

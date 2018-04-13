package game.tictactoe;

import java.util.HashMap;

import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

public class Winner {

	private HashMap<String, String> board = new HashMap<>();

	public void updateMap(String playerSelection, Players player) {
		String rowKey = "row" + playerSelection.charAt(0);
		String columnKey = "column" + playerSelection.charAt(1);
		String marker = player == Players.HUMAN ? Seed.MARKER1.getMarker() : Seed.MARKER2.getMarker();

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
			String diagonalKey = "LtoR";
			if(board.containsKey(diagonalKey)){
				//Get the column value and concatenate the new value at the end of the string and put it back
				board.put(diagonalKey, board.get(diagonalKey) + marker);
			} else {
				board.put(diagonalKey, marker);
			}
		}

		if (Board.diagonalSet.contains(playerSelection)) {
			String diagonalKey = "RtoL";
			if(board.containsKey(diagonalKey)){
				//Get the column value and concatenate the new value at the end of the string and put it back
				board.put(diagonalKey, board.get(diagonalKey) + marker);
			} else {
				board.put(diagonalKey, marker);
			}
		}
	}

	public Players checkDistinctMarkers(String playerSelection) {
		String human = Seed.MARKER1.getMarker();
		String computer = Seed.MARKER2.getMarker();
		String rowKey = "row" + playerSelection.charAt(0);
		String columnKey = "column" + playerSelection.charAt(1);
		String target;

		// Gets the value stores it in target
		// Current example will return => "XXX"
		target = board.get(rowKey);

		if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			Game.flaggedSet.add(rowKey);
		}

		if (target.length() == Board.boardSize) {
			if (target.indexOf(human) > -1 && target.indexOf(computer) > -1) {
			} else if ((target.indexOf(human) > -1)) {
				return Players.HUMAN;
			} else {
				return Players.COMPUTER;
			}
		}

		target = board.get(columnKey);

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
			// Same thing again

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
			// Same thing again

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

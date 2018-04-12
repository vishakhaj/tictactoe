package game.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.tictactoe.enums.Players;

/**
 * @author vish This class contains a simple AI for the computer
 */
public class Computer extends Move {

	private List<String> preferredMoves = new ArrayList<>();
	private String selectedElement;

	// creates a list of preferred moves that the computer can play
	public String makeMove(Players currentPlayer, List<String> listOfIndex) {

		System.out.println("Computer");
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				preferredMoves.add(String.valueOf(((i + 1) * 10) + (j + 1)));
			}
		}
		selectedElement = selectRandomMove(listOfIndex, preferredMoves);
		super.storeCurrentMove(selectedElement, currentPlayer);
		super.printAllMoves();
		return selectedElement;
	}

	// selects a random cell from the board
	public String selectRandomMove(List<String> listOfIndex, List<String> preferredMoves) {

		for (String p : preferredMoves) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(preferredMoves.size());
			selectedElement = preferredMoves.get(randomIndex);
			if (!listOfIndex.contains(selectedElement)) {
				preferredMoves.remove(randomIndex);
				return selectedElement;
			}
		}
		return null;
	}
}

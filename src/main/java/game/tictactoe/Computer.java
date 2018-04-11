package game.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

/**
 * @author vish This class contains a simple AI for the computer
 */
public class Computer {

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
		selectRandomMove(listOfIndex, preferredMoves);
		storeMove();
		printMove();
		return selectedElement;
	}

	// selects a random cell from the board
	public void selectRandomMove(List<String> listOfIndex, List<String> preferredMoves) {

		for (String p : preferredMoves) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(preferredMoves.size());
			selectedElement = preferredMoves.get(randomIndex);
			if (!listOfIndex.contains(selectedElement)) {
				preferredMoves.remove(randomIndex);
				break;
			}
		}
	}

	// stores the selected move in the boardSizeArray
	private void storeMove() {
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				if ((((i + 1) * 10) + (j + 1)) == Integer.parseInt(selectedElement)) {
					Game.boardSizeArray[i][j] = Seed.MARKER2;
				}
			}
		}
	}

	// prints the board with the selected move as well as the previous moves
	private void printMove() {
		for (int i = 0; i < Board.boardSize; i++) {
			for (int j = 0; j < Board.boardSize; j++) {
				if (Game.boardSizeArray[i][j] == Seed.MARKER2) {
					System.out.print(Seed.MARKER2.getMarker() + "\t");
				} else if (Game.boardSizeArray[i][j] == Seed.MARKER1) {
					System.out.print(Seed.MARKER1.getMarker() + "\t");
				} else {
					System.out.print((i + 1) + "," + (j + 1) + "\t");
				}
			}
			System.out.println("");
		}
	}
}

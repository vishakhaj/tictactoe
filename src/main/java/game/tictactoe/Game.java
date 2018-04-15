package game.tictactoe;

import java.util.HashSet;
import java.util.Scanner;

import game.tictactoe.enums.GameState;
import game.tictactoe.enums.Players;

/*
 * Calls methods of other classes
 */
public class Game {

	Scanner scan = new Scanner(System.in);

	private static final Players DEFAULT_FIRST_PLAYER = Players.HUMAN;
	private GameState currentState;
	private Players currentPlayer;
	private String playerSelection;
	private int numberOfMoves = 0;

	public static HashSet<String> flaggedSet = new HashSet<>();

	private Board board;
	private Marker marker;
	private Human human;
	private Computer computer;
	private Winner winner;

	public Game() {
		this.board = new Board();
		this.marker = new Marker();
		this.human = new Human();
		this.computer = new Computer();
		this.winner = new Winner();
	}

	public void init() {
		marker.markers();
		board.inputBoardSize();
		currentState = GameState.PLAYING;
		currentPlayer = DEFAULT_FIRST_PLAYER;
		startGame(currentPlayer);
	}

	private void startGame(Players currentPlayer) {

		while (currentState == GameState.PLAYING) {
			if (currentPlayer == Players.HUMAN) {
				playerSelection = human.makeMove(currentPlayer);
				winner.updateMap(playerSelection, currentPlayer);
			} else {
				playerSelection = computer.makeMove(currentPlayer);
				winner.updateMap(playerSelection, currentPlayer);
			}
			numberOfMoves++;
			currentPlayer = currentPlayer == DEFAULT_FIRST_PLAYER ? Players.COMPUTER : Players.HUMAN;

			// check for winner only after certain number of moves
			if (numberOfMoves >= (2 * Board.boardSize) - 1) {
				Players player = winner.checkDistinctMarkers(playerSelection);
				if (player != Players.NONE) {
					System.out.println("Winner: " + player);
					currentState = GameState.WINNER;
				}
			}

			// check if the game is a draw
			if (flaggedSet.size() != (2 * Board.boardSize) + 2) {
				winner.checkDistinctMarkers(playerSelection);
			} else {
				currentState = GameState.DRAW;
				System.out.println("DRAW");
			}
		}
	}
}


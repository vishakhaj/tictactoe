package game.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.tictactoe.enums.GameState;
import game.tictactoe.enums.Players;
import game.tictactoe.enums.Seed;

/*
 * Calls methods of other classes
 */
public class Game {

	Scanner scan = new Scanner(System.in);

	private static final Players DEFAULT_FIRST_PLAYER = Players.HUMAN;
	private GameState currentState;
	private Players currentPlayer;
	private String playerSelection;
	private GameState gameState;

	private List<String> listOfIndex = new ArrayList<>();
	public static Seed boardSizeArray[][] = new Seed[10][10];

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
				playerSelection = human.makeMove(currentPlayer, listOfIndex);
			} else {
				playerSelection = computer.makeMove(currentPlayer, listOfIndex);
			}
			listOfIndex.add(playerSelection);
			currentPlayer = currentPlayer == DEFAULT_FIRST_PLAYER ? Players.COMPUTER : Players.HUMAN;
			gameState = winner.checkWin();
			currentState = gameState;
			if (currentState != GameState.PLAYING) {
				break;
			}
		}
	}
}


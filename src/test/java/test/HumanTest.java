package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Board;
import game.tictactoe.Human;

public class HumanTest {

	private static final String ERROR_MESSAGE = "The input you have entered cannot be found on the board";
	private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "The input must be a number on the board";
	private static final String CELL_TAKEN_ERROR_MESSAGE = "Cell already taken. Please select a different move.";
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Human human;


	@Before
	public void setUp() {
		System.setErr(new PrintStream(outContent));
		human = new Human();
	}

	@Test(expected = NullPointerException.class)
	public void when_PlayerSelectionIsNull_ThrowException() {
		human.validatePlayerSelection(null, new ArrayList<>());
	}

	@Test
	public void when_PlayerSelectionIsLessThanRange_Return_ErrorMessageDisplayed() {
		human.validatePlayerSelection("2", new ArrayList<>());
		assertEquals(ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_PlayerSelectionIsGreaterThanRange_Return_ErrorMessageDisplayed() {
		human.validatePlayerSelection("333", new ArrayList<>());
		assertEquals(ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_ListContainsPlayerSelection_Return_ErrorMessageDisplayed() {
		List<String> listOfIndex = new ArrayList<>();
		String playerSelection;

		listOfIndex.add("11");
		listOfIndex.add("12");
		playerSelection = "11";
		human.validatePlayerSelection(playerSelection, listOfIndex);
		assertEquals(CELL_TAKEN_ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_PlayerSelectionIsInRange_Return_NoErrorMessage() {
		Board.boardSize = 3;
		human.validatePlayerSelection("12", new ArrayList<String>());
		assertEquals("", outContent.toString().trim());
	}

	@Test
	public void when_PlayerSelectionIsNotAnInt_Return_ErrorMessageDisplayed() {
		human.validatePlayerSelection("hello", null);
		assertEquals(NUMBER_FORMAT_EXCEPTION_MESSAGE, outContent.toString().trim());
	}


}

package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Board;
import game.tictactoe.Human;

public class HumanTest {

	private static final String ERROR_MESSAGE = "The input you have entered cannot be found on the board";
	private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "The input must be a number on the board";
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Human human;


	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
		human = new Human();
	}

	@Test(expected = NullPointerException.class)
	public void when_PlayerSelectionIsNull_ThrowException() {
		human.validatePlayerSelection(null);
	}

	@Test
	public void when_PlayerSelectionIsNotInRange_Return_ErrorMessageDisplayed() {
		human.validatePlayerSelection("2");
		assertEquals(ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_PlayerSelectionIsInRange_Return_NoErrorMessage() {
		Board.boardSize = 3;
		human.validatePlayerSelection("12");
		assertEquals("", outContent.toString().trim());
	}

	@Test
	public void when_PlayerSelectionIsNotAnInt_Return_ErrorMessageDisplayed() {
		human.validatePlayerSelection("hello");
		assertEquals(NUMBER_FORMAT_EXCEPTION_MESSAGE, outContent.toString().trim());
	}


}

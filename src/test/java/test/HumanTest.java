package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Board;
import game.tictactoe.Human;

public class HumanTest {

	private static final String ERROR_MESSAGE = "Cell already taken. Please select a different move.";
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Human human;


	@Before
	public void setUp() {
		System.setErr(new PrintStream(outContent));
		human = new Human();
	}

	@Test(expected = NullPointerException.class)
	public void when_PlayerSelectionIsNull_ThrowException() {
		human.validatePlayerSelection(null);
	}

	@Test
	public void when_PlayerSelectionIsInRange_Return_NoErrorMessage() {
		Board.boardSize = 3;
		human.validatePlayerSelection("12");
		assertEquals("", outContent.toString().trim());
	}

	// @Test
	// public void when_PlayerSelectionIsAlreadyTaken_Return_ErrorMessage() {
	// Set<String> boardSet = new HashSet<>();
	// boardSet.add("11");
	// boardSet.add("12");
	// human.validatePlayerSelection("11");
	// assertEquals(NUMBER_FORMAT_EXCEPTION_MESSAGE,
	// outContent.toString().trim());
	// }

}

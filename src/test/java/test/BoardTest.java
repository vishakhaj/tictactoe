package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Board;

public class BoardTest {

	private static final String OUT_OUT_BOUNDS_ERROR_MESSAGE = "Please choose a board size between 3 and 10";
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Board board;

	@Before
	public void setUp() {
		System.setErr(new PrintStream(outContent));
		board = new Board();
	}

	@Test
	public void when_inputBoardSizeIsOfSize2_EnsureErrorMessageDisplayed() {
		board.validateBoardSize(2);
		assertOutOfBoundsErrorMessageDisplayed();
	}

	@Test
	public void setBoardSizeGreaterThan10_EnsureErrorMessageDisplayed() {
		board.validateBoardSize(20);
		assertOutOfBoundsErrorMessageDisplayed();
	}

	@Test
	public void setBoardSizeOf3EnsureNoErrorMessageDisplayed() {
		board.validateBoardSize(3);
		assertNoErrorMessageDisplayed();
	}

	private void assertOutOfBoundsErrorMessageDisplayed() {
		assertEquals(OUT_OUT_BOUNDS_ERROR_MESSAGE, outContent.toString().trim());
	}

	private void assertNoErrorMessageDisplayed() {
		assertEquals("", outContent.toString().trim());
	}

}

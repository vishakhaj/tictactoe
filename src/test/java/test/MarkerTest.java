package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Marker;

public class MarkerTest {

	private static final String ERROR_MESSAGE = "Please enter only capital letters [A-Z]";
	private static final String SAME_SYMBOL_ERROR_MESSAGE = "Both the symbols cannot be the same.";
	private static final String INPUT_DECISION_ERROR_MESSAGE = "Enter your decision again. Should be y/Y or n/N";

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Marker marker;

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
		marker = new Marker();
	}

	@Test
	public void when_Marker1isANumber_Return_ErrorMessageDisplayed() {
		marker.validateMarker("1", "D");
		assertErrorMessage();
	}

	@Test
	public void when_Marker2isANumber_Return_ErrorMessageDisplayed() {
		marker.validateMarker("D", "2");
		assertErrorMessage();
	}

	@Test
	public void when_Marker1orMarker2isALowerCaseAlphabet_Return_ErrorMessgaeDisplayed() {
		marker.validateMarker("d", "c");
		assertErrorMessage();
	}

	@Test
	public void when_BothTheMarkersAreSame_Return_ErrorMessageDisplayed() {
		marker.validateMarker("D", "D");
		assertEquals(SAME_SYMBOL_ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_MarkersIsCorrect_Return_NoErrorMessgae() {
		marker.validateMarker("D", "C");
		assertNoErrorMessage();
	}

	@Test
	public void when_InputDecisionIsNeitherYesorNo_Return_AskPromptAgain() {
		marker.checkInputDecision('1');
		assertEquals(INPUT_DECISION_ERROR_MESSAGE, outContent.toString().trim());
	}

	@Test
	public void when_InputDecisionIsNo_Return_NoErrorMessage() {
		marker.checkInputDecision('n');
		assertNoErrorMessage();
	}

	private void assertErrorMessage() {
		assertEquals(ERROR_MESSAGE, outContent.toString().trim());
	}

	private void assertNoErrorMessage() {
		assertEquals("", outContent.toString().trim());
	}
}

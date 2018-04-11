package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import game.tictactoe.Computer;

public class ComputerTest {

	private Computer computer;

	@Before
	public void setUp() {
		computer = new Computer();
	}

	@Test
	public void when_ListDoesNotContainSelectedElement_Return_ExpectedList() {
		List<String> preferredMoves = new ArrayList<>();
		List<String> listOfIndex = new ArrayList<>();
		List<String> expectedList = new ArrayList<>();
		String selectedElement = "12";

		preferredMoves.add("11");
		preferredMoves.add("12");
		listOfIndex.add("11");
		expectedList.add("11");

		computer.selectRandomMove(listOfIndex, preferredMoves);
		preferredMoves.remove(selectedElement);
		assertEquals(expectedList, preferredMoves);
	}

}

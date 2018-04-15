package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<String> boardSet = new HashSet<>();
		boardSet.add("11");
		List<String> testList = new ArrayList<String>(boardSet);
		List<String> expectedList = new ArrayList<>();
		String selectedElement = "12";

		preferredMoves.add("11");
		preferredMoves.add("12");
		// listOfIndex.add("11");
		expectedList.add("11");

		computer.selectRandomMove();
		preferredMoves.remove(selectedElement);
		assertEquals(expectedList, preferredMoves);
	}

}

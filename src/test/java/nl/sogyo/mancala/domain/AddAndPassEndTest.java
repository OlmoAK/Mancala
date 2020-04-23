package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class AddAndPassEndTest {

	@Test
	public void test() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl6 = (Bowl) bowl1.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour();
		int test = bowl6.getStones();
		bowl1.MakeMove();
		assertEquals(0, bowl6.getStones() - test);
	}

}

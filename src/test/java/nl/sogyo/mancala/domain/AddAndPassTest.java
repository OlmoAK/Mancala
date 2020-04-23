package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class AddAndPassTest {

	@Test
	public void test() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl2 = (Bowl) bowl1.getNeighbour();
		int test = bowl2.getStones();
		bowl1.MakeMove();
		assertEquals(1, bowl2.getStones() - test);
	}

}

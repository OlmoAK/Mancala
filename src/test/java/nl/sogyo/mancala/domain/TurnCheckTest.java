package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class TurnCheckTest {

	@Test
	public void test() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl7 = (Bowl) bowl1.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour();
		bowl7.MakeMove();
		assertEquals(4, bowl7.getStones());
	}

}

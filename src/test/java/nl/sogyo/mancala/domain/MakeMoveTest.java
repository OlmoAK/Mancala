package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class MakeMoveTest {

	@Test
	public void test() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		bowl1.MakeMove();
		assertEquals(0, bowl1.getStones());
	}

}

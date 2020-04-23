package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class CheckStonesTest {

	@Test
	public void test() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {0});
		bowl1.MakeMove();
		assertEquals(true, bowl1.getOwner().getTurn());
	}

}

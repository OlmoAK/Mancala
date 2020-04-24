package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class BowlTest {
	
	@Test
	public void MakeMoveTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		bowl1.MakeMove();
		assertEquals(0, bowl1.getStones());
	}
	
	@Test
	public void TurnCheckTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl7 = (Bowl) bowl1.getNeighbour(7);
		bowl7.MakeMove();
		assertEquals(4, bowl7.getStones());
	}
	
	@Test
	public void CheckStonesTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {0});
		bowl1.MakeMove();
		assertEquals(true, bowl1.getOwner().getTurn());
	}
	
	@Test
	public void AddAndPassTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl2 = (Bowl) bowl1.getNeighbour();
		int test = bowl2.getStones();
		bowl1.MakeMove();
		assertEquals(1, bowl2.getStones() - test);
	}
	
	@Test
	public void AddAndPassEndTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl6 = (Bowl) bowl1.getNeighbour(5);
		int test = bowl6.getStones();
		bowl1.MakeMove();
		assertEquals(0, bowl6.getStones() - test);
	}
	
}

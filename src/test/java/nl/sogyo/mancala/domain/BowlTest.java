package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class BowlTest {
	
	@Test
	public void MakeMoveTest() {
		Bowl bowl1 = new Bowl();
		bowl1.MakeMove();
		assertEquals(0, bowl1.getStones());
	}
	
	/*
	@Test
	public void MakeMoveAfterGameEndTest() {
		Bowl bowl1 = new Bowl();
		bowl1.getOwner().EndGame();
		bowl1.MakeMove();
		assertEquals(4, bowl1.getStones());
	}
	
	@Test
	public void TurnCheckTest() {
		Bowl bowl1 = new Bowl();
		Bowl bowl7 = (Bowl) bowl1.getNeighbour(7);
		bowl7.MakeMove();
		assertEquals(4, bowl7.getStones());
	}
	
	@Test
	public void CheckStonesTest() {
		Bowl bowl1 = new Bowl(new int[] {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
		bowl1.MakeMove();
		assertEquals(true, bowl1.getOwner().getTurn());
	}
	*/
	
	@Test
	public void AddAndPassTest() {
		Bowl bowl1 = new Bowl();
		Bowl bowl2 = (Bowl) bowl1.getNeighbour();
		bowl1.MakeMove();
		assertEquals(5, bowl2.getStones());
	}
	
	@Test
	public void AddAndPassEndTest() {
		Bowl bowl1 = new Bowl();
		Bowl bowl6 = (Bowl) bowl1.getNeighbour(5);
		bowl1.MakeMove();
		assertEquals(4, bowl6.getStones());
	}
	
	@Test
	public void EmptyOppositesTest() {
		Bowl bowl1 = new Bowl(new int[] {1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
		bowl1.MakeMove();
		assertEquals(0, bowl1.getNeighbour(11).getStones());
	}
	
}

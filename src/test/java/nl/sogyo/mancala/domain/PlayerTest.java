package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;

public class PlayerTest {
	
	@Test
	public void ChangeTurnTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		bowl1.getOwner().ChangeTurn();
		assertEquals(true, bowl1.getOwner().getOpponent().getTurn());
	}
	
	@Test
	public void DeclareWinnerTest() {        
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {0, 0, 0, 0, 1, 0, 1, 0});
		Bowl bowl7 = (Bowl) bowl1.getNeighbour(7);
		bowl1.getOwner().ChangeTurn();
		bowl7.MakeMove();
		assertEquals(true, bowl1.getOwner().GameOver());
		assertEquals(bowl7.getOwner(), bowl7.getWinner());
	}
	
	@Test
	public void DeclareDrawTest() {        
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1});
		Bowl bowl6 = (Bowl) bowl1.getNeighbour(5);
		Bowl bowl12 = (Bowl) bowl1.getNeighbour(12);
		bowl6.MakeMove();
		bowl1.MakeMove();
		bowl12.MakeMove();
		assertEquals(true, bowl1.getOwner().GameOver());
		assertEquals(null, bowl1.getWinner());
	}
}

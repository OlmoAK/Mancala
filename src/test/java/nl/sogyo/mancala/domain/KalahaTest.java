package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;
import nl.sogyo.mancala.Kalaha;

public class KalahaTest {

	@Test
	public void AddOppositesTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {1, 0, 4, 4});
		Kalaha kalaha1 = (Kalaha) bowl1.getNeighbour(2);
		bowl1.MakeMove();
		assertEquals(5, kalaha1.getStones());
	}
	
	@Test
	public void MoveAgainTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2");
		Bowl bowl3 = (Bowl) bowl1.getNeighbour(2);
		bowl3.MakeMove();
		assertEquals(true, bowl1.getOwner().getTurn());
	}
	
	@Test
	public void GameEndTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4});
		Bowl bowl6 = (Bowl) bowl1.getNeighbour(5);
		Kalaha kalaha1 = (Kalaha) bowl1.getNeighbour(6);
		bowl6.MakeMove();
		assertEquals(bowl1.getOwner().getTurn(), bowl1.getNeighbour(7).getOwner().getTurn());
		assertEquals(bowl1.getOwner(), kalaha1.getLeadingPlayer());
	}
	
	@Test
	public void EndTurnTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2");
		bowl1.MakeMove();
		assertEquals(false, bowl1.getOwner().getTurn());
	}
	
}

package nl.sogyo.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.mancala.Bowl;
import nl.sogyo.mancala.Kalaha;

public class KalahaTest {

	@Test
	public void AddOppositesTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {1,0});
		Bowl bowl11 = (Bowl) bowl1.getNeighbour(11);
		int before = bowl11.getStones();
		Kalaha kalaha1 = (Kalaha) bowl1.getNeighbour(6);
		int test = kalaha1.getStones();
		bowl1.MakeMove();
		assertEquals(1, kalaha1.getStones() - before - test);
	}
	
	@Test
	public void MoveAgainTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Bowl bowl3 = (Bowl) bowl1.getNeighbour(2);
		bowl3.MakeMove();
		assertEquals(true, bowl1.getOwner().getTurn());
	}
	
	@Test
	public void GameEndTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {0, 0, 0, 0, 0, 1});
		Bowl bowl6 = (Bowl) bowl1.getNeighbour(5);
		bowl6.MakeMove();
		assertEquals(bowl1.getOwner().getTurn(), bowl1.getNeighbour(7).getOwner().getTurn());
		assertEquals(bowl1.getOwner(), bowl1.getWinner());
	}
	
	@Test
	public void EndTurnTest() {
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		bowl1.MakeMove();
		assertEquals(false, bowl1.getOwner().getTurn());
	}
	
	
}

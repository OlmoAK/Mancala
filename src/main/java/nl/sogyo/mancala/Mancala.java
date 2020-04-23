package nl.sogyo.mancala;

public class Mancala {

	public static void main(String[] args) {
		
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		Player player1 = bowl1.getOwner();
		Player player2 = player1.getOpponent();
		Bowl bowl2 = (Bowl) bowl1.getNeighbour();
		Bowl bowl3 = (Bowl) bowl2.getNeighbour();
		Bowl bowl4 = (Bowl) bowl3.getNeighbour();
		Bowl bowl5 = (Bowl) bowl4.getNeighbour();
		Bowl bowl6 = (Bowl) bowl5.getNeighbour();
		Kalaha kahala1 = (Kalaha) bowl6.getNeighbour();
		Bowl bowl7 = (Bowl) kahala1.getNeighbour();
		Bowl bowl8 = (Bowl) bowl7.getNeighbour();
		Bowl bowl9 = (Bowl) bowl8.getNeighbour();
		Bowl bowl10 = (Bowl) bowl9.getNeighbour();
		Bowl bowl11 = (Bowl) bowl10.getNeighbour();
		Bowl bowl12 = (Bowl) bowl11.getNeighbour();
		Kalaha kahala2 = (Kalaha) bowl12.getNeighbour();
		
		System.out.println(kahala2.getNeighbour() == bowl1);
		System.out.println(player2.getOpponent() == player1);
		
	}
}

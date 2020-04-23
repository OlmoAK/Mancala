package nl.sogyo.mancala;

public class Player {
	private String Name;
	
	public String getName() {
		return this.Name;
	}
	
	private boolean Turn;
	
	public boolean getTurn() {
		return this.Turn;
	}
	
	private Player Opponent;
	
	public Player getOpponent() {
		return this.Opponent;
	}
	
	private Player(String name) {
		this.Name = name;
		this.Turn = false;
	}
	
	public Player(String name1, String name2) {
		this.Name = name1;
		this.Turn = true;
		this.Opponent = new Player(name2);
		this.Opponent.Opponent = this;
	}
	
	//public void EndTurn() {
	//	if(this.FirstBowl.EndGameCheck()) {
	//		this.DeclareWinner();
	//	} else {
	//		this.Turn ^= true;
	//		this.Opponent.ChangeTurn();
	//	}
	//}
	
	//private void ChangeTurn() {
	//	this.Turn ^= true;
	//	if(this.FirstBowl.EndGameCheck()) {
	//		this.DeclareWinner();
	//	} else if (this.Turn && !this.Opponent.Turn) {
	//		System.out.println("It is now " + this.getName() + "'s turn.");
	//	} else if (this.Opponent.Turn && !this.Turn) {
	//		System.out.println("It is now " + this.Opponent.getName() + "'s turn.");
	//	} else {
	//		throw new IllegalStateException("Both Players were initalized to the same turn states, while theu need to be opposite!");
	//	}
	//}
	
	//private void DeclareWinner() {
	//	int myPoints = this.MyKalaha.getStones();
	//	int opponentPoints = this.Opponent.MyKalaha.getStones();
	//	System.out.print("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". ");
	//	if (myPoints > opponentPoints) {
	//		System.out.println("Congratulations " + this.getName() + ", you've won!");
	//	} else if (myPoints < opponentPoints) {
	//		System.out.println("Congratulations " + this.Opponent.getName() + ", you've won!");
	//	} else {
	//		System.out.println("It's a draw!");
	//	}
	//}
}

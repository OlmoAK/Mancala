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
	
	public void ChangeTurn() {
		this.Turn ^= true;
		this.Opponent.Turn ^= true;;
	}
	
	//private void ChangeTurn(boolean opponentsTurn) {
	//	this.Turn ^= true;
	//	if (this.Turn && !opponentsTurn) {
	//		System.out.println("It is now " + this.getName() + "'s turn.");
	//	} else if (!this.Turn && opponentsTurn) {
	//		System.out.println("It is now " + this.Opponent.getName() + "'s turn.");
	//	} else {
	//		throw new IllegalStateException("Both Players were initialized to the same turn states, while they need to be opposite!");
	//	}
	//}
	
	//public String DeclareWinner(int myPoints, int opponentPoints) {
	//	this.EndGame(); //This prevents further moves being made and allows .GameOver() to check that the game has indeed ended.
	//	if (myPoints > opponentPoints) {
	//		return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". Congratulations " + this.getName() + ", you've won!");
	//	} else if (myPoints < opponentPoints) {
	//		return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". Congratulations " + this.Opponent.getName() + ", you've won!");
	//	} else {
	//		return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". It's a draw!");
	//	}
	//}
	
	public void EndGame() {
		this.Turn = false;
		this.Opponent.Turn = false;
	}
	
	public boolean GameOver() {
		return !(this.Turn || this.Opponent.Turn);
	}
}

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
	
	/**Initializes a Player object, as well as a second Player object with both set as each other's Opponent.
	 * @param name1 Set as the Name of the first Player object.
	 * @param name2 Set as the Name of the Second Player object.
	 * @return The first, newly initialized Player object, with the second newly initialized Player object set as it's Opponent.*/
	public Player(String name1, String name2) {
		this.Name = name1;
		this.Turn = true;
		this.Opponent = new Player(name2);
		this.Opponent.Opponent = this;
	}
	
	private Player(String name) {
		this.Name = name;
		this.Turn = false;
	}
	
	/**Changes the Turn of both the Player object from which this method was called, as well as the Turn of that Player object's Opponent, by applying a boolean NOT operation to both Turn veriables.*/
	public void ChangeTurn() {
		this.Turn ^= true;
		//this.Opponent.ChangeTurn(this.Turn);
		this.Opponent.Turn ^= true;
	}
	
	/*
	private void ChangeTurn(boolean opponentsTurn) {
		this.Turn ^= true;
		if (this.Turn && !opponentsTurn) {
			System.out.println("It is now " + this.getName() + "'s turn.");
		} else if (!this.Turn && opponentsTurn) {
			System.out.println("It is now " + this.Opponent.getName() + "'s turn.");
		} else {
			throw new IllegalStateException("Both Players were initialized to the same turn states, while they need to be opposite!");
		}
	}
	
	public String DeclareWinner(int myPoints, int opponentPoints) {
		this.EndGame(); //This prevents further moves being made and allows .GameOver() to check that the game has indeed ended.
		if (myPoints > opponentPoints) {
			return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". Congratulations " + this.getName() + ", you've won!");
		} else if (myPoints < opponentPoints) {
			return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". Congratulations " + this.Opponent.getName() + ", you've won!");
		} else {
			return ("The game has ended! The score is " + myPoints + " - " + opponentPoints + ". It's a draw!");
		}
	}
	*/
	
	/**Ends the game by setting the Turn of both the Player object this method was called from and it's Opponent to 'false', making it impossible to make further moves.*/
	public void EndGame() {
		this.Turn = false;
		this.Opponent.Turn = false;
	}
	
	/**Checks if the game, that the Player object that this method is called from is a part of, is over.
	 * @return Returns 'true' if the Turn of both the Player object this method is called from and it's Opponent are 'false', otherwise returns 'false'.*/
	public boolean GameOver() {
		return !(this.Turn || this.Opponent.Turn);
	}
}

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
	
	/**Initializes a Player object (with .Name = "Player 1"), as well as a second Player object (with .Name = "Player 2") with both set as each other's Opponent.
	 * @return The first, newly initialized Player object, with the second newly initialized Player object set as it's Opponent.*/
	public Player() {
		this.Name = "Player 1";
		this.Turn = true;
		this.Opponent = new Player(this);
	}
	
	private Player(Player opponent) {
		this.Name = "Player 2";
		this.Turn = false;
		this.Opponent = opponent;
	}
	
	/**Changes the Turn of both the Player object from which this method was called, as well as the Turn of that Player object's Opponent, by applying a boolean NOT operation to both Turn variables.*/
	public void ChangeTurn() {
		this.Turn ^= true;	// this.Turn = !this.turn, but fancier.
		this.Opponent.Turn ^= true;
	}
	
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

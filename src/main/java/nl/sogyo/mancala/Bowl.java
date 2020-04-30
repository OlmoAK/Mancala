package nl.sogyo.mancala;

public class Bowl extends BoardElement {
	
	/**Starts the initialization of the Mancala board by initializing the first bowl of the Mancala board.
	 * It calls the constructor for the first player as its Owner, which in turn calls a constructor for the second player as the first players Opponent.
	 * It also calls a constructor for the next bowl as it's Neighbour.
	 * These will in turn will call the constructor for the other board elements, constructing a total of 6 bowls on each players side of the board with all having set their (number of) Stones to the default value of 4, while passing this first bowl along as a parameter to be set as the Neighbour for the second kalaha.
	 * @param name1 Will be passed to the constructor for this bowls Owner, and is set as that first player's Name.
	 * @param name2 Will be passed through the constructor for this bowls Owner to the constructor of the second player as the first player's Opponent, and is set as that second player's Name.
	 * @return The first bowl of the newly initialized Mancala board.*/
	public Bowl(String name1, String name2) { // Most basic constructor that passes empty stones array to the larger constructor.
		this(name1, name2, new int[] {});
	}
	
	/**Starts the initialization of the Mancala board by initializing the first bowl of the Mancala board.
	 * It calls the constructor for the first player as its Owner, which in turn calls a constructor for the second player as the first players Opponent.
	 * It also calls a constructor for the next bowl as it's Neighbour.
	 * These will in turn will call the constructor for the other board elements, constructing a total of 6 bowls on each players side of the board, while passing this first bowl along as a parameter to be set as the Neighbour for the second kalaha.
	 * @param name1 Will be passed to the constructor for this bowls Owner, and is set as that first player's Name.
	 * @param name2 Will be passed through the constructor for this bowls Owner to the constructor of the second player as the first player's Opponent, and is set as that second player's Name.
	 * @param stones The first value of this array (stones[0]) is set as this bowls (number of) Stones, and is passed on to the Neighbour's constructor to us it's subsequent values to set the following bowls (number of) Stones as. If the array's length is shorter then 2*bowlRowLength, the unspecified bowls Stones will default to 4.
	 * @return The first bowl of the newly initialized Mancala board.*/
	public Bowl(String name1, String name2, int[] stones) { // Larger constructor that passes the default bowl row length of 6 to the starting constructor that begins the initialization of the board
		this(name1, name2, stones, 6);
	}
	
	/**Starts the initialization of the Mancala board by initializing the first bowl of the Mancala board.
	 * It calls the constructor for the first player as its Owner, which in turn calls a constructor for the second player as the first players Opponent.
	 * It also calls a constructor for the next bowl or the first kahala (if the bowl row is only 1 bowl long) as it's Neighbour.
	 * These will in turn will call the constructor for the other board elements, while passing this first bowl along as a parameter to be set as the Neighbour for the second kalaha.
	 * @param name1 Will be passed to the constructor for this bowls Owner, and is set as that first player's Name.
	 * @param name2 Will be passed through the constructor for this bowls Owner to the constructor of the second player as the first player's Opponent, and is set as that second player's Name.
	 * @param stones The first value of this array (stones[0]) is set as this bowls (number of) Stones, and is passed on to the Neighbour's constructor to us it's subsequent values to set the following bowls (number of) Stones as. If the array's length is shorter then 2*bowlRowLength, the unspecified bowls Stones will default to 4.
	 * @param bowlRowLength The length of the row of bowls on the Mancala board for each player. If this is set to be less then 1, it will default beck to 1 bowl on each player's side.
	 * @return The first bowl of the newly initialized Mancala board.*/
	public Bowl(String name1, String name2, int[] stones, int bowlRowLength) { //Starting constructor for initializing the board.
		this.Owner = new Player(name1, name2); // Calls constructor for both opposing players.
		if (stones.length > 0) { // Checks if a starting number of stones for any of the bowls is specified.
			this.Stones = stones[0];
		} else {
			this.Stones = 4; // Defaults to 4 stones in the bowl if not specified.
		}
		if (bowlRowLength > 1) {
			this.Neighbour = new Bowl(this.Owner, stones, this, bowlRowLength, 1); // Calls protected constructor to continue construction of the neighbour chain, passes itself as argument to be used as final kalaha's neighbour to complete neighbour chain.
		} else {
			this.Neighbour = new Kalaha(this.Owner, stones, this, 1, 1); //Calls the protected Kalaha constructor to continue construction of the neighbour chain, passes itself as argument to be used as final kalaha's neighbour to complete neighbour chain.
		}
	}
	
	protected Bowl(Player owner, int[] stones, Bowl firstBowl, int bowlRowLength, int counter) {
		this.Owner = owner;
		if (counter < stones.length) {
			this.Stones = stones[counter];
		} else {
			this.Stones = 4;
		}
		counter++;
		if (counter == bowlRowLength) {
			this.Neighbour = new Kalaha(owner, stones, firstBowl, bowlRowLength, counter);
		} else if (counter == 2*bowlRowLength) {
			this.Neighbour = new Kalaha(owner, firstBowl);
		} else {
			this.Neighbour = new Bowl(owner, stones, firstBowl, bowlRowLength, counter);
		}
	}
	
	protected Kalaha getOwnerKalaha() {
		return this.Neighbour.getOwnerKalaha();
	}
	
	protected Kalaha getOpponentKalaha() {
		return this.Neighbour.getOpponentKalaha();
	}
	
	protected Bowl getOpposite(int counter, boolean tag) {
		if (tag) {
			counter--;
		} else {
			counter++;
		}
		if (counter > 0) {
			return this.Neighbour.getOpposite(counter, tag);
		} else {
			return this;
		}
	}
	
	/**Makes a move in Mancala, from the bowl that this method was called from.
	 * First checks if it is this bowls Owner's Turn and if this bowls is not empty (Stones > 0).
	 * If that is the case, then the bowl is emptied (setting Stones to 0) and these stones are distributed by adding 1 to the Stones of each subsequent neighbour board element (but skipping over this bowls Owner's Opponent's kahala), until the number of stones taken from this bowl runs out.
	 * If the final stone ends in this bowls Owner's kahala, then he can move again.
	 * If the last stone ends in a otherwise empty bowl (Stones == 0) on this bowls Owner's side of the board, and the opposite bowl on the this bowls Owner's Opponents side of the board is not empty (Stones > 0), then both these bowls are emptied (setting Stones to 0) and these stones are added to this bowls Owner's kahala.*/
	public void MakeMove() {
		if (this.Owner.getTurn()) {
			this.EmptyAndPass();
		} else if (this.Owner.GameOver()) {
		//	System.out.println("You can't make a move, because " + this.Owner.DeclareWinner(this.getOwnerKalaha().getStones(), this.getOpponentKalaha().getStones()));
		} else {
		//	System.out.println("This bowl belongs to " + this.Owner.getName() + ", and it is " + this.Owner.getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
		}
	}
	
	protected void EmptyAndPass() {
		if (this.Stones > 0) {
			int stones = this.Stones;
			this.Stones = 0;
			this.Neighbour.AddStoneAndPass(stones);
		} else {
		//	System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
		}
	}
	
	protected void AddStoneAndPass(int stones) {
		stones--;
		this.Stones++;
		if (stones > 0) {
			this.Neighbour.AddStoneAndPass(stones);
		} else {
			this.EndPassChain();
		}
	}
	
	private void EndPassChain() {
		if (this.Stones == 1 && this.Owner.getTurn() && this.getOpposite(0, false).Stones > 0) {
			this.Stones = 0;
			this.getOpposite(0, false).EmptyOpposite(this.getOwnerKalaha());
		} else {
			this.getOwnerKalaha().EndTurn();
		}
	}
	
	protected void EmptyOpposite(Kalaha target) {
		int stones = this.Stones + 1;
		this.Stones = 0;
		target.AddOpposites(stones);
	}
	
	protected boolean EndGameCheck() {
		if (this.Stones > 0) {
			return false;
		} else {
			return this.Neighbour.EndGameCheck();
		}
	}
	
}

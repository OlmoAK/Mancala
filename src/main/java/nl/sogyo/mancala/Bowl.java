package nl.sogyo.mancala;

public class Bowl extends BoardElement {
	
	/**Starts the initialization of the Mancala board by initializing the first bowl of the Mancala board.
	 * It calls the constructor for the first player as its Owner, which in turn calls a constructor for the second player as the first players Opponent.
	 * It also calls a constructor for the next bowl as it's Neighbour.
	 * These will in turn will call the constructor for the other board elements, constructing a total of 6 bowls on each players side of the board which will all having set their (number of) Stones to the default value of 4, while passing this first bowl along as a parameter to be set as the Neighbour for the second kalaha.
	 * @param name1 Will be passed to the constructor for this bowls Owner, and is set as that first player's Name.
	 * @param name2 Will be passed through the constructor for this bowls Owner to the constructor of the second player as the first player's Opponent, and is set as that second player's Name.
	 * @return The first bowl of the newly initialized Mancala board.*/
	public Bowl(String name1, String name2) { // Basic constructor that passes the default stones array to the larger constructor.
		this(name1, name2, new int[] {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
	}
	
	/**Starts the initialization of the Mancala board by initializing the first bowl of the Mancala board.
	 * It calls the constructor for the first player as its Owner, which in turn calls a constructor for the second player as the first players Opponent.
	 * It also calls a constructor for the next bowl or the first kalaha (if the bowl row is only 1 bowl long) as it's Neighbour.
	 * These will in turn will call the constructor for the other board elements, while passing this first bowl along as a parameter to be set as the Neighbour for the second kalaha (which is the last board-element).
	 * In total an even number of bowls are constructed (one row on each players side of the board, each of the same length) and two kalaha's (one for each player).
	 * @param name1 Will be passed to the constructor for this bowls Owner, and is set as that first player's Name.
	 * @param name2 Will be passed through the constructor for this bowls Owner to the constructor of the second player as the first player's Opponent, and is set as that second player's Name.
	 * @param stones The length of this array determines the total (even) number of bowls initiated. If the array's length is not an even number larger then 1, an error occurs. The first value of this array (stones[0]) is set as this bowls (number of) Stones, and the array is passed on to the Neighbour's constructor to use it's subsequent values to set the following bowls (number of) Stones as. If the value of any of these values in the array is negative, an error occurs.
	 * @return The first bowl of the newly initialized Mancala board.*/
	public Bowl(String name1, String name2, int[] stones) { //Starting constructor for initializing the board.
		if ((stones.length < 2) || (stones.length % 2 == 1)) {
			throw new IllegalArgumentException("The length of the stones array is " + stones.length + ", but must be a even number larger then 1.");
		} else if (stones[0] < 0) {
			throw new IllegalArgumentException("The value one of the elements of the stones array (stones[0]) is " + stones[0] + ", which is a negative value. All elements of the stones array must be 0 or larger.");
		} else {
			this.Owner = new Player(name1, name2); // Calls constructor for both opposing players.
			this.Stones = stones[0];
			if (stones.length > 2) {
				this.Neighbour = new Bowl(this.Owner, stones, this, 1); // Calls protected constructor to continue construction of the neighbour chain, passes itself as argument to be used as final kalaha's neighbour to complete neighbour chain.
			} else {
				this.Neighbour = new Kalaha(this.Owner, stones, this, 1); //Calls the protected Kalaha constructor to continue construction of the neighbour chain, passes itself as argument to be used as final kalaha's neighbour to complete neighbour chain.
			}
		}
	}
	
	protected Bowl(Player owner, int[] stones, Bowl firstBowl, int counter) {
		if (stones[counter] < 0) {
			throw new IllegalArgumentException("The value one of the elements of the stones array (stones[" + counter + "]) is " + stones[counter] + ", which is a negative value. All elements of the stones array must be 0 or larger.");
		} else {
			this.Owner = owner;
			this.Stones = stones[counter];
			counter++;
			if (counter == stones.length/2) {
				this.Neighbour = new Kalaha(owner, stones, firstBowl, counter);
			} else if (counter == stones.length) {
				this.Neighbour = new Kalaha(owner, firstBowl);
			} else {
				this.Neighbour = new Bowl(owner, stones, firstBowl, counter);
			}
		}
	}
	
	protected Kalaha getOwnerKalaha() {
		return this.Neighbour.getOwnerKalaha();
	}
	
	protected Kalaha getOpponentKalaha() {
		return this.Neighbour.getOpponentKalaha();
	}
	
	protected BoardElement getOpposite() {
		return this.Neighbour.getOpposite().Neighbour;
	}
	
	/**Makes a move in Mancala, from the bowl that this method was called from.
	 * First checks if it is this bowls Owner's Turn and if this bowls is not empty (Stones > 0).
	 * If that is the case, then the bowl is emptied (setting Stones to 0) and these stones are distributed by adding 1 to the Stones of each subsequent neighbour board element (but skipping over this bowls Owner's Opponent's kalaha), until the number of stones taken from this bowl runs out.
	 * If the final stone ends in this bowls Owner's kalaha, then he can move again.
	 * If the last stone ends in a otherwise empty bowl (Stones == 0) on this bowls Owner's side of the board, and the opposite bowl on the this bowls Owner's Opponents side of the board is not empty (Stones > 0), then both these bowls are emptied (setting Stones to 0) and these stones are added to this bowls Owner's kalaha.*/
	public void MakeMove() {
		if (this.Owner.getTurn()) {
			this.EmptyAndPass();
		} else if (this.Owner.GameOver()) {
			throw new IllegalStateException("You can't make a move, because the game has already ended.");
		} else {
			throw new IllegalStateException("You can't make a move from this bowl, because it belongs to " + this.Owner.getName() + ", and it is " + this.Owner.getOpponent().getName() + "'s turn right now.");
		}
	}
	
	protected void EmptyAndPass() {
		if (this.Stones > 0) {
			int stones = this.Stones;
			this.Stones = 0;
			this.Neighbour.AddStoneAndPass(stones);
		} else {
			throw new IllegalStateException("You can't make a move from this bowl, because it is empty (Stones = 0).");
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
		if (this.Stones == 1 && this.Owner.getTurn() && this.getOpposite().Stones > 0) {
			this.Stones = 0;
			((Bowl) this.getOpposite()).EmptyOpposite(this.getOwnerKalaha());
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

package nl.sogyo.mancala;

public class Bowl extends BoardElement {
	
	public Bowl(String name1, String name2) {
		this(name1, name2, new int[] {});
	}
	
	public Bowl(String name1, String name2, int[] stones) {
		this.Owner = new Player(name1, name2);
		if (stones.length > 0) {
			this.Stones = stones[0];
		} else {
			this.Stones = 4;
		}
		this.Neighbour = new Bowl(this.Owner, stones, this, 1);
	}
	
	public Bowl(Player owner, int[] stones, Bowl firstBowl, int counter) {
		this.Owner = owner;
		if (counter < stones.length) {
			this.Stones = stones[counter];
		} else {
			this.Stones = 4;
		}
		counter++;
		if (counter == 6) {
			this.Neighbour = new Kalaha(owner, stones, firstBowl, counter);
		} else if (counter == 12) {
			this.Neighbour = new Kalaha(owner, firstBowl);
		} else {
			this.Neighbour = new Bowl(owner, stones, firstBowl, counter);
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
	
	public void MakeMove() {
		if (this.Owner.getTurn()) {
			this.EmptyAndPass();
		} else if (this.Owner.GameOver()) {
			System.out.println("You can't make a move, because " + this.Owner.DeclareWinner(this.getOwnerKalaha().getStones(), this.getOpponentKalaha().getStones()));
		} else {
			System.out.println("This bowl belongs to " + this.Owner.getName() + ", and it is " + this.Owner.getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
		}
	}
	
	protected void EmptyAndPass() {
		if (this.Stones > 0) {
			int stones = this.Stones;
			this.Stones = 0;
			this.Neighbour.AddStoneAndPass(stones);
		} else {
			System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
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
	
	public Player getWinner() {
		return this.getOwnerKalaha().getWinner();
	}
}

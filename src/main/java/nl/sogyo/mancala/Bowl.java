package nl.sogyo.mancala;

public class Bowl extends BoardElement {
	
	//public Bowl(Player owner) {
	//	this.Stones = 4;
	//	this.Owner = owner;
	//}
	
	//public Bowl(int stones, Player owner) {
	//	this.Stones = stones;
	//	this.Owner = owner;
	//}
	
	//public Bowl(Player owner, BoardElement neighbour) {
	//	this.Stones = 4;
	//	this.Owner = owner;
	//	this.Neighbour = neighbour;
	//}
	
	//public Bowl(int stones, Player owner, BoardElement neighbour) {
	//	this.Stones = stones;
	//	this.Owner = owner;
	//	this.Neighbour = neighbour;
	//}
	
	public Bowl(String name1, String name2) {
		this(name1, name2, new int[] {4});
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
	
	protected Kalaha getKalaha() {
		return this.Neighbour.getKalaha();
	}
	
	protected void emptyOpposite(int counter) {
		counter++;
		this.Neighbour.emptyOpposite(counter);
	}
	
	protected void emptyOpposite(int counter, Kalaha target) {
		if (counter == 0) {
			int stones = this.Stones + 1;
			this.Stones = 0;
			//target.AddOpposites(stones);
		} else {
			counter--;
			this.Neighbour.emptyOpposite(counter, target);
		}
	}
	
	public void MakeMove() {
		if(this.Owner.getTurn()) {
			this.EmptyAndPass();
		} else {
			System.out.println("This bowl belongs to " + this.Owner.getName() + ", and it is " + this.Owner.getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
		}
	}
	
	public void EmptyAndPass() {
		if (this.Stones > 0) {
			int stones = this.Stones;
			this.Stones = 0;
			//this.Neighbour.addStoneAndPass(stones);
		} else {
			System.out.println("This bowl is empty, please pick one of your bowls with some stones in it to make a move.");
		}
	}
	
	//protected void addStoneAndPass(int stones) {
	//	stones--;
	//	this.Stones++;
	//	if (stones > 0) {
	//		this.Neighbour.addStoneAndPass(stones);
	//	} else if (this.Stones == 1 && this.Owner.getTurn()) {
	//		this.emptyOpposite(0);
	//		this.Stones = 0;
	//	} else {
	//		this.Owner.EndTurn();
	//	}
	//}
	
	//public boolean EndGameCheck() {
	//	if (this.Stones > 0) {
	//		return false;
	//	} else {
	//		return this.Neighbour.EndGameCheck();
	//	}
	//}
}

package nl.sogyo.mancala;

public class Kalaha extends BoardElement {
	
	public Kalaha(Player owner, Bowl neighbour) {
		this.Stones = 0;
		this.Owner = owner;
		this.Neighbour = neighbour;
	}
	
	public Kalaha(Player owner, int[] stones, Bowl firstBowl, int counter) {
		this.Stones = 0;
		this.Owner = owner;
		this.Neighbour = new Bowl(owner.getOpponent(), stones, firstBowl, counter);
	}
	
	protected Kalaha getOwnerKalaha() {
		return this;
	}
	
	protected Kalaha getOpponentKalaha() {
		return this.Neighbour.getOwnerKalaha();
	}
	
	protected void EmptyOpposite(int counter) {
		this.Neighbour.EmptyOpposite(counter, this);
	}
	
	protected void EmptyOpposite(int counter, Kalaha target) {
		System.out.println("Error, opposite of bowl could not be found.");
	}
	
	protected void AddStoneAndPass(int stones) {
		if(this.Owner.getTurn()) {
			stones--;
			this.Stones++;
			if (stones > 0) {
				this.Neighbour.AddStoneAndPass(stones);
			} else {
				System.out.println("You can move again, " + this.Owner.getName());
			}
		} else {
			this.Neighbour.AddStoneAndPass(stones);
		}
	}
	
	//protected void AddOpposites(int stones) {
	//	this.Stones += stones;
	//	this.Owner.EndTurn();
	//}
	
	//public boolean EndGameCheck() {
	//	return true;
	//}
}

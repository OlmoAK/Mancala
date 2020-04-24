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
	
	protected Bowl getOpposite(int counter, boolean tag) {
		return this.Neighbour.getOpposite(counter, !tag);
	}
	
	protected void AddStoneAndPass(int stones) {
		if(this.Owner.getTurn()) {
			stones--;
			this.Stones++;
			if (stones > 0) {
				this.Neighbour.AddStoneAndPass(stones);
			} else {
				this.MoveAgain();
			}
		} else {
			this.Neighbour.AddStoneAndPass(stones);
		}
	}
	
	private void MoveAgain() {
		if (this.Neighbour.EndGameCheck() || this.getOpponentKalaha().getNeighbour().EndGameCheck()) {
			this.Owner.DeclareWinner(this.getStones(), this.getOpponentKalaha().getStones());
		} else {
			System.out.println("You can move again, " + this.Owner.getName());
		}
	}
	
	protected void AddOpposites(int stones) {
		this.Stones += stones;
		this.EndTurn();
	}
	
	protected void EndTurn() {
		if (this.Neighbour.EndGameCheck() || this.getOpponentKalaha().getNeighbour().EndGameCheck()) {
			this.Owner.DeclareWinner(this.getStones(), this.getOpponentKalaha().getStones());
		} else {
			this.Owner.ChangeTurn();
		}
	}
	
	protected boolean EndGameCheck() {
		return true;
	}
	
}

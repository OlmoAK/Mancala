package nl.sogyo.mancala;

public class Kalaha extends BoardElement {
	
	/**Initializes a Kalaha object.
	 * @param owner Set as this objects Owner.
	 * @param neighbour Set as this objects Neighbour.
	 * @return The newly initialized Kalaha object.*/
	public Kalaha(Player owner, Bowl neighbour) {
		this.Stones = 0;
		this.Owner = owner;
		this.Neighbour = neighbour;
	}
	
	protected Kalaha(Player owner, int[] stones, Bowl firstBowl, int counter) {
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
	
	protected BoardElement getOpposite() {
		return this;
	}
	
	protected void AddStoneAndPass(int stones) {
		if(this.Owner.getTurn()) {
			MoveAgainCheck(stones);
		} else {
			this.Neighbour.AddStoneAndPass(stones);
		}
	}
	
	private void MoveAgainCheck(int stones) {
		stones--;
		this.Stones++;
		if (stones > 0) {
			this.Neighbour.AddStoneAndPass(stones);
		} else {
			this.MoveAgain();
		}
	}
	
	private void MoveAgain() {
		if (this.Neighbour.EndGameCheck() || this.getOpponentKalaha().getNeighbour().EndGameCheck()) {
			this.Owner.EndGame();
		}
	}
	
	protected void AddOpposites(int stones) {
		this.Stones += stones;
		this.EndTurn();
	}
	
	protected void EndTurn() {
		if (this.Neighbour.EndGameCheck() || this.getOpponentKalaha().getNeighbour().EndGameCheck()) {
			this.Owner.EndGame();
		} else {
			this.Owner.ChangeTurn();
		}
	}
	
	protected boolean EndGameCheck() {
		return true;
	}
	
	/**Gives the player of the Mancala game that is currently n the lead. by returning the Owner of the kalaha with the higher number of Stones.
	 * @return The Owner of the kalaha with the higher number of Stones. If both kalaha have the same number of stones, this returns null.*/
	public Player getLeadingPlayer() {
		if (this.getStones() > this.getOpponentKalaha().getStones()) {
			return this.Owner;
		} else if (this.getStones() < this.getOpponentKalaha().getStones()) {
			return this.Owner.getOpponent();
		} else {
			return null;
		}
	}
}

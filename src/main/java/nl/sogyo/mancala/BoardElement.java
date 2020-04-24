package nl.sogyo.mancala;

public abstract class BoardElement{
	protected int Stones;
	
	public int getStones() {
		return this.Stones;
	}
	
	protected Player Owner;
	
	public Player getOwner() {
		return this.Owner;
	}
	
	protected BoardElement Neighbour;
	
	public BoardElement getNeighbour() {
		return this.Neighbour;
	}
	
	public BoardElement getNeighbour(int steps) {
		BoardElement neighbour = this;
		for (int i = 0; i < steps; i++) {
			neighbour = neighbour.Neighbour;
		}
		return neighbour;
	}
	
	abstract Kalaha getOwnerKalaha();
	
	abstract Kalaha getOpponentKalaha();
	
	protected abstract Bowl getOpposite(int counter, boolean tag);
	
	protected abstract void AddStoneAndPass(int stones);
	
	protected abstract boolean EndGameCheck();
}

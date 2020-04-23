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
	
	abstract Kalaha getKalaha();
	
	abstract void EmptyOpposite(int counter);
	
	abstract void EmptyOpposite(int counter, Kalaha target);
	
	abstract void AddStoneAndPass(int stones);
	
	//abstract boolean EndGameCheck();
}

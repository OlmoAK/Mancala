package nl.sogyo.mancala;

/**Abstract super-class for both Bowl and Kahala, making it possible for their Neighbour variable to point to objects of either class.*/
public abstract class BoardElement{
	
	protected int Stones; // Implementing the (shared) variables and their getter methods.
	
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
	
	/**Implements a repeated loop of the getNeighbour() method to get to objects further down the neighbour chain.
	 * @param steps The number of times that the getNeighbour() method is implemented.
	 * @return The 'steps'-times neighbour of the object that this method is called from.*/
	public BoardElement getNeighbour(int steps) {
		BoardElement neighbour = this;
		for (int i = 0; i < steps; i++) {
			neighbour = neighbour.Neighbour;
		}
		return neighbour;
	}
	
	// Created abstract methods for the methods that work by passing along the neighbour chain while taking advantage of different implementations between Bowls and Kalahas.
	protected abstract Kalaha getOwnerKalaha();
	
	protected abstract Kalaha getOpponentKalaha();
	
	protected abstract Bowl getOpposite(int counter, boolean tag);
	
	protected abstract void AddStoneAndPass(int stones);
	
	protected abstract boolean EndGameCheck();
	
}

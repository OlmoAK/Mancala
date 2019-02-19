package nl.sogyo.mancala.domain;

public interface Mancala {
	
	/**
	 * Method for returning the specified players name. 
	 * 
	 * @param playerIndex Index of the player, 1 for the first player and 2 for the second player
	 * @return Name of de specified player.
	 * @throws IllegalStateException If the players index is not 1 or 2.
	 */
	String getPlayerName(int playerIndex) throws IllegalStateException;
	
	/**
	 * Method for giving the specified player his or her name.
	 * 
	 * @param name Name for the player.
	 * @param playerIndex Index of the player, 1 for the first player and 2 for the second player
	 * @throws IllegalStateException If the players index is not 1 or 2.
	 */
	void setPlayerName(String name, int playerIndex) throws IllegalStateException;
	
	/**
	 * Method indicating if the specified player has the next turn of not.
	 * 
	 * @param playerIndex Index of the player, 1 for the first player and 2 for the second player.
	 * @return True if the specified player has the next turn, otherwise False.
	 * @throws IllegalStateException If the players index is not 1 or 2.
	 */
	boolean isToMovePlayer(int playerIndex) throws IllegalStateException;
	
	/**
	 * Method for playing the specified recess. Index is as specified below:
	 * 
	 *    13 12 11 10  9  8
	 * 14                    7
	 *     1  2  3  4  5  6
	 * 
	 * @param index Index of the recess to be played.
	 * @return 15 item long Array with the current state of the game. The 15th item indicates which player has the next turn (possible values are 1 or 2).
	 */
	int[] playRecess(int index);
	
	/**
	 * Method for returning the amount of stones in de specified pit. Index is as specified below:
	 * 
	 *    13 12 11 10  9  8
	 * 14                    7
	 *     1  2  3  4  5  6
	 * 
	 * @param index Index of the pit.
	 * @return Amount of stone.
	 */
	int getStonesForPit(int index);
	
	/**
	 * Method for retrieving the current state of the game. 
	 * 
	 *    13 12 11 10  9  8
	 * 14                    7
	 *     1  2  3  4  5  6
	 * 
	 * @return 15 item long Array with the current state of the game. The 15th item indicates which player has the next turn (possible values are 1 or 2).
	 */
	int[] exportGameState();

	/**
	 * Method for retrieving whether the game has ended or not.
	 * 
	 * @return True is the game has ended otherwise False.
	 */
	boolean isEndOfGame();

	/**
	 * Method for retrieving the name of the player that has won the game.
	 * 
	 * @return Name of the winner, or 'null' if the game has not ended yet.
	 */
	String getWinnersName();

}
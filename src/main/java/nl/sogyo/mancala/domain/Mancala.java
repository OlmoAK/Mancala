package nl.sogyo.mancala.domain;

import java.util.Collection;

public interface Mancala {

	/**
	 * @return
	 */
	Pit getPit();

	/**
	 * @param index
	 * @return
	 */
	Pit getPit(int index);

	/**
	 * @param index
	 * @return
	 */
	int[] playRecess(int index);

	/**
	 * @return
	 */
	int[] exportGameState();

	/**
	 * @return
	 */
	boolean isEndOfGame();

	/**
	 * @return
	 */
	Collection<Recess> getPlayableRecesses();

	/**
	 * @return
	 */
	Player getWinner();

}
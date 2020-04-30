package nl.sogyo.mancala;

import java.util.Scanner;

/**A simple GUI that runs the Mancala game locally.*/
public class Mancala {
	
	
	public static void main(String[] args) {
		
		while (true) {
			Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {}); // Initializing the board.
			/*
			Old initialization of unused variables.
			Player player1 = bowl1.getOwner();
			Player player2 = player1.getOpponent();
			Bowl bowl2 = (Bowl) bowl1.getNeighbour();
			Bowl bowl3 = (Bowl) bowl2.getNeighbour();
			Bowl bowl4 = (Bowl) bowl3.getNeighbour();
			Bowl bowl5 = (Bowl) bowl4.getNeighbour();
			Bowl bowl6 = (Bowl) bowl5.getNeighbour();
			Kalaha kahala1 = (Kalaha) bowl6.getNeighbour();
			Bowl bowl7 = (Bowl) kahala1.getNeighbour();
			Bowl bowl8 = (Bowl) bowl7.getNeighbour();
			Bowl bowl9 = (Bowl) bowl8.getNeighbour();
			Bowl bowl10 = (Bowl) bowl9.getNeighbour();
			Bowl bowl11 = (Bowl) bowl10.getNeighbour();
			Bowl bowl12 = (Bowl) bowl11.getNeighbour();
			Kalaha kahala2 = (Kalaha) bowl12.getNeighbour();
			kahala2.getNeighbour() == bowl1 && player2.getOpponent() == player1
			 */
			boolean oldTurn = !bowl1.getOwner().getTurn(); // Initializing the old turn tracker to be opposite of the first turn.
			
			Scanner s = new Scanner(System.in);
			
			while(!bowl1.getOwner().GameOver()) {
				printBoard(bowl1); // Print out the current state of the board.
				if (bowl1.getOwner().getTurn() == oldTurn) { // Check if the same player get's to move again or not and if so, notify the user. 
					System.out.print("You can move again.");
				} else if (bowl1.getOwner().getTurn() && !bowl1.getOwner().getOpponent().getTurn()) { // If the turn changed, notify the user which players turn it now is.
					System.out.print("It is now " + bowl1.getOwner().getName() + "'s turn.");
				} else if (!bowl1.getOwner().getTurn() && bowl1.getOwner().getOpponent().getTurn()) { // If the turn changed, notify the user which players turn it now is.
					System.out.print("It is now " + bowl1.getOwner().getOpponent().getName() + "'s turn.");
				} else { // If there was some kind if initialization error, throw an error.
					throw new IllegalStateException("Both Players were initialized to the same turn states, while they need to be opposite!");
				}
				oldTurn = bowl1.getOwner().getTurn();
				System.out.println(" Please specify one of your bowls to make a move from."); // Finish print line with request for user input.
				
				String input = s.nextLine();
				
				if (("bowl 1").equalsIgnoreCase(input)) { // Differentiation between the different commands.
					if (!bowl1.getOwner().getTurn()) { // Give notice to user if he tries to make a move from a bowl that doesn't belong to the player who's turn it currently is, so that he know that his move failed.
						System.out.println("This bowl belongs to " + bowl1.getOwner().getName() + ", and it is " + bowl1.getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getStones() == 0) { // Give notice to user if he tries to make a move from a bowl that is empty, so that he know that his move failed.
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					bowl1.MakeMove(); //Make corresponding move.
				} else if (("bowl 2").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour().getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour().getOwner().getName() + ", and it is " + bowl1.getNeighbour().getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour().getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour()).MakeMove();
				} else if (("bowl 3").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(2).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(2).getOwner().getName() + ", and it is " + bowl1.getNeighbour(2).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(2).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(2)).MakeMove();
				} else if (("bowl 4").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(3).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(3).getOwner().getName() + ", and it is " + bowl1.getNeighbour(3).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(3).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(3)).MakeMove();
				} else if (("bowl 5").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(4).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(4).getOwner().getName() + ", and it is " + bowl1.getNeighbour(4).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(4).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(4)).MakeMove();
				} else if (("bowl 6").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(5).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(5).getOwner().getName() + ", and it is " + bowl1.getNeighbour(5).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(5).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(5)).MakeMove();
				} else if (("bowl 7").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(7).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(7).getOwner().getName() + ", and it is " + bowl1.getNeighbour(7).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(7).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(7)).MakeMove();
				} else if (("bowl 8").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(8).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(8).getOwner().getName() + ", and it is " + bowl1.getNeighbour(8).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(8).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(8)).MakeMove();
				} else if (("bowl 9").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(9).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(9).getOwner().getName() + ", and it is " + bowl1.getNeighbour(9).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(9).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(9)).MakeMove();
				} else if (("bowl 10").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(10).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(10).getOwner().getName() + ", and it is " + bowl1.getNeighbour(10).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(10).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(10)).MakeMove();
				} else if (("bowl 11").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(11).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(11).getOwner().getName() + ", and it is " + bowl1.getNeighbour(11).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(11).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(11)).MakeMove();
				} else if (("bowl 12").equalsIgnoreCase(input)) {
					if (!bowl1.getNeighbour(12).getOwner().getTurn()) {
						System.out.println("This bowl belongs to " + bowl1.getNeighbour(12).getOwner().getName() + ", and it is " + bowl1.getNeighbour(12).getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
					} else if (bowl1.getNeighbour(12).getStones() == 0) {
						System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
					}
					((Bowl) bowl1.getNeighbour(12)).MakeMove();
				} else if (("quite").equalsIgnoreCase(input)) { //Shut down command to break the while loop and end the program.
					System.out.println("Quiting the game.");
					break;
				} else { //If user command is not recognized, print a warning for the user and include a list of available user commands.
					System.out.println("Command not recognized. Please specify one of your bowls by their number x (starting in the lower left and going counter-clockwise) as 'Bowl x' or input 'Quite' to quite the game.");
				}
				
			}
			
			printBoard(bowl1); // Print out the final state of the board.
			if (bowl1.getOwnerKalaha().getStones() > bowl1.getOpponentKalaha().getStones()) { // Declare the winner (or the draw), and give the final score.
				System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". Congratulations " + bowl1.getOwner().getName() + ", you've won!");
			} else if (bowl1.getOwnerKalaha().getStones() < bowl1.getOpponentKalaha().getStones()) {
				System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". Congratulations " + bowl1.getOwner().getOpponent().getName() + ", you've won!");
			} else {
				System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". It's a draw!");
			}
			
			System.out.println("Play again (y/n)?");
			char input = s.next().charAt(0);
			if (("" + input).equalsIgnoreCase("Y")) {
				continue;
			} else {
				break;
			}
		}
	}
	
	/**Static method that print's out the (current) state of the board. Assumes the Bowl input is bowl 1 on the board with a row of 6 bowls for each player, followed by a kahala.
	 * @param firstBowl Bowl 1 on the board, this should be the bowl that was returned by the constructor used in initialize the Mancala board.*/ 
	public static void printBoard(Bowl firstBowl) {
		System.out.println("");
		System.out.println("      " + firstBowl.getOwner().getOpponent().getName());
		System.out.println("  " + firstBowl.getNeighbour(12).getStones() + "  " + firstBowl.getNeighbour(11).getStones() + "  " + firstBowl.getNeighbour(10).getStones() + "  " + firstBowl.getNeighbour(9).getStones() + "  " + firstBowl.getNeighbour(8).getStones() + "  " + firstBowl.getNeighbour(7).getStones() + "  ");
		System.out.println(firstBowl.getOpponentKalaha().getStones() + "                  " + firstBowl.getOwnerKalaha().getStones());
		System.out.println("  " + firstBowl.getNeighbour(0).getStones() + "  " + firstBowl.getNeighbour(1).getStones() + "  " + firstBowl.getNeighbour(2).getStones() + "  " + firstBowl.getNeighbour(3).getStones() + "  " + firstBowl.getNeighbour(4).getStones() + "  " + firstBowl.getNeighbour(5).getStones() + "  ");
		System.out.println("      " + firstBowl.getOwner().getName());
		System.out.println("");
	}
	
}

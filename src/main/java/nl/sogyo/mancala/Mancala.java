package nl.sogyo.mancala;

import java.util.Scanner;

public class Mancala {

	public static void main(String[] args) {
		
		boolean oldTurn = false;
		Bowl bowl1 = new Bowl("Player 1", "Player 2", new int[] {});
		//Player player1 = bowl1.getOwner();
		//Player player2 = player1.getOpponent();
		//Bowl bowl2 = (Bowl) bowl1.getNeighbour();
		//Bowl bowl3 = (Bowl) bowl2.getNeighbour();
		//Bowl bowl4 = (Bowl) bowl3.getNeighbour();
		//Bowl bowl5 = (Bowl) bowl4.getNeighbour();
		//Bowl bowl6 = (Bowl) bowl5.getNeighbour();
		//Kalaha kahala1 = (Kalaha) bowl6.getNeighbour();
		//Bowl bowl7 = (Bowl) kahala1.getNeighbour();
		//Bowl bowl8 = (Bowl) bowl7.getNeighbour();
		//Bowl bowl9 = (Bowl) bowl8.getNeighbour();
		//Bowl bowl10 = (Bowl) bowl9.getNeighbour();
		//Bowl bowl11 = (Bowl) bowl10.getNeighbour();
		//Bowl bowl12 = (Bowl) bowl11.getNeighbour();
		//Kalaha kahala2 = (Kalaha) bowl12.getNeighbour();
		// kahala2.getNeighbour() == bowl1 && player2.getOpponent() == player1
		
		
		while(!bowl1.getOwner().GameOver()) {
			printBoard(bowl1);
			if (bowl1.getOwner().getTurn() == oldTurn) {
				System.out.print("You can move again.");
			} else if (bowl1.getOwner().getTurn() && !bowl1.getOwner().getOpponent().getTurn()) {
				System.out.print("It is now " + bowl1.getOwner().getName() + "'s turn.");
			} else if (!bowl1.getOwner().getTurn() && bowl1.getOwner().getOpponent().getTurn()) {
				System.out.print("It is now " + bowl1.getOwner().getOpponent().getName() + "'s turn.");
			} else {
				throw new IllegalStateException("Both Players were initialized to the same turn states, while they need to be opposite!");
			}
			oldTurn = bowl1.getOwner().getTurn();
			System.out.println(" Please specify one of your bowls to make a move from.");
			Scanner s = new Scanner(System.in); 
			String input = s.nextLine();
			
			if (("bowl 1").equalsIgnoreCase(input)) {
				if (!bowl1.getOwner().getTurn()) {
					System.out.println("This bowl belongs to " + bowl1.getOwner().getName() + ", and it is " + bowl1.getOwner().getOpponent().getName() + "'s turn right now. Please make a move using one of your own bowls.");
				} else if (bowl1.getStones() == 0) {
					System.out.println("This bowl is empty, please pick one of your bowls with stones in it to make a move.");
				}
				bowl1.MakeMove();
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
		
		if (bowl1.getOwnerKalaha().getStones() > bowl1.getOpponentKalaha().getStones()) {
			System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". Congratulations " + bowl1.getOwner().getName() + ", you've won!");
		} else if (bowl1.getOwnerKalaha().getStones() < bowl1.getOpponentKalaha().getStones()) {
			System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". Congratulations " + bowl1.getOwner().getOpponent().getName() + ", you've won!");
		} else {
			System.out.println("The game has ended! The score is " + bowl1.getOwnerKalaha().getStones() + " - " + bowl1.getOpponentKalaha().getStones() + ". It's a draw!");
		}
	}
	
	public static void printBoard(Bowl bowl) {
		System.out.println("");
		System.out.println("      " + bowl.getOwner().getOpponent().getName());
		System.out.println("  " + bowl.getNeighbour(12).getStones() + "  " + bowl.getNeighbour(11).getStones() + "  " + bowl.getNeighbour(10).getStones() + "  " + bowl.getNeighbour(9).getStones() + "  " + bowl.getNeighbour(8).getStones() + "  " + bowl.getNeighbour(7).getStones() + "  ");
		System.out.println(bowl.getOpponentKalaha().getStones() + "                  " + bowl.getOwnerKalaha().getStones());
		System.out.println("  " + bowl.getNeighbour(0).getStones() + "  " + bowl.getNeighbour(1).getStones() + "  " + bowl.getNeighbour(2).getStones() + "  " + bowl.getNeighbour(3).getStones() + "  " + bowl.getNeighbour(4).getStones() + "  " + bowl.getNeighbour(5).getStones() + "  ");
		System.out.println("      " + bowl.getOwner().getName());
		System.out.println("");
	}
}

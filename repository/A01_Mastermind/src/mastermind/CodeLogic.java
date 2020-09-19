package mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CodeLogic {
	private static Random rand = new Random();
	public static ArrayList<BallColors> secretCode = new ArrayList<>();
	public static ArrayList<BallColors> usersGuesses = new ArrayList<>();
	public static ArrayList<PegColors> pegResults = new ArrayList<>();
	private static int turn = 1;

	public static ArrayList<BallColors> generateSecretCode() {
		
		for(int i = 0; i < 4; i++) {
			secretCode.add(BallColors.values()[rand.nextInt(BallColors.values().length)]);
		}
		System.out.println(secretCode);
		return secretCode;
	}
	
	/**
	 * Clears ArrayList secretCode
	 */
	public static void clearSecretCode() {
		secretCode.clear();
	}
	
	/**
	 * Adds user's guess to ArrayList usersGueses
	 * @param enum BallColors
	 */
	public static void addUserGuess(BallColors b) {
		usersGuesses.add(b);
	}
	
	/**
	 * clears ArrayList usersGuesses
	 */
	public static void clearUserGuess() {
		usersGuesses.clear();
	}
	
	/**
	 * Checks the users guess to the generated secret code.
	 */
	public static void checkGuess() {
		turn++;
		//Compares the secret code with the users guess
		if(secretCode.equals(usersGuesses)) {
			MainWindow.changeLblOutput("YOU WIN!");
			Board.gameOver = true;
			
			//TODO Process win conditions here
		} 
		else {
			//create a copy of the secret code
			ArrayList<BallColors> pegsSecretCode = (ArrayList<BallColors>) secretCode.clone();
			
			//iterate through to find black pegs (where color and index equal)
			for(int i = 0; i < 4; i++) {
				if(usersGuesses.contains(pegsSecretCode.get(i))){ 
					if(usersGuesses.get(i).equals(pegsSecretCode.get(i))) { 						//right guess, right position (black peg)
						pegResults.add(PegColors.BLACK);
						pegsSecretCode.set(i, null);
					}
				}
			}
			
			//iterate through to find white pegs (remaining pegs where color equal
			for(int i = 0; i < 4; i++) {
				if(usersGuesses.contains(pegsSecretCode.get(i)) && pegsSecretCode.get(i) != null){
					pegResults.add(PegColors.WHITE);
				}
			}
			//TODO display peg code
			System.out.println(pegResults);
			
			pegResults.clear();
			usersGuesses.clear();
			
		}
	}
	
	public static ArrayList<BallColors> getSecretCode() {
		return secretCode;
	}

	/**
	 * Notifies player of loss after 10 turns
	 */
	public static void loseGame() {
		MainWindow.changeLblOutput("YOU LOSE!");
	}
}

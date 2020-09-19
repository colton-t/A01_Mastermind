package mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CodeLogic {
	private static Random rand = new Random();
	public static ArrayList<BallColors> secretCode = new ArrayList<>();
	public static ArrayList<BallColors> usersGuesses = new ArrayList<>();
	private static int turn = 1;
	private final static int NUM_BALL_COLORS = 6;

	public static ArrayList<BallColors> generateSecretCode() {
		
		for(int i = 0; i < 4; i++) {
			secretCode.add(BallColors.values()[rand.nextInt(NUM_BALL_COLORS)]);
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
		} 
		else {
			ArrayList<BallColors> tempSecretCode = (ArrayList<BallColors>) secretCode.clone();
			ArrayList<BallColors> tempUserGuesses = (ArrayList<BallColors>) usersGuesses.clone();
			
			int blackPegs = 0;
			for(int i = 0; i < secretCode.size(); i++) {
				if(tempSecretCode.get(i).equals(tempUserGuesses.get(i))) {
					blackPegs++;
					tempSecretCode.set(i, BallColors.BLANK);
					tempUserGuesses.set(i, BallColors.BLANK);
				}
			}
			
			int whitePegs = 0;
			for (int i = 0; i < secretCode.size(); i++) {
				if(tempSecretCode.get(i).equals(BallColors.BLANK)) {
					continue;
				}
				for(int j = 0; j < secretCode.size(); j++) {
					if (tempUserGuesses.get(j).equals(BallColors.BLANK)) {
						continue;
					}
					if (tempSecretCode.get(i).equals(tempUserGuesses.get(j))) {
						whitePegs++;
						tempSecretCode.set(i, BallColors.BLANK);
						tempUserGuesses.set(j, BallColors.BLANK);
					}
					
				}
			}
			
			//sends number of pegs to board to represent graphically
			Board.setLblPegs(blackPegs, whitePegs);
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

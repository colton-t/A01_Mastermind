package mastermind;

import java.util.ArrayList;
import java.util.Random;

public class CodeLogic {
	private static Random rand = new Random();
	public static ArrayList<BallColors> secretCode = new ArrayList<>();
	public static ArrayList<BallColors> usersGuesses = new ArrayList<>();
	public static ArrayList<PegColors> pegResults = new ArrayList<>();

	public static ArrayList<BallColors> generateSecretCode() {
		
		for(int i = 0; i < 4; i++) {
			secretCode.add(BallColors.values()[rand.nextInt(BallColors.values().length)]);
		}
		System.out.println(secretCode);
		return secretCode;
	}
	
	public static void addUserGuess(BallColors b) {
		usersGuesses.add(b);
	}
	
	public static void clearUserGuess() {
		usersGuesses.clear();
	}
	
	/**
	 * Checks the users guess to the generated secret code.
	 */
	public static void checkGuess() {
		//Compares the secret code with the users guess
		if(secretCode.equals(usersGuesses)) {
			System.out.println("YOU WIN!");
			//TODO Process win conditions here
		} else {
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
}

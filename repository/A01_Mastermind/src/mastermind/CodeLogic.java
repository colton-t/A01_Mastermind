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
	
	public static void checkGuess() {
		//Compares the secret code with the users guess
		if(secretCode.equals(usersGuesses)) {
			System.out.println("YOU WIN!");
			//TODO Process win conditions here
		} else {
			System.out.println("Process pegs");
			ArrayList<BallColors> pegsUserGuess = (ArrayList<BallColors>) usersGuesses.clone();
			for(int i = 0; i < 4; i++) {
				if(secretCode.contains(pegsUserGuess.get(i))){ //if the secret code even has the element
					if(secretCode.get(i) == pegsUserGuess.get(i)) { //if on the same index
						//right guess, right position (black peg)
						pegResults.add(PegColors.BLACK);
						pegsUserGuess.set(i, null);
					} else { //right guess, wrong position (white peg)
						pegResults.add(PegColors.WHITE);
						pegsUserGuess.set(i, null);
					}
				}
			}
			//display pegs here
			System.out.println(pegResults);
			
			pegResults.clear();
			usersGuesses.clear();
		}
	}
}

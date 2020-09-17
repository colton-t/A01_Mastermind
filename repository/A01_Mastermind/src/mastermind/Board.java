package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Board extends JPanel {
	
	private static Random rand = new Random();
	private int turn = 9;
	private int guess = 0;
	private int rows = 10;
	private int coloumns = 4;
	ArrayList<BallColors> secretCode = new ArrayList<>();
	ArrayList<BallColors> usersGuesses = new ArrayList<>();
	ArrayList<PegColors> pegResults = new ArrayList<>();
	
	private JButton btnRed;
	private JButton btnYellow;
	private JButton btnBlue;
	private JButton btnGreen;
	private JButton btnWhite;
	private JButton btnBlack;
	private JButton btnCheck;
	private JButton btnClear;
	

	/**
	 * Create the panel.
	 */
	public Board() {
		//set background color
		setBackground(Color.LIGHT_GRAY);
		
		//create color selection buttons
		createRedBtn();
		setLayout(null);
		add(btnRed);
		
		createYellowBtn();
		add(btnYellow);
		
		createBlueBtn();
		add(btnBlue);
		
		createGreenBtn();
		add(btnGreen);
		
		createWhiteBtn();
		add(btnWhite);
		
		createBlackBtn();
		add(btnBlack);
		
		
		//create control buttons
		createCheckBtn();
		add(btnCheck);
		
		createClearBtn();
		add(btnClear);
		
		//create pegs
		//TODO
		
		//create secret code
		secretCode = generateSecretCode();
	}
	
	private ArrayList<BallColors> generateSecretCode() {
		ArrayList<BallColors> returnedSecretCode = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			returnedSecretCode.add(BallColors.values()[rand.nextInt(BallColors.values().length)]);
		}
		System.out.println(returnedSecretCode);
		return returnedSecretCode;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < coloumns; x++) {
				g.drawOval((x + 1) * 60, (y + 1) * 45, 30, 30);
				g.fillOval((x + 1) * 60, (y + 1) * 45, 30, 30);
			}
		}
		for (int x =0; x < coloumns; x++) {
			g.drawRect((x+1)*60, 2, 30, 30);
			g.fillRect((x+1)*60, 2, 30, 30);
			
			g.drawOval((x+1)*60, 2, 30, 30);
			g.fillOval((x+1)*60, 2, 30, 30);
		}
	}
	
	private void createClearBtn() {
		btnClear = new JButton("Clear");
		btnClear.setBounds(226, 500, 80, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guess = 0;
				usersGuesses.clear(); //clear the users guesses from guess array.
				Graphics g = getGraphics();
				g.setColor(Color.gray);
				for (int x = 0; x < coloumns; x++) {
					g.drawOval((x + 1) * 60, (turn + 1) * 45, 30, 30);
					g.fillOval((x + 1) * 60, (turn + 1) * 45, 30, 30);
				}
			}
		});
		btnClear.setMinimumSize(new Dimension(80, 30));
		btnClear.setDefaultCapable(false);
	}
	private void createCheckBtn() {
		btnCheck = new JButton("Check");
		btnCheck.setBounds(46, 500, 80, 30);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guess > 3 && turn > 0) {
					turn--;
					guess = 0;
					checkGuess();
				}
				if(turn == 0) {
					
				}
			}
		});
		btnCheck.setMinimumSize(new Dimension(80, 30));
	}
	
	protected void checkGuess() {
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

	private void createBlackBtn() {
		btnBlack = new JButton("");
		btnBlack.setBounds(136, 538, 80, 30);
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.BLACK);
					guess++;
					usersGuesses.add(BallColors.BLACK); //add black to guess array
					}
			}
		});
		btnBlack.setMinimumSize(new Dimension(80, 30));
		btnBlack.setBackground(Color.BLACK);
	}
	private void createWhiteBtn() {
		btnWhite = new JButton("");
		btnWhite.setBounds(226, 538, 80, 30);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.WHITE);
					guess++;
					usersGuesses.add(BallColors.WHITE); //add white to guess array
					}
			}
		});
		btnWhite.setMinimumSize(new Dimension(80, 30));
		btnWhite.setBackground(Color.WHITE);
	}
	private void createGreenBtn() {
		btnGreen = new JButton("");
		btnGreen.setBounds(46, 538, 80, 30);
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.GREEN);
					guess++;
					usersGuesses.add(BallColors.GREEN); //add green to guess array
					}
			}
		});
		btnGreen.setMinimumSize(new Dimension(80, 30));
		btnGreen.setBackground(Color.GREEN);
	}
	private void createBlueBtn() {
		btnBlue = new JButton("");
		btnBlue.setBounds(226, 580, 80, 30);
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.BLUE);
					guess++;
					usersGuesses.add(BallColors.BLUE); //add blue to guess array
					}
			}
		});
		btnBlue.setMinimumSize(new Dimension(80, 30));
		btnBlue.setBackground(Color.BLUE);
	}
	private void createYellowBtn() {
		btnYellow = new JButton("");
		btnYellow.setBounds(136, 580, 80, 30);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.YELLOW);
					guess++;
					usersGuesses.add(BallColors.YELLOW); //add yellow to guess array
					}

			}
		});
		btnYellow.setMinimumSize(new Dimension(80, 30));
		btnYellow.setBackground(Color.YELLOW);
	}
	private void createRedBtn() {
		btnRed = new JButton("");
		btnRed.setBounds(46, 580, 80, 30);
		
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (guess < 4) {
					paintCircle(Color.RED);
					guess++;
					usersGuesses.add(BallColors.RED); //add red to guess array
					}
			}
		});
		btnRed.setMinimumSize(new Dimension(80, 30));
		btnRed.setBackground(Color.RED);
	}
	private void paintCircle(Color c) {
		Graphics g = getGraphics();
		g.setColor(c);
		g.drawOval((guess+1) * 60, (turn+1) * 45, 30, 30);
		g.fillOval((guess+1) * 60, (turn+1) * 45, 30, 30);
	}
}

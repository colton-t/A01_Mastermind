package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Board extends JPanel {
	
	public static boolean gameOver = false;
	private static int turn = 9; //starts at bottom goes up
	public static  int guess = 0;
	private int rows = 10;
	private int coloumns = 4;
	
	private JButton btnRed;
	private JButton btnYellow;
	private JButton btnBlue;
	private JButton btnGreen;
	private JButton btnWhite;
	private JButton btnBlack;
	private JButton btnCheck;
	private JButton btnClear;
	private JButton btnNewGame;
	
	private static JLabel lblNewLabel = new JLabel(" ");
	private static JPanel panel = new JPanel();
	

	/**
	 * Create the panel.
	 * @param  
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
		
		createNewGame();
		add(btnNewGame);
		
		
		//create pegs
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(288, 0, 115, 499);
		add(panel);
		panel.setLayout(null);
		
		//create secret code
		CodeLogic.generateSecretCode();
	}

	/**
	 * Generates JLabel pegs based on passed black and white peg values
	 * @param blackPegs number of black pegs
	 * @param whitePegs number of white pegs
	 */
	public static void setLblPegs(int blackPegs, int whitePegs) {
		//for testing only DELETE UPON FINAL VERSION
		blackPegs = 0;
		whitePegs = 0;
		
		//x and y values used to create the group of four squares
		int xAdjustment = 0;
		int yAdjustment = 0;
		System.out.println(blackPegs + whitePegs);
		for(int i = 0; i <= 3; i++) {
			lblNewLabel = new JLabel(" ");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBounds((guess+1) * 20 + xAdjustment, 468 - (i * 10) + yAdjustment, 10, 10);
			
			if(blackPegs > 0) { //set color of squares to black for black pegs
				lblNewLabel.setBackground(Color.black);
				blackPegs--;
			} else if(whitePegs > 0) { //set color of squares to white for white pegs
				lblNewLabel.setBackground(Color.white);
				whitePegs--;
			} else { // set empty / wrong pegs to dark gray
				lblNewLabel.setBackground(Color.DARK_GRAY);
			}
			panel.add(lblNewLabel);
			if(i % 2 == 0) {
				xAdjustment += 12;
			} else {
				yAdjustment -= 12;
				xAdjustment -= 12;
			}
			
			panel.revalidate();
	        panel.repaint();
		}
	}
	
	private void createNewGame() {
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turn = 9;
				guess = 0;
				repaint();
				CodeLogic.usersGuesses.clear();
				CodeLogic.clearSecretCode();
				CodeLogic.generateSecretCode();
				MainWindow.changeLblOutput("Good Luck!");
				gameOver = false;
			}
		});
		btnNewGame.setBounds(288, 500, 100, 30);
	}
	
	/**
	 * Displays the secret code at the top of the board.
	 */
	private void revealSecretCode() {
		ArrayList<BallColors> temp = CodeLogic.getSecretCode();
		Graphics g = getGraphics();
		int x = 0;
		for(BallColors balls : temp) {
			if(balls.equals(BallColors.RED)) {
				g.setColor(Color.RED);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
			if(balls.equals(BallColors.YELLOW)) {
				g.setColor(Color.YELLOW);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
			if(balls.equals(BallColors.BLUE)) {
				g.setColor(Color.BLUE);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
			if(balls.equals(BallColors.GREEN)) {
				g.setColor(Color.GREEN);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
			if(balls.equals(BallColors.WHITE)) {
				g.setColor(Color.WHITE);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
			if(balls.equals(BallColors.BLACK)) {
				g.setColor(Color.BLACK);
				g.drawOval((x+1) * 60, (0) * 45, 30, 30);
				g.fillOval((x+1) * 60, (0) * 45, 30, 30);
				x++;
			}
		}
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
		btnClear.setBounds(136, 500, 80, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameOver == false) {
					guess = 0;
					CodeLogic.usersGuesses.clear(); //clear the users guesses from guess array.
					Graphics g = getGraphics();
					g.setColor(Color.gray);
					for (int x = 0; x < coloumns; x++) {
						g.drawOval((x + 1) * 60, (turn + 1) * 45, 30, 30);
						g.fillOval((x + 1) * 60, (turn + 1) * 45, 30, 30);
					}
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
				if(guess == 4 && turn > 0) {
					turn--;
					guess = 0;
					CodeLogic.checkGuess();
					if (gameOver == true) {
						revealSecretCode();
					}
				}
				else if(turn == 0 && guess == 4) {
					CodeLogic.loseGame();
					gameOver = true;
					turn--;
				}
			}
		});
		btnCheck.setMinimumSize(new Dimension(80, 30));
	}
	
	private void createBlackBtn() {
		btnBlack = new JButton("");
		btnBlack.setBounds(136, 538, 80, 30);
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.BLACK);
					guess++;
					CodeLogic.addUserGuess(BallColors.BLACK); // //add black to guess array
					}
			}
		});
		btnBlack.setMinimumSize(new Dimension(80, 30));
		btnBlack.setBackground(Color.BLACK);
		btnBlack.setOpaque(true);
		btnBlack.setBorderPainted(false);
	}
	private void createWhiteBtn() {
		btnWhite = new JButton("");
		btnWhite.setBounds(226, 538, 80, 30);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.WHITE);
					guess++;
					CodeLogic.addUserGuess(BallColors.WHITE); // //add white to guess array
					}
			}
		});
		btnWhite.setMinimumSize(new Dimension(80, 30));
		btnWhite.setBackground(Color.WHITE);
		btnWhite.setOpaque(true);
		btnWhite.setBorderPainted(false);
	}
	private void createGreenBtn() {
		btnGreen = new JButton("");
		btnGreen.setBounds(46, 538, 80, 30);
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.GREEN);
					guess++;
					CodeLogic.addUserGuess(BallColors.GREEN); //add green to guess array
					}
			}
		});
		btnGreen.setMinimumSize(new Dimension(80, 30));
		btnGreen.setBackground(Color.GREEN);
		btnGreen.setOpaque(true);
		btnGreen.setBorderPainted(false);
	}
	private void createBlueBtn() {
		btnBlue = new JButton("");
		btnBlue.setBounds(226, 580, 80, 30);
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.BLUE);
					guess++;
					CodeLogic.addUserGuess(BallColors.BLUE); // //add blue to guess array
					}
			}
		});
		btnBlue.setMinimumSize(new Dimension(80, 30));
		btnBlue.setBackground(Color.BLUE);
		btnBlue.setOpaque(true);
		btnBlue.setBorderPainted(false);
	}
	private void createYellowBtn() {
		btnYellow = new JButton("");
		btnYellow.setBounds(136, 580, 80, 30);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.YELLOW);
					guess++;
					CodeLogic.addUserGuess(BallColors.YELLOW); // //add yellow to guess array
					}

			}
		});
		btnYellow.setMinimumSize(new Dimension(80, 30));
		btnYellow.setBackground(Color.YELLOW);
		btnYellow.setOpaque(true);
		btnYellow.setBorderPainted(false);
	}
	private void createRedBtn() {
		btnRed = new JButton("");
		btnRed.setBounds(46, 580, 80, 30);
		
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (guess < 4 && gameOver == false) {
					paintCircle(Color.RED);
					guess++;
					CodeLogic.addUserGuess(BallColors.RED); //add red to guess array
					}
			}
		});
		btnRed.setMinimumSize(new Dimension(80, 30));
		btnRed.setBackground(Color.RED);
		btnRed.setOpaque(true);
		btnRed.setBorderPainted(false);
	}
	
	private void paintCircle(Color c) {
		Graphics g = getGraphics();
		g.setColor(c);
		g.drawOval((guess+1) * 60, (turn+1) * 45, 30, 30);
		g.fillOval((guess+1) * 60, (turn+1) * 45, 30, 30);
	}
	
}

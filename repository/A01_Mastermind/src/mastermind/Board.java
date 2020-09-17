package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Board extends JPanel {
	
	private int turn = 9;
	public int guess = 0;
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
		//create new game button
		createCheckBtn();
		add(btnCheck);
		
		createClearBtn();
		add(btnClear);
		
		createNewGame();
		add(btnNewGame);
		
		
		//create pegs
		//TODO
		
		//create secret code
		CodeLogic.generateSecretCode();
	}

	private void createNewGame() {
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turn = 9;
				guess = 0;
				repaint();
				CodeLogic.clearSecretCode();
				CodeLogic.generateSecretCode();
			}
		});
		btnNewGame.setBounds(288, 500, 100, 30);
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
				guess = 0;
				CodeLogic.usersGuesses.clear(); //clear the users guesses from guess array.
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
					CodeLogic.checkGuess();
				}
				else if(turn == 0) {
					CodeLogic.loseGame();
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
				if (guess < 4) {
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
				if (guess < 4) {
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
				if (guess < 4) {
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
				if (guess < 4) {
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
				if (guess < 4) {
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
				if (guess < 4) {
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
	
	public int getGuess() {
		return guess;
	}
}

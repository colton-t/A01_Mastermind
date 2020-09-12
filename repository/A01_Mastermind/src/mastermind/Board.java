package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Board extends JPanel {
	
	private int turn = 9;
	private int guess = 0;
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
	

	/**
	 * Create the panel.
	 */
	public Board() {
		setBackground(Color.LIGHT_GRAY);
		
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
		
		createCheckBtn();
		add(btnCheck);
		
		createClearBtn();
		add(btnClear);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < coloumns; x++) {
				g.drawOval((x + 1) * 60, (y + 1) * 60, 40, 40);
				g.fillOval((x + 1) * 60, (y + 1) * 60, 40, 40);
			}
		}
		for (int x =0; x < coloumns; x++) {
			g.drawRect((x+1)*60, 3, 40, 40);
			g.fillRect((x+1)*60, 3, 40, 40);
			
			g.drawOval((x+1)*60, 3, 40, 40);
			g.fillOval((x+1)*60, 3, 40, 40);
		}
	}
	
	private void createClearBtn() {
		btnClear = new JButton("Clear");
		btnClear.setBounds(226, 755, 80, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guess = 0;
				Graphics g = getGraphics();
				g.setColor(Color.gray);
				for (int x = 0; x < coloumns; x++) {
					g.drawOval((x + 1) * 60, (turn + 1) * 60, 40, 40);
					g.fillOval((x + 1) * 60, (turn + 1) * 60, 40, 40);
				}
			}
		});
		btnClear.setMinimumSize(new Dimension(80, 30));
		btnClear.setDefaultCapable(false);
	}
	private void createCheckBtn() {
		btnCheck = new JButton("Check");
		btnCheck.setBounds(46, 755, 80, 30);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guess > 3 && turn > 0) {
					turn--;
					guess = 0;
				}
				if(turn == 0) {
					
				}
			}
		});
		btnCheck.setMinimumSize(new Dimension(80, 30));
	}
	private void createBlackBtn() {
		btnBlack = new JButton("");
		btnBlack.setBounds(136, 678, 80, 30);
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.BLACK);
					guess++;
					}
			}
		});
		btnBlack.setMinimumSize(new Dimension(80, 30));
		btnBlack.setBackground(Color.BLACK);
	}
	private void createWhiteBtn() {
		btnWhite = new JButton("");
		btnWhite.setBounds(226, 678, 80, 30);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.WHITE);
					guess++;
					}
			}
		});
		btnWhite.setMinimumSize(new Dimension(80, 30));
		btnWhite.setBackground(Color.WHITE);
	}
	private void createGreenBtn() {
		btnGreen = new JButton("");
		btnGreen.setBounds(46, 678, 80, 30);
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.GREEN);
					guess++;
					}
			}
		});
		btnGreen.setMinimumSize(new Dimension(80, 30));
		btnGreen.setBackground(Color.GREEN);
	}
	private void createBlueBtn() {
		btnBlue = new JButton("");
		btnBlue.setBounds(226, 714, 80, 30);
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.BLUE);
					guess++;
					}
			}
		});
		btnBlue.setMinimumSize(new Dimension(80, 30));
		btnBlue.setBackground(Color.BLUE);
	}
	private void createYellowBtn() {
		btnYellow = new JButton("");
		btnYellow.setBounds(136, 714, 80, 30);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guess < 4) {
					paintCircle(Color.YELLOW);
					guess++;
					}

			}
		});
		btnYellow.setMinimumSize(new Dimension(80, 30));
		btnYellow.setBackground(Color.YELLOW);
	}
	private void createRedBtn() {
		btnRed = new JButton("");
		btnRed.setBounds(46, 714, 80, 30);
		
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (guess < 4) {
					paintCircle(Color.RED);
					guess++;
					}
			}
		});
		btnRed.setMinimumSize(new Dimension(80, 30));
		btnRed.setBackground(Color.RED);
	}
	private void paintCircle(Color c) {
		Graphics g = getGraphics();
		g.setColor(c);
		g.drawOval((guess+1) * 60, (turn+1) * 60, 40, 40);
		g.fillOval((guess+1) * 60, (turn+1) * 60, 40, 40);
	}
}

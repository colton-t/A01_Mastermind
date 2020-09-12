package mastermind;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 880);
		getContentPane().setLayout(null);
		
		JPanel displayBoard = createBoard();
		getContentPane().add(displayBoard);
		
		JPanel titlePanel = createTitlePanel();
		titlePanel.setLayout(null);
		
		JLabel lblTitle = createTitleLabel();
		titlePanel.add(lblTitle);
		
		JTextArea txtrRulesWillGo = createRulesTextPanel();
		titlePanel.add(txtrRulesWillGo);
		
		JPanel outputPanel = createOutputPanel();
		getContentPane().add(outputPanel);
	}

	private JPanel createTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(413, 11, 395, 609);
		getContentPane().add(titlePanel);
		return titlePanel;
	}

	private JLabel createTitleLabel() {
		JLabel lblTitle = new JLabel("MASTERMIND");
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 375, 61);
		return lblTitle;
	}

	private JTextArea createRulesTextPanel() {
		JTextArea txtRules = new JTextArea();
		txtRules.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtRules.setEditable(false);
		txtRules.setText("Object of the game:\r\nThe computer has selected a secret combination \r\nof 4 colored pegs and you have to guess that \r\ncombination in 10 or fewer tries to win.\r\n\r\nHow to play:\r\nTo create your guess click each apparent \r\ncolored peg until you've filled the row with \r\nyour combination (you can delete your guess\r\nby clicking \"clear\" button). Then click the \r\n\"check\" button.\r\n\r\nEach time you submit a guess the machine will \r\nuse score pegs to let you know how close that\r\nguess is.\r\n\r\nFor each guess a black score peg indicates that \r\none of your pegs is the right color in the right \r\nposition. A white score peg indicates that one \r\nof your pegs is the right color in the wrong\r\nposition.\r\n\r\nUse the score to guide your next guess. \r\nIf your guess scores 4 black score pegs within \r\n10 tries, you win.\r\n\r\nTo begin a new game click the \"new game\" button.");
		txtRules.setBounds(10, 147, 375, 439);
		return txtRules;
	}

	private JPanel createOutputPanel() {
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(Color.DARK_GRAY);
		outputPanel.setBounds(413, 631, 395, 201);
		return outputPanel;
	}

	private JPanel createBoard() {
		JPanel displayBoard = new JPanel();
		displayBoard.setBounds(10, 11, 393, 821);
		
		displayBoard.setLayout(new BorderLayout(0, 0));
		displayBoard.setBackground(Color.GRAY);
		
		Board board = new Board();
		displayBoard.add(board, BorderLayout.CENTER);
		
		return displayBoard;
	}
}

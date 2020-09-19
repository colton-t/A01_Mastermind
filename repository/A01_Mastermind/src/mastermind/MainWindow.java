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
import java.awt.Insets;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	public static JLabel lblOutput;
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
		setBounds(100, 100, 834, 666);
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
		titlePanel.setBounds(413, 11, 395, 484);
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
		txtRules.setMargin(new Insets(0, 0, 0, 4));
		txtRules.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtRules.setEditable(false);
		txtRules.setText(" Object of the game:\r\n The computer has selected a secret combination \r\n of 4 colored pegs and you have to guess that \r\n combination in 10 or fewer tries to win.\r\n\r\n How to play:\r\n To create your guess click each apparent \r\n colored peg until you've filled the row with \r\n your combination (you can delete your guess\r\n by clicking \"clear\" button). Then click the \r\n \"check\" button.\r\n\r\n Each time you submit a guess the machine will \r\n use score pegs to let you know how close that\r\n guess is.\r\n\r\n For each guess a black score peg indicates that \r\n one of your pegs is the right color in the right \r\n position. A white score peg indicates that one \r\n of your pegs is the right color in the wrong\r\n position.\r\n\r\n Use the score to guide your next guess. \r\n If your guess scores 4 black score pegs within \r\n 10 tries, you win.\r\n\r\n To begin a new game click the \"new game\" button.");
		txtRules.setBounds(10, 84, 375, 390);
		return txtRules;
	}

	private JPanel createOutputPanel() {
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(Color.LIGHT_GRAY);
		outputPanel.setBounds(415, 509, 395, 123);
		outputPanel.setLayout(null);
		
		lblOutput = new JLabel("Good Luck!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Kohinoor Telugu", Font.BOLD, 32));
		lblOutput.setBounds(6, 6, 383, 111);
		outputPanel.add(lblOutput);
		return outputPanel;
	}

	private JPanel createBoard() {
		JPanel displayBoard = new JPanel();
		displayBoard.setBounds(10, 11, 393, 621);
		
		displayBoard.setLayout(new BorderLayout(0, 0));
		displayBoard.setBackground(Color.GRAY);
		
		Board board = new Board();
		displayBoard.add(board, BorderLayout.CENTER);
		
		return displayBoard;
	}
	
	public static String changeLblOutput(String s) {
		lblOutput.setText(s);
		return s;
	}
}

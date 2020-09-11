package mastermind;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 5415959675461106180L;

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
		setBounds(100, 100, 911, 833);
		getContentPane().setLayout(new MigLayout("", "[375.00,grow][548.00,grow]", "[557.00,grow][96.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, "cell 0 0,grow");
		
		JPanel displayBoard = createBoard();
		getContentPane().add(displayBoard, "cell 1 0 1 2,grow");
		
		JPanel displayControls = createControlPanel();
		getContentPane().add(displayControls, "cell 0 1,grow");
	}

	private JPanel createControlPanel() {
		JPanel displayControls = new JPanel();
		
		displayControls.setLayout(new BorderLayout(0, 0));
		displayControls.setBackground(Color.LIGHT_GRAY);
		
		PlayerControls controlPanel = new PlayerControls();
		displayControls.add(controlPanel);
		return displayControls;
	}

	private JPanel createBoard() {
		JPanel displayBoard = new JPanel();
		
		displayBoard.setLayout(new BorderLayout(0, 0));
		displayBoard.setBackground(Color.LIGHT_GRAY);
		
		Board board = new Board();
		displayBoard.add(board);
		
		return displayBoard;
	}

}

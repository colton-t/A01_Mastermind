package mastermind;

import javax.swing.JPanel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PlayerControls extends JPanel {
	
	private JButton btnRed;
	private JButton btnYellow;
	private JButton btnBlue;
	private JButton btnGreen;
	private JButton btnWhite;
	private JButton btnBlack;
	private JButton btnCheck;
	private JButton btnClear;
	private BallColors ball;
	/**
	 * Create the panel.
	 */
	public PlayerControls() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[grow][grow][grow]"));
		
		createRedBtn();
		add(btnRed, "cell 0 0");
		
		createYellowBtn();
		add(btnYellow, "cell 1 0");
		
		createBlueBtn();
		add(btnBlue, "cell 2 0");
		
		createGreenBtn();
		add(btnGreen, "cell 3 0");
		
		createWhiteBtn();
		add(btnWhite, "cell 4 0");
		
		createBlackBtn();
		add(btnBlack, "cell 5 0");
		
		createCheckBtn();
		add(btnCheck, "cell 0 1 3 2,alignx center,aligny center");
		
		createClearBtn();
		add(btnClear, "cell 3 1 3 2,alignx center,aligny center");
	}
	private void createClearBtn() {
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClear.setMinimumSize(new Dimension(80, 30));
		btnClear.setDefaultCapable(false);
	}
	private void createCheckBtn() {
		btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheck.setMinimumSize(new Dimension(80, 30));
	}
	private void createBlackBtn() {
		btnBlack = new JButton("");
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlack.setMinimumSize(new Dimension(80, 30));
		btnBlack.setBackground(Color.BLACK);
	}
	private void createWhiteBtn() {
		btnWhite = new JButton("");
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWhite.setMinimumSize(new Dimension(80, 30));
		btnWhite.setBackground(Color.WHITE);
	}
	private void createGreenBtn() {
		btnGreen = new JButton("");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGreen.setMinimumSize(new Dimension(80, 30));
		btnGreen.setBackground(Color.GREEN);
	}
	private void createBlueBtn() {
		btnBlue = new JButton("");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlue.setMinimumSize(new Dimension(80, 30));
		btnBlue.setBackground(Color.BLUE);
	}
	private void createYellowBtn() {
		btnYellow = new JButton("");
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board b = new Board();
				Graphics g = getGraphics();
				g.setColor(Color.yellow);
				g.drawOval(( 1) * 60, ( 1) * 60, 40, 40);
				g.fillOval((1) * 60, ( 1) * 60, 40, 40);
				b.changeColor(Color.yellow);
			}
		});
		btnYellow.setMinimumSize(new Dimension(80, 30));
		btnYellow.setBackground(Color.YELLOW);
	}
	private void createRedBtn() {
		btnRed = new JButton("");
		
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRed.setMinimumSize(new Dimension(80, 30));
		btnRed.setBackground(Color.RED);
	}

}

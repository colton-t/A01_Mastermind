package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Board extends JPanel {
	private static final long serialVersionUID = -6746198111706791600L;
	private int turn = 0;
	private int guess = 0;
	private BallColors[] row;
	private PegColors[] guessRow;
	private BallColors[] secretCode;
	private int MAX_TRIES;
	private int rows = 10;
	private int coloumns = 4;
	private Color color = Color.blue;

	/**
	 * Create the panel.
	 */
	public Board() {
		
	}
	
	public void changeColor(Color c) {
		this.color = c;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < coloumns; x++) {
				g.drawOval((x + 1) * 60, (y + 1) * 60, 40, 40);
				g.fillOval((x + 1) * 60, (y + 1) * 60, 40, 40);
			}
			for (int i = 0; i < 2; i++) {
				g.drawOval((coloumns + 1) * 60, (y + 1) *60, 10, 10);
				g.fillOval((coloumns + 1) * 60, (y + 1) *60, 10, 10);
				g.drawOval((coloumns + 1) * 64, (y + 1) *60, 10, 10);
				g.fillOval((coloumns + 1) * 64, (y + 1) *60, 10, 10);
				
				g.drawOval((coloumns + 1) * 60, (y+1) * 30, 10, 10);
				g.fillOval((coloumns + 1) * 60, (y+1) * 30, 10, 10);
				g.drawOval((coloumns + 1) * 64, (y+1) * 30, 10, 10);
				g.fillOval((coloumns + 1) * 64, (y+1) * 30, 10, 10);
			}
		}
	}
}

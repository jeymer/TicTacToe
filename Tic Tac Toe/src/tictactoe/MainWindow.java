package tictactoe;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
public class MainWindow {
	
	
	// Strings representing the letters that go into the squares
	public Customization options = new Customization();
	
	// Boolean representing who's turn it is
	public boolean xTurn = true;
	
	// Tic Tac Toe Window
	public static JFrame frame = new JFrame("Tic Tac Toe");
	
	// Grid holding contents of board
	public Grid grid = new Grid(this);
	
	// Create a MenuBarBuilder and use it to build the menu bar
	public static MenuBarBuilder menuBarBuilder = new MenuBarBuilder();
	public static JMenuBar menuBar = menuBarBuilder.createMenuBar();
	
	// Object used to display end screen
	public EndScreen endScreen = new EndScreen(this);
	
	public MainWindow() { 
		createAndShowGUI();
	}
	
	public void createAndShowGUI() {
		// Set attributes of the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setJMenuBar(menuBar);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.setBackground(Color.BLACK);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		// Add "squares" (buttons) to game screen
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				panel.add(grid.getSquare(r, c).button);
			}
		}
		
		// Add panel to the game window and show the window
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainWindow(); 
			}
		});
	}
	
	public int checkWinner() {
		
		// Check rows for winner
		for(int r = 0; r < 3; r++) {
			if(grid.getSquare(r, 0).value != 0 
					&& grid.getSquare(r, 0).value == grid.getSquare(r, 1).value 
					&& grid.getSquare(r, 1).value == grid.getSquare(r, 2).value ) {
				if(xTurn) return 1;
				return 2;
			}
		}
		
		// Check columns for winner
		for(int c = 0; c < 3; c++) {
			if(grid.getSquare(0, c).value != 0 
					&& grid.getSquare(0, c).value == grid.getSquare(1, c).value 
					&& grid.getSquare(1, c).value == grid.getSquare(2, c).value ) {
				if(xTurn) return 1;
				return 2;
			}
		}
		
		// Check diagonals
		if(	(grid.getSquare(0, 0).value != 0 
				&&grid.getSquare(0, 0).value == grid.getSquare(1, 1).value 
				&& grid.getSquare(1, 1).value == grid.getSquare(2, 2).value)
				|| (grid.getSquare(0, 2).value != 0
				&& grid.getSquare(0, 2).value == grid.getSquare(1, 1).value 
				&& grid.getSquare(1, 1).value == grid.getSquare(2, 0).value)){
					if(xTurn) return 1;
					return 2;
		}
		
		// Check tie
		// Start with value of 3, if it finds an empty square make it 0 otherwise return 3
		int tie = 3;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(grid.getSquare(r, c).value == 0) {
					tie = 0;
				}
			}
		}
		
		return tie;
	}
}

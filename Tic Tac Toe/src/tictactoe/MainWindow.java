package tictactoe;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow {
	
	// Strings representing the letters that go into the squares
	public static String X = "X";
	public static String O = "O";
	
	// Boolean representing who's turn it is
	public static boolean xTurn = true;
	
	// Tic Tac Toe Window
	public static JFrame frame = new JFrame("Tic Tac Toe");
	
	// Grid holding contents of board
	public static Grid grid = new Grid();
	
	public static void main(String args[]) {
		
		// Set attributes of the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.setBackground(Color.BLACK);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		// Add "squares" (buttons) to game screen
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				panel.add(grid.getSquare(r, c).getButton());
			}
		}
		
		// Add panel to the game window and show the window
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	public static int checkWinner() {
		
		// Check rows for winner
		for(int r = 0; r < 3; r++) {
			if(grid.getSquare(r, 0).getValue() != 0 
					&& grid.getSquare(r, 0).getValue() == grid.getSquare(r, 1).getValue() 
					&& grid.getSquare(r, 1).getValue() == grid.getSquare(r, 2).getValue() ) {
				if(xTurn) return 1;
				return 2;
			}
		}
		
		// Check columns for winner
		for(int c = 0; c < 3; c++) {
			if(grid.getSquare(0, c).getValue() != 0 
					&& grid.getSquare(0, c).getValue() == grid.getSquare(1, c).getValue() 
					&& grid.getSquare(1, c).getValue() == grid.getSquare(2, c).getValue() ) {
				if(xTurn) return 1;
				return 2;
			}
		}
		
		// Check diagonals
		if(	(grid.getSquare(0, 0).getValue() != 0 
				&&grid.getSquare(0, 0).getValue() == grid.getSquare(1, 1).getValue() 
				&& grid.getSquare(1, 1).getValue() == grid.getSquare(2, 2).getValue())
				|| (grid.getSquare(0, 2).getValue() != 0
				&& grid.getSquare(0, 2).getValue() == grid.getSquare(1, 1).getValue() 
				&& grid.getSquare(1, 1).getValue() == grid.getSquare(2, 0).getValue())){
					if(xTurn) return 1;
					return 2;
		}
		
		// Check tie
		// Start with value of 3, if it finds an empty square make it 0 otherwise return 3
		int tie = 3;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(grid.getSquare(r, c).getValue() == 0) {
					tie = 0;
				}
			}
		}
		
		return tie;
	}
}

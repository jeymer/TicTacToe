/* Jeffrey Eymer, 2016
 * Class to represent the full grid of the tic-tac-toe game
 */

package tictactoe;

import java.awt.Color;

public class Grid {

	public MainWindow mainWindow; // Used to pass along to the square constructor
	public Square[][] grid = new Square[3][3]; // 3x3 grid of Square objects

	public Grid(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				grid[r][c] = new Square(mainWindow, r, c);

			}
		}
	}

	// Get square at (x, y)
	public Square getSquare(int xCoord, int yCoord) {
		return this.grid[xCoord][yCoord];
	}


	// Delegate method to clear all squares
	public void clear() {
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				grid[r][c].clear();
			}
		}
	}
	
	// Method to change color of the grid squares(buttons)
	public void setColor(Color color) {
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				this.grid[r][c].button.setForeground(color);
			}
		}
	}


	public int checkWinner() {

		// Check rows for winner
		for(int r = 0; r < 3; r++) {
			if(grid[r][0].value != 0 
					&& grid[r][0].value == grid[r][1].value 
					&& grid[r][1].value == grid[r][2].value) {
				if(mainWindow.xTurn) return 1;
				return 2;
			}
		}

		// Check columns for winner
		for(int c = 0; c < 3; c++) {
			if(grid[0][c].value != 0 
					&& grid[0][c].value == grid[1][c].value 
					&& grid[1][c].value == grid[2][c].value ) {
				if(mainWindow.xTurn) return 1;
				return 2;
			}
		}

		// Check diagonals
		if(	(grid[0][0].value != 0 
				&& grid[0][0].value == grid[1][1].value 
				&& grid[1][1].value == grid[2][2].value)
				|| (grid[0][2].value != 0
				&& grid[0][2].value == grid[1][1].value 
				&& grid[1][1].value == grid[2][0].value)){
			if(mainWindow.xTurn) return 1;
			return 2;
		}

		// Check tie
		// If empty square found return 0, otherwise return 3 signifying tie
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(grid[r][c].value == 0) {
					return 0;
				}
			}
		}

		return 3;
	}



}
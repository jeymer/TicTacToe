/* Jeffrey Eymer, 2016
 * Class to represent the full grid of the tic-tac-toe game
 */

package tictactoe;

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
	
	
	
	
	
}
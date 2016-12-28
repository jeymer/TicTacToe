/* Jeffrey Eymer, 2016
 * This class is a simple class used to hold the screen which displays the winner
 */

package tictactoe;

import javax.swing.JOptionPane;

public class EndScreen {
	
	public MainWindow mainWindow;
	
	public EndScreen(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	public void displayEndScreen() {
		String winner = ""; 
		switch(mainWindow.checkWinner()) {
		case 1:
			winner = "Player 1 (" + mainWindow.options.X + ") wins!\nPlay again?";
			break;
		case 2:
			winner = "Player 2 (" + mainWindow.options.O + ") wins!\nPlay again?";
			break;
		case 3:
			winner = "Draw!\nPlay again?";
			break;
		default:
			break;
		}
		if(!winner.equals("")) {
			int choice = JOptionPane.showConfirmDialog(MainWindow.frame, winner, "Congratulations!", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				mainWindow.grid.clear();
				mainWindow.xTurn = false;
			}
			else {
				System.exit(0);
			}
		}
		
	}
}

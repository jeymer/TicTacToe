/* Jeffrey Eymer, 2016
 * This class represents each individual square in the Tic Tac Toe grid
 */

package tictactoe;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Square {
	
	private int value = 0; // The value within the square starts at 0 (empty square)
	private JButton button;
	
	// value will always be preset to 0, so no constructor code needed to set that
	public Square(int xCoord, int yCoord) {
		this.button = new JButton("");
		button.setFont(new Font("Arial", Font.PLAIN, 72));
		this.setActionListener();
	}
	
	
	// Get and set the value of the square
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	// Get the button
	public JButton getButton() {
		return this.button;
	}
	
	// Set the text in the button
	public void setText() {
		if(this.value == 0) this.button.setText("");
		else if(this.value == 1) this.button.setText(MainWindow.X);
		else if(this.value == 2) this.button.setText(MainWindow.O);
		// These are set to the string variable in the MainWindow class to allow 
		// for easy switching of the letters (in case of future customization options)
	}
	
	// Sets value back to 0 and clears button text
	public void clear() {
		this.value = 0;
		this.setText();
	}
	
	// Set up action listener to handle clicking button
	public void setActionListener() {
		this.button.addActionListener(e -> {
			if(value != 0) {
				JOptionPane.showMessageDialog(MainWindow.frame, "Please select an unused square.");
			}
			else {
				if(MainWindow.xTurn) {
					this.value = 1;
					this.setText();
				}
				else {
					this.value = 2;
					this.setText();
				}
				EndScreen.displayEndScreen();
				MainWindow.xTurn = !(MainWindow.xTurn);
			}
		});
	}
	
}

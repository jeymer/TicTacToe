package tictactoe;

import java.awt.Color;

public class Customization {
	
	// Properties that can be changed include the colors 
	// and the letters/strings used in the boxes
	public Color lineColor;
	public Color textColor;
	public String X;
	public String O;
	
	// Set to initial values
	public Customization() {
		this.lineColor = Color.BLACK;
		this.textColor = Color.BLACK;
		this.X = "X";
		this.O = "O";
	}
	
}

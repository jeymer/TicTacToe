package tictactoe;

import java.awt.Color;

public class Customization {
	
	// Properties that can be changed include the colors 
	// and the letters/strings used in the boxes
	public Color lineColor;
	public Color squareColor;
	public String X;
	public String O;
	
	public Customization() {
		this.lineColor = Color.BLACK;
		this.squareColor = Color.WHITE;
		this.X = "X";
		this.O = "O";
	}
	
}

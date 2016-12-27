package tictactoe;

import java.awt.Color;

public class Customization {
	
	// Properties that can be changed include the colors 
	// and the letters/strings used in the boxes
	private Color lineColor;
	private Color squareColor;
	private String X;
	private String Y;
	
	public Customization() {
		this.lineColor = Color.BLACK;
		this.squareColor = Color.WHITE;
		this.X = "X";
		this.Y = "Y";
	}

	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getSquareColor() {
		return squareColor;
	}

	public void setSquareColor(Color squareColor) {
		this.squareColor = squareColor;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}
	
	
}

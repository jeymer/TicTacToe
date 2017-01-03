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
	
	public MainWindow() { 
		createAndShowGUI();
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainWindow(); 
			}
		});
	}
}

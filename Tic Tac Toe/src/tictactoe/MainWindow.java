package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow {
	
	public static final String X = "X";
	public static final String O = "O";
	public static boolean xTurn = true;
	public static JFrame frame = new JFrame("Tic Tac Toe");
	public static int[][] board = new int[3][3];
	//0 = empty
	//1 = x
	//2 = O
	
	//Had to declare buttons up here in order to make new game work
	public static JButton ul = new JButton("");
	public static JButton uc = new JButton("");
	public static JButton ur = new JButton("");
	public static JButton cl = new JButton("");
	public static JButton cc = new JButton("");
	public static JButton cr = new JButton("");
	public static JButton bl = new JButton("");
	public static JButton bc = new JButton("");
	public static JButton br = new JButton("");
	
	
	public static void main(String args[]) {
		for(int a = 0; a < 3; a++) {
			for(int b = 0; b < 3; b++) {
				board[a][b] = 0;
			}
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.setBackground(Color.BLACK);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		
		ul.setFont(new Font("Arial", Font.PLAIN, 72));
		uc.setFont(new Font("Arial", Font.PLAIN, 72));
		ur.setFont(new Font("Arial", Font.PLAIN, 72));
		cl.setFont(new Font("Arial", Font.PLAIN, 72));
		cc.setFont(new Font("Arial", Font.PLAIN, 72));
		cr.setFont(new Font("Arial", Font.PLAIN, 72));
		bl.setFont(new Font("Arial", Font.PLAIN, 72));
		bc.setFont(new Font("Arial", Font.PLAIN, 72));
		br.setFont(new Font("Arial", Font.PLAIN, 72));
		
		ul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[0][0] == 0) {
					if(xTurn) {
						ul.setText(X);
						board[0][0] = 1;
					}
					else {
						ul.setText(O);
						board[0][0] = 2;
					}
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		uc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[0][1] == 0) {
					if(xTurn) {
						uc.setText(X);
						board[0][1] = 1;
					}
					else {
						uc.setText(O);
						board[0][1] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		ur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[0][2] == 0) {
					if(xTurn) {
						ur.setText(X);
						board[0][2] = 1;
					}
					else {
						ur.setText(O);
						board[0][2] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		cl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[1][0] == 0) {
					if(xTurn) {
						cl.setText(X);
						board[1][0] = 1;
					}
					else {
						cl.setText(O);
						board[1][0] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});		
		cc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[1][1] == 0) {
					if(xTurn) {
						cc.setText(X);
						board[1][1] = 1;
					}
					else {
						cc.setText(O);
						board[1][1] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		cr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[1][2] == 0) {
					if(xTurn) {
						cr.setText(X);
						board[1][2] = 1;
					}
					else {
						cr.setText(O);
						board[1][2] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});		
		bl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[2][0] == 0) {
					if(xTurn) {
						bl.setText(X);
						board[2][0] = 1;
					}
					else {
						bl.setText(O);
						board[2][0] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[2][1] == 0) {
					if(xTurn) {
						bc.setText(X);
						board[2][1] = 1;
					}
					else {
						bc.setText(O);
						board[2][1] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});		
		br.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board[2][2] == 0) {
					if(xTurn) {
						br.setText(X);
						board[2][2] = 1;
					}
					else {
						br.setText(O);
						board[2][2] = 2;
					}
					
					if(checkWinner() != 0) {
						displayEndScreen();
					}
					xTurn = !xTurn;
				}
				else {
					errorWindow();
				}
			}
		});
		
		
		panel.add(ul);
		panel.add(uc);
		panel.add(ur);
		panel.add(cl);
		panel.add(cc);
		panel.add(cr);
		panel.add(bl);
		panel.add(bc);
		panel.add(br);
		
		frame.add(panel);
		
		
	}

	public static void errorWindow() {
		JOptionPane.showMessageDialog(frame, "Please select an unused square.");
	}
	
	public static int checkWinner() {
		
		//Check rows
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return board[i][0];
			}
		}
		
		//Check columns
		for(int i = 0; i < 3; i++) {
			if(board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return board[0][i];
			}
		}
		
		//Check diagonal
		if(board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[0][0];
		}
		if(board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return board[0][2];
		}
		
		boolean full = true;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(board[r][c] == 0) {
					full = false;
				}
			}
		}
		
		if(full) return 3;
		
		//0 = no winner
		//1 = X
		//2 = O
		//3 = Draw
		return 0;
	}
	
	public static void displayEndScreen() {
		//Class should only be called if someone wins or board is full
		String end = "Error"; //If error displays in box, something went wrong in program
		if(checkWinner() == 1) {
			end = "Player 1 (X) wins!\nPlay again?";
		}
		else if(checkWinner() == 2) {
			end = "Player 2 (O) wins!\nPlay again?";
		}
		else if(checkWinner() == 3) {
			end = "Draw!\nPlay again?";
		}
		int choice = JOptionPane.showConfirmDialog(frame, end, "Congratulations!", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			//Reset board
			for(int a = 0; a < 3; a++) {
				for(int b = 0; b < 3; b++) {
					board[a][b] = 0;
				}
			}
			xTurn = false; //Awful coding, just know that xTurn will always be changed to true after this line is called
			ul.setText("");
			uc.setText("");
			ur.setText("");
			cl.setText("");
			cc.setText("");
			cr.setText("");
			bl.setText("");
			bc.setText("");
			br.setText("");
			
		}
		else if(choice == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
		
	}
}

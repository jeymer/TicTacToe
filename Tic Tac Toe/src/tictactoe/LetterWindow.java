package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LetterWindow {
	public MainWindow mainWindow;
	
	public JButton save = new JButton("Save");
	public JButton cancel = new JButton("Cancel");
	
	public JTextField xBox = new JTextField();
	public JTextField oBox = new JTextField();
	
	public JFrame frame = new JFrame("Customize Text");
	
	

	public void save() {
		boolean successful = true;
		
		// Make sure not empty strings and only one character long
		if(this.xBox.getText().equals("") 
				|| this.oBox.getText().equals("") 
				|| this.xBox.getText().length() != 1 
				|| this.oBox.getText().length() != 1) {
			JOptionPane.showMessageDialog(this.frame, "Please enter valid characters.\n(Only one character allowed)", "Error", JOptionPane.ERROR_MESSAGE);
			successful = false;
		}

		if(successful) {
			this.mainWindow.setText(xBox.getText(), oBox.getText());
			this.frame.setVisible(false);
		}
	}
	
	public void createAndShowGUI() {
		frame.setSize(350, 150);
		frame.setResizable(false);
		
		JLabel message = new JLabel("Please enter your desired letters below.");
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.add(message, BorderLayout.PAGE_START);
		
		JPanel settings = new JPanel();
		settings.setLayout(new GridLayout(2, 0, 0, 5));
		
		// Set initial text of boxes
		xBox.setText(mainWindow.options.X);
		oBox.setText(mainWindow.options.O);
		
		// Center text in box
		xBox.setHorizontalAlignment(JTextField.CENTER);
		oBox.setHorizontalAlignment(JTextField.CENTER);
		
		settings.add(xBox);
		settings.add(oBox);
		
		frame.add(settings, BorderLayout.CENTER);
		
		// Add save and cancel buttons to bottom
		JPanel buttons = new JPanel();
		cancel.addActionListener(e -> {
			frame.setVisible(false);
		});
		buttons.add(cancel);
		save.addActionListener(e -> {
			save();
		});
		buttons.add(save);
		frame.add(buttons, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	
	public LetterWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		createAndShowGUI();
	}
}

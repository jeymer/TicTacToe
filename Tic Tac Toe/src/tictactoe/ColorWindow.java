package tictactoe;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class ColorWindow {

	public MainWindow mainWindow;
	public JButton save = new JButton("Save");
	public JButton cancel = new JButton("Cancel");
	public 	JFrame frame = new JFrame("Customize Colors");

	JTextField lineR = new JTextField();
	JTextField lineG = new JTextField();
	JTextField lineB = new JTextField();
	JTextField textR = new JTextField();
	JTextField textG = new JTextField();
	JTextField textB = new JTextField();

	public void createAndShowGUI() {
		frame.setSize(450, 150);
		frame.setResizable(false);

		JLabel message = new JLabel("Please enter the colors' RGB values below.");
		message.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.add(message, BorderLayout.PAGE_START);

		JPanel settings = new JPanel();
		settings.setLayout(new GridLayout(2, 0));

		// Center the text in the boxes
		lineR.setHorizontalAlignment(JTextField.CENTER);
		lineG.setHorizontalAlignment(JTextField.CENTER);
		lineB.setHorizontalAlignment(JTextField.CENTER);
		textR.setHorizontalAlignment(JTextField.CENTER);
		textG.setHorizontalAlignment(JTextField.CENTER);
		textB.setHorizontalAlignment(JTextField.CENTER);

		// Set textFields' initial text to the current values
		lineR.setText("" + mainWindow.panel.getBackground().getRed());
		lineG.setText("" + mainWindow.panel.getBackground().getGreen());
		lineB.setText("" + mainWindow.panel.getBackground().getBlue());
		textR.setText("" + mainWindow.grid.getSquare(0, 0).button.getForeground().getRed());
		textG.setText("" + mainWindow.grid.getSquare(0, 0).button.getForeground().getGreen());
		textB.setText("" + mainWindow.grid.getSquare(0, 0).button.getForeground().getBlue());


		// Add boxes to set color
		JPanel lineColor = new JPanel();
		lineColor.setLayout(new GridLayout(1, 0, 20, 10));
		JLabel label1 = new JLabel("Line Color:");
		label1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lineColor.add(label1);
		lineColor.add(lineR);
		lineColor.add(lineG);
		lineColor.add(lineB);
		settings.add(lineColor, BorderLayout.LINE_START);

		// Add boxes to set text color
		JPanel textColor = new JPanel();
		textColor.setLayout(new GridLayout(1, 0, 20, 10));
		JLabel label2 = new JLabel("Text Color:");
		label2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		textColor.add(label2);
		textColor.add(textR);
		textColor.add(textG);
		textColor.add(textB);
		settings.add(textColor, BorderLayout.LINE_START);

		frame.add(settings);

		// Add save and cancel buttons to bottom
		JPanel buttons = new JPanel();
		cancel.addActionListener(e -> {
			frame.setVisible(false);
		});
		buttons.add(cancel);
		save.addActionListener(e -> {
			save(frame);
		});
		buttons.add(save);
		frame.add(buttons, BorderLayout.SOUTH);

		// Make color customization window appear
		frame.setVisible(true);
	}

	public void save(JFrame frame) {
		boolean successful = true;

		// Make sure all inputs are numbers, if not then catch the NumberFormatException
		try {
			// Make sure all inputs are in the range for valid RGB values
			if(Integer.parseInt(this.lineR.getText()) < 0
					|| Integer.parseInt(this.lineR.getText()) > 255
					|| Integer.parseInt(this.lineG.getText()) < 0
					|| Integer.parseInt(this.lineG.getText()) > 255
					|| Integer.parseInt(this.lineB.getText()) < 0
					|| Integer.parseInt(this.lineB.getText()) > 255
					|| Integer.parseInt(this.textR.getText()) < 0
					|| Integer.parseInt(this.textR.getText()) > 255
					|| Integer.parseInt(this.textG.getText()) < 0
					|| Integer.parseInt(this.textG.getText()) > 255
					|| Integer.parseInt(this.textB.getText()) < 0
					|| Integer.parseInt(this.textB.getText()) > 255) {
				JOptionPane.showMessageDialog(this.frame, "Please enter valid RGB values", "Error", JOptionPane.ERROR_MESSAGE);
				successful = false;
			}

			if(successful) {
				Color line = new Color(Integer.parseInt(this.lineR.getText()), Integer.parseInt(this.lineG.getText()), Integer.parseInt(this.lineB.getText()));
				Color text = new Color(Integer.parseInt(this.textR.getText()), Integer.parseInt(this.textG.getText()), Integer.parseInt(this.textB.getText()));
				mainWindow.setColors(line, text);
				frame.setVisible(false);
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this.frame, "Please enter valid RGB values", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ColorWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		createAndShowGUI();
	}


}

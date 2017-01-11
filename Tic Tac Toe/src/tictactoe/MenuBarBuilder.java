package tictactoe;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarBuilder {
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem colors = new JMenuItem("Colors");
	private JMenuItem text = new JMenuItem("Text");
	public MainWindow mainWindow;
	
	public MenuBarBuilder(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	public JMenu createFileMenu() {
		JMenu returnMenu = new JMenu("File");
		exit.addActionListener(e -> {
			System.exit(0);
		});
		returnMenu.add(exit);
		return returnMenu;
	}
	
	public JMenu createCustomizeMenu() {
		JMenu returnMenu = new JMenu("Customize");
		colors.addActionListener(e -> {
			new ColorWindow(this.mainWindow);
		});
		returnMenu.add(colors);
		//text.addActionListener();
		returnMenu.add(text);
		return returnMenu;
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar returnMenuBar = new JMenuBar();
		returnMenuBar.add(this.createFileMenu());
		returnMenuBar.add(this.createCustomizeMenu());
		return returnMenuBar;
		
	}
	
}

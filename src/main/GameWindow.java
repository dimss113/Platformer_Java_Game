package main;

import javax.swing.JFrame;

// JFrame
// the backbone for our window
// the "frame" of painting
// part of a larger collections of GUI components

public class GameWindow{
	private JFrame jFrame;
	// Constructor
	public GameWindow(GamePanel gamePanel) {
		
		// Create jframe object 
		jFrame  = new JFrame();
		
		// few calls to make window appear
		/// set size of window game
		jFrame.setSize(400, 400);
		/// make call for terminating window by exit_close_button
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		/// adding gamepanel to the display window
		jFrame.add(gamePanel);
		/// spawn the window in the center of screen
		jFrame.setLocationRelativeTo(null);
		/// set visible of window or display the window
		jFrame.setVisible(true);
		
	}
}

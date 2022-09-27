package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	// Constructor
	public GamePanel() {
		
	}

	// JPanel cannot draw so we need graphic object for that
	// jFrame + jPanel allows for window
	// graphics allows us to draw to the panel
	// graphics is like a paintbrush
	public void paintComponent(Graphics g) {
		
		// calling super class which is JPanel's own component method
		// we need this call so that JPanel can clean the surface for us
		// to paint our new picture
		super.paintComponent(g);
		
		// simple square
		// allbits: x position; abort: y position; width: width of rect; height: height of the rect
		g.drawRect(100, 100, 200, 50);
		g.fillRect(100, 100, 200, 50);
		g.setColor(Color.red);
		
	}
}

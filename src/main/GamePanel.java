package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	
	// parameter used for move rectangle using drag mouse
	private int xDelta = 100;
	private int yDelta = 100;
	
	// Constructor
	public GamePanel() {
		mouseInputs = new MouseInputs(this); 
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	
	// increase and decrease x and y delta
	public void ChangeXDelta(int value) {
		this.xDelta += value;
		
		// re paint the paint component with new value
		repaint();
	}
	
	public void ChangeYDelta(int value) {
		this.yDelta += value;
		
		// re paint the paint component with new value
		repaint();
	}
	
	// Draw rectangle at this position given by mouse
	public void setRectPosition(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
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
		
		/// make lines of rectangle
//		g.drawRect(100, 100, 200, 50);
		/// fill the rectangle
		g.fillRect(xDelta, yDelta, 200, 50);
//		g.setColor(Color.red);
		
	}
}

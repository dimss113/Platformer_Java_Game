package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	
	// parameter used for move rectangle using drag mouse
	private float xDelta = 100;
	private float yDelta = 100;
	
	private float xDir = 1f;
	private float yDir = 1f;
	
	private int frames = 0;
	private long lastCheck = 0;
	
	private Color color = new Color(150, 20, 90);
	
	private Random random;
	
	// Constructor
	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this); 
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	
	// increase and decrease x and y delta
	public void ChangeXDelta(int value) {
		this.xDelta += value;
		
		// re paint the paint component with new value (calling paintComponent)
//		repaint();
	}
	
	public void ChangeYDelta(int value) {
		this.yDelta += value;
		
		// re paint the paint component with new value (calling paintComponent)
//		repaint();
	}
	
	// Draw rectangle at this position given by mouse
	public void setRectPosition(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
//		repaint();
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
		
		updateRectangle();
		g.setColor(color);
		
		// simple square
		// allbits: x position; abort: y position; width: width of rect; height: height of the rect
		
		/// make lines of rectangle
//		g.drawRect(100, 100, 200, 50);
		/// fill the rectangle
		g.fillRect((int)xDelta, (int)yDelta, 200, 50);
//		g.setColor(Color.red);
		
		frames++;
		// return time in milisecond
		// if one second have passed since the last fps check,
		// we do a new fps check save the newFPS check as the lastFPS check
		// and repeat
		if(System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
		
//		repaint();
	}
	
	// method to update rect position and color
	private void updateRectangle() {
		xDelta+=xDir;
		if(xDelta > 200 || xDelta < 0) {
			xDir *=-1;
			color = getRandColor();
		}
		yDelta += yDir;
		if(yDelta > 300 || yDelta < 0) {
			yDir *=-1;
			color = getRandColor();
		}
	}
	
	// return random rgb value used for coloring rect
	private Color getRandColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		return new Color(r,g,b);
	}
}

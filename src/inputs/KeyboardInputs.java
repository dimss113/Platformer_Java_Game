package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

// different between extends end implements
// we extend a class but you implements a interface
// we can extend one class but can implement more than one interface

public class KeyboardInputs implements KeyListener{
	
	private GamePanel gamePanel;
	
	// constructor
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("key type test");
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("A key is pressed");
		
		// specify what keyboard key we pressed
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
//			System.out.println("its W");
			gamePanel.ChangeYDelta(-5);
			break;
		case KeyEvent.VK_A:
//			System.out.println("its A");
			gamePanel.ChangeXDelta(-5);
			break;
		case KeyEvent.VK_S:
//			System.out.println("its S");
			gamePanel.ChangeYDelta(5);
			break;
		case KeyEvent.VK_D:
//			System.out.println("its D");
			gamePanel.ChangeXDelta(5);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("key release test");
	}
}

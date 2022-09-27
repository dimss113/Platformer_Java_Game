package main;

public class GameClass {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	// Constructor GameClass
	public GameClass() {
//		System.out.println("testing GameClass constructor");
		
		// create gamewindow object
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);		
		
	}
}

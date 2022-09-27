package main;

public class GameClass implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	private Thread gameThread;
	
	private final int FPS_SET = 120;
	
	// Constructor GameClass
	public GameClass() {
//		System.out.println("testing GameClass constructor");
		
		// create gamewindow object
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);	
		// needed for keylistener 
		gamePanel.requestFocus();
		startGameLoop();
		
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		// create variable that can store duration each frame should at last
		double timePerFrame = 1000000000.0/FPS_SET;
		
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		// creating game loop 
		while(true) {
			now = System.nanoTime();
			if(System.nanoTime() - lastFrame >= timePerFrame) {
				
				// repaint the game panel
				gamePanel.repaint();
				lastFrame = now;
			}
		}
		
	}
}

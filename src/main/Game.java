package main;

public class Game implements Runnable{
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private long now;

	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;   // 1 sec is a billion nano sec

		long lastframe = System.nanoTime();
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		
		while(true) {
			now = System.nanoTime();
			if(now - lastframe >= timePerFrame) {
				// repaint
				gamePanel.repaint();
				lastframe = now;
				frames++;
			}
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS : "+ frames);
				frames = 0;
			}
			
		}
	}

}

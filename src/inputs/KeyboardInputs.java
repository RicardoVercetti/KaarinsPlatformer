package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

// you extend a class, but you implement an interface

public class KeyboardInputs implements KeyListener {
	
	private GamePanel gamePanel;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("A key is pressed!");
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
//			System.out.println("Pressed w");
			gamePanel.changeYDelta(-5);
			break;
		case KeyEvent.VK_A:
			gamePanel.changeXDelta(-5);
//			System.out.println("Pressed a");
			break;
		case KeyEvent.VK_S:
			gamePanel.changeYDelta(5);
//			System.out.println("Pressed s");
			break;
		case KeyEvent.VK_D:
			gamePanel.changeXDelta(5);
//			System.out.println("Pressed d");
			break;
		}
		
	}

}

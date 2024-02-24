package main;

import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	private MouseInputs mouseInputs;
	private int xDelta = 0, yDelta = 0;
	GamePanel() {
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	
	public void setXYDelta(int xValue, int yValue) {
		this.xDelta = xValue;
		this.yDelta = yValue;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(xDelta, yDelta, 200, 50);  // x-pos, y-pos, width, height
	}
}
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	private MouseInputs mouseInputs;
	private int xDelta = 0, yDelta = 0;
	private int xDir = 2, yDir = 2;
//	private int frames = 0;
//	private long lastCheck = 0;
	private Color color = new Color(150, 20, 90);
	private Random random;
	private ArrayList<MyRect> rects = new ArrayList<>();
	
	GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	public void setXYDelta(int xValue, int yValue) {
		this.xDelta = xValue;
		this.yDelta = yValue;
	}
	
	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// temp rects
		for(MyRect rect : rects) {
			rect.updateRect();
			rect.draw(g);
		}
		

		g.setColor(color);
		g.fillRect(xDelta, yDelta, 200, 50);  // x-pos, y-pos, width, height
		updateRectangle();
		
		
//		repaint();
	}

	private void updateRectangle() {
		xDelta+= xDir;
		if(xDelta >= 400 || xDelta <= 0) {
			xDir *= -1;
			color = getRandomColor();
		}
		yDelta+= yDir;
		if(yDelta >= 400 || yDelta <= 0) {
			yDir *= -1;
			color = getRandomColor();
		}
		
	}

	private Color getRandomColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		return new Color(r, g, b);
	}
	
	class MyRect {
		int x, y, w, h;
		int xDir = 2, yDir = 2;
		Color color;
		
		public MyRect(int x, int y) {
			this.x = x;
			this.y = y;
			w = random.nextInt(50);
			h = w;
			color = newColor();
		}
		
		public void updateRect() {
//			this.x = this.xDir;
//			this.y = this.yDir;
			
			if((x+w)>400 || x<0) {
				xDir *= -1;
				color = newColor();
			}
			if((y+h)>400 || y<0) {
				yDir *= -1;
				color = newColor();
			}
			this.x += this.xDir;
			this.y += this.yDir;
		}
		
		private Color newColor() {
			int r, g, b;
			r = random.nextInt(255);
			g = random.nextInt(255);
			b = random.nextInt(255);
			return new Color(r, g, b);
		}
		
		public void draw(Graphics g) {
			g.setColor(color);
			g.fillRect(x, y, w, h);
		}
		
		
	}
}

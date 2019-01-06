package pkg;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	int x;
	int y;
	int width;
	int height;
	int vx;
	int vy;
	Rectangle ballBox;
	public Ball(int x, int y, int width, int height, int vx, int vy) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		
	}
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getVx() {
		return vx;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	public int getVy() {
		return vy;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}

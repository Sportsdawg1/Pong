package pkg;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	int width;
	int height;
	int x;
	int y;
	int speed;
	
	int vx;
	int vy;
	boolean up, down, left, right;
	Rectangle collisionBox;
	public Player(int x, int y, int width, int height, int speed, int vx, int vy) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.vx = vx;
		this.vy = vy;
		collisionBox  = new Rectangle(x, y, width, height);
	}
	void updateVelocity() {
		if (up) {
			vy = speed*(-1);
		}
		if (down) {
			vy = speed;
		}
		if(left) {
			vx = speed*(-1);
		}
		if (right) {
			vx = speed;
		}
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
}

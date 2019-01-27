package pkg;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	double width;
	double height;
	double x;
	double y;
	double speed;
	int points;
	double vx;
	double vy;
	boolean up, down, left, right;
	Rectangle collisionBox;
	public Player(double x, double y, double width, double height, double speed, int points, double vx, double vy) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.points = points;
		this.vx = vx;
		this.vy = vy;
		collisionBox  = new Rectangle((int) Math.round(x), (int) Math.round(y), (int) Math.round(width), (int) Math.round(height));
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
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
		g.fillRoundRect((int) Math.round(x), (int) Math.round(y), (int) Math.round(width), (int) Math.round(height), 5, 2);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getVx() {
		return vx;
	}
	public void setVx(double vx) {
		this.vx = vx;
	}
	public double getVy() {
		return vy;
	}
	public void setVy(double vy) {
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

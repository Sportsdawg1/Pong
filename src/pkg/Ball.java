package pkg;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	double x;
	double y;
	double width;
	double height;
	double vx;
	double vy;
	Rectangle ballBox;
	public Ball(double x, double y, double width, double height, double vx, double vy) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		ballBox = new Rectangle((int) Math.round(x),(int) Math.round(y),(int) Math.round(width),(int) Math.round(height));
	}
	void draw(Graphics g) {
		g.fillOval((int) Math.round(x), (int) Math.round(y), (int) Math.round(width), (int) Math.round(height));
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
	
	
}

package pkg;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	Player p1 = new Player(10,200,5,50,5,0,0);
	Player p2 = new Player(0,200,5,50,5,0,0);
	Ball ball = new Ball(200,200,5,5,5,5);
	Timer t = new Timer(1000/60, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			p2.collisionBox.y = p2.y;
			p2.collisionBox.x = p2.x;
			p1.collisionBox.y = p2.y;
			p1.collisionBox.x = p1.x;
			ball.ballBox.y = ball.y;
			repaint();
			if (p1.up || p1.down) {
				while (p1.vy <= p1.speed && p1.vy >= (p1.speed*-1)) {
					p1.vy*=2;
				}
			}
			if (p1.left || p1.right) {
				while (p1.vx <= p1.speed && p1.vx >= (p1.speed*-1)) {
					p1.vx*=2;
				}
			}
			if (p2.up || p2.down) {
				while (p2.vy <= p2.speed && p2.vy >= (p2.speed*-1)) {
					p2.vy*=2;
				}
			}
			if (p2.left || p2.right) {
				while (p2.vx <= p2.speed && p2.vx >= (p2.speed*-1)) {
					p2.vx*=2;
				}
			}
			if (ball.ballBox.intersects(p1.collisionBox)) {
				if (p1.vy>0 || p1.vy<0) {
					ball.vy+=(p1.vy/2);
				}
				if (p1.vx>0 || p1.vx<0) {
					ball.vx+=(p1.vy/2);
				}
				ball.vx = ball.vx*-1;
			}
			if (ball.ballBox.intersects(p2.collisionBox)) {
				if (p2.vy>0 || p2.vy<0) {
					ball.vy+=(p2.vy/2);
				}
				if (p2.vx>0 || p2.vx<0) {
					ball.vx+=(p2.vy/2);
				}
				ball.vx = ball.vx*-1;
			}
		}});
	
	
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.fillRect(0, 0, PongRunner.width, PongRunner.height);
		p1.draw(g);
		p2.draw(g);
		ball.draw(g);
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char charPressed = e.getKeyChar();
		int keyInt = e.getKeyCode();
		if (keyInt == KeyEvent.VK_UP) {
			p2.up = true;
		}
		if (keyInt == KeyEvent.VK_DOWN) {
			p2.down = true;
		}
		if (keyInt == KeyEvent.VK_LEFT) {
			p2.left = true;
		}
		if (keyInt == KeyEvent.VK_RIGHT) {
			p2.right = true;
		}
		if (charPressed == 'w') {
			p1.up = true;
		}
		if (charPressed == 'a') {
			p1.left = true;
		}
		if (charPressed == 's') {
			p1.down = true;
		}
		if (charPressed == 'd') {
			p1.right = true;
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyInt = e.getKeyCode();
		char charReleased = e.getKeyChar();
		if (keyInt == KeyEvent.VK_UP) {
			p2.up = false;
		}
		if (keyInt == KeyEvent.VK_DOWN) {
			p2.down = false;
		}
		if (keyInt == KeyEvent.VK_LEFT) {
			p2.left = false;
		}
		if (keyInt == KeyEvent.VK_RIGHT) {
			p2.right = false;
		}
		if (charReleased == 'w') {
			p1.up = false;
		}
		if (charReleased == 's') {
			p1.down = false;
		}
		if (charReleased == 'a') {
			p1.left = false;
		}
		if (charReleased == 'd') {
			p1.right = false;
		}
	}
}

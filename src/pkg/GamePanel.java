package pkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	Player p1 = new Player(10,200,5,50,5,0,0);
	Player p2 = new Player(590,200,5,50,5,0,0);
	Ball ball = new Ball(200,200,5,5,5,5);

	GamePanel(){ 
		t.start();
	}
	
	
	
	Timer t = new Timer(1000/60, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			updateCollisionBox(p1);
			updateCollisionBox(p2);
			updateCollisionBox(ball);

			movePlayer(p1);
			movePlayer(p2);
			curveVelocity(p1);
			curveVelocity(p2);
			collisions(p1);
			collisions(p2);
//			if (p1.up || p1.down) {
//				while (p1.vy <= p1.speed && p1.vy >= (p1.speed*-1)) {
//					p1.vy*=2;
//				}
//			}
//			if (p1.left || p1.right) {
//				while (p1.vx <= p1.speed && p1.vx >= (p1.speed*-1)) {
//					p1.vx*=2;
//				}
//			}
//			if (p2.up || p2.down) {
//				while (p2.vy <= p2.speed && p2.vy >= (p2.speed*-1)) {
//					p2.vy*=2;
//				}
//			}
//			if (p2.left || p2.right) {
//				while (p2.vx <= p2.speed && p2.vx >= (p2.speed*-1)) {
//					p2.vx*=2;
//				}
//			}
//			if (ball.ballBox.intersects(p1.collisionBox)) {
//				if (p1.vy>0 || p1.vy<0) {
//					ball.vy+=(p1.vy/2);
//				}
//				if (p1.vx>0 || p1.vx<0) {
//					ball.vx+=(p1.vy/2);
//				}
//				ball.vx = ball.vx*-1;
//			}
//			if (ball.ballBox.intersects(p2.collisionBox)) {
//				if (p2.vy>0 || p2.vy<0) {
//					ball.vy+=(p2.vy/2);
//				}
//				if (p2.vx>0 || p2.vx<0) {
//					ball.vx+=(p2.vy/2);
//				}
//				ball.vx = ball.vx*-1;
//			}
			if (ball.y<0 || ball.y>600) {
				ball.vy *= -1;
			}
			if (ball.x<0 || ball.x>600) {
				ball.vx *= -1;
			}
			
			p1.x+=p1.vx;
			p1.y+=p1.vy;
			ball.x+=ball.vx;
			ball.y+=ball.vy;
			repaint();
		}

		private void movePlayer(Player player) {
			if (player.up) {
				player.vy-=player.speed;
			}
			if (player.down) {
				player.vy+=player.speed;
			}
			if (player.left) {
				player.vx-=player.speed;
			}
			if (player.right) {
				player.vx+=player.speed;
			}			
		}});
	
	void updateCollisionBox(Player player) {
		player.collisionBox.y = player.y;
		player.collisionBox.x = player.x;
	}
	void updateCollisionBox(Ball ball) {
		ball.ballBox.y = ball.y;
		ball.ballBox.x = ball.x;
	}
	void curveVelocity(Player player) {
		if (player.up || player.down) {
			while (player.vy <= player.speed && player.vy >= (player.speed*-1)) {
				player.vy*=2;
			}
		}
		if (player.left || player.right) {
			while (player.vx <= player.speed && player.vx >= (player.speed*-1)) {
				player.vx*=2;
			}
		}
		player.vx/=2;
		player.vy/=2;
		
	}
	void collisions (Player player) {
		if (ball.ballBox.intersects(player.collisionBox)) {
			if (player.vy>0 || player.vy<0) {
				ball.vy+=(player.vy/2);
			}
			if (player.vx>0 || player.vx<0) {
				ball.vx+=(player.vy/2);
			}
			ball.vx = ball.vx*-1;
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PongRunner.width, PongRunner.height);
		g.setColor(Color.WHITE);
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

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
	Player p1 = new Player(10,200,15,70,0.4,0,0);
	Player p2 = new Player(590,200,15,70,0.4,0,0);
	Ball ball = new Ball(200,200,20,20,2,2);

	GamePanel(){ 
		t.start();
	}
	
	
	
	Timer t = new Timer(1000/180, new ActionListener() {
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
			System.out.println("VX = " + ball.vx);
			System.out.println("VY = " + ball.vy);
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
			if (p1.x<0) {
				p1.x = 5;
				p1.vx = 0;
			}
			if (p1.x>600) {
				p1.x = 590;
				p1.vx = 0;
			}
			if (p1.y<0) {
				p1.y = 5;
				p1.vy = 0;
			}
			if (p1.y>600) {
				p1.y = 590;
				p1.vy = 0;
			}
			if (p2.x<0) {
				p2.x = 5;
				p2.vx = 0;
			}
			if (p2.x>600) {
				p2.x = 590;
				p2.vx = 0;
			}
			if (p2.y<0) {
				p2.y = 5;
				p2.vy = 0;
			}
			if (p2.y>600) {
				p2.y = 590;
				p2.vy = 0;
			}
			
			p1.x+=p1.vx;
			p1.y+=p1.vy;
			p2.x+=p2.vx;
			p2.y+=p2.vy;
			if (ball.vx<=6) {
				
			}
			if (-3<=ball.vx && ball.vx<=3) {
				ball.x+=ball.vx;
			} else if (ball.vx>3) {
				ball.vx = 3;
			} else if (ball.vx<-3) {
				ball.vx = -3;
			}
			if (-3<=ball.vy && ball.vy<=3) {
				ball.y+=ball.vy;
			} else if (ball.vy>3) {
				ball.vy = 3;
			} else if (ball.vy<-3) {
				ball.vy = -3;
			}
			
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
		player.collisionBox.y = (int) Math.round(player.y);
		player.collisionBox.x = (int) Math.round(player.x);
	}
	void updateCollisionBox(Ball ball) {
		ball.ballBox.y = (int) Math.round(ball.y);
		ball.ballBox.x = (int) Math.round(ball.x);
	}
	void curveVelocity(Player player) {
//		if (player.up || player.down) {
//			while (player.vy <= player.speed && player.vy >= (player.speed*-1)) {
//				player.vy*=2;
//			}
//		}
//		if (player.left || player.right) {
//			while (player.vx <= player.speed && player.vx >= (player.speed*-1)) {
//				player.vx*=2;
//			}
//		}
		player.vx/=1.1;
		player.vy/=1.1;
		
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
		g.fillRect(0, 0, (int) Math.round(PongRunner.width), (int) Math.round(PongRunner.height));
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
			System.out.println("2up");
			p2.up = true;
		}
		if (keyInt == KeyEvent.VK_DOWN) {
			System.out.println("2down");
			p2.down = true;
		}
		if (keyInt == KeyEvent.VK_LEFT) {
			System.out.println("2left");
			p2.left = true;
		}
		if (keyInt == KeyEvent.VK_RIGHT) {
			System.out.println("2right");
			p2.right = true;
		}
		if (keyInt == KeyEvent.VK_W) {
			System.out.println("1up");
			p1.up = true;
		}
		if (keyInt == KeyEvent.VK_S) {
			System.out.println("1down");
			p1.down = true;
		}
		if (keyInt == KeyEvent.VK_A) {
			System.out.println("1left");
			p1.left = true;
		}
		if (keyInt == KeyEvent.VK_D) {
			System.out.println("1right");
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

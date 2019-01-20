package pkg;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongRunner {
	public static final double width = 600;
	public static final double height = 600;
	JFrame frame = new JFrame("Pong");
	GamePanel panel = new GamePanel();
	
	public static void main(String[] args) {
		PongRunner r = new PongRunner();
		r.setup();
	}
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize((int) Math.round(width), (int) Math.round(height));
		frame.add(panel);
		frame.addKeyListener(panel);
	}
}

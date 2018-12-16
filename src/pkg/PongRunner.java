package pkg;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongRunner {
	public static final int width = 600;
	public static final int height = 600;
	JFrame frame = new JFrame("Pong");
	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		
	}
	void setup() {
		frame.setSize(width, height);
		frame.add(panel);
	}
}

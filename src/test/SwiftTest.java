package test;
import javax.swing.*;

public class SwiftTest {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		JButton b = new JButton("button");
		b.setBounds(100, 100, 100, 100);
		f.add(b);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setSize(400, 300);
		setLayout(null);
		setVisible(true);
	}
}
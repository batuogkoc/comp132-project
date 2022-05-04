package test;
import backend.*;
import frontend.ContentPanel;
import frontend.ContentsPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class SwingTest {
	public static void main(String[] args) {
		User batu = new User("creepyjokester33", "1234", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com");
		batu.addContent(new Content(batu, "First content", "Hello world!", "cat.png"));
		batu.addContent(new Content(batu, "Second content", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "cat.png"));
		
		MyFrame f = new MyFrame();
		
		f.add(new ContentsPanel(batu.getContents()));
		
		
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setSize(400, 300);
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class HomePage extends JFrame{
	User user;
	
	public HomePage(User user) {
		this.user = user;		
		
		JPanel A = new JPanel();
		A.setSize(200,300);
		A.setBackground(Color.red);
		JPanel B = new JPanel();
		B.setSize(200,300);
		B.setBackground(Color.blue);
		
		JPanel mainMenu = new JPanel();
		mainMenu.setSize(400,600);
		mainMenu.setLayout(new FlowLayout());		
		add(mainMenu);
		
		JButton aButton = new JButton("A");
		add(aButton);
		aButton.addActionListener( ae->{
			mainMenu.removeAll();
			mainMenu.add(A);
			mainMenu.repaint();
		});
		
		JButton bButton = new JButton("B");
		add(bButton);
		bButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.removeAll();
				mainMenu.add(B);
				mainMenu.repaint();
			}
		});
		
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class ProfilePage extends JFrame {
	User user;
	public ProfilePage(User user) {
		this.user = user;
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}




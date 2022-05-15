package test;
import backend.*;
import frontend.*;
import frontend.ContentPanel;
import frontend.ContentsPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class SwingTest {
	private static JPanel mainPanel = new JPanel();
	public static void main(String[] args) {
		User batu = new User("creepyjokester33", "1234", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com");
		batu.addContent(new Content(batu, "First content", "Hello world!", "cat.png"));
		batu.addContent(new Content(batu, "Second content", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "cat.png"));
		
		MyFrame f = new MyFrame();
		ContentsPanel cp = new ContentsPanel(batu.getContents());
		JScrollPane sp = new JScrollPane(cp);
		JPanel jp = new JPanel();
		jp.add(sp);
		jp.setLayout(new GridLayout(1,1));
		f.add(jp);

//		f.add(mainPanel);

//		Login loginView = new Login();
//		f.add(loginView);
//		loginView.getLoginButton().addActionListener(ae->{
//			if(User.authenticateUser(loginView.getEnteredNickname(), loginView.getEnteredPassword()) != null) {
//				f.removeAll();
//				f.add(new JPanel());
//			}
//		});
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setSize(400, 300);
		setLayout(new GridLayout(1,1));
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




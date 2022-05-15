package mvc;

import java.awt.GridLayout;

import javax.swing.*;

import frontend.ContentsPanel;
import frontend.MainPage;

public class View {
	private static JFrame f;
	
	static {
		f = new JFrame();
		f.setSize(400, 300);
		f.setLayout(new GridLayout(1,1));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void setFrameContents(JComponent component) {
		f.getContentPane().removeAll();
		f.add(component);
		f.validate();
		f.repaint();
	}
	
	public static void displayView(String viewCode) {
		switch (viewCode) {
		case "HOME PAGE":
			setFrameContents(new MainPage(new ContentsPanel(Model.getCurrentUser().getContents())));
			break;
		case "ADD CONTENT MENU":
			setFrameContents(new MainPage(new JPanel()));
			
		default:
			System.out.println("View: Unknown view code: " +viewCode);
			break;
		}
	}
}

package mvc;

import java.awt.GridLayout;

import javax.swing.*;

import frontend.*;


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
			setFrameContents(new MainPage(new CreateContent()));
			break;
		case "USER PROFILE":
			setFrameContents(new MainPage(new ProfilePage(Model.getCurrentUser(), Model.getUserOfInterest())));
			break;
		case "NEW ACCOUNT":
			setFrameContents(new NewUser());
			break;
			
		case "GROUP":
			setFrameContents(new MainPage(new GroupPage(Model.getGroupOfInterest(), Model.getCurrentUser())));
			break;
			
		case "GROUPS PAGE":
			setFrameContents(new MainPage(new GroupsPanel(Model.getCurrentUser().getJoinedGroups())));
			break;
			
		case "CONTENT EDIT":
			setFrameContents(new MainPage(new EditContent(Model.getContentOfInterest())));
			break;
		
		default:
			System.out.println("View: Unknown view code: " +viewCode);
			break;
		}
	}
	
	public static JFrame getFrame() {
		return f;
	}
}

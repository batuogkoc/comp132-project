package mvc;

import java.awt.GridLayout;

import javax.swing.*;

import frontend.*;

/**
 * allows for pages to be displayed. Takes in data from the model and constructs pages.
 * @author batu
 *
 */
public class View {
	private static JFrame f; //currently active frame
	
	/**
	 * set the properties of the static field f
	 */
	static {
		f = new JFrame();
		f.setSize(800, 600);
		f.setLayout(new GridLayout(1,1));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * remove everything in the frame and add the provided JComponent instead. repaint after the fact.
	 * @param component
	 */
	public static void setFrameContents(JComponent component) {
		f.getContentPane().removeAll();
		f.add(component);
		f.validate();
		f.repaint();
	}
	
	/**
	 * displays different pages dictated by the viewCode parameter.
	 * @param viewCode
	 */
	public static void displayView(String viewCode) {
		switch (viewCode) {
		case "HOME PAGE":
			setFrameContents(new MainPage(new HomePage(Model.getCurrentUser()))); //Home page the user sees. has contents, and a search bar
			break;
		case "ADD CONTENT MENU":
			setFrameContents(new MainPage(new CreateContent(Model.getCurrentUser()))); //new content creation menu
			break;
		case "USER PROFILE":
			//viewing of a user's profile. Can be yours, an unfollowed user and a user you follow
			setFrameContents(new MainPage(new ProfilePage(Model.getCurrentUser(), Model.getUserOfInterest()))); 
			break;
		case "NEW ACCOUNT":
			setFrameContents(new NewUser()); //new user generation page
			break;
			
		case "GROUP":
			 //viewing a group of interest set by the event thrower. It can be a group that you are a member of, creator of, or a group you aren't a part of
			setFrameContents(new MainPage(new GroupPage(Model.getGroupOfInterest(), Model.getCurrentUser())));
			break;
			
		case "CONTENT EDIT":
			setFrameContents(new MainPage(new EditContent(Model.getContentOfInterest()))); //editing a content set by the event thrower. This window is called when a content panel has been clicked on by its creator.
			break;
		case "CREATE GROUP":
			setFrameContents(new MainPage(new NewGroup())); //new group creation menu
			break;
		default:
			System.err.println("View: Unknown view code: " +viewCode); //print the viewCode if it is unknown
			break;
		}
	}
	
	public static JFrame getFrame() {
		return f;
	}
}

package frontend;

import backend.*;
import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * panel that shows a list of users. Useful when reccommending, searcing for users.
 * @author batu
 *
 */
public class UsersPanel extends JPanel{
	
	/**
	 * generate the UsersPanel object from the collection of users provided
	 * @param users users to be displayed
	 */
	public UsersPanel(Collection<? extends User> users) {
		ArrayList<UserPanel> userPanels = new ArrayList<UserPanel>();
		for (User user : users) {
			userPanels.add(new UserPanel(user));//since VerticalScrollPanel takes in JComponents, we create an arraylist of UserPanel objects from the users provided
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(userPanels)); //display the VerticalScrollPanel containing the UserPanel objects
	}
	
}

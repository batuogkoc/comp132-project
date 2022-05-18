package frontend;

import backend.*;
import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class UsersPanel extends JPanel{

	public UsersPanel(Collection<? extends User> users) {
		ArrayList<UserPanel> userPanels = new ArrayList<UserPanel>();
		for (User user : users) {
			userPanels.add(new UserPanel(user));
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(userPanels));
	}
	
}

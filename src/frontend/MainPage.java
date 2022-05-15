package frontend;

import java.awt.*;
import java.awt.*;

import javax.swing.*;
import backend.*;
import frontend.*;
import mvc.*;

public class MainPage extends JPanel{

	public MainPage(JComponent currentPage) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		
		ControllerEventButton homePageButton = new ControllerEventButton("Home Page", "HOME PAGE");
		buttons.add(homePageButton);
		
		ControllerEventButton addContentButton = new ControllerEventButton("Add Content", "ADD CONTENT MENU");
		buttons.add(addContentButton);
		
		ControllerEventButton profilePageButton = new ControllerEventButton("Profile Page", "PROFILE PAGE");
		buttons.add(profilePageButton);
		
		ControllerEventButton groupsPageButton = new ControllerEventButton("Groups", "GROUPS PAGE");
		buttons.add(groupsPageButton);
		
		add(currentPage);
		add(buttons);
		

		

	}
	
}

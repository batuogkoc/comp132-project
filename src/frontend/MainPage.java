package frontend;

import java.awt.*;
import java.awt.*;

import javax.swing.*;
import backend.*;
import frontend.*;
import mvc.*;

public class MainPage extends JPanel{

	public MainPage(JComponent currentPage) {
		setLayout(new BorderLayout());

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton homePageButton = new ControllerEventButton("Home Page", "HOME PAGE");
		buttons.add(homePageButton);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton addContentButton = new ControllerEventButton("Add Content", "ADD CONTENT MENU");
		buttons.add(addContentButton);
		
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton profilePageButton = new ControllerEventButton("Profile Page", "PROFILE PAGE");
		buttons.add(profilePageButton);
		
//		c.gridx = 3;
//		c.gridy = 0;
//		c.weightx = 1.0;
//		ControllerEventButton groupsPageButton = new ControllerEventButton("Groups", "GROUPS PAGE");
//		buttons.add(groupsPageButton);
		
		add(currentPage, BorderLayout.CENTER);
		add(buttons, BorderLayout.PAGE_END);
		

		

	}
	
}

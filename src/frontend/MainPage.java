package frontend;

import java.awt.*;
import java.awt.*;

import javax.swing.*;
import backend.*;
import frontend.*;
import mvc.*;
/**
 * main page is the page that gets shown when the user entes the application. The page consists of menu buttons and
 * a dynamic panel whose contents change according to shich button gets pressed. All pages in the app except the login and new user pages
 * get displayed inside a MainPage object
 * @author batu
 *
 */
public class MainPage extends JPanel{
	/**
	 * generate the mainpage and add the currentPage JComponent into the dynamic panel
	 * @param currentPage JComponent that will be displayed inside the MainPage panel
	 */
	public MainPage(JComponent currentPage) {
		setLayout(new BorderLayout());

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton homePageButton = new ControllerEventButton("Home Page", "HOME PAGE"); //takes the user to the homepage
		buttons.add(homePageButton);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton addContentButton = new ControllerEventButton("Add Content", "ADD CONTENT MENU");//Takes usr to add content menu
		buttons.add(addContentButton);
		
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1.0;
		ControllerEventButton profilePageButton = new ControllerEventButton("Profile Page", "PROFILE PAGE");//Takes user to profile page
		buttons.add(profilePageButton);
		
		
		add(currentPage, BorderLayout.CENTER);
		add(buttons, BorderLayout.PAGE_END);		
	}
	
}

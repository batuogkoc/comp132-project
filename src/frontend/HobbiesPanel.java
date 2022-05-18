package frontend;

import java.util.*;
import javax.swing.*;

/**
 * panel that displays hobbies. Used when listing the hobbies of a group or a user.
 * @author batu
 *
 */
public class HobbiesPanel extends JPanel{
	/**
	 * take a collection of hobies and turn it into a panel listing the hobies
	 * @param hobbies hobbies to be displayed
	 */
	public HobbiesPanel(Collection<? extends String> hobbies) {
		super();
		ArrayList<JLabel> hobbyLabels = new ArrayList<JLabel>();
		for (String hobby : hobbies) {
			hobbyLabels.add(new JLabel(hobby)); //every hobby is displayed as a JLabel. Since VerticalScrollPane takes in jcomponents, create an arraylist of JLabels containing the hobbies
		}
		add(new VerticalScrollPanel(hobbyLabels)); //add the VerticalScrollPanel to the current object
	}
	
}

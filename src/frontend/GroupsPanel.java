package frontend;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import backend.*;
/**
 * panel that displays info about multiple groups. Used when reccommending, searching for or dsplaying the joined groups of a user.
 * @author batu
 *
 */
public class GroupsPanel extends JPanel{
	/**
	 * take a collection of groups and turn it into a panel listing the groups' info
	 * @param groups groups to display
	 */
	public GroupsPanel(Collection<? extends Group> groups) {
		ArrayList<GroupPanel> groupPanels = new ArrayList<>();
		for (Group group : groups) {
			groupPanels.add(new GroupPanel(group));//since VerticalScrollPane takes in jcomponents, create an arraylist of grouppanels
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(groupPanels)); //add the VerticalScrollPane full of groupPanels to this object
	}
}

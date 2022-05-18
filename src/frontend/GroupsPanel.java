package frontend;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import backend.*;

public class GroupsPanel extends JPanel{
	public GroupsPanel(Collection<? extends Group> groups) {
		ArrayList<GroupPanel> groupPanels = new ArrayList<>();
		for (Group group : groups) {
			groupPanels.add(new GroupPanel(group));
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(groupPanels));
	}
}

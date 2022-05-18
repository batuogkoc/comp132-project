package frontend;
import backend.*;

import java.awt.*;

import java.util.*;

import javax.swing.*;

/**
 * panel that displays multiple content panels. Useful for home page and group pages
 * @author batu
 *
 */
public class ContentsPanel extends JPanel{
	private VerticalScrollPanel scrollPanel; // contents are added in a vertical scroll panel
	public ContentsPanel(Collection<? extends Content> contents) {
		ArrayList<ContentPanel> contentPanels = new ArrayList<ContentPanel>();
		//create a list of content panel objects. these will later be used to initialise the vertical scroll panel object
		for (Content content : contents) {
			contentPanels.add(new ContentPanel(content));
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(contentPanels)); // add the vertical scroll panel to the contents panel
	}
}
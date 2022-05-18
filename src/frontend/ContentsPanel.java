package frontend;
import backend.*;

import java.awt.*;

import java.util.*;

import javax.swing.*;

public class ContentsPanel extends JPanel{
	private VerticalScrollPanel scrollPanel;
	public ContentsPanel(Collection<? extends Content> contents) {
		ArrayList<ContentPanel> contentPanels = new ArrayList<ContentPanel>();
		for (Content content : contents) {
			contentPanels.add(new ContentPanel(content));
		}
		setLayout(new GridLayout(1,1));
		add(new VerticalScrollPanel(contentPanels));
	}
}
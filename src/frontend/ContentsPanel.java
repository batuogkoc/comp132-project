package frontend;
import backend.*;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;

import javax.swing.JPanel;

public class ContentsPanel extends JPanel{
	public ContentsPanel(Collection<? extends Content> contents) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0;
		for (Content content : contents) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			ContentPanel contentPanel = new ContentPanel(content);
			add(contentPanel, gbc);
			i++;
		}
		setBackground(Color.red);
	}
}

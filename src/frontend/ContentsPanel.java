package frontend;
import backend.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Collection;

import javax.swing.*;

public class ContentsPanel extends JPanel{
	public ContentsPanel(Collection<? extends Content> contents) {
		setLayout(new GridLayout(1,1));
		add(new JScrollPane(new __ContentsPanel(contents)));
	}
}


class __ContentsPanel extends JPanel implements Scrollable{
	public __ContentsPanel(Collection<? extends Content> contents) {
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
//		https://stackoverflow.com/questions/2716274/jscrollpane-needs-to-shrink-its-width
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return ((orientation == SwingConstants.VERTICAL) ? visibleRect.height : visibleRect.width) - 10;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		return true;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		return false;
	}
}
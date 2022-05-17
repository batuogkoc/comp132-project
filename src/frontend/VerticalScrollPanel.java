package frontend;

import java.awt.*;

import java.util.Collection;

import javax.swing.*;

public class VerticalScrollPanel extends JPanel{
	private __VerticalScrollPanel innerPanel;
	public VerticalScrollPanel(Collection<? extends JComponent> components) {
		setLayout(new GridLayout(1,1));
		innerPanel = new __VerticalScrollPanel(components);
		add(new JScrollPane(innerPanel));
	}
	
	public Container getContentPane() {
		return innerPanel;
	}
}

class __VerticalScrollPanel extends JPanel implements Scrollable{
	public __VerticalScrollPanel(Collection<? extends JComponent> components) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0;
		for (JComponent component : components) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			add(component, gbc);
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
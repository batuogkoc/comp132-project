package frontend;

import java.awt.*;

import java.util.Collection;

import javax.swing.*;

/**
 * a panel that allows for only vertical scrolling while fitting everything inside of it horizontally. Useful for displaying a list of users, groups, contents
 * @author batu
 *
 */

/**
 * wrapper class extending JPanel for __VerticalScrollPane that includes the JScrollPane needed for scrolling
 * @author batu
 *
 */
public class VerticalScrollPanel extends JPanel{
	private __VerticalScrollPanel innerPanel;//the panel that holds all the objects to be displayed. 
	public VerticalScrollPanel(Collection<? extends JComponent> components) {
		setLayout(new GridLayout(1,1));
		innerPanel = new __VerticalScrollPanel(components);
		add(new JScrollPane(innerPanel));//add the scrollable innerPanel into a JScrollPane which also gets added to the current object
	}
	
	/**
	 * return the actual content pane (innerPanel) of this object to allow the objects inside of it to be changed
	 * @return innerPanel
	 */
	public Container getContentPane() {
		return innerPanel;
	}
}

/**
 * actual class that has the functionality mentioned. Is a scrollable JPanel that can only be scrolled on the vertical axis
 * @author batu
 *
 */
class __VerticalScrollPanel extends JPanel implements Scrollable{
	public __VerticalScrollPanel(Collection<? extends JComponent> components) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0;
		//add every component to the object
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
	}
	//return the preferred size of the viewport
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}
	
	//how much a scroll wheel click scrolls the panel
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}
	//how much a block scroll srolls the panel
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return ((orientation == SwingConstants.VERTICAL) ? visibleRect.height : visibleRect.width) - 10;
	}
	//the width of this object will be scaled to always fit the viewport
	@Override
	public boolean getScrollableTracksViewportWidth() {
		return true;
	}
	//the height of this object will not be scaled to always fit the viewport
	@Override
	public boolean getScrollableTracksViewportHeight() {
		return false;
	}
}
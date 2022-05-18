package frontend;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import mvc.Controller;
import mvc.Model;
import backend.*;

/**
 * a single panel that displays brief info (name and member number) about a group. Used mainly for groupspanel.
 * @author batu
 *
 */
public class GroupPanel extends JPanel {

	/**
	 * create the panel from a  group
	 * @param group group whose info will be displayed
	 */
	public GroupPanel(Group group) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnGroupDataField = new JTextPane();
		txtpnGroupDataField.setEditable(false);
		add(txtpnGroupDataField);
		
		txtpnGroupDataField.setText(group.toString()); //set the displated info to the toString method of the group (name and member numer)
		//if the panel is clicked upon, display the group page.
		txtpnGroupDataField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Model.setGroupOfInterest(group);
				Controller.sendEvent("GROUP");
			}
		});
	}

}

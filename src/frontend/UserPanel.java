package frontend;

import javax.swing.JPanel;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import mvc.*;
import javax.swing.border.BevelBorder;

/**
 * panel that displays brief info about a single user. Used in UsersPanel
 * @author batu
 *
 */
public class UserPanel extends JPanel {

	/**
	 * create the panel from the provided user
	 * @param user user to display info on
	 */
	public UserPanel(User user) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnUserdatafield = new JTextPane();
		txtpnUserdatafield.setEditable(false); //set the data field as uneditable
		add(txtpnUserdatafield);
		
		txtpnUserdatafield.setText(user.toString()); //display info on the user <Name Surname (Nickname)>
		
		//if the data field is clicked on, take the currently logged in user to the page of this panel's user
		txtpnUserdatafield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Model.setUserOfInterest(user);
				Controller.sendEvent("OTHER USER");
			}
		});
	}

}

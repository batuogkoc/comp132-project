package frontend;

import javax.swing.JPanel;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import mvc.*;
import javax.swing.border.BevelBorder;

public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserPanel(User user) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnUserdatafield = new JTextPane();
		txtpnUserdatafield.setEditable(false);
		add(txtpnUserdatafield);
		
		txtpnUserdatafield.setText(user.toString());
		txtpnUserdatafield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Model.setUserOfInterest(user);
				Controller.sendEvent("OTHER USER");
			}
		});
	}

}

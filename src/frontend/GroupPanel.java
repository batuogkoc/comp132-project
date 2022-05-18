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

public class GroupPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GroupPanel(Group group) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnUserdatafield = new JTextPane();
		txtpnUserdatafield.setEditable(false);
		add(txtpnUserdatafield);
		
		txtpnUserdatafield.setText(group.toString());
		txtpnUserdatafield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Model.setGroupOfInterest(group);
				Controller.sendEvent("GROUP");
			}
		});
	}

}

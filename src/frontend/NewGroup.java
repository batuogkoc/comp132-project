package frontend;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import mvc.Controller;
import mvc.Model;
import mvc.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import backend.*;
public class NewGroup extends JPanel {
	private JTextField txtNamefield;
	private JTextField txtCountryfield;

	/**
	 * Create the panel.
	 */
	public NewGroup() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		txtNamefield = new JTextField();
		GridBagConstraints gbc_txtNamefield = new GridBagConstraints();
		gbc_txtNamefield.gridwidth = 2;
		gbc_txtNamefield.insets = new Insets(0, 0, 5, 0);
		gbc_txtNamefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNamefield.gridx = 1;
		gbc_txtNamefield.gridy = 0;
		add(txtNamefield, gbc_txtNamefield);
		txtNamefield.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.EAST;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 1;
		add(lblCountry, gbc_lblCountry);
		
		txtCountryfield = new JTextField();
		GridBagConstraints gbc_txtCountryfield = new GridBagConstraints();
		gbc_txtCountryfield.gridwidth = 2;
		gbc_txtCountryfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtCountryfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCountryfield.gridx = 1;
		gbc_txtCountryfield.gridy = 1;
		add(txtCountryfield, gbc_txtCountryfield);
		txtCountryfield.setColumns(10);
		
		JLabel lblHobbies = new JLabel("Hobbies");
		GridBagConstraints gbc_lblHobbies = new GridBagConstraints();
		gbc_lblHobbies.insets = new Insets(0, 0, 5, 5);
		gbc_lblHobbies.gridx = 0;
		gbc_lblHobbies.gridy = 2;
		add(lblHobbies, gbc_lblHobbies);
		
		JTextPane txtpnHobbiesfield = new JTextPane();
		GridBagConstraints gbc_txtpnHobbiesfield = new GridBagConstraints();
		gbc_txtpnHobbiesfield.gridwidth = 2;
		gbc_txtpnHobbiesfield.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnHobbiesfield.fill = GridBagConstraints.BOTH;
		gbc_txtpnHobbiesfield.gridx = 1;
		gbc_txtpnHobbiesfield.gridy = 2;
		add(txtpnHobbiesfield, gbc_txtpnHobbiesfield);
		
		JButton btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 3;
		add(btnClear, gbc_btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
		
		JButton btnCreateGroup = new JButton("Create Group");
		GridBagConstraints gbc_btnCreateGroup = new GridBagConstraints();
		gbc_btnCreateGroup.gridx = 2;
		gbc_btnCreateGroup.gridy = 3;
		add(btnCreateGroup, gbc_btnCreateGroup);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNamefield.setText("");
				txtCountryfield.setText("");
				txtpnHobbiesfield.setText("");
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.setUserOfInterest(Model.getCurrentUser());
				Controller.sendEvent("PROFILE PAGE");
			}
		});
		
		btnCreateGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int r = JOptionPane.showConfirmDialog(View.getFrame(), "Create group?", "Creating group", JOptionPane.YES_NO_OPTION);
					if(r == JOptionPane.YES_OPTION) {
						Group group = new Group(Model.getCurrentUser(), txtNamefield.getText(), txtCountryfield.getText());
						for(String hobby : txtpnHobbiesfield.getText().split("\\r?\\n")) {
							group.addHobby(hobby);
						}
						Model.setGroupOfInterest(group);
						Controller.sendEvent("GROUP");
					}
				}
				catch(IllegalArgumentException e){
					JOptionPane.showConfirmDialog(View.getFrame(), e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
	}

}

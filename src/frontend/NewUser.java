package frontend;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import backend.User;
import mvc.Controller;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.print.attribute.UnmodifiableSetException;
import javax.swing.*;
import mvc.*;

public class NewUser extends JPanel {
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField nicknameField;
	private JTextField passwordField;
	private JTextField ageField;
	private JTextField emailField;
	private String profilePicturePath = "";
	private JPanel imagePanel;
	private JFileChooser fileChooser = new JFileChooser(".");
	private JTextField txtCountryfield;
	/**
	 * Create the panel.
	 */
	public NewUser() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		
		imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		add(imagePanel, gbc_imagePanel);
		imagePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.gridwidth = 3;
		gbc_infoPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_infoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_infoPanel.gridx = 1;
		gbc_infoPanel.gridy = 0;
		add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[] {0, 0};
		gbl_infoPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_infoPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		infoPanel.add(lblName, gbc_lblName);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		infoPanel.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 1;
		infoPanel.add(lblSurname, gbc_lblSurname);
		
		surnameField = new JTextField();
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameField.gridx = 1;
		gbc_surnameField.gridy = 1;
		infoPanel.add(surnameField, gbc_surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.EAST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 2;
		infoPanel.add(lblNickname, gbc_lblNickname);
		
		nicknameField = new JTextField();
		GridBagConstraints gbc_nicknameField = new GridBagConstraints();
		gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nicknameField.insets = new Insets(0, 0, 5, 0);
		gbc_nicknameField.gridx = 1;
		gbc_nicknameField.gridy = 2;
		infoPanel.add(nicknameField, gbc_nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		infoPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JTextField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		infoPanel.add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 4;
		infoPanel.add(lblAge, gbc_lblAge);
		
		ageField = new JTextField();
		GridBagConstraints gbc_ageField = new GridBagConstraints();
		gbc_ageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ageField.insets = new Insets(0, 0, 5, 0);
		gbc_ageField.gridx = 1;
		gbc_ageField.gridy = 4;
		infoPanel.add(ageField, gbc_ageField);
		ageField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		infoPanel.add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 5;
		infoPanel.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country:");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.EAST;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 6;
		infoPanel.add(lblCountry, gbc_lblCountry);
		
		txtCountryfield = new JTextField();
		GridBagConstraints gbc_txtCountryfield = new GridBagConstraints();
		gbc_txtCountryfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtCountryfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCountryfield.gridx = 1;
		gbc_txtCountryfield.gridy = 6;
		infoPanel.add(txtCountryfield, gbc_txtCountryfield);
		txtCountryfield.setColumns(10);
		
		JLabel lblHobbies = new JLabel("Hobbies:");
		GridBagConstraints gbc_lblHobbies = new GridBagConstraints();
		gbc_lblHobbies.anchor = GridBagConstraints.EAST;
		gbc_lblHobbies.insets = new Insets(0, 0, 5, 5);
		gbc_lblHobbies.gridx = 0;
		gbc_lblHobbies.gridy = 7;
		infoPanel.add(lblHobbies, gbc_lblHobbies);
		
		JTextPane txtpnHobbiesfield = new JTextPane();
		GridBagConstraints gbc_txtpnHobbiesfield = new GridBagConstraints();
		gbc_txtpnHobbiesfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnHobbiesfield.fill = GridBagConstraints.BOTH;
		gbc_txtpnHobbiesfield.gridx = 1;
		gbc_txtpnHobbiesfield.gridy = 7;
		infoPanel.add(txtpnHobbiesfield, gbc_txtpnHobbiesfield);
		
		JCheckBox chckbxPremium = new JCheckBox("Premium");
		GridBagConstraints gbc_chckbxPremium = new GridBagConstraints();
		gbc_chckbxPremium.gridx = 1;
		gbc_chckbxPremium.gridy = 8;
		infoPanel.add(chckbxPremium, gbc_chckbxPremium);
		
		JButton btnChooseProfilePicture = new JButton("Choose Profile Picture");
		GridBagConstraints gbc_btnChooseProfilePicture = new GridBagConstraints();
		gbc_btnChooseProfilePicture.insets = new Insets(0, 0, 0, 5);
		gbc_btnChooseProfilePicture.gridx = 0;
		gbc_btnChooseProfilePicture.gridy = 1;
		add(btnChooseProfilePicture, gbc_btnChooseProfilePicture);
		
		JButton btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 1;
		add(btnClear, gbc_btnClear);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 1;
		add(btnLogin, gbc_btnLogin);
		
		JButton btnCreateNewUser = new JButton("Create New User");
		GridBagConstraints gbc_btnCreateNewUser = new GridBagConstraints();
		gbc_btnCreateNewUser.gridx = 3;
		gbc_btnCreateNewUser.gridy = 1;
		add(btnCreateNewUser, gbc_btnCreateNewUser);
		
		displayProfilePicture(profilePicturePath);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component component : infoPanel.getComponents()) {
					if(component instanceof JTextField) {
						((JTextField)component).setText("");
					}
					else if (component instanceof JCheckBox) {
						((JCheckBox) component).setSelected(false);
					}
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.sendEvent("LOGIN");
			}
		});
		btnChooseProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					profilePicturePath = fileChooser.getSelectedFile().getAbsolutePath();
				}
				else {
					profilePicturePath = "";
				}
				displayProfilePicture(profilePicturePath);
			}
		});
		btnCreateNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					User user = new User(nicknameField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), chckbxPremium.isSelected());
					for(String hobby : txtpnHobbiesfield.getText().split("\\r?\\n")) {
						user.addHobby(hobby);
					}
					Model.setCurrentUser(user);
					Controller.sendEvent("HOME PAGE");
				}
				catch(NumberFormatException e) {
					JOptionPane.showConfirmDialog(View.getFrame(), "Age must be an integer", "Error", JOptionPane.DEFAULT_OPTION);
				}
				catch(IllegalArgumentException e) {
					JOptionPane.showConfirmDialog(View.getFrame(), e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
	}
	
	private void displayProfilePicture(String profilePicturePath) {
		imagePanel.removeAll();
		if(profilePicturePath == "")
			profilePicturePath = User.getDefaultProfilePicturePath();
		imagePanel.add(new ResizableImage(new ImageIcon(profilePicturePath)));
		imagePanel.validate();
		imagePanel.repaint();
	}

}

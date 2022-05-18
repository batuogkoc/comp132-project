package frontend;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import backend.*;
import mvc.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePage extends JPanel {
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField nicknameField;
	private JPanel dynamicPanel;

	/**
	 * Create the panel.
	 */
	public ProfilePage(User viewingUser, User viewedUser) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {20, 60};
		gridBagLayout.rowHeights = new int[] {40, 40, 80};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.gridheight = 2;
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		add(imagePanel, gbc_imagePanel);
		imagePanel.setLayout(new GridLayout(1, 1));
		
		JPanel infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 1;
		gbc_infoPanel.gridy = 0;
		add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[] {0, 0};
		gbl_infoPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel lblName = new JLabel("Name: ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		infoPanel.add(lblName, gbc_lblName);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setText("nameField");
		nameField.setColumns(10);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		infoPanel.add(nameField, gbc_nameField);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 1;
		infoPanel.add(lblSurname, gbc_lblSurname);
		
		surnameField = new JTextField();
		surnameField.setEditable(false);
		surnameField.setText("surnameField");
		surnameField.setColumns(10);
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.gridx = 1;
		gbc_surnameField.gridy = 1;
		infoPanel.add(surnameField, gbc_surnameField);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.EAST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 2;
		infoPanel.add(lblNickname, gbc_lblNickname);
		
		nicknameField = new JTextField();
		nicknameField.setEditable(false);
		nicknameField.setText("nicknameField");
		GridBagConstraints gbc_nicknameField = new GridBagConstraints();
		gbc_nicknameField.insets = new Insets(0, 0, 5, 0);
		gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nicknameField.gridx = 1;
		gbc_nicknameField.gridy = 2;
		infoPanel.add(nicknameField, gbc_nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblAccount = new JLabel("Account:");
		GridBagConstraints gbc_lblAccount = new GridBagConstraints();
		gbc_lblAccount.anchor = GridBagConstraints.EAST;
		gbc_lblAccount.insets = new Insets(0, 0, 0, 5);
		gbc_lblAccount.gridx = 0;
		gbc_lblAccount.gridy = 3;
		infoPanel.add(lblAccount, gbc_lblAccount);
		
		String[] accountTypes = {"Regular", "Premium"};
		JComboBox accountTypeCombo = new JComboBox(accountTypes);
		GridBagConstraints gbc_accountTypeCombo = new GridBagConstraints();
		gbc_accountTypeCombo.gridx = 1;
		gbc_accountTypeCombo.gridy = 3;
		infoPanel.add(accountTypeCombo, gbc_accountTypeCombo);
		
		JPanel controlPanel = new JPanel();
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.fill = GridBagConstraints.BOTH;
		gbc_controlPanel.insets = new Insets(0, 0, 5, 0);
		gbc_controlPanel.gridx = 1;
		gbc_controlPanel.gridy = 1;
		add(controlPanel, gbc_controlPanel);
		controlPanel.setLayout(new CardLayout(0, 0));
		
		JPanel yourProfile = new JPanel();
		controlPanel.add(yourProfile, "name_26374192294213");
		GridBagLayout gbl_yourProfile = new GridBagLayout();
		gbl_yourProfile.columnWidths = new int[] {0, 0};
		gbl_yourProfile.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_yourProfile.columnWeights = new double[]{0.0, 1.0};
		gbl_yourProfile.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		yourProfile.setLayout(gbl_yourProfile);
		
		JButton btnLogOut = new JButton("Log Out");
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogOut.gridx = 0;
		gbc_btnLogOut.gridy = 0;
		yourProfile.add(btnLogOut, gbc_btnLogOut);
		
		JButton btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 0;
		yourProfile.add(btnEdit, gbc_btnEdit);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		GridBagConstraints gbc_btnDeleteAccount = new GridBagConstraints();
		gbc_btnDeleteAccount.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteAccount.gridx = 0;
		gbc_btnDeleteAccount.gridy = 1;
		yourProfile.add(btnDeleteAccount, gbc_btnDeleteAccount);
		
		JButton btnFriends = new JButton("Friends");
		GridBagConstraints gbc_btnFriends = new GridBagConstraints();
		gbc_btnFriends.insets = new Insets(0, 0, 5, 0);
		gbc_btnFriends.gridx = 1;
		gbc_btnFriends.gridy = 1;
		yourProfile.add(btnFriends, gbc_btnFriends);
		
		JButton btnSuggestUsers = new JButton("Suggest Users");
		GridBagConstraints gbc_btnSuggestUsers = new GridBagConstraints();
		gbc_btnSuggestUsers.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuggestUsers.gridx = 0;
		gbc_btnSuggestUsers.gridy = 2;
		yourProfile.add(btnSuggestUsers, gbc_btnSuggestUsers);
		
		JButton btnGroups = new JButton("Groups");
		GridBagConstraints gbc_btnGroups = new GridBagConstraints();
		gbc_btnGroups.insets = new Insets(0, 0, 5, 0);
		gbc_btnGroups.gridx = 1;
		gbc_btnGroups.gridy = 2;
		yourProfile.add(btnGroups, gbc_btnGroups);
		
		JButton btnSuggestGroups = new JButton("Suggest Groups");
		GridBagConstraints gbc_btnSuggestGroups = new GridBagConstraints();
		gbc_btnSuggestGroups.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuggestGroups.gridx = 0;
		gbc_btnSuggestGroups.gridy = 3;
		yourProfile.add(btnSuggestGroups, gbc_btnSuggestGroups);
		
		JButton btnContents = new JButton("Contents");
		GridBagConstraints gbc_btnContents = new GridBagConstraints();
		gbc_btnContents.insets = new Insets(0, 0, 5, 0);
		gbc_btnContents.gridx = 1;
		gbc_btnContents.gridy = 3;
		yourProfile.add(btnContents, gbc_btnContents);
		
		JButton btnCreateGroup = new JButton("Create Group");
		GridBagConstraints gbc_btnCreateGroup = new GridBagConstraints();
		gbc_btnCreateGroup.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateGroup.gridx = 0;
		gbc_btnCreateGroup.gridy = 4;
		yourProfile.add(btnCreateGroup, gbc_btnCreateGroup);
		
		JPanel followedProfile = new JPanel();
		controlPanel.add(followedProfile, "name_26455931790925");
		GridBagLayout gbl_followedProfile = new GridBagLayout();
		gbl_followedProfile.columnWidths = new int[] {0, 0};
		gbl_followedProfile.rowHeights = new int[] {0, 0};
		gbl_followedProfile.columnWeights = new double[]{0.0, 1.0};
		gbl_followedProfile.rowWeights = new double[]{0.0, 0.0};
		followedProfile.setLayout(gbl_followedProfile);
		
		JButton btnUnfollow_1 = new JButton("Unfollow");
		GridBagConstraints gbc_btnUnfollow_1 = new GridBagConstraints();
		gbc_btnUnfollow_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnUnfollow_1.gridx = 0;
		gbc_btnUnfollow_1.gridy = 0;
		followedProfile.add(btnUnfollow_1, gbc_btnUnfollow_1);
		
		JButton btnFriends_1 = new JButton("Friends");
		GridBagConstraints gbc_btnFriends_1 = new GridBagConstraints();
		gbc_btnFriends_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnFriends_1.gridx = 1;
		gbc_btnFriends_1.gridy = 0;
		followedProfile.add(btnFriends_1, gbc_btnFriends_1);
		
		JButton btnContents_1 = new JButton("Contents");
		GridBagConstraints gbc_btnContents_1 = new GridBagConstraints();
		gbc_btnContents_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnContents_1.gridx = 0;
		gbc_btnContents_1.gridy = 1;
		followedProfile.add(btnContents_1, gbc_btnContents_1);
		
		JButton btnGroups_1 = new JButton("Groups");
		GridBagConstraints gbc_btnGroups_1 = new GridBagConstraints();
		gbc_btnGroups_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnGroups_1.gridx = 1;
		gbc_btnGroups_1.gridy = 1;
		followedProfile.add(btnGroups_1, gbc_btnGroups_1);
		
		JPanel unfollowedProfile = new JPanel();
		controlPanel.add(unfollowedProfile, "name_26836584180790");
		GridBagLayout gbl_unfollowedProfile = new GridBagLayout();
		gbl_unfollowedProfile.columnWidths = new int[] {0};
		gbl_unfollowedProfile.rowHeights = new int[] {0};
		gbl_unfollowedProfile.columnWeights = new double[]{1.0};
		gbl_unfollowedProfile.rowWeights = new double[]{0.0};
		unfollowedProfile.setLayout(gbl_unfollowedProfile);
		
		JButton btnFollow = new JButton("Follow");
		GridBagConstraints gbc_btnFollow = new GridBagConstraints();
		gbc_btnFollow.insets = new Insets(0, 0, 5, 0);
		gbc_btnFollow.gridx = 0;
		gbc_btnFollow.gridy = 0;
		unfollowedProfile.add(btnFollow, gbc_btnFollow);
		
		dynamicPanel = new JPanel();
		GridBagConstraints gbc_dynamicPanel = new GridBagConstraints();
		gbc_dynamicPanel.gridwidth = 2;
		gbc_dynamicPanel.fill = GridBagConstraints.BOTH;
		gbc_dynamicPanel.gridx = 0;
		gbc_dynamicPanel.gridy = 2;
		add(dynamicPanel, gbc_dynamicPanel);
		dynamicPanel.setLayout(new GridLayout(1, 1));
		
		imagePanel.add(new ResizableImage(new ImageIcon(viewedUser.getProfilePicturePath())));
		nameField.setText(viewedUser.getName());
		surnameField.setText(viewedUser.getSurname());
		nicknameField.setText(viewedUser.getNickname());
		accountTypeCombo.setSelectedIndex(viewedUser.isPremium()?1:0);
			
		
		if(viewingUser == viewedUser) {
			((CardLayout)controlPanel.getLayout()).show(controlPanel, "name_26374192294213");
			setDynamicPanelContents(new ContentsPanel(viewedUser.getContents()));
			btnCreateGroup.setEnabled(viewedUser.isPremium());
		}
		else if (viewingUser.getFollowedUsers().contains(viewedUser)) {
			((CardLayout)controlPanel.getLayout()).show(controlPanel, "name_26455931790925");
		}
		else {
			((CardLayout)controlPanel.getLayout()).show(controlPanel, "name_26836584180790");
		}
		
		btnContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDynamicPanelContents(new ContentsPanel(viewedUser.getContents()));
			}
		});
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDynamicPanelContents(new JPanel());
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEdit.getText().equals("Edit")) {
					btnEdit.setText("Done");
					nameField.setEditable(true);
					surnameField.setEditable(true);
					accountTypeCombo.setEditable(true);
				}
				else{
					btnEdit.setText("Edit");
					viewedUser.setName(nameField.getText());
					viewedUser.setSurname(surnameField.getText());
					viewedUser.setPremium(accountTypeCombo.getSelectedIndex()==0?false:true);

					nameField.setEditable(false);
					surnameField.setEditable(false);
					accountTypeCombo.setEditable(false);
					nameField.setText(viewedUser.getName());
					surnameField.setText(viewedUser.getSurname());
					accountTypeCombo.setSelectedIndex(viewedUser.isPremium()?1:0);
				}
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(View.getFrame(), "Are you sure you want to log out?", "Logging out", JOptionPane.YES_NO_OPTION);
				if(a == JOptionPane.YES_OPTION) {
					Controller.sendEvent("LOGIN");
				}
			}
		});
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(View.getFrame(), "Are you sure you want to delete your account?", "Deleting account", JOptionPane.YES_NO_OPTION);
				if(a == JOptionPane.YES_OPTION) {
					viewedUser.deleteUser();
					Controller.sendEvent("LOGIN");
				}
			}
		});
		
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDynamicPanelContents(new UsersPanel(viewingUser.getFollowedUsers()));
			}
		});
	}
	
	private void setDynamicPanelContents(JComponent component) {
		dynamicPanel.removeAll();
		dynamicPanel.add(component);
		dynamicPanel.validate();
		dynamicPanel.repaint();
	}

}

package frontend;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JComboBox;

import backend.*;
import mvc.*;

public class ProfilePage extends JPanel {
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public ProfilePage(User viewingUser, User viewedUser) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {2, 4};
		gridBagLayout.rowHeights = new int[] {15, 15, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		add(imagePanel, gbc_imagePanel);
		imagePanel.setLayout(new GridLayout(1, 1));
		imagePanel.add(new ResizableImage(new ImageIcon(viewedUser.getProfilePicturePath())));
		
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
		
		textField_6 = new JTextField();
		textField_6.setText("nameField");
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 0;
		infoPanel.add(textField_6, gbc_textField_6);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 1;
		infoPanel.add(lblSurname, gbc_lblSurname);
		
		textField_7 = new JTextField();
		textField_7.setText("surnameField");
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 1;
		infoPanel.add(textField_7, gbc_textField_7);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 2;
		infoPanel.add(lblNickname, gbc_lblNickname);
		
		JLabel lblNicknamefield = new JLabel("nicknameField");
		GridBagConstraints gbc_lblNicknamefield = new GridBagConstraints();
		gbc_lblNicknamefield.insets = new Insets(0, 0, 5, 0);
		gbc_lblNicknamefield.gridx = 1;
		gbc_lblNicknamefield.gridy = 2;
		infoPanel.add(lblNicknamefield, gbc_lblNicknamefield);
		
		JLabel lblAccount = new JLabel("Account:");
		GridBagConstraints gbc_lblAccount = new GridBagConstraints();
		gbc_lblAccount.anchor = GridBagConstraints.EAST;
		gbc_lblAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccount.gridx = 0;
		gbc_lblAccount.gridy = 3;
		infoPanel.add(lblAccount, gbc_lblAccount);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		infoPanel.add(comboBox, gbc_comboBox);
		
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
		gbl_unfollowedProfile.rowWeights = new double[]{0.0, 0.0};
		unfollowedProfile.setLayout(gbl_unfollowedProfile);
		
		JButton btnFollow = new JButton("Follow");
		GridBagConstraints gbc_btnFollow = new GridBagConstraints();
		gbc_btnFollow.insets = new Insets(0, 0, 5, 5);
		gbc_btnFollow.gridx = 0;
		gbc_btnFollow.gridy = 1;
		unfollowedProfile.add(btnFollow, gbc_btnFollow);
		
		JPanel dynamicPanel = new JPanel();
		GridBagConstraints gbc_dynamicPanel = new GridBagConstraints();
		gbc_dynamicPanel.gridwidth = 2;
		gbc_dynamicPanel.fill = GridBagConstraints.BOTH;
		gbc_dynamicPanel.gridx = 0;
		gbc_dynamicPanel.gridy = 2;
		add(dynamicPanel, gbc_dynamicPanel);
		
		
	}

}

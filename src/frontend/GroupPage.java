package frontend;

import java.awt.*;
import javax.swing.*;

import backend.*;
import mvc.*;
import java.awt.event.*;
import java.beans.beancontext.BeanContextMembershipListener;
import java.util.Iterator;

public class GroupPage extends JPanel {
	private JTextField txtNamefield;
	private JTextField txtCountryfield;
	private JTextField txtCreatorfield;
	private boolean removingMembers = false;
	private JComboBox memberRemovalComboBox;

	/**
	 * Create the panel.
	 */
	public GroupPage(Group group, User viewingUser) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.5, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		txtNamefield = new JTextField();
		txtNamefield.setEditable(false);
		GridBagConstraints gbc_txtNamefield = new GridBagConstraints();
		gbc_txtNamefield.insets = new Insets(0, 0, 5, 5);
		gbc_txtNamefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNamefield.gridx = 1;
		gbc_txtNamefield.gridy = 0;
		add(txtNamefield, gbc_txtNamefield);
		txtNamefield.setColumns(10);
		
		JLabel lblHobbies = new JLabel("Hobbies");
		GridBagConstraints gbc_lblHobbies = new GridBagConstraints();
		gbc_lblHobbies.insets = new Insets(0, 0, 5, 5);
		gbc_lblHobbies.gridx = 2;
		gbc_lblHobbies.gridy = 0;
		add(lblHobbies, gbc_lblHobbies);
		
		JPanel hobbiesPanel = new JPanel();
		GridBagConstraints gbc_hobbiesPanel = new GridBagConstraints();
		gbc_hobbiesPanel.gridheight = 2;
		gbc_hobbiesPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hobbiesPanel.fill = GridBagConstraints.BOTH;
		gbc_hobbiesPanel.gridx = 3;
		gbc_hobbiesPanel.gridy = 0;
		add(hobbiesPanel, gbc_hobbiesPanel);
		
		JLabel lblCountry = new JLabel("Country");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.EAST;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 1;
		add(lblCountry, gbc_lblCountry);
		
		txtCountryfield = new JTextField();
		txtCountryfield.setEditable(false);
		GridBagConstraints gbc_txtCountryfield = new GridBagConstraints();
		gbc_txtCountryfield.insets = new Insets(0, 0, 5, 5);
		gbc_txtCountryfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCountryfield.gridx = 1;
		gbc_txtCountryfield.gridy = 1;
		add(txtCountryfield, gbc_txtCountryfield);
		txtCountryfield.setColumns(10);
		
		JPanel dynamicPanel = new JPanel();
		GridBagConstraints gbc_dynamicPanel = new GridBagConstraints();
		gbc_dynamicPanel.gridwidth = 4;
		gbc_dynamicPanel.insets = new Insets(0, 0, 0, 5);
		gbc_dynamicPanel.fill = GridBagConstraints.BOTH;
		gbc_dynamicPanel.gridx = 0;
		gbc_dynamicPanel.gridy = 2;
		add(dynamicPanel, gbc_dynamicPanel);
		dynamicPanel.setLayout(new CardLayout(0, 0));
		
		JPanel nonMemberPanel = new JPanel();
		dynamicPanel.add(nonMemberPanel, "name_22987395406545");
		
		JButton btnJoin = new JButton("Join");
		nonMemberPanel.add(btnJoin);
		
		JPanel memberPanel = new JPanel();
		dynamicPanel.add(memberPanel, "name_23002355336325");
		GridBagLayout gbl_memberPanel = new GridBagLayout();
		gbl_memberPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_memberPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_memberPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_memberPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		memberPanel.setLayout(gbl_memberPanel);
		
		JButton btnLeave = new JButton("Leave");
		GridBagConstraints gbc_btnLeave = new GridBagConstraints();
		gbc_btnLeave.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeave.gridx = 0;
		gbc_btnLeave.gridy = 0;
		memberPanel.add(btnLeave, gbc_btnLeave);
		
		JLabel lblCreator = new JLabel("Creator:");
		GridBagConstraints gbc_lblCreator = new GridBagConstraints();
		gbc_lblCreator.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreator.anchor = GridBagConstraints.EAST;
		gbc_lblCreator.gridx = 1;
		gbc_lblCreator.gridy = 0;
		memberPanel.add(lblCreator, gbc_lblCreator);
		
		txtCreatorfield = new JTextField();
		txtCreatorfield.setEditable(false);
		GridBagConstraints gbc_txtCreatorfield = new GridBagConstraints();
		gbc_txtCreatorfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtCreatorfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCreatorfield.gridx = 2;
		gbc_txtCreatorfield.gridy = 0;
		memberPanel.add(txtCreatorfield, gbc_txtCreatorfield);
		txtCreatorfield.setColumns(10);
		
		JButton btnRemoveMembers = new JButton("Remove Members");
		GridBagConstraints gbc_btnRemoveMembers = new GridBagConstraints();
		gbc_btnRemoveMembers.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveMembers.gridx = 0;
		gbc_btnRemoveMembers.gridy = 1;
		memberPanel.add(btnRemoveMembers, gbc_btnRemoveMembers);
		
		JLabel lblMembers = new JLabel("Members");
		GridBagConstraints gbc_lblMembers = new GridBagConstraints();
		gbc_lblMembers.fill = GridBagConstraints.VERTICAL;
		gbc_lblMembers.insets = new Insets(0, 0, 5, 5);
		gbc_lblMembers.gridx = 1;
		gbc_lblMembers.gridy = 1;
		memberPanel.add(lblMembers, gbc_lblMembers);
		
		JPanel membersPanel = new JPanel();
		GridBagConstraints gbc_membersPanel = new GridBagConstraints();
		gbc_membersPanel.insets = new Insets(0, 0, 5, 0);
		gbc_membersPanel.fill = GridBagConstraints.BOTH;
		gbc_membersPanel.gridx = 2;
		gbc_membersPanel.gridy = 1;
		memberPanel.add(membersPanel, gbc_membersPanel);
		membersPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel memberRemovalPanel = new JPanel();
		GridBagConstraints gbc_memberRemovalPanel = new GridBagConstraints();
		gbc_memberRemovalPanel.insets = new Insets(0, 0, 0, 5);
		gbc_memberRemovalPanel.fill = GridBagConstraints.BOTH;
		gbc_memberRemovalPanel.gridx = 0;
		gbc_memberRemovalPanel.gridy = 2;
		memberPanel.add(memberRemovalPanel, gbc_memberRemovalPanel);
		memberRemovalPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblContents = new JLabel("Contents");
		GridBagConstraints gbc_lblContents = new GridBagConstraints();
		gbc_lblContents.insets = new Insets(0, 0, 0, 5);
		gbc_lblContents.gridx = 1;
		gbc_lblContents.gridy = 2;
		memberPanel.add(lblContents, gbc_lblContents);
		
		JPanel contentsPanel = new JPanel();
		GridBagConstraints gbc_contentsPanel = new GridBagConstraints();
		gbc_contentsPanel.fill = GridBagConstraints.BOTH;
		gbc_contentsPanel.gridx = 2;
		gbc_contentsPanel.gridy = 2;
		memberPanel.add(contentsPanel, gbc_contentsPanel);
		contentsPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		hobbiesPanel.add(new HobbiesPanel(group.getHobbies()));
		txtNamefield.setText(group.getName());
		txtCountryfield.setText(group.getCountry());
		if(group.getMembers().contains(viewingUser)) {
			CardLayout l = (CardLayout)dynamicPanel.getLayout();
			l.show(dynamicPanel, "name_23002355336325");		
			txtCreatorfield.setText(group.getGroupCreator().toString());
			membersPanel.add(new UsersPanel(group.getMembers()));
			contentsPanel.add(new ContentsPanel(group.getContents()));
			if(group.isCreator(viewingUser)) {
				btnLeave.setText("Delete Group");
				btnRemoveMembers.setEnabled(true);
			}
			else {
				btnLeave.setText("Leave");
				btnRemoveMembers.setEnabled(false);
			}
		}
		else {
			CardLayout l = (CardLayout)dynamicPanel.getLayout();
			l.show(dynamicPanel, "name_22987395406545");
		}
		
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Join group?", "Joining Group", JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION) {
					viewingUser.joinGroup(group);
					Model.setGroupOfInterest(group);
					Controller.sendEvent("GROUP");
				}
			}
		});
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group.isCreator(viewingUser)) {
					int r = JOptionPane.showConfirmDialog(View.getFrame(), "Delete group?", "Deleting Group", JOptionPane.YES_NO_OPTION);
					if(r == JOptionPane.YES_OPTION) {
						group.deleteGroup();
						Model.setGroupOfInterest(null);
						Controller.sendEvent("HOME PAGE");
					}
				}
				else {
					int r = JOptionPane.showConfirmDialog(View.getFrame(), "Leave group?", "Leaving Group", JOptionPane.YES_NO_OPTION);
					if(r == JOptionPane.YES_OPTION) {
						viewingUser.leaveGroup(group);
						Model.setGroupOfInterest(group);
						Controller.sendEvent("GROUP");
					}
				}
				
			}
		});
		btnRemoveMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(removingMembers) {
					removingMembers = false;
					if(memberRemovalComboBox.getSelectedIndex() != 0) {
//						User userToRemove;
						Iterator<User> it = group.getMembers().iterator();
						for (int i = 1; it.hasNext(); i++) {
							User user = it.next();
							if(memberRemovalComboBox.getSelectedIndex() == i) {
								if(user == group.getGroupCreator()) {
									JOptionPane.showConfirmDialog(View.getFrame(), "Cannot remove yourself, try deleting the group.", "Error", JOptionPane.DEFAULT_OPTION);
									break;
								}
								int a = JOptionPane.showConfirmDialog(View.getFrame(), "Remove "+user.toString(), "Removing user", JOptionPane.YES_NO_OPTION);
								if(a == JOptionPane.YES_OPTION) {
									user.leaveGroup(group);
									break;
								}
							}
						}
					}
					Model.setGroupOfInterest(group);
					Controller.sendEvent("GROUP");
				}
				else {
					removingMembers = true;
					String[] comboboxItems = new String[group.getMembers().size()+1];
					comboboxItems[0] = "Cancel";
					Iterator<User> it = group.getMembers().iterator();
					for (int i = 1; it.hasNext(); i++) {
						comboboxItems[i] = (it.next().getNickname());
					}
					memberRemovalComboBox = new JComboBox(comboboxItems);
					memberRemovalPanel.add(memberRemovalComboBox);
					membersPanel.removeAll();
					membersPanel.add(new UsersPanel(group.getMembers()));
					membersPanel.validate();
					membersPanel.repaint();
					btnRemoveMembers.setText("Done");
				}
			}
		});
	}

}

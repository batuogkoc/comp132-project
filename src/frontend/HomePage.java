package frontend;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import backend.*;
import mvc.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;

import javax.swing.JButton;
import java.awt.Insets;
public class HomePage extends JPanel {
	private JTextField txtSearch;
	private JPanel dynamicPanel;

	/**
	 * Create the panel.
	 */
	public HomePage(User viewingUser) {
		setLayout(new BorderLayout(0, 0));
		
		dynamicPanel = new JPanel();
		add(dynamicPanel, BorderLayout.CENTER);
		dynamicPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		setDynamicPanelContents(new ContentsPanel(viewingUser.getReceivedContents()));
		
		txtSearch = new JTextField();
		add(txtSearch, BorderLayout.NORTH);
		txtSearch.setColumns(10);
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				update();					
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				update();					
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				update();				
			}
			public void update() {
				if(txtSearch.getText().equals("")) {
					setDynamicPanelContents(new ContentsPanel(viewingUser.getReceivedContents()));
				}
				else {
					JPanel searchResultsPanel = new JPanel();
					searchResultsPanel.setLayout(new GridBagLayout());
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx=0;
					gbc.gridy=0;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weighty =0.0;
					searchResultsPanel.add(new JLabel("Users:"),gbc);
					gbc.gridx=0;
					gbc.gridy=1;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weighty =1.0;
					searchResultsPanel.add(new UsersPanel(User.searchUsers(txtSearch.getText())), gbc);
					gbc.gridx=0;
					gbc.gridy=2;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weighty =0.0;
					searchResultsPanel.add(new JLabel("Groups:"),gbc);
					gbc.gridx=0;
					gbc.gridy=3;
					gbc.weighty =1.0;
					gbc.fill = GridBagConstraints.BOTH;
					searchResultsPanel.add(new GroupsPanel(Group.searchGroups(txtSearch.getText())),gbc);
					setDynamicPanelContents(searchResultsPanel);
				}
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

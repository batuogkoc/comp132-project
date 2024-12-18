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
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.*;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;

import javax.swing.JButton;
import java.awt.Insets;
/**
 * Home Page of the application. Has a search bar that allows a user to search groups, contents and other users, and a contents panel that displays the contents the user's groups and friends posted.
 * @author batu
 *
 */
public class HomePage extends JPanel {
	private JTextField txtSearch;
	private JPanel dynamicPanel;

	/**
	 * create the home page panel of the viewing user
	 * @param viewingUser the user that is currently logged in.
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
		//search bar. Updates the located items as the user types every letter.
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
					setDynamicPanelContents(new ContentsPanel(viewingUser.getReceivedContents())); // if the search bar is empty, display the contents
				}
				else {
					//if there is a keyword being searched for, first display the located users then the groups
					JPanel searchResultsPanel = new JPanel();
					searchResultsPanel.setLayout(new GridBagLayout());
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx=0;
					gbc.gridy=0;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weightx =1.0;
					gbc.weighty =0.0;
					searchResultsPanel.add(new JLabel("Users:"),gbc);
					gbc.gridx=0;
					gbc.gridy=1;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weightx =1.0;
					gbc.weighty =1.0;
					searchResultsPanel.add(new UsersPanel(User.searchUsers(txtSearch.getText())), gbc);//search users for the keyword
					gbc.gridx=0;
					gbc.gridy=2;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weightx =1.0;
					gbc.weighty =0.0;
					searchResultsPanel.add(new JLabel("Groups:"),gbc);
					gbc.gridx=0;
					gbc.gridy=3;
					gbc.weightx =1.0;
					gbc.weighty =1.0;
					gbc.fill = GridBagConstraints.BOTH;
					searchResultsPanel.add(new GroupsPanel(Group.searchGroups(txtSearch.getText())),gbc); //search groups by keyword
					gbc.gridx=0;
					gbc.gridy=4;
					gbc.fill = GridBagConstraints.BOTH;
					gbc.weightx =1.0;
					gbc.weighty =0.0;
					searchResultsPanel.add(new JLabel("Contents:"),gbc);
					gbc.gridx=0;
					gbc.gridy=5;
					gbc.weightx =1.0;
					gbc.weighty =1.0;
					gbc.fill = GridBagConstraints.BOTH;
					HashSet<ContentPanel> searchedContentsPanels = new HashSet<>();//create empty hashset so that we can store the searched contents as contentpanel in them and then pass the hashset into the verticalscrollpanel object
					for(Content content : viewingUser.getReceivedContents()) {
						if(content.getTitle().contains(txtSearch.getText())) {
							searchedContentsPanels.add(new ContentPanel(content));//if keywords exists in the title of content, generate a ContentPanel from it and add it to the set
						}
					}
					searchResultsPanel.add(new VerticalScrollPanel(searchedContentsPanels),gbc);//display the contents in the form of a vertical scroll panel
					setDynamicPanelContents(searchResultsPanel); //update the dynamicPanel
				}
			}
		});
	}
	/**
	 * clear the dynamic panel(the one that either shows search results or contens depeding on the search bar contents) and add the provided component
	 * @param component component to be added to the dynamic panel
	 */
	private void setDynamicPanelContents(JComponent component) {
		dynamicPanel.removeAll();
		dynamicPanel.add(component);
		dynamicPanel.validate();
		dynamicPanel.repaint();
	}

}

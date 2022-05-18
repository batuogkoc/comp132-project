package frontend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import backend.Content;
import backend.Group;
import backend.User;
import mvc.Controller;
import mvc.Model;
import mvc.View;

public class CreateContent extends JPanel {
	private JTextField txtTitlefield;
	private JPanel imagePanel; //panel that holds the picture
	private String picturePath = ""; //path to picture. "" means no picture
	private JFileChooser fileChooser; //filechooser is a filed because it retains the last opened directory this way.

	/**
	 * Create the panel that holds the gui for content creation.
	 */
	public CreateContent(User viewingUser) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{.5, 0.0, 0.5};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		
		imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.gridwidth = 2;
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		add(imagePanel, gbc_imagePanel);
		imagePanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel dataPanel = new JPanel();
		GridBagConstraints gbc_dataPanel = new GridBagConstraints();
		gbc_dataPanel.insets = new Insets(0, 0, 5, 0);
		gbc_dataPanel.fill = GridBagConstraints.BOTH;
		gbc_dataPanel.gridx = 2;
		gbc_dataPanel.gridy = 0;
		add(dataPanel, gbc_dataPanel);
		GridBagLayout gbl_dataPanel = new GridBagLayout();
		gbl_dataPanel.columnWidths = new int[] {0, 30};
		gbl_dataPanel.rowHeights = new int[] {0, 0, 0};
		gbl_dataPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_dataPanel.rowWeights = new double[]{0.0, 1.0, 0.0};
		dataPanel.setLayout(gbl_dataPanel);
		
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		dataPanel.add(lblTitle, gbc_lblTitle);
		
		txtTitlefield = new JTextField();
		GridBagConstraints gbc_txtTitlefield = new GridBagConstraints();
		gbc_txtTitlefield.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitlefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitlefield.gridx = 1;
		gbc_txtTitlefield.gridy = 0;
		dataPanel.add(txtTitlefield, gbc_txtTitlefield);
		txtTitlefield.setColumns(10);
		
		JLabel lblText = new JLabel("Text");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.WEST;
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 1;
		dataPanel.add(lblText, gbc_lblText);
		
		JTextPane txtTextfield = new JTextPane();
		GridBagConstraints gbc_txtTextfield = new GridBagConstraints();
		gbc_txtTextfield.insets = new Insets(0, 0, 5, 5);
		gbc_txtTextfield.fill = GridBagConstraints.BOTH;
		gbc_txtTextfield.gridx = 1;
		gbc_txtTextfield.gridy = 1;
		dataPanel.add(txtTextfield, gbc_txtTextfield);
		
		JLabel lblDestination = new JLabel("Destination");
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.insets = new Insets(0, 0, 0, 5);
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 2;
		dataPanel.add(lblDestination, gbc_lblDestination);
		
		//create a string array to store possible destinations for the content. these are the user's own account and the groups they are in.
		String[] comboBoxItems= new String[1+viewingUser.getJoinedGroups().size()];
		comboBoxItems[0] = "Your account";
		Iterator<Group> it = viewingUser.getJoinedGroups().iterator();
		int i = 1;
		while (it.hasNext()) {
			comboBoxItems[i++] = it.next().getName() + " (Group)";	
		}
		JComboBox comboBox = new JComboBox(comboBoxItems); //create a combobox with this array
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		dataPanel.add(comboBox, gbc_comboBox);
		
		JButton btnChangePicture = new JButton("Change Picture");
		GridBagConstraints gbc_btnChangePicture = new GridBagConstraints();
		gbc_btnChangePicture.insets = new Insets(0, 0, 0, 5);
		gbc_btnChangePicture.gridx = 0;
		gbc_btnChangePicture.gridy = 1;
		add(btnChangePicture, gbc_btnChangePicture);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 1;
		add(btnCancel, gbc_btnCancel);
		
		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 1;
		add(btnCreate, gbc_btnCreate);
		
		displayPicture(picturePath); //display the picture. This is initialised as "" which is no image.
		fileChooser = new JFileChooser("."); //initialise the fileChooser object
		
		//change picture button event. Updates the image path
		btnChangePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					picturePath = fileChooser.getSelectedFile().getAbsolutePath();
				}
				else {
					picturePath = "";//cancelling file choose sets the image as none
				}
				displayPicture(picturePath); //display new image
			}
		});
		
		//create content button. Creates the content using the data in the fields and adds it to the destination pointed to by the combobox index
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					if(comboBox.getSelectedIndex() == 0) {
						Content content = new Content(viewingUser, viewingUser, txtTitlefield.getText(), txtTextfield.getText(), picturePath); //create content and specify destination. Constructor automatically adds the content to the destination's container
						Controller.sendEvent("HOME PAGE"); //return to home after it is done
					}
					else {
						Iterator<Group> it = viewingUser.getJoinedGroups().iterator();
						int i = 0;
						while(it.hasNext()) {
							Group group = it.next();
							if(++i==comboBox.getSelectedIndex()) {
								Content content = new Content(group, viewingUser, txtTitlefield.getText(), txtTextfield.getText(), picturePath); //create content and specify destination. Constructor automatically adds the content to the destination's container
								Model.setGroupOfInterest(group); //show the group the content has been added to
								Controller.sendEvent("GROUP");
							}
						}
					}
				}
				catch (IllegalArgumentException e) {
					JOptionPane.showConfirmDialog(View.getFrame(), e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION); //if constructor throws IllegalArgumentException, create a popup that informs the user of their error.
				}
			}
		});
	}
	/**
	 * adds the picture at the picturePath to the relevant panel (imagePanel)
	 * @param picturePath path to picture
	 */
	private void displayPicture(String picturePath) {
		imagePanel.removeAll();
		if(picturePath == "")
			imagePanel.add(new JLabel("No picture")); //if no picture is selected, show a label that indicates that no picture is selected
		else
			imagePanel.add(new ResizableImage(new ImageIcon(picturePath))); //add a resizableImage object to the relevant panel
		imagePanel.validate();
		imagePanel.repaint();
	}

}

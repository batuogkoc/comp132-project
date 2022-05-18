package frontend;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import backend.Content;
import backend.Group;
import mvc.Controller;
import mvc.Model;
import mvc.View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

/**
 * GUI panel that allows user to edit a content.
 * @author batu
 *
 */
public class EditContent extends JPanel {
	private JTextField txtTitlefield;
	private JPanel imagePanel; //panel that holds the picture
	private String picturePath = ""; //path to picture. "" means no picture
	private JFileChooser fileChooser; //filechooser is a filed because it retains the last opened directory this way.
	
	/**
	 * Create the GUI that allows the user to edit a profile.
	 * @param content content that will be edited
	 */
	public EditContent(Content content) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 2;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		txtTitlefield = new JTextField();
		txtTitlefield.setEditable(false);
		GridBagConstraints gbc_txtTitlefield = new GridBagConstraints();
		gbc_txtTitlefield.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitlefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitlefield.gridx = 3;
		gbc_txtTitlefield.gridy = 0;
		add(txtTitlefield, gbc_txtTitlefield);
		txtTitlefield.setColumns(10);
		
		imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.gridwidth = 2;
		gbc_imagePanel.gridheight = 2;
		gbc_imagePanel.insets = new Insets(0, 0, 5, 5);
		gbc_imagePanel.fill = GridBagConstraints.BOTH;
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		add(imagePanel, gbc_imagePanel);
		imagePanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblText = new JLabel("Text");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.EAST;
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 2;
		gbc_lblText.gridy = 1;
		add(lblText, gbc_lblText);
		
		JTextPane txtpnTextfield = new JTextPane();
		GridBagConstraints gbc_txtpnTextfield = new GridBagConstraints();
		gbc_txtpnTextfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnTextfield.fill = GridBagConstraints.BOTH;
		gbc_txtpnTextfield.gridx = 3;
		gbc_txtpnTextfield.gridy = 1;
		add(txtpnTextfield, gbc_txtpnTextfield);
		
		JButton btnChangePicture = new JButton("Change Picture");
		GridBagConstraints gbc_btnChangePicture = new GridBagConstraints();
		gbc_btnChangePicture.insets = new Insets(0, 0, 0, 5);
		gbc_btnChangePicture.gridx = 0;
		gbc_btnChangePicture.gridy = 2;
		add(btnChangePicture, gbc_btnChangePicture);
		
		JButton btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 2;
		add(btnDelete, gbc_btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 2;
		add(btnCancel, gbc_btnCancel);
		
		JButton btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.gridx = 3;
		gbc_btnDone.gridy = 2;
		add(btnDone, gbc_btnDone);
		
		picturePath = content.getImagePath(); //get the current path to the image from the content
		//set the relevant fields with the data from the content being edited.
		txtpnTextfield.setText(content.getText());
		txtTitlefield.setText(content.getTitle());
		displayPicture(picturePath); //display current picture
		fileChooser = new JFileChooser(picturePath); //initialise the fileChooser
		
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
		
		//update the content with the new values of all the fields.
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Save changes?", "Saving Changes", JOptionPane.YES_NO_OPTION);//confirm if the changes want to be kept
				if(r == JOptionPane.YES_OPTION) {
					content.setImagePath(picturePath);//update image path
					content.setText(txtpnTextfield.getText());//update text of content
					Controller.sendEvent("HOME PAGE");//take user to the homePage
				}

			}
		});
		
		//Cancel and exit the edit menu
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Quit without saving?", "Cancel Changes", JOptionPane.YES_NO_OPTION);//confirm if user wants to exit
				if(r == JOptionPane.YES_OPTION)
					Controller.sendEvent("HOME PAGE");//take user to the homePage
			}
		});
		
		//Delete the content
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Delete content?", "Deleting content", JOptionPane.YES_NO_OPTION);//confirm if the user wants to delete the content
				if(r == JOptionPane.YES_OPTION) {
					content.delete();//delete content
					Controller.sendEvent("HOME PAGE");//take user to the homePage
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
			imagePanel.add(new JLabel("No picture"));//if no picture is selected, show a label that indicates that no picture is selected
		else
			imagePanel.add(new ResizableImage(new ImageIcon(picturePath)));//add a resizableImage object to the relevant panel
		imagePanel.validate();
		imagePanel.repaint();
	}

}


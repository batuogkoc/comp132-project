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

public class EditContent extends JPanel {
	private JTextField txtTitlefield;
	private JPanel imagePanel;
	private String picturePath = "";
	private JFileChooser fileChooser;
	/**
	 * Create the panel.
	 */
	public EditContent(Content content) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		txtTitlefield = new JTextField();
		txtTitlefield.setEditable(false);
		GridBagConstraints gbc_txtTitlefield = new GridBagConstraints();
		gbc_txtTitlefield.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitlefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitlefield.gridx = 2;
		gbc_txtTitlefield.gridy = 0;
		add(txtTitlefield, gbc_txtTitlefield);
		txtTitlefield.setColumns(10);
		
		imagePanel = new JPanel();
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
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
		gbc_lblText.gridx = 1;
		gbc_lblText.gridy = 1;
		add(lblText, gbc_lblText);
		
		JTextPane txtpnTextfield = new JTextPane();
		GridBagConstraints gbc_txtpnTextfield = new GridBagConstraints();
		gbc_txtpnTextfield.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnTextfield.fill = GridBagConstraints.BOTH;
		gbc_txtpnTextfield.gridx = 2;
		gbc_txtpnTextfield.gridy = 1;
		add(txtpnTextfield, gbc_txtpnTextfield);
		
		JButton btnChangePicture = new JButton("Change Picture");
		GridBagConstraints gbc_btnChangePicture = new GridBagConstraints();
		gbc_btnChangePicture.insets = new Insets(0, 0, 0, 5);
		gbc_btnChangePicture.gridx = 0;
		gbc_btnChangePicture.gridy = 2;
		add(btnChangePicture, gbc_btnChangePicture);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 2;
		add(btnCancel, gbc_btnCancel);
		
		JButton btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.gridx = 2;
		gbc_btnDone.gridy = 2;
		add(btnDone, gbc_btnDone);
		
		picturePath = content.getImagePath();
		txtpnTextfield.setText(content.getText());
		txtTitlefield.setText(content.getTitle());
		displayPicture(picturePath);
		fileChooser = new JFileChooser(picturePath);
		btnChangePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					picturePath = fileChooser.getSelectedFile().getAbsolutePath();
				}
				else {
					picturePath = "";
				}
				displayPicture(picturePath);
			}
		});
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Save changes?", "Saving Changes", JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION) {
					content.setImagePath(picturePath);
					content.setText(txtpnTextfield.getText());
					Controller.sendEvent("HOME PAGE");
				}

			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(View.getFrame(), "Quit without saving?", "Cancel Changes", JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION)
					Controller.sendEvent("HOME PAGE");
			}
		});
	}
	
	private void displayPicture(String picturePath) {
		imagePanel.removeAll();
		if(picturePath == "")
			imagePanel.add(new JLabel("No picture"));
		else
			imagePanel.add(new ResizableImage(new ImageIcon(picturePath)));
		imagePanel.validate();
		imagePanel.repaint();
	}

}


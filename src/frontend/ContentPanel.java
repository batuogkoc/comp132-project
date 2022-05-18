package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import backend.*;
import mvc.Controller;
import mvc.Model;

public class ContentPanel extends JPanel{
	public ContentPanel(Content content) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		User author = content.getAuthor();
		JTextArea name = new JTextArea(author.getName() + " " + author.getSurname() + " (" + author.getNickname()+")");
		name.setLineWrap(true);
		name.setEditable(false);
		JTextArea title = new JTextArea(content.getTitle());
		title.setLineWrap(true);
		title.setEditable(false);
		JTextArea text = new JTextArea(content.getText());
		text.setLineWrap(true);
		text.setEditable(false);
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(Model.getCurrentUser() == content.getAuthor()) {
					Model.setContentOfInterest(content);
					Controller.sendEvent("CONTENT EDIT");
				}
			}
		};
		add(name);
		name.addMouseListener(ma);
		name.setAlignmentX(LEFT_ALIGNMENT);
		add(title);
		title.addMouseListener(ma);
		title.setAlignmentX(LEFT_ALIGNMENT);
		add(text);
		text.addMouseListener(ma);
		text.setAlignmentX(LEFT_ALIGNMENT);

		try {
			ImageIcon image = new ImageIcon(content.getImagePath());
			float aspectRatio = image.getIconWidth()/image.getIconHeight();
			JLabel imageLabel = new JLabel(new ImageIcon(image.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
			add(imageLabel);
			imageLabel.addMouseListener(ma);
			imageLabel.setAlignmentX(LEFT_ALIGNMENT);
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					imageLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(getWidth(), (int)((float)getWidth()/aspectRatio), Image.SCALE_DEFAULT)));
				}
			});
		}
		catch(Exception e){
			System.out.println(e);
		}
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}

package frontend;

import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import backend.*;

public class ContentPanel extends JPanel{
	public ContentPanel(Content content) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		User author = content.getAuthor();
		JTextArea name = new JTextArea(author.getName() + " " + author.getSurname() + " (" + author.getNickname()+")");
		name.setLineWrap(true);
		JTextArea title = new JTextArea(content.getTitle());
		title.setLineWrap(true);
		JTextArea text = new JTextArea(content.getText());
		text.setLineWrap(true);
		
		add(name);
		name.setAlignmentX(LEFT_ALIGNMENT);
		add(title);
		title.setAlignmentX(LEFT_ALIGNMENT);
		add(text);
		text.setAlignmentX(LEFT_ALIGNMENT);
		
		try {
			ImageIcon image = new ImageIcon(getClass().getResource(content.getImagePath()));
			float aspectRatio = image.getIconWidth()/image.getIconHeight();
			JLabel imageLabel = new JLabel(new ImageIcon(image.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
			add(imageLabel);
			imageLabel.setAlignmentX(LEFT_ALIGNMENT);
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					imageLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(getWidth(), (int)((float)getWidth()/aspectRatio), Image.SCALE_DEFAULT)));
				}
			});
		}
		catch(Exception e){
		}
	}
}

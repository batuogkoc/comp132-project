package frontend;

import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class ResizableImage extends JLabel{
	public ResizableImage(ImageIcon image) {
		float imageAspectRatio = image.getIconWidth()/image.getIconHeight();
		setHorizontalAlignment(JLabel.CENTER);
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				float aspectRatio = getWidth()/getHeight();
				if(imageAspectRatio>aspectRatio) {
					setIcon(new ImageIcon(image.getImage().getScaledInstance((int)getWidth(), (int)(getWidth()/imageAspectRatio), Image.SCALE_DEFAULT)));
				}
				else {
					setIcon(new ImageIcon(image.getImage().getScaledInstance((int)(getHeight()*imageAspectRatio), (int)(getHeight()), Image.SCALE_DEFAULT)));
				}
			}
		});
	}	
}

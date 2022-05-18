package frontend;

import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

/**
 * a resizable image object that scales an image into the space the object occupies while preserving the aspect ration of the image
 * @author batu
 *
 */
public class ResizableImage extends JLabel{
	/**
	 * generate the panel that holds the dynamically resizable image
	 * @param image image to be displayed
	 */
	public ResizableImage(ImageIcon image) {
		float imageAspectRatio = image.getIconWidth()/image.getIconHeight(); //aspect ratio of original image
		setHorizontalAlignment(JLabel.CENTER);
		//whenever the object is resized, redraw the image
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				float aspectRatio = getWidth()/getHeight(); //get aspect ratio of the object
				if(imageAspectRatio>aspectRatio) {
					//Scale image to fit it horizontally (add empty space to the top and bottom of image)
					setIcon(new ImageIcon(image.getImage().getScaledInstance((int)getWidth(), (int)(getWidth()/imageAspectRatio), Image.SCALE_DEFAULT)));
				}
				else {
					//Scale image to fit it vertically (add empty space to the sides of the image)
					setIcon(new ImageIcon(image.getImage().getScaledInstance((int)(getHeight()*imageAspectRatio), (int)(getHeight()), Image.SCALE_DEFAULT)));
				}
			}
		});
	}	
}

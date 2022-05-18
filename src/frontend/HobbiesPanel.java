package frontend;

import java.util.*;
import javax.swing.*;

public class HobbiesPanel extends JPanel{

	public HobbiesPanel(Collection<? extends String> hobbies) {
		super();
		ArrayList<JLabel> hobbyLabels = new ArrayList<JLabel>();
		for (String hobby : hobbies) {
			hobbyLabels.add(new JLabel(hobby));
		}
		add(new VerticalScrollPanel(hobbyLabels));
	}
	
}

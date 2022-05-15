package frontend;

import mvc.*;

import java.awt.event.*;

import javax.swing.*;

public class ControllerEventButton extends JButton implements ActionListener{
	private final String controllerEventCode;

	public ControllerEventButton(String text) {
		super(text);
		this.controllerEventCode = text;
		addActionListener(this);
	}
	
	public ControllerEventButton(String text, String controllerEventCode) {
		super(text);
		this.controllerEventCode = controllerEventCode;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Controller.sendEvent(controllerEventCode);
	}
}

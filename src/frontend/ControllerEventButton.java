package frontend;

import mvc.*;

import java.awt.event.*;

import javax.swing.*;

/**
 * a button whose sole purpose is to send its specified event code to the controller
 * @author batu
 *
 */
public class ControllerEventButton extends JButton implements ActionListener{
	private final String controllerEventCode; //which event code this button sends
	
	/**
	 * event code same as the text of the button
	 * @param text text of button
	 */
	public ControllerEventButton(String text) {
		super(text);
		this.controllerEventCode = text;
		addActionListener(this);
	}
	/**
	 * custom event code specified
	 * @param text text of button
	 * @param controllerEventCode which event code this button sends
	 */
	public ControllerEventButton(String text, String controllerEventCode) {
		super(text);
		this.controllerEventCode = controllerEventCode;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Controller.sendEvent(controllerEventCode); //send the event code to the controller
	}
}

package frontend;

import mvc.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

import backend.User;

/**
 * Login view. Also has option to redirect user to account creation page.
 * @author batu
 *
 */
public class Login extends JPanel{
	private final JButton loginButton;
	private final JTextField nicknameTextField;
	private final JTextField passwordTextField;
	private final JButton newAccountButton;
	/**
	 * create the panel that allows the user to login
	 */
	public Login() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel l1 = new JLabel("Nickname: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(l1, gbc);
		JLabel l2 = new JLabel("Password: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(l2, gbc);
		
		nicknameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(nicknameTextField, gbc);
		
		passwordTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(passwordTextField, gbc);
		
		loginButton = new JButton("Login");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(loginButton, gbc);
		
		newAccountButton = new JButton("New Account");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(newAccountButton, gbc);
		
		//if login button pressed, authenticate user. If authenticated, set the model's logged in (currentUser) user parameter and enter the user's homepage
		getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				User authResult = User.authenticateUser(getEnteredNickname(), getEnteredPassword());
				if(authResult != null) {
					Model.setCurrentUser(authResult);//set the logged in user, switch to home page
					Controller.sendEvent("HOME PAGE");
				}
				else {
					JOptionPane.showMessageDialog(View.getFrame(), "Wrong nickname or password", "Alert", JOptionPane.WARNING_MESSAGE); //wrong password or nickname
				}
			}
		});
		
		//if the new account button is pressed, switch to the new account creation menu.
		getNewAccountButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.sendEvent("NEW ACCOUNT");
			}
		});
		
	}
	public String getEnteredPassword() {
		return passwordTextField.getText();
	}
	public String getEnteredNickname() {
		return nicknameTextField.getText();
	}
	public JButton getLoginButton() {
		return loginButton;
	}
	public JButton getNewAccountButton() {
		return newAccountButton;
	}
}

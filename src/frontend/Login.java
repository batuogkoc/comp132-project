package frontend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Login extends JPanel{
	private final JButton loginButton;
	private final JTextField nicknameTextField;
	private final JTextField passwordTextField;
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
		gbc.gridwidth = 2;
		add(loginButton, gbc);
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
}

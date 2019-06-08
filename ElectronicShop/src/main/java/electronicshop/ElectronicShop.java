package electronicshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

import electronicshop.services.AuthService;
import electronicshop.services.ReadingService;
import electronicshop.services.RegService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElectronicShop {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JTextField nuname;
	private JPasswordField newpass;
	private JPasswordField cnpass;
	private AuthService authService;
	private RegService regService;
	
	public ElectronicShop(AuthService authService) {
		this.authService = authService;
		
	}
	
	public ElectronicShop(RegService regService) {
		this.regService = regService;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectronicShop window = new ElectronicShop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ElectronicShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 19));
		frame.setBounds(100, 100, 1098, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter username");
		lblEnterUsername.setFont(new Font("Dialog", Font.BOLD, 19));
		lblEnterUsername.setBounds(72, 170, 170, 67);
		frame.getContentPane().add(lblEnterUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Dialog", Font.BOLD, 19));
		lblEnterPassword.setBounds(74, 262, 156, 35);
		frame.getContentPane().add(lblEnterPassword);
		
		username = new JTextField();
		username.setBounds(303, 187, 229, 35);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(303, 263, 229, 35);
		frame.getContentPane().add(password);
		
		JLabel lblWelcomeToElectroic = new JLabel(" Welcome to electroic shop");
		lblWelcomeToElectroic.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToElectroic.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToElectroic.setBounds(333, 12, 432, 35);
		frame.getContentPane().add(lblWelcomeToElectroic);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usrname = username.getSelectedText();
				String pass = password.getText();
				authService.auth(usrname, pass);
				
				
				
				
			
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 19));
		btnLogin.setBounds(303, 338, 98, 25);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewToOur = new JLabel("New to our shop?");
		lblNewToOur.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewToOur.setBounds(810, 75, 219, 25);
		frame.getContentPane().add(lblNewToOur);
		
		JLabel lblRegisterNow = new JLabel("Register now!!");
		lblRegisterNow.setFont(new Font("Dialog", Font.BOLD, 19));
		lblRegisterNow.setBounds(806, 87, 185, 58);
		frame.getContentPane().add(lblRegisterNow);
		
		JLabel lblNewUsername = new JLabel("New username");
		lblNewUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewUsername.setBounds(632, 169, 178, 53);
		frame.getContentPane().add(lblNewUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPassword.setBounds(642, 214, 113, 64);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConfirmPassword.setBounds(632, 290, 178, 53);
		frame.getContentPane().add(lblConfirmPassword);
		
		nuname = new JTextField();
		nuname.setFont(new Font("Dialog", Font.PLAIN, 19));
		nuname.setBounds(868, 170, 170, 36);
		frame.getContentPane().add(nuname);
		nuname.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setBounds(868, 235, 161, 25);
		frame.getContentPane().add(newpass);
		
		cnpass = new JPasswordField();
		cnpass.setBounds(868, 299, 170, 25);
		frame.getContentPane().add(cnpass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newUser = nuname.getText();
				String newpword = newpass.getText();
				String confimpword = cnpass.getText();
				String finalpass = newpword;
				if(newpword.equals(confimpword)) {
					regService.passwriting(finalpass);
					regService.userwriter(newUser);
					
				}
				}
		});
		btnRegister.setFont(new Font("Dialog", Font.BOLD, 18));
		btnRegister.setBounds(883, 356, 145, 25);
		frame.getContentPane().add(btnRegister);
	}
}

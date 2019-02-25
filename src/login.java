import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.security.Signer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection con;
	private ResultSet resultSet;
	private PreparedStatement ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		super("Login");
		setResizable(false);
		setAlwaysOnTop(true);
		con = ConnectJava.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 3, true), new LineBorder(new Color(255, 0, 0), 2, true)), "Login Page", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(87, 67, 100, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 110, 100, 35);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(204, 74, 153, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Loading Page
				String sql = "select * from Account where Username=? and Password=?";
				try {
				ps = con.prepareStatement(sql);
				ps.setString(1, textField.getText());
				ps.setString(2, passwordField.getText());
				resultSet = ps.executeQuery();
				if(resultSet.next()) {
					resultSet.close();
					ps.close();
					setVisible(false);
					Home home = new Home();
					home.setVisible(true);
				}else {
					JOptionPane.showConfirmDialog(null, "Incoreect Username and Password");
				}
			}catch (Exception ee) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, ee);
			}
				finally {
					try {
						resultSet.close();
						ps.close();
					}
					catch(Exception x) {
						JOptionPane.showMessageDialog(null, "Finally Block");
					}
				}
				}
		});
		btnLogin.setBounds(84, 166, 117, 25);
		btnLogin.setBackground(new Color(0, 128, 0));
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup signup = new Signup();
				signup.setVisible(true);
			}
		});
		btnSignup.setBounds(240, 166, 117, 25);
		btnSignup.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSignup);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 115, 153, 25);
		contentPane.add(passwordField);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBackground(Color.BLUE);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Password_Forget pass_forget = new Password_Forget();
				pass_forget.setVisible(true);
			}
		});
		btnForgotPassword.setBounds(140, 213, 160, 25);
		contentPane.add(btnForgotPassword);
	}
}

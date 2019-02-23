import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JComboBox comboBox;
	private Connection con;
//	private ResultSet resultSet;
	private PreparedStatement ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("App started!!");
					Signup frame = new Signup();
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
	public Signup() {
		super("Create New Account");
		ConnectJava connectJava = new ConnectJava();
		con = ConnectJava.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 80, 70, 20);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(37, 40, 100, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 120, 70, 20);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(37, 160, 140, 20);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(37, 200, 70, 20);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(220, 40, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 80, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your first pet name?", "What is your birth place?", "Who is your best friend?", "Your favorite game?"}));
		comboBox.setBounds(220, 160, 200, 20);
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 120, 150, 20);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 200, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "insert into Account (Username,Name,Password,Security_Question,Answer) values (?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1,textField.getText());	//Username
					ps.setString(2,textField_1.getText());	// Name
					ps.setInt(3,Integer.parseInt(passwordField.getText()));	// Password
					ps.setString(4, (String)comboBox.getSelectedItem());//Security Question
					ps.setString(5,textField_2.getText());
					System.out.println(ps.executeUpdate());
					JOptionPane.showMessageDialog(null, "New Account created");
					ps.close();
					setVisible(false);
				}catch(Exception ee) {
					ee.printStackTrace();
				}
//				connectJava.setVisible(true);
			}
		});
		
		btnCreate.setBounds(47, 232, 117, 25);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login ob  = new login();
				ob.setVisible(true);
			}
		});
		btnCancel.setBounds(253, 232, 117, 25);
		contentPane.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("MenuBar.border"), "New Account", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 205)));
		panel.setBounds(0, 0, 450, 270);
		contentPane.add(panel);
	}
}

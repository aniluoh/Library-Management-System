import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Password_Forget extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					Password_Forget frame = new Password_Forget();
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
	
	public void search() {
		String search_username = textField.getText();
		String sql = "select * from Account where Username='"+search_username+"'";
		try {
			ps = con.prepareStatement(sql);
			resultSet = ps.executeQuery();
			if(resultSet.next()) {
				textField.setText(resultSet.getString(1));
				textField_1.setText(resultSet.getString(2));
				textField_2.setText(resultSet.getString(4));
				resultSet.close();
				ps.close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void retrieve() {
		String a1 = textField.getText();
//		System.out.println(a1);
		String a2 = textField_3.getText();
		String sql = "select Password from Account where Username='"+a1+"'and Answer='"+a2+"'";
//		System.out.println(sql);
		try {
			System.out.println("Hello");
			ps = con.prepareStatement(sql);
			resultSet = ps.executeQuery();
//			System.out.println(resultSet.next());
			if(resultSet.next()) {
//				textField_4.setText(resultSet.getString(3));
				textField_4.setText(resultSet.getString(1));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}
		
		
	public Password_Forget() {
		super("forgot password");
		setResizable(false);
		setAlwaysOnTop(true);
		con = ConnectJava.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 5, true), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(30, 25, 90, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(30, 55, 90, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Security Question");
		lblNewLabel_2.setBounds(30, 85, 140, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(30, 115, 70, 20);
		contentPane.add(lblAnswer);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 145, 70, 20);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(190, 25, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(190, 51, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(190, 82, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 118, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(190, 153, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(333, 25, 100, 20);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login login = new login();
				login.setVisible(true);
			}
		});
		btnBack.setBounds(333, 153, 100, 20);
		contentPane.add(btnBack);
		
		JButton Retrieve = new JButton("Retrieve");
		Retrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retrieve(); 
			}
		});
		Retrieve.setBounds(333, 118, 100, 20);
		contentPane.add(Retrieve);
	}
}

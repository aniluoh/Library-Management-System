import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Connection con;
	private PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("App started!!");
					Student frame = new Student();
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
	public Student() {
		super("Create New Student Account");
		setAlwaysOnTop(true);
		setTitle("Create Account");
		ConnectJava connectJava = new ConnectJava();
		con = ConnectJava.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 3), "New Student", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(60, 30, 100, 18);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(60, 54, 100, 18);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(59, 81, 100, 15);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(59, 108, 70, 15);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(59, 135, 70, 15);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(59, 162, 70, 15);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(59, 189, 70, 15);
		contentPane.add(lblSemester);
		
		textField = new JTextField();
		
		
		S_writer s_id = new S_writer();
		String update = s_id.studentId();
		textField.setText(update);
		textField.setBounds(225, 30, 150, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 57, 150, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 81, 150, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Course", "BCA", "BSc", "B-Tech", "MCA", "MSc", "M-Tech", "Phd"}));
		comboBox.setBounds(225, 108, 150, 18);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Branch", "AE", "AI", "CA", "CS", "IT", "ME"}));
		comboBox_1.setBounds(225, 135, 150, 18);
		contentPane.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 162, 150, 18);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(225, 189, 150, 18);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String sql = "Insert into Student(StudentId,Name,FatherName,Course,Branch,Year,Semester)values(?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				System.out.println("Hello");
				ps.setInt(1, Integer.parseInt(textField.getText()));
				ps.setString(2,textField_1.getText());
				ps.setString(3, textField_2.getText());
				ps.setString(4, (String)comboBox.getSelectedItem());
				ps.setString(5, (String)comboBox_1.getSelectedItem());
				ps.setInt(6, Integer.parseInt(textField_3.getText()));
				ps.setInt(7, Integer.parseInt(textField_4.getText()));
				System.out.println(ps.executeUpdate());
				JOptionPane.showMessageDialog(null, "New Student account has been created.");
				ps.close();
				setVisible(false);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
				}
			
		});
		btnRegister.setBackground(new Color(0, 128, 0));
		btnRegister.setBounds(70, 225, 117, 25);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(245, 225, 120, 25);
		contentPane.add(btnBack);
	}

}

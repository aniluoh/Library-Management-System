import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class Return extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet resultSet; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
//	Fetching the data from IssueBook Table.
	public void searchBookID() {
		String searchBookID = textField.getText();
//		System.out.println("serching block");
		String sql = "select * from IssueBook where BookID='"+searchBookID+"'";
		try {
			ps = con.prepareStatement(sql); // Problem is arises from here...
			resultSet = ps.executeQuery();
			if(resultSet.next()) {
				textField_1.setText(resultSet.getString(2));
				textField_2.setText(resultSet.getString(3));
				textField_3.setText(resultSet.getString(4));
				textField_4.setText(resultSet.getString(5));
				textField_5.setText(resultSet.getString(6));
//				textField_6.setText(resultSet.getString(7)); // It should show the date 
				textField_8.setText(resultSet.getString(7)); // StudentID
				textField_9.setText(resultSet.getString(8));
				textField_10.setText(resultSet.getString(9));
				textField_11.setText(resultSet.getString(10));
				textField_12.setText(resultSet.getString(11));
				textField_13.setText(resultSet.getString(12));
				textField_14.setText(resultSet.getString(13));
			}
		}catch(Exception e) {
//			System.out.println("catch Block ");
			e.printStackTrace();
		}
	}
	
// Deleting record from IssueBook Table;
	public void returnBook() {
		String bookID = textField.getText();
		String returnBook = "delete from IssueBook where BookID='"+bookID+"'";
		try {
			ps = con.prepareStatement(returnBook); 
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Book has been returned sucessfully");
		}catch(Exception e) {
			System.out.println("Catch Block");
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Return() {
		setResizable(false);
		setAlwaysOnTop(true);
		con = ConnectJava.connectDB();
		setTitle("Return");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 3), "Return Book ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Book ID");
		lblStudentId.setBounds(81, 35, 100, 20);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(81, 65, 100, 20);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Edition");
		lblFatherName.setBounds(81, 95, 100, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblNewLabel = new JLabel("Publisher");
		lblNewLabel.setBounds(81, 125, 70, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblBranch = new JLabel("Price");
		lblBranch.setBounds(81, 155, 100, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Pages");
		lblYear.setBounds(81, 185, 100, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Date of Issue");
		lblSemester.setBounds(81, 215, 100, 20);
		contentPane.add(lblSemester);
		
		JLabel lblReurnDate = new JLabel("Reurn Date");
		lblReurnDate.setBounds(290, 260, 90, 20);
		contentPane.add(lblReurnDate);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook();
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnReturn.setBounds(252, 295, 117, 25);
		contentPane.add(btnReturn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(529, 295, 117, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(245, 35, 65, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 65, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 95, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 125, 150, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 155, 150, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(245, 185, 150, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(245, 215, 150, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		textField_7.setText(timeStamp);
		textField_7.setBounds(422, 260, 114, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblBookId = new JLabel("Student ID");
		lblBookId.setBounds(496, 35, 80, 20);
		contentPane.add(lblBookId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(496, 65, 70, 19);
		contentPane.add(lblName_1);
		
		JLabel lblEdition = new JLabel("Father Name");
		lblEdition.setBounds(496, 95, 95, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Course");
		lblPublisher.setBounds(496, 125, 70, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Branch");
		lblPrice.setBounds(496, 155, 70, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Year");
		lblPages.setBounds(496, 185, 70, 20);
		contentPane.add(lblPages);
		
		JLabel lblDateOfIssue = new JLabel("Semester");
		lblDateOfIssue.setBounds(496, 215, 110, 20);
		contentPane.add(lblDateOfIssue);
		
		textField_8 = new JTextField();
		textField_8.setBounds(645, 35, 114, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(645, 65, 114, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(645, 95, 114, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(645, 125, 114, 19);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(645, 155, 114, 19);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(645, 185, 114, 19);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(645, 215, 114, 19);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookID();
			}
		});
		btnNewButton.setBounds(310, 35, 85, 20);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 3), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(35, 23, 389, 225);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 3), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(422, 23, 355, 225);
		contentPane.add(panel_1);
	}
}

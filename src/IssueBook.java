import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class IssueBook extends JFrame {

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
					IssueBook frame = new IssueBook();
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
	public void searchBook() {
		String search_BookId = textField_13.getText();
		String sql = "select * from Book where BookId='"+search_BookId+"'";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			resultSet = ps.executeQuery();
			if(resultSet.next()) {
//				textField.setText(resultSet.getText());
//				textField_1.setText(resultSet.getText());
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public IssueBook() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 3, true), "Issue Book", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setBounds(70, 70, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(70, 105, 70, 20);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(70, 140, 70, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(70, 175, 100, 20);
		contentPane.add(lblPublisher);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 70, 15);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(70, 210, 70, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(70, 245, 70, 20);
		contentPane.add(lblPages);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(270, 70, 85, 20);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(200, 245, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 106, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 141, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 175, 150, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 210, 150, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setBounds(436, 70, 100, 20);
		contentPane.add(lblStudentId_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(436, 105, 70, 20);
		contentPane.add(lblName_1);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(436, 140, 100, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(436, 175, 70, 20);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(436, 210, 70, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(436, 245, 70, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(436, 280, 70, 20);
		contentPane.add(lblSemester);
		
		textField_5 = new JTextField();
		textField_5.setBounds(566, 70, 150, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(566, 106, 150, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(566, 140, 150, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setBounds(566, 175, 150, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setText("");
		textField_9.setBounds(566, 210, 150, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setText("");
		textField_10.setBounds(566, 245, 150, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setText("");
		textField_11.setBounds(566, 280, 150, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setBounds(190, 320, 120, 20);
		contentPane.add(lblDateOfIssue);
		
		textField_12 = new JTextField();
		textField_12.setBounds(350, 320, 150, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.setBackground(new Color(0, 128, 0));
		btnIssue.setBounds(164, 352, 117, 25);
		contentPane.add(btnIssue);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(371, 352, 117, 25);
		contentPane.add(btnBack);
		
		textField_13 = new JTextField();
		textField_13.setBounds(200, 70, 70, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 100, 0), 3, true), "Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(36, 40, 365, 266);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 100, 0), 3, true), "Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(402, 40, 340, 266);
		contentPane.add(panel_1);
	}
}
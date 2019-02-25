import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
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

	/**
	 * Create the frame.
	 */
	public Return() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Return");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 3), "Return Book ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(81, 23, 100, 17);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(81, 48, 100, 17);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(81, 75, 100, 17);
		contentPane.add(lblFatherName);
		
		JLabel lblNewLabel = new JLabel("Course");
		lblNewLabel.setBounds(81, 98, 70, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(81, 123, 100, 17);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(81, 148, 100, 17);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(81, 171, 100, 17);
		contentPane.add(lblSemester);
		
		JLabel lblReurnDate = new JLabel("Reurn Date");
		lblReurnDate.setBounds(258, 221, 90, 17);
		contentPane.add(lblReurnDate);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(252, 285, 117, 25);
		contentPane.add(btnReturn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBounds(529, 285, 117, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(245, 22, 150, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 47, 150, 17);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 74, 150, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 97, 150, 17);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 122, 150, 17);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(245, 147, 150, 17);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(245, 170, 150, 17);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		textField_7.setText(timeStamp);
		textField_7.setBounds(417, 221, 114, 17);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(496, 24, 70, 15);
		contentPane.add(lblBookId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(496, 49, 70, 15);
		contentPane.add(lblName_1);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(496, 76, 70, 15);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(496, 99, 70, 15);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(496, 124, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(496, 149, 70, 15);
		contentPane.add(lblPages);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setBounds(496, 172, 110, 15);
		contentPane.add(lblDateOfIssue);
		
		textField_8 = new JTextField();
		textField_8.setBounds(645, 22, 114, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(645, 47, 114, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(645, 74, 114, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(645, 97, 114, 19);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(645, 122, 114, 19);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(645, 147, 114, 19);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(645, 170, 114, 19);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 5), "Home", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Book book = new Book();
				book.setVisible(true);
			}
		});
		btnAddBook.setBounds(153, 283, 130, 30);
		contentPane.add(btnAddBook);
		
		JButton btnNewStudent = new JButton("Add Student");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student student = new Student();
				student.setVisible(true);
			}
		});
		btnNewStudent.setBounds(424, 283, 130, 30);
		contentPane.add(btnNewStudent);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IssueBook issueBook = new IssueBook();
				issueBook.setVisible(true);
			}
		});
		btnIssueBook.setBounds(153, 405, 130, 30);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Return returnBook = new Return();
				returnBook.setVisible(true);
			}
		});
		btnReturnBook.setBounds(424, 405, 130, 30);
		contentPane.add(btnReturnBook);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3, true), "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel.setBounds(118, 225, 463, 110);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3, true), "Action", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_1.setBounds(118, 348, 463, 123);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionText);
		panel_2.setBounds(12, 12, 686, 208);
		contentPane.add(panel_2);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Library Management System");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 25, 665, 170);
		panel_2.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login login = new login();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(120, 483, 85, 25);
		contentPane.add(btnLogout);
		
	}
}

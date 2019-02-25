import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private PreparedStatement ps;
	private Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {
		super("Add new Book");
		setAlwaysOnTop(true);
		ConnectJava connectJava = new ConnectJava();
		con = ConnectJava.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 5), "Add Book", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Id");
		lblNewLabel.setBounds(50, 35, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 65, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(50, 95, 70, 15);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(50, 125, 70, 15);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(50, 155, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(50, 185, 70, 15);
		contentPane.add(lblPages);
		
		/*JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String sql ="insert into Book(BookId,Name,Edition,Publisher,Price,Pages)values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1,Integer.parseInt(textField.getText()));
				ps.setString(2,textField_1.getText());
				ps.setString(3,(String)comboBox.getSelectedItem());
//				ps.setString(4, (String)comboBox.getSelectedItem());
				ps.setString(4, textField_3.getText());
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			}
		});*/
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(255, 220, 117, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		Book_Writer  bWriter = new Book_Writer();
		String update = bWriter.bookId();
		textField.setText(update);
		textField.setBounds(220, 35, 175, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 65, 175, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(220, 95, 175, 24);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 125, 175, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 155, 175, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(220, 185, 175, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String sql ="insert into Book(BookId,Name,Edition,Publisher,Price,Pages)values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1,Integer.parseInt(textField.getText()));
				ps.setString(2,textField_1.getText());
				ps.setString(3,(String)comboBox.getSelectedItem());
//				ps.setString(4, (String)comboBox.getSelectedItem());
				ps.setString(4, textField_2.getText());
				ps.setInt(5, Integer.parseInt(textField_3.getText()));
				ps.setInt(6,Integer.parseInt(textField_4.getText()));
				ps.executeUpdate();
				ps.close();
				JOptionPane.showMessageDialog(null, "Book added sucessfully");
				setVisible(false);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnAdd.setBounds(70, 220, 117, 25);
		contentPane.add(btnAdd);
	}
}

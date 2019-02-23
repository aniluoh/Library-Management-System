import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
*	@Author 			: Anil Chaurasiya
*	Email   			: achaurasiya59@gmail.com
*	LinkedIn 			: www.linkedin.com/in/anilchaurasiya/
*	Date 				: 
*	Problem Statement   : 
*/
public class ConnectJava {
	Connection con;
	public static Connection connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS","root","root");
			System.out.println("Connection Established");
			return con;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static void main(String[] args) {
//		System.out.print("Heelo");
	}
}

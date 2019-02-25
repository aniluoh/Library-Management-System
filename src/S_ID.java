import java.io.File;
import java.util.Scanner;

public class S_ID {
	int input;
	public String doIncrement() {
		File file = new File("Student_ID.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				input = sc.nextInt();
				System.out.println(input);
				input++;
			}
		}catch(Exception e) {
			System.out.println("File not found ");
		}
//		System.out.println(String.valueOf(input));
		return String.valueOf(input);
	}
}
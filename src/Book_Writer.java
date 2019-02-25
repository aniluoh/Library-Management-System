import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Book_Writer {

	public String bookId(){
		// TODO Auto-generated method stub
		S_ID sid= new S_ID();
		String update = sid.doIncrement();
		Writer wr;
		try {
			wr = new FileWriter("Student_ID.txt");
			wr.write(update);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(update);
	}
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Book_Writer {

	public String bookId(){
		// TODO Auto-generated method stub
		Book_ID bookID= new Book_ID();
		String update = bookID.doIncrement();
		Writer wr;
		try {
			wr = new FileWriter("BookID.txt");
			wr.write(update);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(update);
	}
}

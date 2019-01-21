package file_features;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendToFile {
	public static void main(String[] args) {
		try {
			FileWriter  fileWriter = new FileWriter("C:/App Home/output.txt", true);
			PrintWriter pw = new PrintWriter(fileWriter);
			pw.println("Rahul 99");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

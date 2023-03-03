package exercise7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class CopyFile {
	public static void main(String[] args) {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/input.txt"));
			outputStream = new PrintWriter(new FileWriter("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/output.txt"));

			String l;
			try {
				while ((l = inputStream.readLine()) != null) {
					outputStream.println(l);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}

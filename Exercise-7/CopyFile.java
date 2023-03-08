package exercise7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class CopyFile {
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/input.txt"));
			writer = new PrintWriter(new FileWriter("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/output.txt"));

			String l;
			try {
				while ((l = reader.readLine()) != null) {
					writer.println(l);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}

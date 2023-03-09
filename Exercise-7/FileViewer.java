package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileViewer {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader (new FileReader ("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/sample.txt"))) {
			
			String input;
			while((input = reader.readLine())!=null) {
				System.out.println(input);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

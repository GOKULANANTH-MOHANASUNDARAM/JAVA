package exercise7;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CountTheNumberOfWords {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		int count = 0;
		try(BufferedReader reader = new BufferedReader(new StringReader(string))){
			String str;
			while((str = reader.readLine())!=null) {
				String[] words = str.split("\\s+");
				count += words.length;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("No.of words " + count);
		scanner.close();
	}

}

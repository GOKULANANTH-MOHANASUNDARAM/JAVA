package exercise7;

import java.io.File;

public class Java11 {
	public static void main(String[] args) {
		File file = new File("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/day1");
		if (file.isDirectory()) {
			String string[] = file.list();
			for (int i = 0; i < string.length; i++) {
				System.out.println(string[i]);
			}
		}
	}
}

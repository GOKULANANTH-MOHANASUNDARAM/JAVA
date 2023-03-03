package exercise7;

import java.io.File;
import java.io.IOException;

public class Java10 {
	public static void main(String[] args) {
		//toDelete();
		//toRename();
		toDisplaySize();
	}
	
	static void toDelete() {
		File file = new File("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/fileDelete.txt");
		try {
			while (true) {
				if (file.delete()) 
				{
					System.out.println(file.getName() + " deleted");
					return;
				} else {
					file.createNewFile();
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void toRename() {
		File file = new File("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/rename.txt");
		File changeFileName = new File("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/fileRename.txt");
		try {
			file.createNewFile();
			if (file.renameTo(changeFileName)) {
				System.out.println("File name succesfully changed");
			} else {
				System.out.println("Rename failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void toDisplaySize() {
		try {
			File file = new File("/Users/gokulananth/eclipse-workspace/Java-Exercise/src/exercise7/displaySize.txt");
			System.out.println(file.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

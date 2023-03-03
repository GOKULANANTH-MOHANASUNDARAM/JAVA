package exercise7;

import java.io.FileReader;
import java.io.FileWriter;

public class SourceToDestination {
	public static void main(String[] args) {
		try(FileReader reader =new FileReader("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/source.txt");
				FileWriter writer =new FileWriter("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/destination.txt")){
				int a;
				while((a=reader.read())!=-1) {
					writer.write(a);
				}
				System.out.println("file copied");
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

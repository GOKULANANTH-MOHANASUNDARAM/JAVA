package exercise7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DataObject {
	public static void main(String[] args) {
		try(ObjectOutputStream outputStream =new ObjectOutputStream(new FileOutputStream("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/Date.txt"))){
			Date date=new Date();
			outputStream.writeObject(date);
			System.out.println("written to file");
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/Date.txt"))){
			Date date=(Date)inputStream.readObject();
			System.out.println("Object read from file " + date);
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
}

package day4;

import java.io.FileReader;
import java.io.IOException;

public class ThrowIOException {
	public static void main(String[] args) throws IOException{
		ThrowException te = new ThrowException();
		//te.throwIO();
		te.sample();
	}
}

class ThrowException{
//	public void throwIO() throws IOException {
//		throw new IOException("IOException occured");
//	}
	public void sample() throws IOException {
		FileReader newfile = new FileReader("Exceptions.txt");
		System.out.println(newfile.read());
		newfile.close();
	}
}

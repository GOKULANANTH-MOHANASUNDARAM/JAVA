package day4;

import java.io.*;

public class Java2 {
	public static void main(String[] p) {
		Java2 reference = new Java2();
		reference.callThrowException();
	}
	public void callThrowException() {
		throwException();
		System.out.println("Caller");
	}
	public void throwException() {
		try {
			throw new IOException("Error Occured");
			return;
		}
		catch (Exception e) {
			System.out.println("catch-mth-2");
		}
		finally {
			System.out.println("Finally-mth2");
		}
	}
}

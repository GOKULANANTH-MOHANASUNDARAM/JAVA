package day4;

import java.io.*;

public class Java2 {
	public static void main(String[] p) {
		Java2 s = new Java2();
		s.mth1();
	}
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public void mth2() {
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

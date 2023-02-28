package day4;

import java.io.IOException;

public class ReplaceSystemJava2 {
	public static void main(String[] args) {
		ReplaceSystemJava2 s = new ReplaceSystemJava2();
		s.mth1();
	}
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public void mth2() {
		try {
			throw new IOException("Error Occured");
			System.exit(0);
		}
		catch (Exception e) {
			System.out.println("catch-mth-2");
		}
		finally {
			System.out.println("Finally-mth2");
		}
	}
}

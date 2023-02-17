package day1;

import java.util.Scanner;

public class TypeCasting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number that should be under -127 to 128: ");
		byte b = sc.nextByte();
		System.out.println("\nEnter a number that should be under");
		double d1 = sc.nextDouble();
		widening(b);
		narrowing(d1);
		sc.close();
	}
		
		public static void widening(byte b) {
			//byte -> short -> char -> int -> long -> float -> double
			System.out.print("SHORT: ");
			short s = b;
			System.out.println(s);
			System.out.print("CHAR: ");
			char c = (char)b;
			System.out.println(c);
			System.out.print("INT: ");
			int i = b;
			System.out.println(i);
			System.out.print("LONG: ");
			long l = b;
			System.out.println(l);
			System.out.print("FLOAT: ");
			float f = b;
			System.out.println(f);
			System.out.print("DOUBLE: ");
			double d = b;
			System.out.println(d);
		}
		
		public static void narrowing(double d1) {
			//double -> float -> long -> int -> char -> short -> byte
			System.out.print("FLOAT: ");
			float f1 = (float)d1;
			System.out.println(f1);
			System.out.print("LONG: ");
			long l1 = (long)d1;
			System.out.println(l1);
			System.out.print("INT: ");
			int i1 =(int)d1;
			System.out.println(i1);
			System.out.print("CHAR: ");
			char c1 = (char)d1;
			System.out.println(c1);
			System.out.print("SHORT: ");
			short s1 = (short) d1;
			System.out.println(s1);
			System.out.print("BYTE: ");
			byte b1 = (byte) d1;
			System.out.println(b1);
		}
}

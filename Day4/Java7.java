package day4;

import java.util.Scanner;

public class Java7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char numerator, denominator;
		while(true) {
				System.out.println("Enter numerator: ");
				numerator = scanner.next().charAt(0);
				if(ch == 'q'||ch == 'Q'){
					System.exit(0);
				}
				System.out.println("Enter denominator: ");
				denominator = scanner.next().charAt(0);
				divide(Integer.parseInt(numerator), Integer.parseInt(denominator));
		}
			
	}
	
	static void divide(int numerator, int denominator) {
		float result;
		try {
			result = (float) numerator/denominator;
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

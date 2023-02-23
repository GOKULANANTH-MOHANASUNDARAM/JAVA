package day4;

import java.util.Scanner;

public class Java7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char numerator, denominator;
		Exit exit = new Exit();
		Division division = new Division();
		while(true) {
				System.out.println("Enter numerator: ");
				numerator = sc.next().charAt(0);
				exit.checkCharacter(numerator);
				System.out.println("Enter denominator: ");
				denominator = sc.next().charAt(0);
				division.divide(numerator-'0', denominator-'0');
		}
			
	}

}

class Exit{
	void checkCharacter(char ch) {
		if(ch == 'q'||ch == 'Q')
			System.exit(0);
	}
}

class Division{
	void divide(int numerator, int denominator) {
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

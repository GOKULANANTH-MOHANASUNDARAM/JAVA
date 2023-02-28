package day4;

import java.util.Scanner;

public class FormatException {

	public static void main(String args[]) throws Exception{

		Scanner scanner = new Scanner(System.in);
		int average = 0;
		while(average == 0) {
			try {
			
				System.out.println("Enter mark of subject 1 (Tamil) : ");
				String sub1 = scanner.nextLine();
				int subject1 = Integer.parseInt(sub1);
		
				System.out.println("Enter mark of subject 2 (English): ");
				String sub2 = scanner.nextLine();
				int subject2 = Integer.parseInt(sub2);
				
				System.out.println("Enter mark of subject 3 (Maths) : ");
				String sub3=scanner.nextLine();
				int subject3 = Integer.parseInt(sub3);

				System.out.println("Enter mark of subject 4 (Science) : ");
				String sub4=scanner.nextLine();
				int subject4 = Integer.parseInt(sub4);

				System.out.println("Enter mark of subject 5 (Social Science)");
				String sub5=scanner.nextLine();
				int subject5 = Integer.parseInt(sub5);

		
				average = (subject1 + subject2 + subject3 + subject4 + subject5) / 5;
				System.out.println("Average Mark is " + average);
			
			}
			catch(NumberFormatException e) {
				System.out.println(e);
			}
		
		}
		sc.close();
	}
}

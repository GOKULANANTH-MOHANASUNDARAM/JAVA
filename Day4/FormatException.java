package day4;

import java.util.Scanner;

public class FormatException {

	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		int average = 0;
		while(average == 0) {
			try {
			
				System.out.println("Enter mark of subject 1 (Tamil) : ");
				String sub1 = sc.nextLine();
				int subject_1 = Integer.parseInt(sub1);
		
				System.out.println("Enter mark of subject 2 (English): ");
				String sub2 = sc.nextLine();
				int subject_2 = Integer.parseInt(sub2);
				
				System.out.println("Enter mark of subject 3 (Maths) : ");
				String sub3=sc.nextLine();
				int subject_3 = Integer.parseInt(sub3);

				System.out.println("Enter mark of subject 4 (Science) : ");
				String sub4=sc.nextLine();
				int subject_4 = Integer.parseInt(sub4);

				System.out.println("Enter mark of subject 5 (Social Science)");
				String sub5=sc.nextLine();
				int subject_5 = Integer.parseInt(sub5);

		
				average=(subject_1+subject_2+subject_3+subject_4+subject_5)/5;
				System.out.println("Average Mark is "+average);
			
			}
			catch(NumberFormatException e) {
				System.out.println(e);
			}
		
		}
		sc.close();
	}
}

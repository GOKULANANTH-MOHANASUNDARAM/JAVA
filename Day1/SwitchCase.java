package day1;

//import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		//Scanner sc= new Scanner(System.in);
		while(true) {
			//System.out.println("\nEnter the year: ");
			//int year = sc.nextInt();
			//System.out.println("Enter the month (in numbers): ");
			//int month = sc.nextInt();
			int year = 2020, month = 2;
			display(year, month);
		}
	}
	
	static void display(int year, int month) {
		switch(month) {
			case 1:
				System.out.println("January: 31");
				break;
			case 2:
				if((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0) {
					System.out.println("Febrauary: 29");
				}
				else {
					System.out.println("Febrauary: 28");
				}
				break;
			case 3:
				System.out.println("March: 31");
				break;
			case 4:
				System.out.println("April: 30");
				break;
			case 5:
				System.out.println("May: 31");
				break;
			case 6:
				System.out.println("June: 30");
				break;
			case 7:
				System.out.println("July: 31");
				break;
			case 8:
				System.out.println("August: 31");
				break;
			case 9:
				System.out.println("September: 30");
				break;
			case 10:
				System.out.println("October: 31");
				break;
			case 11:
				System.out.println("November: 30");
				break;
			case 12:
				System.out.println("December: 31");
				break;
			default:
				System.out.println("Wrong month... do it right");
		}
	}
}

package day1;

import java.util.Scanner;

public class CalculateMaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to invest: ");
		float investment = sc.nextFloat();
		System.out.println("Total amount invested is: " + investment);
		investment += investment * 0.4f; // 1st year
		investment -= 1500f; // 2nd year
		investment += investment * 0.12f; // 3rd year
		System.out.println("Amount after three years is: " + investment);
		sc.close();
	}
}

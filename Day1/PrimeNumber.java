package day1;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the nth value: ");
		int number1 = sc.nextInt();
		Prime prime = new Prime(number);
		prime.finishprime();
		System.out.println();
		System.out.println("Enter the value to check Armstrong number or Perfect number or Palindrome or none of these");
		int number2 = sc.nextInt();
		ThreeInOne t = new ThreeInOne(number2);
		t.finishall();
		sc.close();
	}
}

class Prime{
	public Prime(int number) {
		System.out.println("prime number b/w 1 to " + number + "are: ");
		for(int i=2; i<=number; i++) {
			int count = 0;
			for(int j=2; j<=i/2; j++) {
				if(i%j == 0) {
					count=1;
					break;
				}
			}
			if(count==0){
				System.out.print(i + " ");
			}
		}
	}
	public void finishprime() {
		System.out.println("\n\nNext Checkout for Armstrong number or Perfect number or Palindrome or none of these");
	}
}

class ThreeInOne{
	public ThreeInOne(int number) {
		checkArmstrong(number);
		checkPerfectNumber(number);
		checkPalindrome(number);
		checkNone(number);
	}
	
	public static void checkArmstrong(int n) {
		int copy = n, remainder = 0, number = 0, flag = 0;
		while(copy != 0) {
			remainder = copy%10;
			number += Math.pow(remainder, 3);
			copy/=10;
		}
		if(number == n) {
			System.out.println("\n" + n + " is an armstrong number");
		}
		else {
			System.out.println(n + " is not an armstrong number");
			flag = 1;
		}
	}
	
	public static void checkPerfectNumber(int n){
		int copy = n, sum = 0, flag = 1;
		for(int i=1; i<=copy/2; i++) {
			if(copy%i==0) {
				sum+=i;
			}
		}
		if(sum == n) {
			System.out.println(n + " is a perfect number");
		}
		else {
			System.out.println(n + " is not a perfect number");
			flag = 1;
		}
	}
	
	public static void checkPalindrome(int n) {
		int copy=n, reverse = 0, remainder = 0, flag = 0;
		while(copy!=0) {
			remainder = copy%10;
			reverse = remainder+(reverse * 10);
			copy/=10;
		}
		if(reverse == n) {
			System.out.println(n + " is a palindrome");
		}
		else {
			System.out.println(n + " is not a palindrome");
			flag=1;
		}
	}
	
	public static void checkNone(int number){
		int flag1, flag2, flag3;
		static void referArmstrong(int flag1){
			this.flag1 = flag1;
		}
		static void referPerfectNumber(int flag2){
			this.flag2 = flag2;
		}
		static void referPalindrome(int flag3){
			this.flag3 = flag3;
		}
		if(flag1 == 0 && flag2 == 0 && flag3 == 0){
			System.out.print("None of These");
		}
	}
	
	public void finishall() {
		System.out.println("\nProgram finished...");
	}
}



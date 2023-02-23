package day1;

import java.util.Scanner;

public class PresentOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the array elements");
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Enter the value to find: ");
		int number = sc.nextInt();
		findInt(n, array, number);
		sc.close();
	}
	
	public static void findInt(int n, int[] array, int find) {
		int flag = 0, count=0;
		System.out.println("Output: ");
		for(int i=0; i<array.length; i++) {
			if(find == array[i]) {
				++count;
				System.out.println("Index: " + i);
				flag = 1;
			}
		}
		if(flag==0) {
			System.out.println("Not Found");
		}
		System.out.println("total Count: " + count);
	}
}

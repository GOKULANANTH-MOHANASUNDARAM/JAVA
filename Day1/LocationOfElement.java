package day1;

import java.util.Scanner;

public class LocationOfElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Implement the array: ");
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		int flag = 0;
		System.out.println("Enter the number to find: ");
		int find = sc.nextInt();
		for(int i=0; i<array.length; i++) {
			if(find == array[i]) {
				System.out.println("Output: " + i);
				flag = 1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("Not Found");
		}
		sc.close();
	}
}

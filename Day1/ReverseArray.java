package day1;

import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Implement the array: ");
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Output: ");
		for(int i=array.length-1; i>=0; i--) {
			System.out.print(array[i]+" ");
		}
		sc.close();
	}
}

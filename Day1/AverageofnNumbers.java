package day1;

import java.util.Scanner;
public class AverageofnNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n size: ");
		int n = sc.nextInt();
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		average(array, n);
		sc.close();
	}
	public static void average(int[] array, int n) {
		int sum = 0;
		for(int i=0; i<array.length; i++) {
			sum+=array[i];
		}
		double avg = 0.0d;
		avg = sum/n;
		System.out.print(avg);
	}
}

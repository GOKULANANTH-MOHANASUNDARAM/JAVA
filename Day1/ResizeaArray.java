package day1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Array size cannot be decreased but can be increased...
 * But even though we cannot increase it as for the length of "int" too...
 */
public class ResizeaArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Implement the array: ");
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Enter the size to resize the array: ");
		int arrayresize = sc.nextInt();
		array = Arrays.copyOf(array, arrayresize);
		System.out.println("Output: ");
		for(int i=0; i<array.length; i++) {
		System.out.print(array[i]+" ");}
		sc.close();
	}
}

package day1;

import java.util.Scanner;

public class TwoDArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row-size: ");
		int row = sc.nextInt();
		int matrix[][] = new int[row][];
		for(int i=0; i<row; i++) {
			matrix[i] = new int[i+1];
			for(int j=0; j<i+1; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		display(row, matrix);
		sc.close();
	}
	public static void display(int row, int[][] matrix) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}

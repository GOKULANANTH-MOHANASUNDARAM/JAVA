package day1;

import java.util.Scanner;

public class Reverse2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row-size: ");
		int row = sc.nextInt();
		System.out.println("Enter the column-size: ");
		int column = sc.nextInt();
		int matrix[][] = new int[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		display(row, column, matrix);
		sc.close();
	}
	public static void display(int row, int column, int[][] matrix) {
		for(int i=0; i<row; i++) {
			int left = 0, right = column-1;
			while(left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}

package exercisee;

import java.util.Scanner;

public class exp20 {
static Scanner sc=new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("Enter the size of matrix");
	int r=sc.nextInt();
	int c=sc.nextInt();
	System.out.println("Enter the elements in matrix");
	int arr[][]=new int[r][c];
	for(int i=0;i<r;i++) {
		for(int j=0;j<c;j++) {
			arr[i][j]=sc.nextInt();
			}
	}
	int max;
	for(int i=0;i<r;i++) {
		max=arr[i][0];
		for(int j=0;j<c;j++) {
			if(arr[i][j]>max)
				max=arr[i][j];
		}
		System.out.println("Largest element in "+i+"row is :"+max);
	}

}

}

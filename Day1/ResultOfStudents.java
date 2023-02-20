package day1;

import java.util.Scanner;

public class ResultOfStudents {
	public static void main(String[] args) {
		//subjects -> maths, physics, chemistry, biology, tamil, english
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of Students: ");
		int students = sc.nextInt();
		System.out.println("Enter the no. of subjects: ");
		int subjects = sc.nextInt();
		int marks[][] = new int[students][subjects];
		System.out.println("Enter the Marks: ");
		for(int i=0; i<students; i++) {
			for(int j=0; j<subjects; j++) {
				marks[i][j] = sc.nextInt();
			}
		}
		calculate(students, subjects, marks);
		sc.close();
	}
	public static void calculate(int students, int subjects, int[][] marks) {
		int stu_reference = 1;
		for(int i=0; i<students; i++) {
			int result=0;
			System.out.println("Marks: <mat> <phy> <chem> <bio> <tam> <eng>");
			for(int j=0; j<subjects; j++) {
				System.out.print(marks[i][j] + " ");
				result += marks[i][j];
			}
			System.out.println("\nstudent reference: " + stu_reference + "\tResult: " + result);
			stu_reference++;
		}
	}
}
package day2;

import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		Result.sc=new Scanner(System.in);
		Result ans=new Result();
		ans.getDetails();
		ans.getMarks();
		ans.getTotal();
	}
}

class Student{
	public static Scanner sc;
	public String name;
	public String regno;
	public int rollno;
	
	public void getDetails() {
		System.out.println("Enter the Student's name:");
		name=sc.next();
		System.out.println("Enter his regno:");
		regno=sc.next();
		System.out.println("Enter his rollno:");
		rollno=sc.nextInt();
	}
}

class Exam extends Student{
	public int maths, physics, chemistry;
	
	public void getMarks() {
		System.out.println("Enter the marks of " + regno + " :");
		maths=sc.nextInt();
		physics=sc.nextInt();
		chemistry=sc.nextInt();
	}
}

class Result extends Exam{
	public int total;
	public float avg;
	
	public void getTotal() {
		total = maths + physics + chemistry;
		avg = average(total);
		System.out.println("Total marks of " + name + "(" + regno + "):" + total);
		System.out.println("His average is: " + avg);
	}
	public float average(int total) {
		avg = total/3;
		return avg;
	}
}


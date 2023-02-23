package day1;

import java.util.Scanner;
public class PrimeOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int flag=0;
		for(int i=0; i<n/2; i++) {
			if(i==0 || i==1){
				flag=0;
				break;
			}
			else if(n%i==0){
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.print("Prime");
		}
		else {
			System.out.println("Not Prime");
		}
		sc.close();
	}
}


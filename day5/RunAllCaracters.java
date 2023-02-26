package day5;

import java.util.Scanner;
import java.util.concurrent.*;

public class RunAllCaracters {
	public static void main(String[] args) {
		CountAllCharacter counter = new CountAllCharacter();
		ExecutorService es=Executors.newFixedThreadPool(1);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter a character: ");
			char ch = sc.next().charAt(0);
			if(ch=='\0') {
				break;
			}
			Future<Void> future = es.submit(()->{
				try {
					counter.addCharacter(ch);
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
				return null;
			});
			try {
				future.get();
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("total alphabetic characters: " + counter.getCount());
		es.shutdown();
		sc.close();
		
	}
}

class CountAllCharacter {
	private int count = 0;
	
	public synchronized void addCharacter(char c) throws Exception {
		if(!Character.isAlphabetic(c)) {
			throw new Exception("The character found is non-alphabetic charcater: " + c);
		}
		count++;
	}
	
	public synchronized int getCount() {
		return count;
	}
}

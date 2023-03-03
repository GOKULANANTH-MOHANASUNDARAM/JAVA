package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEven {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{ 
				Even.getEven();
		});
		
		es.execute(()->{
				Odd.getOdd();
		});
		
		es.shutdown();
	}
}

class Odd{
	public static void getOdd() {
		for(int i=1; i<=100; i+=2) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}

class Even{
	public static void getEven() {
		for(int i=0; i<=100; i+=2) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}

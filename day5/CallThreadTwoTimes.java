package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallThreadTwoTimes {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			Numbers.printNumber();
		});
		es.shutdown();
		
//		es.execute(()->{
//			Numbers.printNumber();
//		});
//		es.shutdown();
	}
}

class Numbers{
	public static void printNumber() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);}catch(Exception e) {		
			}
		}
	}
}
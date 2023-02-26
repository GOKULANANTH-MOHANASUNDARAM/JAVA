package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCount {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			PrintThread.toPrint();
		});
		es.shutdown();
	}
}

class PrintThread{
	public static void toPrint() {
		for(int i=1; i<=100; i++) {
			System.out.println(i);
			if(i%10==0) {
				System.out.println("Hi I am Printer");
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}    	
		}
	}
}

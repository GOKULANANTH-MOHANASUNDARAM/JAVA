package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMethods {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);

		es.execute(()->{ 
			Message.toPrintDash1();
		});
		
		es.execute(()->{
			Message.toPrintMessage();		
		});
		
		es.execute(()->{
			Message.toPrintDash2();
		});
		es.shutdown();
	}
}

class Message{
	synchronized public static void toPrintDash1() {
		System.out.print("[ ------");
	}
	
	synchronized public static void toPrintMessage() {
		System.out.print("Message");
	}
	
	synchronized public static void toPrintDash2() {
		System.out.print("------ ]");
	}
}

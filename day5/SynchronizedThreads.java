package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedThreads {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			Run.toPrintA();
		});
		es.execute(()->{
			Run.toPrintB();
		});
		es.execute(()->{
			Run.toPrintC();
		});
		es.shutdown();
	}
}

class Run{
	public synchronized static void toPrintA(){
		for(int i=1; i<=100; i++) {
			System.out.print("A ");
		}
		System.out.println();
	}
	
	public synchronized static void toPrintB(){
		for(int i=1; i<=100; i++) {
			System.out.print("B ");
		}
		System.out.println();
	}
	
	public synchronized static void toPrintC(){
		for(int i=1; i<=100; i++) {
			System.out.print("C ");
		}
		System.out.println();
	}
}

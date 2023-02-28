package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerProblem {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		Inventory inventory = new Inventory();
		es.execute(()->{
				inventory.produce();
				inventory.produce();
				inventory.produce();
		});
		es.execute(()->{
				inventory.consume();
				inventory.consume();
				inventory.consume();
		});
		es.shutdown();
			
			
	}
}

class Inventory{
	int product=0;
	synchronized void produce() {
		if(product==1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Produced Product");
		product=1;
		System.out.println("Inventory Product: "+product);
		notify();
	}
	synchronized void consume() {
		if(product==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumed Product");
		product=0;
		System.out.println("Inventory Product: "+product);
		
		notify();
		
	}
}



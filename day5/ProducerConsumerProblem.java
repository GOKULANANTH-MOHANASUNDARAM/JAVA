package day5;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerProblem {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Enter the products you have for the first day-> "); int products_provided = sc.nextInt();

		es.execute(()->{ 
			synchronized(Inventory.class) {
				for(int i=0; i<=products_provided; i++) {
					Inventory.addMaterial();
					try { Thread.sleep(500); } catch (Exception e) {}
				}
			}
		});
		
		es.execute(()->{
			synchronized(Consumer.class) {
				for(int i=0; i<=products_provided; i++) {
					Consumer.sellMaterial();
					try { Thread.sleep(1000); } catch (Exception e) {}
				}
			}
		});
			
		es.shutdown();
		sc.close();
			
			
	}
}

class Inventory {
	public static void addMaterial() {
		System.out.println("Producer added item into the inventory - 1 item added");
	}
}

class Consumer {
	static int count_products_sold = 0;
	public static void sellMaterial() {
		System.out.println("Customer got the item added into the inventory - 1 item sold");
	}
}



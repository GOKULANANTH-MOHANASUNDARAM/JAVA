package exercise4;

import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
	public static void main(String[] args) {
		
		Stock stock = new Stock();
		
	    BuyStock buyStockOrder = new BuyStock(stock);
	    SellStock sellStockOrder = new SellStock(stock);

	    Broker broker = new Broker();
	    broker.takeOrder(buyStockOrder);
	    broker.takeOrder(sellStockOrder);

	    broker.placeOrders();
	}
}

interface Order {
	   void execute();
}

class Stock {
	
	private String name = "Nifty";
	private int quantity = 10;

	public void buy(){
		System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
	}
	public void sell(){
	    System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
	}
}

class BuyStock implements Order {
	private Stock stock;

	public BuyStock(Stock stock){
	    this.stock = stock;
	}

	public void execute() {
	    stock.buy();
	}
}

class SellStock implements Order {
	private Stock stock;

	public SellStock(Stock stock){
	    this.stock = stock;
	}

	public void execute() {
	    stock.sell();
	}
}

class Broker {
	private List<Order> orderList = new ArrayList<Order>(); 

	public void takeOrder(Order order){
	   orderList.add(order);		
	}

	public void placeOrders(){
	   
	   for (Order order : orderList) {
		   order.execute();
	   }
	   orderList.clear();
	}
}
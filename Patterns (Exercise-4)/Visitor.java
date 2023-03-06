package exercise4;

import java.util.Scanner;

public class Visitor {
	
	public static void main(String[] args)throws BikeExceptions {
		
		Human human = new Human();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the item:");
		String item = scanner.next();
		Bike bike = new Bike();
		human.rideOnRoad(bike, item);
		scanner.close();
	}
}

class Human {
	public void rideOnRoad(Bike bike,String item) {
		try {
			bike.ride(item);
		}catch(BikeExceptions be) {
			System.out.println(be);
			be.visit();
		}
	}
}
class Bike {
	public void ride(String item)throws BikeExceptions {
		if(item.equals("break")) {
			throw new BikeBreakException("Apply break, else danger");
		}
		else if(item.equals("wheel")) {
			throw new BikeWheelException("Fill air before going out");
		}
		else if(item.equals("petrol")) {
			throw new BikePetrolException("It's full can enjoy");
		}
	}
}
abstract class Map {
	public abstract void handle(BikeBreakException bbe);
	public abstract void handle(BikeWheelException dwe);
	public abstract void handle(BikePetrolException bpe);
}
class Phone extends Map {
	@Override
	public void handle(BikeBreakException bbe) {
		System.out.println("Breaks are very important");
	}
	@Override
	public void handle(BikeWheelException dwe) {
		System.out.println("Take the bike to the nearby bunk");
	}
	@Override
	public void handle(BikePetrolException bpe) {
		System.out.println("Have fun, be careful");
	}
}
abstract class BikeExceptions extends Exception{
	public abstract void visit();
}
class BikeBreakException extends BikeExceptions{
	String msg;
	public BikeBreakException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		Map map = new Phone();
		map.handle(this);
	}
}
class BikeWheelException extends BikeExceptions{
	String msg;
	public BikeWheelException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		Map map = new Phone();
		map.handle(this);
	}
}
class BikePetrolException extends BikeExceptions{
	String msg;
	public BikePetrolException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		Map map = new Phone();
		map.handle(this);
	}
}

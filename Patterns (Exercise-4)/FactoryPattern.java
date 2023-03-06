package exercise4;

import java.util.Scanner;

interface CarSeller {
    abstract public Car sellcar1(Customer customer);
}
interface CarFactory {
    abstract public Car makeCar();
}
abstract class CarShowRoom implements CarSeller {
    CarFactory factory;
    abstract public  void setFactory();
    public CarFactory getFactory()
    {
        if(factory == null)
            setFactory();
        return factory;
    }
    abstract public Car sellcar(Customer customer);
}
class Hyundai extends CarShowRoom {
    public Hyundai() {
    }
    @Override
    public Car sellcar(Customer customer) {
        return getFactory().makeCar();
    }
    @Override
    public void setFactory() {
        factory = new GokulCarFactory();
    }
	@Override
	public Car sellcar1(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
class Volkswagon extends CarShowRoom{
    public Volkswagon() {
    }
    @Override
    public Car sellcar(Customer customer) {
        return getFactory().makeCar();
    }
    @Override
    public void setFactory() {
        factory = new SomeCarFactory();
    }
	@Override
	public Car sellcar1(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
class GokulCarFactory implements CarFactory{
    @Override
    public Car makeCar() {
        return new BMW();
    }
}
class SomeCarFactory implements CarFactory{
    @Override
    public Car makeCar() {
        return new Maruthi();
    }
}
class Customer{
    public void buyCar()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Shop name needed to buy..");
        String str=sc.next();
        try {
            CarShowRoom shop = (CarShowRoom)Class.forName(str).getConstructor().newInstance();
            System.out.println(shop.sellcar(this));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        sc.close();
    }
}
class Car{
}
class BMW extends Car{
    @Override
    public String toString() {
        return "BMW car bought";
    }
}
class Maruthi extends Car{
    @Override
    public String toString() {
        return "Maruthi Car bought";
    }
}
class CarImpl{
    public  void doProcess(Customer customer)
    {
        customer.buyCar();
    }
}
public class FactoryPattern {
    public static void main(String[] args) throws Exception {
        CarImpl showRoom =new CarImpl();
        while(true) {
            showRoom.doProcess(new Customer());
        }
    }
}
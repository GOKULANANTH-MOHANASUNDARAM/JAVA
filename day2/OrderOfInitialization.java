package day2;

public class OrderOfInitialization {
	public static void main(String[] args) {
		Gokul gokul = new Gokul();
		Gokul.say1();
	}
}

class Gokul{
	static  {
		System.out.println("Hi this is Gokul - Static");
	}
	Gokul() {
		System.out.println("I am Human, binded statically - Constructor");
	} 
	public static void say1() {
		System.out.println("Am an Engineer - Instance Method");
	}
}
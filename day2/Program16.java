package day2;

public class Program16 {
	public static void main(String[] args) {
		//X x1 = new X();
		Y x2 = new Y();
		//Y y1 = new Y();
		x2.do2();
	}
}

class X {
	void do1() {
		System.out.println("Something...");
	}
}

class Y extends X{
	void do2() {
		System.out.println("Anything");
	}
}


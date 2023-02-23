package day2;

public class Java10 {
	public static void main(String[] args) {
		C obs = new C();
		obs.print();
	}
}

class A{
	public A(){
		System.out.println("Constructor A");
	}
}

class B{
	public B(){
		System.out.println("Constructor B");
	}
}

class C extends A{
	B mem = new B();
	
	public void print() {
		System.out.println("Done");
	}
}

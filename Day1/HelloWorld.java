package day1;

public class HelloWorld {
	public static void main(String[] args) {
		Print p = new Print();
		p.console();	
	}
}
class Print{
	public void console() {
		System.out.println("Hello World");
	}
}

package day2;

public class Singleton {
	public static void main(String[] args) {
		Single s1, s2;
		s1 = Single.getInstance();
		s2 = Single.getInstance();
		s1.checkStatus();
		s2.checkStatus();
		System.out.println("\n" + s1.hashCode());
		System.out.println(s2.hashCode());
	}
}

class Single {
	private static Single single;
	private Single() {
		
	}
	public static Single getInstance() {
		if(single == null) {
	         single = new Single();
	         System.out.println("I am Gokul");
	    }
		return single;
	}
	public void checkStatus() {
		System.out.print("\nStill single.... Enjoy");
	}
	
}

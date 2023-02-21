package day2;

public class PassBy {
	public static void main(String[] args) {
		One a = new One();
		a.pass(5);
		int[] array = new int[] {10, 20, 30};
		Two b = new Two();
		b.pass(array);
	}
}

class One {
	public void pass(int a) {
		System.out.print(a + " - pass by value");
	}
}

class Two extends One {
	public void pass(int[] array) {
		System.out.print("\n"+ array[0] + " - pass by reference");
	}
}
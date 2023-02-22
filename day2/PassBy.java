package day2;

public class Passby_value_and_reference {
	public static void main(String[] args) {
		Pass_by_value a = new Pass_by_value();
		System.out.print("Befor passing the value: " + 5);
		a.pass(5);
		int[] array = new int[] {10, 20, 30};
		System.out.print("Befor passing the refereence: ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		Pass_by_reference b = new Pass_by_reference();
		b.pass(array);
	}
}

class Pass_by_value {
	public void pass(int a) {
		System.out.print(a + " - pass by value");
		System.out.print("After passing the value" + a++);
	}
}

class Pass_by_reference extends Pass_by_value {
	public void pass(int[] array) {
		System.out.print("\n"+ array[0] + " - pass by reference");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]++);
		}
		System.out.println("After passing the refernce, incremented array values");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
	}
}

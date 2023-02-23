package day2;

public class PassbyValueAndReference {
	public static void main(String[] args) {
		PassByValue a = new PassByValue();
		System.out.print("Befor passing the value: " + 5);
		a.pass(5);
		int[] array = new int[] {10, 20, 30};
		System.out.print("Befor passing the refereence: ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		PassByReference b = new PassByReference();
		b.pass(array);
	}
}

class PassByValue {
	public void pass(int a) {
		System.out.print(a + " - pass by value");
		System.out.print("After passing the value" + a++);
	}
}

class PassByReference extends PassByValue {
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

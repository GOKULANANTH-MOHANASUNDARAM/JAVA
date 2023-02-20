package exercisee;

public class exp24 {
public static void main(String[] args) {
	constructor obj=new constructor();
	obj.noparameter();
	obj.parameter(2, 4, 4, 98);
	obj.modifier(2, 30, 20);
	System.out.println(obj.extractorA());
	System.out.println(obj.extractorB());
System.out.println(obj.extractorC());
}
}
class constructor{
	static int a=1,b=1,c=1,x;
	void noparameter() {
		System.out.println(a*x*x+b*x+c);
	}
	void parameter(int a,int b,int c,int x) {
		System.out.println(a*x*x+b*x+c);
	}
	void modifier(int A,int B,int C) {
		int a=A*10,b=B*10,c=C*15;
		System.out.println(a*x*x+b*x+c);
	}
	int A,B,C;
	int extractorA() {
		return A;
	}
	int extractorB() {
		return B;
	}
	int extractorC() {
		return C;
	}
	
	
	}


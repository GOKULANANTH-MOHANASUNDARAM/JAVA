package exercisee;

public class exp22 {
public static void main(String[] args) {
	members obj=new members();
	obj.defaultmethod(12);
	//obj.privatemethod(19);
	obj.protectedmethod(56);
	obj.publicmethod(90);
	//System.out.println(obj.b); cant access the private member
}
}
class members{
	//default modifier
	int a=10;
	void defaultmethod(int x) {
		System.out.println(x*a);
	}
	//private modifier
	private int b=12;
	private void privatemethod(int y) {
		System.out.println(y*b);
	}
	//protected modifier
	protected int c=14;
	protected void protectedmethod(int z) {
		System.out.println(z*c);
	}
	//public modifier
	public int d=16;
	public void publicmethod(int f) {
		System.out.println(d*f);
	}
	
}
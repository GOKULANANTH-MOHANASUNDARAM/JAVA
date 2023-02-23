package day4;

import java.io.*;

public class CheckException {
	public static void main(String[] args) {
		Derived derived = new Derived();
	}
}

class Base {
	public Base() throws Exception {
		throw new Exception("This is a Base Exception");
	}
}

class Derived extends Base {
	public Derived(){
		try {
			super();
		}
		catch(Exception e) {
			System.out.println("Exception thrown by Base class got caught in Derived class: "+ e.getMessage());
		} finally {
			System.out.println("Finally done");

		}
	}
}

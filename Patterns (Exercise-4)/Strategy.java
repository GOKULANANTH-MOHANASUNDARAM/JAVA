package exercise4;

import java.util.*;

public class Strategy {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		GoodFan f = new GoodFan();
		f.state = new Off();
		while(true) {
			System.out.println("Press    a -> on,    q -> off");
			char ch = sc.next().charAt(0);
			if(ch == 'a') {
				f.on();
			}
			else if(ch == 'q') {
				break;
			}
		}
		sc.close();
	}
}

class GoodFan{
	State state; // creating a reference to abstract
	public void on() { 
		// initially the fan will be in off state so turn on
		state.changeState(this); // change 
	}
}
abstract class State {
	// there cannot be any object created using state
	public abstract void changeState (GoodFan fan);
}
class Off extends State { // off state
	@Override
	public void changeState (GoodFan fan) {
		fan.state = new On();
		System.out.println("Switch off...");
	}
}
class On extends State { // on state
	@Override
	public void changeState (GoodFan fan) {
		fan.state = new LowSpeed();
		System.out.println("Switch On...");
	}
}

class LowSpeed extends State { // speed = 1
	@Override
	public void changeState (GoodFan fan) {
		fan.state = new MidSpeed();
		System.out.println("low speed state...");
	}
}
class MidSpeed extends State { // speed = 2
	@Override
	public void changeState (GoodFan fan) {
		fan.state = new HighSpeed();
		System.out.println("Medium speed state...");
	}
}
class HighSpeed extends State { // speed = 3
	@Override
	public void changeState (GoodFan fan) {
		fan.state = new Off();
		System.out.println("High speed state...");
		// fan.on() - loop
	}
}
package day5;

public class CallThreadTwoTimes {
	public static void main(String[] args) throws Exception{
		Numbers number = new Numbers();
		number.start();
		number.start();
	}
}

class Numbers extends Thread{
	public static void printNumber() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);}catch(Exception e) {		
			}
		}
	}
}

package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Calendar;

public class DigitalClock {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		es.execute(()->{ 
				Clock.startRun();
		});
		
		es.shutdown();
	}
}

class Clock {
	static void startRun() {
		try {
			while(true) {
				Calendar Present_time = Calendar.getInstance();
				int hour = Present_time.get(Calendar.HOUR_OF_DAY);
				int minute = Present_time.get(Calendar.MINUTE);
				int second = Present_time.get(Calendar.SECOND);
				System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
				Thread.sleep(60000);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}

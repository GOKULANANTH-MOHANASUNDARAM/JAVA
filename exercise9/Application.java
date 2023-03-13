package exercise9;

import exercise9.Action.Action;
import exercise9.Action.LoginAction;
import exercise9.Action.LogoutAction;

public class Application {

	public static void main(String[] args) {
		Action action = new LoginAction();
		
		String result = action.execute("somu", "secret");
		
		System.out.println(result);
		
		try {
			Thread.sleep(5000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		LogoutAction action2 = new LogoutAction();
		
		result = action2.execute("somu");
		System.out.println();

	}

}

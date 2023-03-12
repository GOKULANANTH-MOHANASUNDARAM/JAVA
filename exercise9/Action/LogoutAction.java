package exercise9.Action;

import exercise9.service.LogoutService;
import exercise9.service.Logout;

public class LogoutAction {
	public String execute(String uname) {
		LogoutService ls=Logout.getLoginServiceImplObject();
		String result=ls.logout(uname);
		return result;
	}
}

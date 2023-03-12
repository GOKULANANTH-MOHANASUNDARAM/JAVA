package exercise9.Action;

import exercise9.service.LoginService;
import exercise9.service.Login;

public class LoginAction extends Action{

	@Override
	public String execute(String uname, String upass) {
		
			LoginService ls=Login.getLoginServiceImplObject();
			String result=ls.login(uname, upass);
			return result;
	}

}
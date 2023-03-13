package exercise9.service;

import exercise9.component.User;
import exercise9.component.UserComponent;

public class Login implements LoginService{
	private static Login userser;
	public static Login getLoginServiceImplObject() {
		if(userser == null) {
			userser=new Login();
			return userser;
		}
		else {
			return userser.createClone();
		}
	}
	private Login createClone() {
		if(userser != null) {
			try{
				return (Login)super.clone();
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	private Login() {
		
	}
	@Override
	public String login(String uname, String upass) {
		UserComponent usercom = User.getUserObject();
		
		if(usercom.checkUser(uname, upass)) {
			if(usercom.checkFlag(uname)) {
				usercom.updateFlag(uname, 1);
				return "welcome";
			}
			else {
				return "alreadylogedin";
			}
		}
		else {
			return "signup";
		}
	}
}

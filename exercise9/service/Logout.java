package exercise9.service;

import exercise9.component.User;
import exercise9.component.UserComponent;

public class Logout implements LogoutService{
	private static Logout userser;
	public static Logout getLoginServiceImplObject() {
		if(userser == null) {
			userser=new Logout();
			return userser;
		}
		else {
			return userser.createClone();
		}
	}
	private Logout createClone() {
		if(userser != null) {
			try{
				return (Logout)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	private Logout() {
		
	}
	@Override
	public String logout(String uname) {
		UserComponent usercom = User.getUserObject();
		
		int n = usercom.updateFlag(uname, 0);
		return "logoutsuccess";
	}
}

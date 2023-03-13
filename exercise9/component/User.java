package exercise9.component;

import exercise9.DAO.UserDAO;
import exercise9.DAO.User_DAO;
import exercise9.DTO.User_DTO;

public class User implements UserComponent, Cloneable{
	private static User user;
	public static User getUserObject() {
		if (user == null) {
			user = new User();
			return user;
		}
		else {
			return user.createClone();
		}
	}
	
	private User createClone() {
		if(user != null) {
			try{
				return (User)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	private User() {
		
	}
	
	private UserDAO userdao;
	
	@Override
	public boolean checkUser(String uname, String upass) {
		userdao = User_DAO.getUser_DAOobject();
		User_DTO dto = userdao.findByName(uname);
		if(dto != null) {
			if(dto.getUpass().equals(upass)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkFlag(String uname) {
		userdao = User_DAO.getUser_DAOobject();
		User_DTO dto = userdao.findByName(uname);
		if(dto != null) {
			if(dto.getFlag() == 0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int updateFlag(String uname, int flag) {
		userdao = User_DAO.getUser_DAOobject();
		User_DTO dto = userdao.findByName(uname);
		if(dto != null) {
			dto.setFlag(flag);
			int n = userdao.updateUser(dto);
			return n;
		}
		else {
			return 0;
		}
	}
}

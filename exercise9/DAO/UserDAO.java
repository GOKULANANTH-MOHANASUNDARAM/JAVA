package exercise9.DAO;

import java.util.Collection;

import exercise9.DTO.User_DTO;

public abstract class UserDAO {
	public abstract User_DTO findByID(int uid);
	public abstract User_DTO findByName(String uname);
	public abstract Collection<User_DTO> findAll();
	public abstract int updateUser(User_DTO userdto);
	public abstract int deleteUserByID(int uid);
	public abstract int deleteUserByName(String uname);
	
}

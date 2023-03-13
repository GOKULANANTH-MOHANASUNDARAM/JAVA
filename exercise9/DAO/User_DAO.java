package exercise9.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise9.DBUtility;
import exercise9.DTO.User_DTO;

public class User_DAO extends UserDAO implements Cloneable{
	
	private static User_DAO userdao;
	public static User_DAO getUser_DAOobject() {
		if(userdao == null) {
			userdao = new User_DAO();
			return userdao;
		}
		else {
			return userdao.createClone();
		}
	}
	
	private User_DAO createClone() {
		if(userdao != null) {
			try{
				return (User_DAO)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	private User_DAO() {
		
	}
	
	@Override
	public User_DTO findByID(int uid) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User_DTO dto = new User_DTO();
				dto.setUid(uid);
				dto.setUname(rs.getString("uname"));
				dto.setUpass(rs.getString("upass"));
				dto.setFlag(rs.getInt("flag"));
				dto.setAge(rs.getInt("age"));
				return dto;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	
	@Override
	public User_DTO findByName(String uname) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User_DTO dto = new User_DTO();
				dto.setUid(rs.getInt(1));
				dto.setUname(rs.getString("uname"));
				dto.setUpass(rs.getString("upass"));
				dto.setFlag(rs.getInt("flag"));
				dto.setAge(rs.getInt("age"));
				return dto;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	
	@Override
	public Collection<User_DTO> findAll() {
		try {
			Connection con = DBUtility.getConnection();
			Statement ps=con.createStatement();
			
			ResultSet rs = ps.executeQuery("select * from users");
			List<User_DTO> users=new ArrayList<User_DTO>();
			while(rs.next()) {
				User_DTO dto = new User_DTO();
				dto.setUid(rs.getInt("uid"));
				dto.setUname(rs.getString("uname"));
				dto.setUpass(rs.getString("upass"));
				dto.setFlag(rs.getInt("flag"));
				dto.setAge(rs.getInt("age"));
				users.add(dto);
			}
			return users;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	
	@Override
	public int updateUser(User_DTO userdto) {
		try {
			Connection con = DBUtility.getConnection();
			int uid=userdto.getUid();
			PreparedStatement ps=con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update users set uname=?,upass=?,age=?,flag=? where uid=?");
				ps.setString(1, userdto.getUname());
				ps.setString(2, userdto.getUpass());
				ps.setInt(3, userdto.getAge());
				ps.setInt(4, userdto.getFlag());
				ps.setInt(5, userdto.getUid());
				int n = ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			}
			else {
				return 0;
			}
		
		} catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	
	@Override
	public int deleteUserByID(int uid) {
		return 0;
	}
	
	@Override
	public int deleteUserByName(String uname) {
		return 0;
	}
	
	public static void main(String[] args) {
		User_DAO user=new User_DAO();
		System.out.println(user.findByID(1));
		System.out.println(user.findByName("somu"));
		
		User_DTO u=user.findByID(1);
		u.setUname("ramu");
		u.setUpass("secret");
		int n=user.updateUser(u);
		System.out.println(n);
		
	}
}

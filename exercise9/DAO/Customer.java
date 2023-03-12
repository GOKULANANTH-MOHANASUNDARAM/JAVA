package exercise9.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise9.DBUtility;
import exercise9.DTO.Customer_DTO;


public class Customer extends CustomerDAO implements Cloneable{
	
	
	private Customer()
	{
		
	}
	
	private static Customer customerDAO;
	public static Customer getUserDAOImplObject() {
		if(customerDAO == null) {
			customerDAO = new Customer();
			return customerDAO;
		}
		else {
			return customerDAO.createClone();
		}
	}
	private Customer createClone() {
		if(customerDAO != null) {
			try { 
				return (Customer)super.clone();
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	@Override
	public Customer_DTO findByID(String cid) {
		try {
				Connection connection = DBUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from customermaster where customerid=?");
				preparedStatement.setString(1, cid);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					Customer_DTO customerDTO = new Customer_DTO();
					customerDTO.setCustomerID(resultSet.getString("customerid"));
					customerDTO.setCustomerAddress(resultSet.getString("customeraddress"));
					customerDTO.setCustomerName(resultSet.getString("customername"));
					return customerDTO;
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
	public Customer_DTO findByName(String uname) {
		try {
				Connection connection = DBUtility.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from customermaster where customername=?");
				preparedStatement.setString(1, uname);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					Customer_DTO customerDTO = new Customer_DTO();
					customerDTO.setCustomerAddress(resultSet.getString("customeraddress"));
					customerDTO.setCustomerID(resultSet.getString("customerid"));
					customerDTO.setCustomerName(resultSet.getString("customername"));
					return customerDTO;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<Customer_DTO> findAll() {
		try {
				Connection connection = DBUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customermaster");
				List<Customer_DTO> customers = new ArrayList<Customer_DTO>();
				while(resultSet.next()) {
					Customer_DTO customerDTO = new Customer_DTO();
					customerDTO.setCustomerAddress(resultSet.getString("customeraddress"));
					customerDTO.setCustomerID(resultSet.getString("customerid"));
					customerDTO.setCustomerName(resultSet.getString("customername"));
					customers.add(customerDTO);
				}
				return customers;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Customer_DTO updateUser(Customer_DTO userDTO) {
		try {
				Connection connection = DBUtility.getConnection();
				String customerID = userDTO.getCustomerID();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from customermaster where customerid=?");
				preparedStatement.setString(1, customerID);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					preparedStatement=connection.prepareStatement("update customermaster set customername=?,customeraddress=? where customerid=?");
					preparedStatement.setString(1, userDTO.getCustomerName());
					preparedStatement.setString(2, userDTO.getCustomerAddress());
					preparedStatement.setString(3, userDTO.getCustomerID());
					DBUtility.closeConnection(null);
					return userDTO;
			}
			else {
				return null;
			}	
		} catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int deleteUserByID(String customerID) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customermaster where customerid=?");
			preparedStatement.setString(1, customerID);
			int n = preparedStatement.executeUpdate();
			return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	public static void main(String[] args) {
		String userid = "c1";
		CustomerDAO customer = new Customer();
		customer.deleteUserByID(userid);
		Customer_DTO customerDTO = new Customer_DTO();
	}
}

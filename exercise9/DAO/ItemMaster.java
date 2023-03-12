package exercise9.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise9.DBUtility;
import exercise9.DTO.ItemMaster_DTO;

public class ItemMaster extends ItemMasterDAO implements Cloneable{
	
	private ItemMaster()
	{
		
	}
	private static ItemMaster itemMasterDAO;
	public static ItemMaster getUserDAOImplObject() {
		if(itemMasterDAO == null) {
			itemMasterDAO = new ItemMaster();
			return itemMasterDAO;
		}
		else {
			return itemMasterDAO.createClone();
		}
	}
	private ItemMaster createClone() {
		if(itemMasterDAO != null) {
			try {
				return ( ItemMaster)super.clone();
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	public ItemMaster_DTO findByID(int id) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from itemmaster where itemno=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				ItemMaster_DTO itemdto=new ItemMaster_DTO();
				itemdto.setItemname(resultSet.getString("itemname"));
				itemdto.setItemprice(resultSet.getInt("itemprice"));
				itemdto.setUnit(resultSet.getString("itemunit"));
				itemdto.setItemno(id);
				return itemdto;
		}
		else {
			return null;
		}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public Collection<ItemMaster_DTO> findAll(){
		try {
			Connection connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from itemmaster");
			List<ItemMaster_DTO> items=new ArrayList<ItemMaster_DTO>();
			while(resultSet.next()) {
				ItemMaster_DTO itemMasterDTO=new ItemMaster_DTO();
				itemMasterDTO.setItemno(resultSet.getInt("itemno"));
				itemMasterDTO.setItemname(resultSet.getString("itemname"));
				itemMasterDTO.setItemprice(resultSet.getInt("itemprice"));
				itemMasterDTO.setUnit(resultSet.getString("itemunit"));				
				items.add(itemMasterDTO);
			}
			return items;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public ItemMaster_DTO update(ItemMaster_DTO itemMasterDTO) {
		try {
			Connection connection = DBUtility.getConnection();
			int itemNumber = itemMasterDTO.getItemno();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from itemmaster where itemno=?");
			preparedStatement.setInt(1, itemNumber);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				preparedStatement = connection.prepareStatement("update itemmaster set itemname=?,itemprice=?,itemunit=? where itemno=?");
				preparedStatement.setString(1, itemMasterDTO.getItemname());
				preparedStatement.setInt(2, itemMasterDTO.getItemprice());
				preparedStatement.setString(3, itemMasterDTO.getUnit());
				preparedStatement.executeUpdate();
				DBUtility.closeConnection(null);
				return itemMasterDTO;
			}
			else {
				return null;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public int deleteItem(ItemMaster_DTO itemMasterDTO) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from itemmaster where itemno=?");
			preparedStatement.setInt(1, itemMasterDTO.getItemno());
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
	
	@Override
	public ItemMaster_DTO findByName(String itemName) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from itemmaster where itemname=?");
			preparedStatement.setString(1, itemName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				ItemMaster_DTO itemMasterDTO=new ItemMaster_DTO();
				itemMasterDTO.setItemname(resultSet.getString("itemname"));
				itemMasterDTO.setItemno(resultSet.getInt("itemno"));
				itemMasterDTO.setItemprice(resultSet.getInt("itemprice"));
				itemMasterDTO.setUnit(resultSet.getString("itemunit"));
				return itemMasterDTO;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
}
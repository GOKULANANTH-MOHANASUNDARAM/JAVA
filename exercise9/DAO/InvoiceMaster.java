package exercise9.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise9.DBUtility;
import exercise9.DTO.InvoiceMaster_DTO;

public class InvoiceMaster extends InvoiceMasterDAO implements Cloneable{
	
	private InvoiceMaster()
	{
		
	}
	
	private static InvoiceMaster invoiceMasterDAO;
	public static InvoiceMaster getUserDAOImplObject() {
		if(invoiceMasterDAO==null) 
		{
			invoiceMasterDAO = new InvoiceMaster();
			return invoiceMasterDAO;
		}
		else 
		{
			return invoiceMasterDAO.createClone();
		}
	}
	private InvoiceMaster createClone() {
		if(invoiceMasterDAO != null) {
			try {
				return (InvoiceMaster)super.clone();
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public InvoiceMaster_DTO findByID(String invoiceNumber) {
		try {
		Connection connection = DBUtility.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicemaster where invoiceno=?");
		preparedStatement.setString(1, invoiceNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			InvoiceMaster_DTO invoiceMasterDTO=new InvoiceMaster_DTO();
			invoiceMasterDTO.setInvoiceno(resultSet.getString("invoiceno"));
			invoiceMasterDTO.setDate(resultSet.getDate("date"));
			invoiceMasterDTO.setCustomerid(resultSet.getString("customerid"));
			return invoiceMasterDTO;
		}
		else {
			return null;
		}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public Collection<InvoiceMaster_DTO> findAll(){
		try {
			Connection connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from invoicemaster");
			List<InvoiceMaster_DTO> invoices=new ArrayList<InvoiceMaster_DTO>();
			while(resultSet.next()) {
				InvoiceMaster_DTO invoiceMasterDTO = new InvoiceMaster_DTO();
				invoiceMasterDTO.setInvoiceno(resultSet.getString("invoiceno"));
				invoiceMasterDTO.setDate(resultSet.getDate("date"));
				invoiceMasterDTO.setCustomerid(resultSet.getString("customerid"));
				invoices.add(invoiceMasterDTO);
			}
			return invoices;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public InvoiceMaster_DTO update(InvoiceMaster_DTO invoiceMasterDTO) {
		try {
			Connection connection = DBUtility.getConnection();
			String invoiceNumber = invoiceMasterDTO.getInvoiceno();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicemaster where invoiceno=?");
			preparedStatement.setString(1,invoiceNumber);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				preparedStatement = connection.prepareStatement("update invoicemaster set customerid=?,date=? where invoiceno=?");
				preparedStatement.setString(1, invoiceMasterDTO.getCustomerid());
				preparedStatement.setDate(2, invoiceMasterDTO.getDate());
				preparedStatement.executeUpdate();
				DBUtility.closeConnection(null);
				return invoiceMasterDTO;
			}
			else {
				return invoiceMasterDTO;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return invoiceMasterDTO;
		}
	}
	public int deleteItem(InvoiceMaster_DTO invoiceMasterDTO) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from invoicemaster where invoiceno=?");
			ps.setString(1, invoiceMasterDTO.getInvoiceno());
			int n = ps.executeUpdate();
			return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	public InvoiceMaster_DTO findByOrderDate(Date date) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from invoicemaster where date=?");
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				InvoiceMaster_DTO invoiceMasterDTO=new InvoiceMaster_DTO();
				invoiceMasterDTO.setInvoiceno(rs.getString("invoiceno"));
				invoiceMasterDTO.setDate(rs.getDate("date"));
				invoiceMasterDTO.setCustomerid(rs.getString("customerid"));
				return invoiceMasterDTO;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
}

package exercise9.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exercise9.DBUtility;
import exercise9.DTO.InvoiceTransaction_DTO;

public class InvoiceTransaction extends InvoiceTransactionDAO implements Cloneable{
	private static InvoiceTransaction invoiceTransDAO;
	public static InvoiceTransaction getUserDAOImplObject() {
		if(invoiceTransDAO == null) {
			invoiceTransDAO = new InvoiceTransaction();
			return invoiceTransDAO;
		}
		else {
			return invoiceTransDAO.createClone();
		}
	}
	private  InvoiceTransaction createClone() {
		if(invoiceTransDAO!=null) {
			try {
				return ( InvoiceTransaction)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	private InvoiceTransaction()
	{
		
	}
	@Override
	public InvoiceTransaction_DTO findByID(int itemNumber, String invoiceNumber) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, invoiceNumber);
			preparedStatement.setInt(2, itemNumber);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				InvoiceTransaction_DTO invoiceTransDTO = new InvoiceTransaction_DTO();
				invoiceTransDTO.setInvoiceNumber(rs.getString("invoiceno"));
				invoiceTransDTO.setItemNumber(rs.getInt("itemno"));
				invoiceTransDTO.setItemQuantity(rs.getInt("itemqty"));
				return invoiceTransDTO;
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
	public Collection<InvoiceTransaction_DTO> findAll() {
		try {
			Connection connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from invoicetrans");
			List<InvoiceTransaction_DTO> transactions = new ArrayList<InvoiceTransaction_DTO>();
			while(resultSet.next()) {
				InvoiceTransaction_DTO dto = new InvoiceTransaction_DTO();
				dto.setInvoiceNumber(resultSet.getString("invoiceno"));
				dto.setItemNumber(resultSet.getInt("itemno"));
				dto.setItemQuantity(resultSet.getInt("itemqty"));
				transactions.add(dto);
			}
			return transactions;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public InvoiceTransaction_DTO update(InvoiceTransaction_DTO invoiceTransDTO) {
		try {
			Connection connection=DBUtility.getConnection();
			String invoiceno = invoiceTransDTO.getInvoiceNumber();
			int itemno = invoiceTransDTO.getItemNumber();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, invoiceno);
			preparedStatement.setInt(2, itemno);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				preparedStatement = connection.prepareStatement("update invoicetrans set itemqty=? where invoiceno=? and itemno=?");
				preparedStatement.setInt(1, invoiceTransDTO.getItemQuantity());
				preparedStatement.setString(2, invoiceno);
				preparedStatement.setInt(3, itemno);
				preparedStatement.executeUpdate();
				DBUtility.closeConnection(null);
				return invoiceTransDTO;
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

	@Override
	public int deleteItem(InvoiceTransaction_DTO dto) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, dto.getInvoiceNumber());
			preparedStatement.setInt(2,dto.getItemNumber());
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

}

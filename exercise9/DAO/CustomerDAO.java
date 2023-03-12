package exercise9.DAO;

import exercise9.DTO.Customer_DTO;
import java.util.Collection;

public abstract class CustomerDAO {
	public abstract Customer_DTO findByID(String cid);
	public abstract Customer_DTO findByName(String uname);
	public abstract Collection<Customer_DTO> findAll();
	public abstract Customer_DTO updateUser(Customer_DTO userdto);
	public abstract int deleteUserByID(String cid);
}

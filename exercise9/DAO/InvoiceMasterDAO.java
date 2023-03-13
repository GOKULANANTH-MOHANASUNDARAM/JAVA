package exercise9.DAO;

import java.sql.Date;
import java.util.Collection;

import exercise9.DTO.InvoiceMaster_DTO;

 abstract public class InvoiceMasterDAO {
	abstract public InvoiceMaster_DTO findByID(String invoiceNumber);
	abstract public Collection<InvoiceMaster_DTO> findAll();
	abstract public InvoiceMaster_DTO update(InvoiceMaster_DTO invoiceMasterDTO);
	abstract public int deleteItem(InvoiceMaster_DTO dto);
	abstract public InvoiceMaster_DTO findByOrderDate(Date date);
}

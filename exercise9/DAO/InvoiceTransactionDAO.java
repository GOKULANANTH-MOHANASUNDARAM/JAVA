package exercise9.DAO;

import java.util.Collection;

import exercise9.DTO.InvoiceTransaction_DTO;

abstract public class InvoiceTransactionDAO {
	abstract public InvoiceTransaction_DTO findByID(int itemNumber,String invoiceNumber);
	abstract public Collection<InvoiceTransaction_DTO> findAll();
	abstract public InvoiceTransaction_DTO update(InvoiceTransaction_DTO dto);
	abstract public int deleteItem(InvoiceTransaction_DTO dto);
}

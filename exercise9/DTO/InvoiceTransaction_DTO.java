package exercise9.DTO;

public class InvoiceTransaction_DTO {
	
	public InvoiceTransaction_DTO()
	{
		
	}
	
	private int itemNumber,itemQuantity;
	private String invoiceNumber;
	
	public InvoiceTransaction_DTO(String invoiceNumber,int itemNumber,int itemQuantity) {
		this.invoiceNumber = invoiceNumber;
		this.itemNumber = itemNumber;
		this.itemQuantity = itemQuantity;
	}
	
	@Override
	public String toString() {
		String str= "InvoiceTransDTO [itemnumber=" + itemNumber + ", invoicenumber=" + invoiceNumber + ", itemquantity=" + itemQuantity + "]";
		return str;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(int invoiceNumber) {
		this.itemNumber = invoiceNumber;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
}

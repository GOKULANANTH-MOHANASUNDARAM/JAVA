package exercise9.DTO;

import java.sql.Date;

public class InvoiceMaster_DTO{
	
	public InvoiceMaster_DTO() {
		
	}
	
	private String invoiceNumber,customerID;
	private Date date;
	
	public InvoiceMaster_DTO(String invoiceNumber, Date date, String customerID) {
		this.invoiceNumber=invoiceNumber;
		this.date=date;
		this.customerID=customerID;
	}
	
	@Override
	public String toString() {
		String str= "InvoicemasterDTO [itemnumber=" + invoiceNumber + ", customerid=" + customerID + ", date=" + date + "]";
		return str;
	}
	
	public String getInvoiceno() {
		return invoiceNumber;
	}

	public void setInvoiceno(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCustomerid() {
		return customerID;
	}

	public void setCustomerid(String customerid) {
		this.customerID = customerid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

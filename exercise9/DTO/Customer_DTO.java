package exercise9.DTO;

public class Customer_DTO {
	public Customer_DTO()
	{
		
	}
	
	private String customerID,customerName,customerAddress;
	
	public Customer_DTO(String customerID,String customerName,String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		String str = "Customer_DTO [customerid = " + customerID + ", customername = " + customerName + ", customeraddress = " + customerAddress + "]";
		return str;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(String cid) {
		this.customerID = cid;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String cname) {
		this.customerName = cname;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String caddr) {
		this.customerAddress = caddr;
	}
}
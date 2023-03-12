package exercise9.DTO;

import java.io.Serializable;
import java.util.Objects;

public class ItemMaster_DTO implements Serializable,Comparable<ItemMaster_DTO>{
	
	public ItemMaster_DTO() {
		
	}
	
	private int itemNumber;
	private String itemName;
	private int itemPrice;
	private String unit;
	
	public ItemMaster_DTO(int itemno, String itemname, int itemprice, String unit) {
		this.itemNumber = itemno;
		this.itemName = itemname;
		this.itemPrice = itemprice;
		this.unit = unit;
	}
	
	@Override
	public int compareTo(ItemMaster_DTO obj) {
		return itemName.compareTo(obj.itemName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(itemName, itemNumber, itemPrice, unit);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMaster_DTO other = (ItemMaster_DTO) obj;
		return Objects.equals(itemName, other.itemName) && itemNumber == other.itemNumber && itemPrice == other.itemPrice
				&& Objects.equals(unit, other.unit);
	}
	
	@Override
	public String toString() {
		return "ItemMasterDTO [itemno = " + itemNumber + ", itemname = " + itemName + ", itemprice = " + itemPrice + ", unit = "
				+ unit + "]";
	}
	
	public int getItemno() {
		return itemNumber;
	}
	
	public void setItemno(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getItemname() {
		return itemName;
	}
	
	public void setItemname(String itemName) {
		this.itemName = itemName;
	}
	
	public int getItemprice() {
		return itemPrice;
	}
	
	public void setItemprice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
}

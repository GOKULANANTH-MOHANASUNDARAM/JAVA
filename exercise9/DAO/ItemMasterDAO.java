package exercise9.DAO;

import java.util.Collection;

import exercise9.DTO.ItemMaster_DTO;

abstract public class ItemMasterDAO {
	public abstract ItemMaster_DTO findByID(int id);
	public abstract ItemMaster_DTO findByName(String itemName);
	public abstract Collection<ItemMaster_DTO> findAll();
	abstract public ItemMaster_DTO update(ItemMaster_DTO ItemMasterDTO);
	abstract public int deleteItem(ItemMaster_DTO itemMasterDTO);
}

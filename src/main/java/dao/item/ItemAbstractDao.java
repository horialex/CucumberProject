package dao.item;

import java.util.List;

import com.google.inject.ImplementedBy;

import entities.Item;

@ImplementedBy(ItemDao.class)
public interface ItemAbstractDao {

	public Item getItemById(String id);

	public List<Item> getItemsByCategoryId(String categoryId);

	public void addItem(Item item);
	
	public List<Item> getAllItems();

	public void print();
}

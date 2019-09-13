package dao.item;

import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Inject;

import config.TestContext;
import constants.ContextKeyConstants;
import entities.Item;

public class ItemDao  implements ItemAbstractDao {

	@Inject
	TestContext context;
	
	@Override
	public Item getItemById(String id) {
		return getAllItems().stream().filter(item -> String.valueOf(item.getId()).contains(id)).findFirst().orElse(null);
	}

	@Override
	public List<Item> getItemsByCategoryId(String categoryId) {
		List<Item> items = context.get(ContextKeyConstants.ITEMS);
		return items.stream().filter(item -> String.valueOf(item.getCategoryId()).contains(categoryId))
				.collect(Collectors.toList());
	}

	@Override
	public void addItem(Item item) {
		System.out.println("Saving item...");
		context.saveObjectInContextList(ContextKeyConstants.ITEMS, item);
	}
	
	@Override
	public void print() {
		context.printContext();
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items = context.get(ContextKeyConstants.ITEMS);
		return items;
	}
}

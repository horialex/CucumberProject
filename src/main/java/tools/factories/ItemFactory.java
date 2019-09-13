package tools.factories;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import dao.category.CategoryAbstractDao;
import entities.Category;
import entities.Item;
import tools.utils.FieldGenerator;

public class ItemFactory {

//	public ItemFactory() {
//		AppInjector.getInjector().injectMembers(this);
//	}
	
	@Inject
	CategoryAbstractDao categoryAbstractDao;
	

	public Item geItemInstance() {

		Category category = categoryAbstractDao.getLastCreatedCategory();
		Item item = new Item();
		item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
		item.setCustomFields(new Object[0]);
		item.setCategoryId(category.getId());
		item.setCategory(category);

		item.setName(null);
		item.setItemTag(null);
		item.setDescription(null);
		item.setCategoryTitle(null);

		return item;
	}

	public Item geItemCSVInstance() {
		Category category = categoryAbstractDao.getLastCreatedCategory();
		Item item = new Item();
		item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
		item.setCustomFields(new Object[0]);
		item.setCategoryId(category.getId());
		item.setCategory(category);

		item.setName(item.getTitle());
		item.setItemTag(item.getTitle() + "_tag");
		item.setDescription("Test item description");
		item.setCategoryTitle(category.getName());

		return item;
	}

	public List<Item> getItemCSVInstantceList(int numberOfItems) {
		Category category = categoryAbstractDao.getLastCreatedCategory();
		List<Item> items = new ArrayList<Item>();

		for (int i = 0; i < numberOfItems; i++) {
			Item item = new Item();

			item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
			item.setCustomFields(new Object[0]);
			item.setCategoryId(category.getId());
			item.setCategory(category);

			item.setName(item.getTitle());
			item.setItemTag(item.getTitle() + "_tag");
			item.setDescription("Test item description");
			item.setCategoryTitle(category.getName());

			items.add(item);
		}
		return items;
	}

}

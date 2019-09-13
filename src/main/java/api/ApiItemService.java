package api;

import com.google.inject.Inject;

import constants.ApiConstants;
import dao.item.ItemAbstractDao;
import entities.Item;
import tools.factories.ItemFactory;
import tools.utils.InstanceUtils;

public class ApiItemService   {
	
	@Inject
	ItemAbstractDao itemAbstractDao;
	@Inject 
	ItemFactory itemfactory;
	@Inject
	AbstractApi abstractApi;
	
	public void createItem() {
		Item itemRequest = itemfactory.geItemInstance();
		Item itemResponse = abstractApi.createResource(ApiConstants.ITEMS, itemRequest, Item.class);
		itemRequest = (Item) InstanceUtils.mergeObjects(itemRequest, itemResponse);
		itemAbstractDao.addItem(itemRequest);
	}
	
}

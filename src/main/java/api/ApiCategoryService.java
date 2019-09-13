package api;

import com.google.inject.Inject;

import constants.ApiConstants;
import dao.category.CategoryAbstractDao;
import entities.Category;
import tools.factories.CategoryFactory;
import tools.utils.InstanceUtils;

public class ApiCategoryService {
	
	@Inject
	CategoryAbstractDao categoryAbstractDao;
	@Inject
	CategoryFactory categoryFactory;
	@Inject
	AbstractApi abstractApiSteps;

	
	public void createCategory() {
		Category categoryRequest = categoryFactory.getCategoryInstance();
		Category categoryResponse = abstractApiSteps.createResource(ApiConstants.CATEGORIES, categoryRequest,
				Category.class);
		categoryRequest = (Category) InstanceUtils.mergeObjects(categoryRequest, categoryResponse);
		
		categoryAbstractDao.saveCategory(categoryRequest);
	}

}

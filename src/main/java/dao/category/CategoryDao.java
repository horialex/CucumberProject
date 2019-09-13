package dao.category;

import java.util.List;

import com.google.inject.Inject;

import config.TestContext;
import constants.ContextKeyConstants;
import entities.Category;

public class CategoryDao implements CategoryAbstractDao {

	@Inject
	TestContext context;

	@Override
	public void saveCategory(Category category) {
		System.out.println("Saving category...");
		context.saveObjectInContextList(ContextKeyConstants.CATEGORIES, category);
	}

	@Override
	public List<Category> getCategories() {
		return context.get(ContextKeyConstants.CATEGORIES);
	}

	@Override
	public void printContext() {
		context.printContext();
	}

	@Override
	public Category getLastCreatedCategory() {
		List<Category> categories = getCategories();
		return categories.get(categories.size() - 1);
	}
}

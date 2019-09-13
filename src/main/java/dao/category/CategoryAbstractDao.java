package dao.category;

import java.util.List;

import com.google.inject.ImplementedBy;

import entities.Category;

@ImplementedBy(CategoryDao.class)
public interface CategoryAbstractDao {
	
	public void saveCategory (Category category);
	
	public List<Category> getCategories();
	
	public Category getLastCreatedCategory();
	
	public void printContext();

}

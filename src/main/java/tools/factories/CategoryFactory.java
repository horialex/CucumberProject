package tools.factories;

import entities.Category;
import tools.utils.FieldGenerator;

public class CategoryFactory {

	public Category getCategoryInstance() {
        Category category = new Category();
        category.setName("Category - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
        return category;
    }
}

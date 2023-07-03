package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);

    public Category getCategoryById(Integer categoryId);

    public List<Category> getAllCategories();

    public Category updateCategory(Category updatedCategory);

    public void deleteCategory(Integer categoryId);
}

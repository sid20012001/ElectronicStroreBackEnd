package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.Category;
import BackEndOfEcom.BackEndOfEcom.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category updatedCategory) {
       int categoryId= updatedCategory.getCId();
        this.categoryRepository.save(updatedCategory);
        return this.categoryRepository.findById(categoryId).get() ;
    }
    public void deleteCategory(Integer categoryId) {
        Category category = getCategoryById(categoryId);
        categoryRepository.delete(category);
    }
}

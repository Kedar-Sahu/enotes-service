package in.main.service;

import java.util.List;

import in.main.entity.Category;

public interface CategoryService {

	Boolean saveCategory(Category category);
	
	List<Category> getAllCategory();
}

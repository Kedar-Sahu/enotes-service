package in.main.service;

import java.util.List;

import in.main.dto.CategoryDto;
import in.main.dto.CategoryResponse;
import in.main.entity.Category;

public interface CategoryService {

	Boolean saveCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategory();

	List<CategoryResponse> getAllActiveCategory();
	
	
}

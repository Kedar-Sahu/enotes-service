package in.main.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import in.main.dto.CategoryDto;
import in.main.dto.CategoryResponse;
import in.main.entity.Category;
import in.main.repository.CategoryRepository;
import in.main.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
	
		Category category=mapper.map(categoryDto, Category.class);
		
//		Category category=new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		
		Category category1=categoryRepository.save(category);
		if(ObjectUtils.isEmpty(category1)) {
			return false;
		}
		return true;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<Category> categoryList=categoryRepository.findAll();
		List<CategoryDto> categoryDtoList=categoryList.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtoList;
	}

	@Override
	public List<CategoryResponse> getAllActiveCategory() {
		List<Category> activeCategoryList=categoryRepository.findByIsActiveTrue();
		List<CategoryResponse> categoryResponse=activeCategoryList.stream().map(cat->mapper.map(cat, CategoryResponse.class)).toList();
		return categoryResponse;
	}

}

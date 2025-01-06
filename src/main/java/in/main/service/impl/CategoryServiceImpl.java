package in.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import in.main.entity.Category;
import in.main.repository.CategoryRepository;
import in.main.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Boolean saveCategory(Category category) {
		Category category1=categoryRepository.save(category);
		if(ObjectUtils.isEmpty(category1)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

}

package in.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.entity.Category;
import in.main.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		Boolean saved=categoryService.saveCategory(category);
		if(saved) {
			return new ResponseEntity<>("saved",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("save failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCategory(){
		List<Category> categories=categoryService.getAllCategory();
		if(CollectionUtils.isEmpty(categories)) {
			return ResponseEntity.noContent().build();
		}
		else {
			return new ResponseEntity<>(categories,HttpStatus.CREATED);
		}
	}
	
}

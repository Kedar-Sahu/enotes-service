package in.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}

package com.jamesluty.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesluty.productsandcategories.models.Category;
import com.jamesluty.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	List<Category> findAllByProducts(Product product);

	List<Category> findByProductsNotContains(Product product);
	
	Category findCategoryById(Long id);
}

package com.jamesluty.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesluty.productsandcategories.models.Category;
import com.jamesluty.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	List<Product> findAllByCategories(Category category);
//	
	List<Product> findByCategoriesNotContains(Category category);
	
	Product findProductById(Long id);
}

package com.jamesluty.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesluty.productsandcategories.models.Category;
import com.jamesluty.productsandcategories.models.Product;
import com.jamesluty.productsandcategories.repos.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
//	Create and update
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
//	Read
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	public List<Category> getProductList(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getNotProductList(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category getCategory(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
//	Delete
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
}

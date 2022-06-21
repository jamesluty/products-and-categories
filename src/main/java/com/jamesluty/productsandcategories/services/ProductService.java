package com.jamesluty.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesluty.productsandcategories.models.Category;
import com.jamesluty.productsandcategories.models.Product;
import com.jamesluty.productsandcategories.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
//	Create and update
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
//	Read
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public List<Product> getCategoryList(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getNotCatgoryList(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product getProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
//	Delete
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
}

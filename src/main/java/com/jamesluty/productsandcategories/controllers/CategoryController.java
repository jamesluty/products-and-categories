package com.jamesluty.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jamesluty.productsandcategories.models.Category;
import com.jamesluty.productsandcategories.models.Product;
import com.jamesluty.productsandcategories.services.CategoryService;
import com.jamesluty.productsandcategories.services.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	
//	Display routes
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@GetMapping("/category/show/{id}")
	public String showCategory(@ModelAttribute("newCategory") Product product, @PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categoryService.getCategory(id));
		model.addAttribute("notList", productService.getNotCatgoryList(categoryService.getCategory(id)));
		model.addAttribute("list", productService.getCategoryList(categoryService.getCategory(id)));
		return "showCategory.jsp";
	}
	
//	Action routes
	@PostMapping("/create/category")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryService.saveCategory(category);
			return "redirect:/";
		}
	}
	
	@PutMapping("/add/product/{id}")
	public String addCategoryToList(@PathVariable("id") Long id, @ModelAttribute("newCategory") Product product) {
		Product thisProduct = productService.getProduct(product.getId());
		Category thisCategory = categoryService.getCategory(id);
		thisCategory.getProducts().add(thisProduct);
		categoryService.saveCategory(thisCategory);
		return "redirect:/category/show/" + id;
	}
}

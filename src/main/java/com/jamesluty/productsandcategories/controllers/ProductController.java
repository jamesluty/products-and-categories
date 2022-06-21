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
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;
	
//	Display routes
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allProducts", productService.getAllProducts());
		model.addAttribute("allCategories", categoryService.getAllCategories());
		return "index.jsp";
	}
	
	@GetMapping("/product/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@GetMapping("/product/show/{id}")
	public String showProduct(@ModelAttribute("newProduct") Category category, @PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.getProduct(id));
		model.addAttribute("notList", categoryService.getNotProductList(productService.getProduct(id)));
		model.addAttribute("list", categoryService.getProductList(productService.getProduct(id)));
		return "showProduct.jsp";
	}
	
//	Action routes
	@PostMapping("/create/product")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productService.saveProduct(product);
			return "redirect:/";
		}
	}
	
	@PutMapping("/add/category/{id}")
	public String addProductToList(@PathVariable("id") Long id, @ModelAttribute("newProduct") Category category) {
		Category thisCategory = categoryService.getCategory(category.getId());
		System.out.println(category.getId());
		System.out.println(thisCategory.getName());
		System.out.println(id);
		Product thisProduct = productService.getProduct(id);
		thisProduct.getCategories().add(thisCategory);
		productService.saveProduct(thisProduct);
		return "redirect:/product/show/" + id;
	}
}

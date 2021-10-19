// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /products in URI - root
@Controller
@RequestMapping("/products")
public class ProductsController {

	/*
	 * Return a view name along with a model attribute Mapping - Invokes using '/'
	 * in URI after controller mapping '/products/'
	 * 
	 * @param Model
	 * 
	 * @return String
	 * 
	 */
	@GetMapping("/")
	public String displayProducts(Model model) {
		// Add model attribute Title
		// Set model attribute products
		model.addAttribute("title", "Products");
		model.addAttribute("products", ProductList.productList);
		// Set model attribute productModel to instance of a new productModel
		model.addAttribute("productModel", new ProductModel());
		return "products";
	}

	@PostMapping("/createProduct")
	public String createProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		// Set model attribute products
		model.addAttribute("title", "Products");
		model.addAttribute("products", ProductList.productList);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "error");
			return "products";
		}
		
		// Set model attribute productModel to instance of a new productModel
		model.addAttribute("productModel", new ProductModel());
		return "products";
	}

}

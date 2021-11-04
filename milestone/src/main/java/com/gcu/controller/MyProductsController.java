// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.model.LoggedInUser;
import com.gcu.model.ProductModel;

/**
 * Product Controller class - all URI's related to Product page belogn here 
 * @author melzs
 *
 */

//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /products in URI - root
@Controller
@RequestMapping("/myproducts")
public class MyProductsController {
	// Inject product service using dependency injection
	@Autowired
	private ProductBusinessServiceInterface productService; 

	/**
	 * Return a view name along with a model attribute Mapping - Invokes using '/'
	 * in URI after controller mapping '/products/'
	 * 
	 * @param model (Model) from products view
	 * 
	 * @return String for view forwarded to
	 * 
	 */
	@GetMapping("/")
	public String displayProducts(Model model) {
		// Add model attribute Title
		// Set model attribute products
		model.addAttribute("title", "My Products");
		model.addAttribute("products", productService.getMyProducts());
		// Set model attribute productModel to instance of a new productModel
		model.addAttribute("productModel", new ProductModel());
		model.addAttribute("user", LoggedInUser.user);
		return "myProducts";
	}
	
	/**
	 * Return a view name along with a model attribute Mappings - Invokes using
	 * '/createProduct' in URI after controller mapping '/products/createProduct'
	 * 
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return String for view forwarded to
	 */
	@PostMapping("/createProduct")
	public String createProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		// Set model attribute products
		model.addAttribute("title", "My Products");
		model.addAttribute("user", LoggedInUser.user);
		
		// Check to see if validation passes
		if (bindingResult.hasErrors()) {
			// Add error model attribute
			model.addAttribute("error", "error");
			model.addAttribute("products", productService.getMyProducts());
			return "myProducts";
		}
		
		// Add product to ArrayList utilizing service
		productService.createProduct(productModel);
		
		// Set model attribute productModel to instance of a new productModel
		model.addAttribute("productModel", new ProductModel());
		model.addAttribute("products", productService.getMyProducts());
		return "myProducts";
	}

}

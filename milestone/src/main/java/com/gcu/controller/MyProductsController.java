// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
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
import com.gcu.util.DatabaseException;
import com.gcu.util.ProductAlreadyExistsException;

/**
 * Product Controller class - all URI's related to Product page belong here 
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
	 * @throws DatabaseException 
	 * 
	 */
	@GetMapping("/")
	public String displayProducts(Model model) throws DatabaseException {
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
	 * @throws DatabaseException 
	 * @throws ProductAlreadyExistsException 
	 */
	@PostMapping("/createProduct")
	public String createProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model) throws DatabaseException, ProductAlreadyExistsException {
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
		
		try {
			//Call service to create product
			productService.createProduct(productModel);
		}catch (ProductAlreadyExistsException e){
			
			//If products already exists - return back to product form with validation binding result error 
			model.addAttribute("error", "error");
        	bindingResult.rejectValue("name", "error.product", "game already exists");
        	model.addAttribute("products", productService.getMyProducts());
        	return "myProducts";
		}
	
		// Set model attribute productModel to instance of a new productModel
		model.addAttribute("productModel", new ProductModel());
		//Set model attribute products to a new list of products in database
		model.addAttribute("products", productService.getMyProducts());
		return "myProducts";
	}

}

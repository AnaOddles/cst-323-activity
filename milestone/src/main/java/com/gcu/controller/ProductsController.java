// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Products Controller class - all URI's related to products page belong here
 * @author anasanchez
 *
 */
//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /products in URI - root
@Controller
@RequestMapping("/products")
public class ProductsController {

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
		model.addAttribute("title", "Products");
		return "products";
	}
}

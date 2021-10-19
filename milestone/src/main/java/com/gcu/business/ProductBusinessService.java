// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;
/**
 * Product Business Service used for product operations
 * @author melzs
 *
 */
@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {
	
	/**
	 * Method to create a product
	 * 
	 * @param product ProductModel that captures product properties
	 * @return void
	 */
	@Override
	public void createProduct(ProductModel productModel) {
		// Retrieve ID by looking at the size of the ArrayList
		int id = ProductList.productList.size();
		// Set product model equal to ID
		productModel.setId(id);
		// Add product to ArrayList
		ProductList.productList.add(productModel);
		// Print that the ProductModel was created
		System.out.println("ProductModel Registered: " + productModel.toString());
	}
	
	/**
	 * Method for spring bean upon init
	 */
	@Override
	public void init() {
		System.out.println("Initialize ProductBusinessService");
	}
	
	/**
	 * Method for spring bean upon destroy
	 */
	@Override
	public void destroy() {
		System.out.println("Destroy ProductBusinessService");
	}

}

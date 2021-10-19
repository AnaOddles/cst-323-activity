// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.business;

import com.gcu.model.ProductModel;

/**
 * Interface that specifies functionality for product operations
 * @author melzs
 *
 */
public interface ProductBusinessServiceInterface {
	// Methods
	
	/**
	 * Method to create product
	 * 
	 * @param productModel
	 * 
	 * @return void
	 */
	void createProduct(ProductModel productModel);
	/**
	 * Method for spring bean upon init
	 */
	void init();
	/**
	 * Method for spring bean upon destroy
	 */
	void destroy();
}

// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.ProductAlreadyExistsException;

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
	 * @return boolean
	 * @throws DatabaseException 
	 * @throws ProductAlreadyExistsException 
	 */
	boolean createProduct(ProductModel productModel) throws DatabaseException, ProductAlreadyExistsException;
	
	/**
	 * Method to edit product
	 * 
	 * @param productModel
	 * 
	 * @return boolean
	 * @throws DatabaseException 
	 * @throws ProductAlreadyExistsException 
	 */
	boolean editProduct(ProductModel productModel) throws DatabaseException, ProductAlreadyExistsException;
	
	/**
	 * Method to delete product
	 * 
	 * @param productModel
	 * 
	 * @return boolean
	 * @throws DatabaseException 
	 * @throws ProductAlreadyExistsException 
	 */
	boolean deleteProduct(ProductModel productModel) throws DatabaseException; 
	
	/**
	 * 
	 * Exception
	 * 
	 * @return List Product Model
	 * @throws DatabaseException
	 */
	List<ProductModel> getProducts() throws DatabaseException;
	
	/**
	 * 
	 * Exception
	 * 
	 * @return List Product Model
	 * @throws DatabaseException
	 */
	List<ProductModel> getMyProducts() throws DatabaseException;
	
	ProductModel getByGameId(long id) throws DatabaseException;
	
	/**
	 * Method for spring bean upon init
	 * 
	 * @return void
	 */
	void init();
	
	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	void destroy();
}

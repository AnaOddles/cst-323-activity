// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.LoggedInUser;
import com.gcu.model.ProductModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.ProductAlreadyExistsException;
import com.gcu.util.UserAlreadyExistsException;

/**
 * Product Business Service used for product operations
 * 
 * @author melzs
 *
 */
@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Autowired
	ProductsDataService service;

	/**
	 * Method to create a product
	 * 
	 * @param product ProductModel that captures product properties
	 * @return void
	 * @throws DatabaseException 
	 * @throws ProductAlreadyExistsException 
	 */
	@Override
	public boolean createProduct(ProductModel productModel) throws DatabaseException, ProductAlreadyExistsException {
		System.out.println("Create Product Business Service");
		
		//Call the products data service to create product
		
		//If A product already exists - throw exception
		if(!service.create(new ProductEntity(LoggedInUser.user.getId(), productModel.getName(),
				productModel.getPublisher(), productModel.getGenre(), productModel.getRating(),
				productModel.getPlatform(), productModel.getImage(), productModel.getDescription()))){
			System.out.println("Cannot create duplicate product");
			throw new ProductAlreadyExistsException();
		}
			
		return true;
	}

	/**
	 * Method to get all products for all users
	 * 
	 * @return void
	 * @throws DatabaseException 
	 */
	@Override
	public List<ProductModel> getProducts() throws DatabaseException {
		
		//Call service to grab all products
		List<ProductEntity> productsEntity = service.findAll();

		//Prepping to return a list of product model for view
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for (ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getProductId(), entity.getUserId(), entity.getName(),
					entity.getPublisher(), entity.getGenre(), entity.getRating(), entity.getPlatform(),
					entity.getImage(), entity.getDescription()));
		}

		return productsDomain;

	}
	
	/**
	 * Method to get all products for logged in user
	 * @return void
	 * @throws DatabaseException 
	 */
	@Override
	public List<ProductModel> getMyProducts() throws DatabaseException {		
		
		//Call service to bran all products for logged in user
		List<ProductEntity> productsEntity = service.findByUserId(LoggedInUser.user.getId());

		//Prepping to return a list of products models for view
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for (ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getProductId(), entity.getUserId(), entity.getName(),
					entity.getPublisher(), entity.getGenre(), entity.getRating(), entity.getPlatform(),
					entity.getImage(), entity.getDescription()));
		}

		return productsDomain;
	}


	/**
	 * Method for spring bean upon init
	 * 
	 * @return void
	 */
	@Override
	public void init() {
		System.out.println("Initialize ProductBusinessService");
	}

	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	@Override
	public void destroy() {
		System.out.println("Destroy ProductBusinessService");
	}

}

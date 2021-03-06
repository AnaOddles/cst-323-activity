// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.ProductAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;

/**
 * Product Business Service used for product operations
 * 
 * @author melzs
 *
 */
@Slf4j
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
		log.debug("In Products Business Service - createProduct");

		// Call the products data service to create product

		// If A product already exists - throw exception
		if (!service.create(new ProductEntity(productModel.getName(),
				productModel.getPublisher(), productModel.getGenre(), productModel.getRating(),
				productModel.getPlatform(), productModel.getImage(), productModel.getDescription()))) {
			// Log error and throw exception
			log.error("Cannot create duplicate product - " + productModel.getName());
			throw new ProductAlreadyExistsException();
		}

		return true;
	}

	/**
	 * Method to edit a product
	 * 
	 * @param product ProductModel that captures product properties
	 * @return boolean
	 * @throws DatabaseException
	 * @throws ProductAlreadyExistsException
	 */
	@Override
	public boolean editProduct(ProductModel productModel) throws DatabaseException, ProductAlreadyExistsException {
		log.debug("In Products Business Service - editProduct");

		// If a product already exists - throw exception
		if (!service.update(new ProductEntity(productModel.getId(), productModel.getName(),
				productModel.getPublisher(), productModel.getGenre(), productModel.getRating(),
				productModel.getPlatform(), productModel.getImage(), productModel.getDescription()))) {
			// Log error and throw exception
			log.error("Cannot update to duplicate product - " + productModel.getName());
			throw new ProductAlreadyExistsException();
		};
		
		return true;
	}

	/**
	 * Method to delete a product
	 * 
	 * @param product ProductModel that captures product properties
	 * @return void
	 * @throws DatabaseException
	 * @throws ProductAlreadyExistsException
	 */
	@Override
	public boolean deleteProduct(ProductModel productModel) throws DatabaseException {
		log.debug("In Products Business Service - deleteProduct");
		// Delete product
		return service.delete(new ProductEntity(productModel.getId(), productModel.getName(),
				productModel.getPublisher(), productModel.getGenre(), productModel.getRating(),
				productModel.getPlatform(), productModel.getImage(), productModel.getDescription()));
	}

	/**
	 * Method to get all products for all users
	 * 
	 * @return void
	 * @throws DatabaseException
	 */
	@Override
	public List<ProductModel> getProducts() throws DatabaseException {
		log.debug("In Products Business Service - getProducts");

		// Call service to grab all products
		List<ProductEntity> productsEntity = service.findAll();

		// Prepping to return a list of product model for view
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for (ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getProductId(), entity.getName(),
					entity.getPublisher(), entity.getGenre(), entity.getRating(), entity.getPlatform(),
					entity.getImage(), entity.getDescription()));
		}

		return productsDomain;

	}
	
	/**
	 * Method to get a product by its GameID
	 * 
	 * @return ProductModel
	 * @throws DatabaseException
	 */
	@Override
	public ProductModel getByGameId(long id) throws DatabaseException {
		// TODO Auto-generated method stub
		log.debug("Get product by GameId");
		try {
			ProductEntity entity = service.findByGameId(id);
			// Create Product based off Entity
			ProductModel product = new ProductModel(entity.getProductId(), entity.getName(),
					entity.getPublisher(), entity.getGenre(), entity.getRating(), entity.getPlatform(),
					entity.getImage(), entity.getDescription());

			return product;
		} catch (Exception e) {
			// Catch and throw exception
			throw new DatabaseException();
		}
	}

	/**
	 * Method to get all products for logged in user
	 * 
	 * @return List<ProductModel>
	 * @throws DatabaseException
	 */
	@Override
	public List<ProductModel> getMyProducts() throws DatabaseException {
		log.debug("In Products Business Service - getMyProducts");

		// Call service to bran all products for logged in user
		List<ProductEntity> productsEntity = service.find();

		// Prepping to return a list of products models for view
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();

		// Create product models to return back to products view
		for (ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getProductId(), entity.getName(),
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
		log.debug("Initialize ProductBusinessService");
	}

	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	@Override
	public void destroy() {
		log.debug("Destroy ProductBusinessService");
	}

}

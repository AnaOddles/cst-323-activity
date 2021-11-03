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
	 */
	@Override
	public boolean createProduct(ProductModel productModel) {
		
		return service.create(new ProductEntity(productModel.getId(), LoggedInUser.user.getId(), productModel.getName(),
				productModel.getPublisher(), productModel.getGenre(), productModel.getRating(),
				productModel.getReleaseDate(), productModel.getImage(), productModel.getDescription()));

	}

	@Override
	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> productsEntity = service.findAll();

		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for (ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getId(), entity.getUserId(), entity.getName(),
					entity.getPublisher(), entity.getGenre(), entity.getRating(), entity.getReleaseDate(),
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

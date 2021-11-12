// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;
import com.gcu.model.LoggedInUser;
import com.gcu.util.DatabaseException;
import lombok.extern.slf4j.Slf4j;

/**
 * Data service class for products
 * @author anasanchez
 *
 */
@Slf4j
@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductsRepository productsRepository;

	/**
	 * Constructpr
	 * 
	 * @param productsRepository
	 */
	public ProductsDataService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	/**
	 * Returns List of Product Entity with Database Exception
	 * 
	 * @return List<ProductEntity> 
	 * @throws DatabaseException
	 */
	@Override
	public List<ProductEntity> findAll() throws DatabaseException {
		log.debug("In Products Data Service - findAll");
		
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			//Use products repository and use findAll() query
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();

			//Make a new array list for our products
			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

		//Exception handling for database errors
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}

		return products;

	}

	/**
	 * Create new Product Entity with Database Exception
	 * 
	 * @return boolean
	 * @param ProductEntity
	 * @throws DatabaseException
	 */
	@Override
	public boolean create(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - create");
		log.info("Creating product " + product.toString());
		
		try {
			//Use products repository to find product using query findByNameAndUserId
			if (this.productsRepository.findByNameAndUserId(product.getName(), LoggedInUser.user.getId()) != null) {
				//If a product already exists for the user logged in with that name 
				return false;
			}
			//If this product is a unique product - use product repository to save product into db
			this.productsRepository.save(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			//Throw database exception if databse error occurs
			throw new DatabaseException(e, "Database exception");
		}
		return true;
	}

	/**
	 * Update a product with Database Exception 
	 * @return boolean
	 * @throws DatabaseException
	 * @param ProductEntity
	 */
	@Override
	public boolean update(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - update");
		log.info("Updating product: " + product.toString());
		
		try {
			//Use products repository to find any products that already exist - so user does not edit a game and add a duplicate 
			if (this.productsRepository.findDuplicateProduct(product.getName(), product.getProductId(), LoggedInUser.user.getId()) != null) {
				return false;
			}
			//Persist the game to the database using the products repository
			this.productsRepository.save(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}

		return true;
	}

	/**
	 * Delete a product with Database Exception 
	 * @return boolean
	 * @throws DatabaseException
	 * @param ProductEntity
	 */
	@Override
	public boolean delete(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - delete");
		log.info("Deleting product: " + product.toString());
		
		try {
			//Use products repository to call delete query for seleted game
			this.productsRepository.delete(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}

		return true;
	}

	/**
	 * Find List of Product Entity by user id with Database Exception
	 * 
	 * @param userId
	 * @return List<ProductEntity>
	 * @throws DatabaseException
	 */
	public List<ProductEntity> findByUserId(long userId) throws DatabaseException {
		log.debug("In Products Data Service - findByUserId");
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			//Call products repository to find a users games using their user id
			Iterable<ProductEntity> productsIterable = productsRepository.findByUserId(userId);

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}

		return products;
	}

	/**
	 * Return Optional Product Entity Find by ID
	 * 
	 * @return Optional<ProductEntity>
	 * @param int id
	 */
	@Override
	public Optional<ProductEntity> findById(int id) {
		log.debug("In Products Data Service - findById");
		return null;
	}

}

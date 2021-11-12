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
	 * @return List Product Entity
	 */
	@Override
	public List<ProductEntity> findAll() throws DatabaseException {
		log.debug("In Products Data Service - findAll");
		
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

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
	 */
	@Override
	public boolean create(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - create");
		log.info("Creating product " + product.toString());
		
		try {
			if (this.productsRepository.findByNameAndUserId(product.getName(), LoggedInUser.user.getId()) != null) {
				return false;
			}
			this.productsRepository.save(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}
		return true;
	}

	/**
	 * Not yet Implemented
	 */
	@Override
	public boolean update(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - update");
		log.info("Updating product: " + product.toString());
		
		try {
			if (this.productsRepository.findDuplicateProduct(product.getName(), product.getProductId(), LoggedInUser.user.getId()) != null) {
				return false;
			}
			this.productsRepository.save(product);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DatabaseException(e, "Database exception");
		}

		return true;
	}

	/**
	 * Not yet Implemented
	 */
	@Override
	public boolean delete(ProductEntity product) throws DatabaseException {
		log.debug("In Products Data Service - delete");
		// TODO Auto-generated method stub
		log.info("Deleting product: " + product.toString());
		try {
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
	 * @return List Product Entity
	 * @throws DatabaseException
	 */
	public List<ProductEntity> findByUserId(long userId) throws DatabaseException {
		log.debug("In Products Data Service - findByUserId");
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
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
	 * @return Optional Product Entity
	 */
	@Override
	public Optional<ProductEntity> findById(int id) {
		log.debug("In Products Data Service - findById");
		return null;
	}

}

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
import com.gcu.util.DatabaseException;

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
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

		} catch (Exception e) {
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
		System.out.println("Product Data Service Create - Product: " + product.toString());
		try {
			if (this.productsRepository.findByName(product.getName()) != null) {
				return false;
			}
			this.productsRepository.save(product);
		} catch (Exception e) {
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
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findByUserId(userId);

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

		} catch (Exception e) {
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
		// TODO Auto-generated method stub

		return null;
	}

	/**
	 * Not yet Implemented
	 */
	@Override
	public boolean update(ProductEntity product) {
		// TODO Auto-generated method stub
		System.out.println("Product Data Service Edit - Product: " + product.toString());
		
		this.productsRepository.save(product);
		
		
		return false;
	}

	/**
	 * Not yet Implemented
	 */
	@Override
	public boolean delete(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}

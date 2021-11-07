package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.ProductsRepository;
import com.gcu.util.DatabaseException;

@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductsRepository productsRepository;

	public ProductsDataService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

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

	@Override
	public boolean create(ProductEntity product) throws DatabaseException {
		System.out.println("Product Data Service Create - Product: " + product.toString());
		try {
			if(this.productsRepository.findByName(product.getName()) != null) {
				return false; 
			}
			this.productsRepository.save(product);
		} catch (Exception e) {
			throw new DatabaseException(e, "Database exception");
		}
		return true;
	}

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

	@Override
	public Optional<ProductEntity> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}

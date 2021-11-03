package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;

@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductsRepository productsRepository;

	public ProductsDataService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);

		} catch (Exception e) {
			// TODO Exception handling
			e.printStackTrace();
		}

		return products;

	}

	@Override
	// TODO Exception handling
	public boolean create(ProductEntity product) {
		System.out.println("Product Data Service Create - Product: " + product.toString());
		// TODO Auto-generated method stub
		try {
			this.productsRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ProductEntity findById(int id) {
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

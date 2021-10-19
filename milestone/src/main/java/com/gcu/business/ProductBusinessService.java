package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Override
	public void createProduct(ProductModel productModel) {
		// Retrieve ID by looking at the size of the ArrayList
		int id = ProductList.productList.size();
		// Set product model equal to ID
		productModel.setId(id);
		// Add product to ArrayList
		ProductList.productList.add(productModel);
		// Print that the ProductModel was created
		System.out.println("ProductModel Registered: " + productModel.toString());
	}

	@Override
	public void init() {
		System.out.println("Initialize ProductBusinessService");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy ProductBusinessService");
	}

}

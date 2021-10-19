package com.gcu.business;

import com.gcu.model.ProductModel;

public interface ProductBusinessServiceInterface {
	// Methods
	void createProduct(ProductModel productModel);
	void init();
	void destroy();
}

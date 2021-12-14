// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;

// Rest Controller for REST API
@RestController
@RequestMapping("/service")
public class ProductRestService {
	
	// Autowire Products Service
	@Autowired
	private ProductBusinessServiceInterface service;
	
	/**
	 * Returns all products in JSON Format
	 * /service/getproducts
	 * 
	 * @return Response Entity - List of all products
	 */
	@GetMapping(path = "/getproducts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getProducts() {
		try {
			// Get List of ProductModel
			List<ProductModel> productList = service.getProducts();
			// No products --> return not found
			if (productList == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				// All products --> OK return
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
		} catch (Exception e) {
			// Internal server error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Returns one users products in JSON Format 
	 * /service/getmyproducts
	 * 
	 * @return Response Entity - List of users products
	 */
	@GetMapping(path = "/getmyproducts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getMyProdcts() {
		try {
			// Get List of ProductModel
			List<ProductModel> productList = service.getMyProducts();
			// No products --> return not found
			if (productList == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				// All products --> OK return
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
		} catch (Exception e) {
			// Internal server error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Returns one product by its ID
	 * /service/getproduct/{id}
	 * 
	 * @param id
	 * @return Return one product by its ID
	 */
	@GetMapping(path = "/getproduct/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
		try {
			// Get ProductModel
			ProductModel product = service.getByGameId(id);
			// No product --> return not found
			if (product == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				// Found product --> return OK
				return new ResponseEntity<>(product, HttpStatus.OK);
			} 
		} catch (Exception e) {
			// Internal server error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

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
			List<ProductModel> productList = service.getProducts();
			if (productList == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
		} catch (Exception e) {
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
			List<ProductModel> productList = service.getMyProducts();
			if (productList == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(productList, HttpStatus.OK);
			}
		} catch (Exception e) {
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
			ProductModel product = service.getByGameId(id);
			if (product == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			} 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

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
import com.gcu.util.DatabaseException;

@RestController
@RequestMapping("/service")
public class ProductRestService {

	@Autowired
	private ProductBusinessServiceInterface service;

	@GetMapping(path = "/getproducts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ProductModel> getProducts() throws DatabaseException {
		return service.getProducts();
	}

	@GetMapping(path = "/getmyproducts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ProductModel> getMyProdcts() throws DatabaseException {
		return service.getMyProducts();
	}

	@GetMapping(path = "/getproduct/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") long id) throws DatabaseException {
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

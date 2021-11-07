// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {
	/**
	 * Returns Iterable Products by userId
	 * @param userId
	 * @return Iterable Product Entity
	 */
	@Query("SELECT * FROM games WHERE user_Id = :userId")
	Iterable<ProductEntity> findByUserId(long userId);
	/**
	 * Find Product by Name
	 * @param name
	 * @return ProductEntity
	 */
	ProductEntity findByName(String name);
}

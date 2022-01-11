// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
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
	@Query("SELECT * FROM games")
	Iterable<ProductEntity> find();
	
	/**
	 * Find Product by Name
	 * @param String name
	 * @param long userId
	 * @return ProductEntity product
	 */
	@Query("SELECT * FROM games WHERE name = :name")
	ProductEntity findByName(String name);
	
	/**
	 * Find a game by Id
	 * @param long gameId

	 * @return ProductEntity product∂
	 */
	@Query("SELECT * FROM games WHERE game_id = :gameId")
	ProductEntity findByGameId(long gameId);
	
	/**
	 * Returns any duplicate products 
	 * @param String name
	 * @param long productId
	 * @param long userId
	 * @return ProductEntity 
	 */
	@Query("SELECT * FROM games WHERE name = :name AND game_Id != :productId")
	ProductEntity findDuplicateProduct(String name,long productId);
}

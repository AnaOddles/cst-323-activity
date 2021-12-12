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
	 * @param String name
	 * @param long userId
	 * @return ProductEntity product
	 */
	@Query("SELECT * FROM games WHERE name = :name AND user_Id = :userId")
	ProductEntity findByNameAndUserId(String name, long userId);
	
	/**
	 * Find Product by GameId
	 * @param gameId
	 * @return ProductEntity product
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
	@Query("SELECT * FROM games WHERE name = :name AND game_Id != :productId AND user_Id = :userId")
	ProductEntity findDuplicateProduct(String name,long productId, long userId);
}

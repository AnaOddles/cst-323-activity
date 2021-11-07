// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity> {
	/**
	 * Product Entity Map Row
	 * @return productEntity
	 */
	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new ProductEntity(rs.getLong("game_Id"), rs.getLong("user_Id"), rs.getString("name"),
				rs.getString("publisher"), rs.getString("genre"), rs.getString("rating"), rs.getString("platform"),
				rs.getString("image"), rs.getString("description"));
	}

}

package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new ProductEntity(rs.getLong("id"), rs.getLong("userId"), rs.getString("name"),
				rs.getString("publisher"), rs.getString("genre"), rs.getString("rating"), rs.getString("platform"),
				rs.getString("image"), rs.getString("description"));
	}

}

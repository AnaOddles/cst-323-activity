package com.gcu.data.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;

public interface ProfilesRepository extends CrudRepository<UserEntity, Long> {
	
}

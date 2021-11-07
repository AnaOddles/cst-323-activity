package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByUsernameAndPassword(String username, String password);
	UserEntity findByUsername(String username);
}

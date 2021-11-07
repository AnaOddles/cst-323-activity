// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.ProfileEntity;

public interface ProfilesRepository extends CrudRepository<ProfileEntity, Long> {
	
}

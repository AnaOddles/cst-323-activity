// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.ProfileEntity;

public interface ProfilesRepository extends CrudRepository<ProfileEntity, Long> {
	
}

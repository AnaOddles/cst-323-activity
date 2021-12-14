// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.data;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gcu.data.entity.ProfileEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.ProfilesRepository;
import com.gcu.data.repository.UsersRepository;
import com.gcu.util.DatabaseException;
/**
 * Data service class for user
 * @author anasanchez
 *
 */
// Service
@Service
public class UsersDataService implements DataAccessInterface<UserEntity> {
	
	// Autowire Repositories
	@Autowired
	private UsersRepository usersRepository;
	private ProfilesRepository profilesRepository;

	/**
	 * Constructor
	 * 
	 * @param usersRepository
	 * @param profilesRepository
	 */
	public UsersDataService(UsersRepository usersRepository, ProfilesRepository profilesRepository) {
		this.usersRepository = usersRepository;
		this.profilesRepository = profilesRepository;
	}

	/**
	 * Transaction Creates User and Profile with Database Exception
	 * 
	 * @param UserEntity user
	 * @param ProfileEntity profile
	 * @return Integer
	 * @throws DatabaseException
	 */
	@Transactional
	public int create(UserEntity user, ProfileEntity profile) throws DatabaseException {
		try {
			//Use user repository for query that finds if user already exists by using username
			if (this.usersRepository.findByUsername(user.getUsername()) != null) {
				//exit and return 1 if user exists
				return 1;
			}
			
			// Encode Password
			String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encoded);
			
			//If user does not already exist - use users repository to persist into db
			user = this.usersRepository.save(user);
			//Grab the userId from user just added into database and set it o to profile entity
			profile.setUserId(user.getUserId());
			//Use profules repository to persist a new profile for the user refistered
			this.profilesRepository.save(profile);

		} catch (Exception e) {
			//Throw database exception if database error occurs
			throw new DatabaseException(e, "Database exception");
		}
		return 0;
	}

	/**
	 * Not Implemented
	 */
	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns Optional<UserEntity>
	 * 
	 * @param Integer id
	 */
	@Override
	public Optional<UserEntity> findById(int id) {
		//Call users repository tp find a user by its ID
		return usersRepository.findById((long) id);
	}

	/**
	 * Not Implemented
	 */
	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not Implemented
	 */
	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not Implemented
	 */
	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}

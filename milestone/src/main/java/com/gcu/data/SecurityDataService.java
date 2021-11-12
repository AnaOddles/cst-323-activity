// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;
import com.gcu.util.DatabaseException;
import lombok.extern.slf4j.Slf4j;
/**
 * Data service class for security
 * @author anasanchez
 *
 */
@Slf4j
@Service
public class SecurityDataService implements DataAccessInterface<UserEntity> {

	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Constructor
	 * 
	 * @param usersRepository
	 */
	public SecurityDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
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
	 * Not Implemented
	 */
	@Override
	public Optional<UserEntity> findById(int id) {
		return null;
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

	/**
	 * Returns User Entity Credentials with Database Exception
	 * 
	 * @param UserEntity
	 * @return User Entity
	 * @throws DatabaseException
	 */
	public UserEntity findByCredentials(UserEntity t) throws DatabaseException {
		//Try catch to catch any database errors
		try {
			// Use user repository to see if username and password exist
			usersRepository.findByUsernameAndPassword(t.getUsername(), t.getPassword());
			
		} catch (Exception e) {
			//throw database exception custom exception
			throw new DatabaseException(e, "Database exception");
		}
		//If no errors use user repository to check if users exists with passed in username and password
		return usersRepository.findByUsernameAndPassword(t.getUsername(), t.getPassword());
	}
}

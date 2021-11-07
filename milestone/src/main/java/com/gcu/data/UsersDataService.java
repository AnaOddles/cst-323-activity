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
import org.springframework.transaction.annotation.Transactional;
import com.gcu.data.entity.ProfileEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.ProfilesRepository;
import com.gcu.data.repository.UsersRepository;
import com.gcu.util.DatabaseException;

@Service
public class UsersDataService implements DataAccessInterface<UserEntity> {

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
	 * @param user
	 * @param profile
	 * @return Integer
	 * @throws DatabaseException
	 */
	@Transactional
	public int create(UserEntity user, ProfileEntity profile) throws DatabaseException {
		System.out.println("User Data Service Create - User: " + user.toString());
		System.out.println("Profile Data Service Create - Profile: " + profile.toString());

		try {

			if (this.usersRepository.findByUsername(user.getUsername()) != null) {
				System.out.println("User already exists");
				return 1;
			}
			user = this.usersRepository.save(user);
			profile.setUserId(user.getUserId());
			System.out.println(profile.getUserId());
			this.profilesRepository.save(profile);

		} catch (Exception e) {
			// e.printStackTrace();
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
	 * Returns Optional User Entity
	 * 
	 * @param id
	 */
	@Override
	public Optional<UserEntity> findById(int id) {
		System.out.println("Grabbing a user with id: " + id);
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

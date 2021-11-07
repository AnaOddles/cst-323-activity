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
public class UsersDataService implements DataAccessInterface<UserEntity>{

	@Autowired
	private UsersRepository usersRepository;
	private ProfilesRepository profilesRepository; 

	public UsersDataService(UsersRepository usersRepository,ProfilesRepository profilesRepository) {
		this.usersRepository = usersRepository;
		this.profilesRepository = profilesRepository;
	}

	@Transactional 
	public int create(UserEntity user, ProfileEntity profile) throws DatabaseException {
		System.out.println("User Data Service Create - User: " + user.toString());
		System.out.println("Profile Data Service Create - Profile: " + profile.toString());

		try {
			
			if(this.usersRepository.findByUsername(user.getUsername()) != null){
				System.out.println("User already exists");
				return 1;
			}
			user = this.usersRepository.save(user);
			profile.setUserId(user.getUserId());
			System.out.println(profile.getUserId());
			this.profilesRepository.save(profile); 
			
		} catch (Exception e) {
			//e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
		return 0;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findById(int id) {
		System.out.println("Grabbing a user with id: " + id);
		return usersRepository.findById((long) id);
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}

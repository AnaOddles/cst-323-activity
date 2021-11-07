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

@Service
public class SecurityDataService implements DataAccessInterface<UserEntity>{

	@Autowired
	private UsersRepository usersRepository;

	public SecurityDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findById(int id) {
		return null;
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
	
	public UserEntity findByCredentials(UserEntity t) throws DatabaseException {
		
		try {
			System.out.println("Loggining in: " + t.toString());
			System.out.println(usersRepository.findByUsernameAndPassword(t.getUsername(), t.getPassword()));
		
			//Use user repository to see if username and password exist
			if(usersRepository.findByUsernameAndPassword(t.getUsername(), t.getPassword()) == null) {
				System.out.println("Invalid credentials!");
			}
		
		}catch(Exception e){
			e.printStackTrace();
			throw new DatabaseException(e, "Database exception");
		}
		return usersRepository.findByUsernameAndPassword(t.getUsername(), t.getPassword());			
	}
}

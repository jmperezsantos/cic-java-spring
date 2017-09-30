package mx.ipn.cic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.model.User;
import mx.ipn.cic.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userReposiory;

	public List<User> getAll() {

		List<User> users = this.userReposiory.fetchAll();

		return users;

	}

	public User findById(Integer id) {

		User user = this.userReposiory.fetchById(id);

		return user;

	}

	public User create(User user) {

		user = this.userReposiory.save(user);

		return user;
	}

	public User update(User user) {

		user = this.userReposiory.update(user);
		
		return user;

	}
	
	public boolean delete(Integer id) {

		User user = this.findById(id);
		
		boolean success = this.userReposiory.delete(user);
		
		return success;
				

	}

}

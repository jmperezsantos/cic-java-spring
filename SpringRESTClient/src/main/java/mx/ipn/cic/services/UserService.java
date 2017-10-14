package mx.ipn.cic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.RESTServices.UserRestService;
import mx.ipn.cic.model.User;

@Service
public class UserService {

	@Autowired
	private UserRestService userRestService;

	public List<User> getAll() {

		List<User> users = this.userRestService.fetchAll();

		return users;

	}

	public User findById(Integer id) {

		User user = this.userRestService.fetchById(id);

		return user;

	}

	public User create(User user) {

		user = this.userRestService.save(user);

		return user;
	}

	public User update(User user) {

		user = this.userRestService.update(user);
		
		return user;

	}
	
	public boolean delete(Integer id) {

		User user = this.findById(id);
		
		boolean success = this.userRestService.delete(user);
		
		return success;
				

	}

}

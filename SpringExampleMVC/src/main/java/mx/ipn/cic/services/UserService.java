package mx.ipn.cic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.ipn.cic.model.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<User>();
	private long max = 0;

	public List<User> getAll() {
		return this.users;
	}

	public User findById(long id) {

		User u = null;
		for (User user : this.users) {
			if (user.getId() == id) {
				u = user;
				break;
			}
		}

		return u;

	}

	public User create(User user) {

		user.setId(++max);

		this.users.add(user);

		return user;
	}

	public boolean delete(long id) {

		User user = this.findById(id);

		return this.users.remove(user);

	}

	public User update(User user) {

		return user;

	}

}

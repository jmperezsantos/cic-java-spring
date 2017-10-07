package mx.ipn.cic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.ipn.cic.model.User;
import mx.ipn.cic.services.GenericModelService;

@Controller
@RequestMapping(value = "/rest/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRESTController {

	@Autowired
	private GenericModelService<User> userService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getAll() {

		List<User> users = this.userService.getAll(User.class);

		return users;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getById(@PathVariable Integer id) {

		User user = this.userService.findById(User.class, id);

		return user;

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User create(@RequestBody User user) {

		user = this.userService.create(user);

		return user;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody User update(@PathVariable Integer id, @RequestBody User user) {

		user.setId(id);
		user = this.userService.update(user);

		return user;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable Integer id) {

		boolean deleted = this.userService.delete(User.class, id);

		return deleted;

	}

}

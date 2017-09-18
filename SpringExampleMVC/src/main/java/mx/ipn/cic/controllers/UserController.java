package mx.ipn.cic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.ipn.cic.model.User;
import mx.ipn.cic.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Método se formularios

	/**
	 * Obtiene el formulario de nuevo registro
	 * 
	 * @return path al jsp requerido
	 */
	@RequestMapping(value = "/newForm", method = RequestMethod.GET)
	public String getNewForm() {

		return "user/new_user";
	}

	/**
	 * Obtiene formulario para modificación de usuario
	 * 
	 * @param id
	 *            el identificador del usuario a modificar
	 * @return path al jsp requerido
	 */
	@RequestMapping(value = "/{id}/updateForm", method = RequestMethod.GET)
	public String getupdateForm(@PathVariable Integer id, Model model) {

		User user = this.userService.findById(id);

		model.addAttribute("user", user);

		return "user/update_form";
	}

	// Métodos CRUD

	/**
	 * Método para obtener todos los usuarios registrados
	 * 
	 * @return path de jsp para mostrar una lista (tabla) de usuarios
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {

		List<User> userList = this.userService.getAll();
		model.addAttribute("users", userList);

		return "user/all";
	}

	/**
	 * Obtiene el detalle de un usuario
	 * 
	 * @param id
	 *            Identificador del usuario requerido
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getById(@PathVariable Integer id, Model model) {

		User user = this.userService.findById(id);
		model.addAttribute("user", user);

		return "user/single_user";
	}

	/**
	 * Método para crear un nuevo registro
	 * 
	 * @param name
	 *            nombre del usuario
	 * @param lastname
	 *            appellido del usuario
	 * @param age
	 *            edad del usuario
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	//public String newRegister(String name, String lastname, int age) {
	public String newRegister(User newUser) {

//		User newUser = new User(name, lastname, age);
		this.userService.create(newUser);

		// model.addAttribute("message", "Usuario creado con id: " +
		// user.getId());

		return "user/ok";
	}

	/**
	 * Método para actualizar/modificar un registro
	 * 
	 * @param id
	 *            identificador del usuario a modificar
	 * @param name
	 *            nombre "modificado"
	 * @param lastName
	 *            apellido "modificado"
	 * @param age
	 *            edad "modificada"
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, String name, String lastname, int age) {

		User user = this.userService.findById(id);

		if (user != null) {

			user.setName(name);
			user.setLastname(lastname);
			user.setAge(age);

			this.userService.update(user);

		}

		// model.addAttribute("message", "Usuario modificado con id: +
		// user.getId()");

		return "user/ok";
	}

	/**
	 * Método para eliminar un usuario
	 * 
	 * @param id
	 *            identificador del usuario a eliminar
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {

		this.userService.delete(id);

		// model.addAttribute("message", "Usuario eliminado con id: +
		// user.getId()");

		return "user/ok";
	}

}

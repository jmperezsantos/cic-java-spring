package mx.ipn.cic.model;

import java.io.Serializable;
import java.util.List;


public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String description;
	
	private List<User> users;

	public Rol(String name, String description) {
		super();
		
		this.name = name;
		this.description = description;
	}

	public Rol() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}

package mx.ipn.cic.RESTServices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.ipn.cic.model.User;

@Service
public class UserRestService {

	public List<User> fetchAll() {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User[]> entity = new HttpEntity<User[]>(headers);

		ResponseEntity<User[]> response =
				restTemplate.exchange("http://127.0.0.1:8080/cic/rest/user", 
				HttpMethod.GET,
				entity, 
				User[].class);
		
		User[] users = response.getBody();
		
		List<User> userList = Arrays.asList(users);

		return userList;

	}

	/**
	 * Método para obtener un usuario por su identificador
	 * 
	 * @param id
	 *            Identificador del usuario a buscar
	 * @return El usuario encontrado o "null" si no existe
	 */
	public User fetchById(Integer id) {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User> entity = new HttpEntity<User>(headers);

		String url = String.format("http://127.0.0.1:8080/cic/rest/user/%d", id);
		ResponseEntity<User> response =
				restTemplate.exchange(url, 
				HttpMethod.GET,
				entity, 
				User.class);
		
		User user = response.getBody();

		return user;

	}

	public User save(User user) {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		
		ResponseEntity<User> response =
				restTemplate.exchange("http://127.0.0.1:8080/cic/rest/user", 
				HttpMethod.POST,
				entity, 
				User.class);
		
		user = response.getBody();

		return user;

	}

	public User update(User user) {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		
		String url = String.format("http://127.0.0.1:8080/cic/rest/user/%d", user.getId());
		ResponseEntity<User> response =
				restTemplate.exchange(url, 
				HttpMethod.PUT,
				entity, 
				User.class);
		
		user = response.getBody();

		return user;

	}

	public boolean delete(User user) {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Boolean> entity = new HttpEntity<Boolean>(headers);
		
		String url = String.format("http://127.0.0.1:8080/cic/rest/user/%d", user.getId());
		ResponseEntity<Boolean> response =
				restTemplate.exchange(url, 
				HttpMethod.DELETE,
				entity, 
				Boolean.class);
		
		Boolean success = response.getBody();

		return success;

	}

}

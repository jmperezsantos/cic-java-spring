package mx.ipn.cic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import mx.ipn.cic.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		RestTemplate restTemplate = new RestTemplate();

		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();

		restTemplate.getMessageConverters().add(messageConverter);

		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		// Para consumir un arreglo (colección) de elementos
		HttpEntity<User[]> entity = new HttpEntity<User[]>(headers);

		ResponseEntity<User[]> responseEntity = 
				restTemplate.exchange("http://127.0.0.1:8080/cic/rest/user",
				HttpMethod.GET, 
				entity,
				User[].class);

		User[] users = responseEntity.getBody();

		List<User> userList = Arrays.asList(users);

		logger.info(users.toString());

		// Para registrar/actualizar un elemento
		User user = new User("Nombre", "Apellido", 18);
		
		HttpEntity<User> entityPOST = new HttpEntity<User>(user, headers);

		ResponseEntity<User> responseEntityPOST = 
				restTemplate.exchange("http://127.0.0.1:8080/cic/rest/user",
				HttpMethod.POST, //HttpMethod.PUT para el caso de actualizaciones 
				entityPOST,
				User.class);

		user = responseEntityPOST.getBody();

		logger.info(user.toString());

		return "home";

	}

}

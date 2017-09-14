package mx.ipn.cic.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get(Model model) {
	
		Locale locale = new Locale("es", "MX");
		
		Date date = new Date();
		DateFormat dateFormat = 
				DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home/home_get";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String post(Model model){
		
		return "home/home_post";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public String put(){
		
		return "home/home_put";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public String delete(Model model){
		
		return "home/home_delete";
		
	}
	
}











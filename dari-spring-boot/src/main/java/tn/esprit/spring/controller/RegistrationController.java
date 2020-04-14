package tn.esprit.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.NotificationServeur;

@RestController
public class RegistrationController {
	@Autowired
	private NotificationServeur notificationServeur;
	@Autowired
	UserRepository userRepository;
	
	
	
	@RequestMapping("/signup")
	public String signup() {
		return "please sign up for our service";
	}
	@RequestMapping("/registration/{nom}/{prenom}/{email}")
	@ResponseBody
	public String signupsucces(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("email") String email) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date d;
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()) {
			return "invalide email";
		}
		
			try {
				d = dateFormat.parse("01/02/2015");
				Client u = new Client(null, "Malek", "Hamida",d ,"oussama.boubaker@esprit.tn", null,null, "oussama.jpg","nothing", 0, false);
				u.setFirstName(nom);
				u.setLastname(prenom);
				u.setEmail(email);
				userRepository.save(u);
				notificationServeur.sendNotification(u);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return"thank you for registration for us";
	}
}

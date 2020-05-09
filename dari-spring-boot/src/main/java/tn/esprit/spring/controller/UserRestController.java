package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserService;


@RestController
public class UserRestController {
	@Autowired 
	UserService userService;
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	AdRepository adRepository;
	
	@GetMapping("/retrieve-all-users") 
	@ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/retrieve-all-users 
	 public List<User> getUsers() { 
		 List<User> list = userService.retrieveAllUsers(); 
		 return list; 
	} 
	
	@GetMapping("/count") 
	@ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/count
	 public int getnombre() { 
		return userRepository.retrieveUsers();
		  
	}
	
/*	@GetMapping("/getAnnoncefollower/{userId}") 
	@ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/getAnnoncefollower 
	 public List<Ad> getAnnoncefollower(@PathVariable("userId") int userId) { 
		return adRepository.affFollow(userId);
		  
	}*/
	
	 @GetMapping("/authentification/{email}/{password}") 
	 @ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/getAnnoncefollower 
	 public String authentification(@PathVariable("email") String email,@PathVariable("password") String password) { 
		return userService.authentification(email, password);
		  
	}
	 
}

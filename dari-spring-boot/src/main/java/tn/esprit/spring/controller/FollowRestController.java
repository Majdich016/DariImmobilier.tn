package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Follow;
import tn.esprit.spring.repository.FollowRepository;


@RestController
public class FollowRestController {
	@Autowired
	FollowRepository followRepository;
	
	
	@PostMapping("/add-Follow/{follow_id}/{followed_id}") //   
	@ResponseBody 
	public void addUser(@PathVariable("follow_id") int follow_id,@PathVariable("followed_id") int followed_id) { //
		followRepository.insertFollow(follow_id, followed_id);
		//
		
		}
	
	@GetMapping("/allFollow") 
	@ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/retrieve-all-users 
	 public List<Follow> getUsers() { 
		 List<Follow> list = followRepository.affFollow(); 
		 return list; 
	} 
	
	


}

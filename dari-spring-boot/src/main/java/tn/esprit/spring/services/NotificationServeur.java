package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.UserRepository;

@Service
public class NotificationServeur {

	@Autowired
	UserRepository userRepository;

	
	public void sendNotification(Client user){
		
		String password="";
		
		for (int i=0;i<10;i++ ) {
			password = password+randomCharacter("abcdefjhijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUV");
		}
		String randomdigit=randomCharacter("123456789");
		password=insertAtRandom(password, randomdigit);
		String randomSymbol=randomCharacter("+-*/§/.?$&£@@@");
		password = insertAtRandom(password, randomSymbol);
		user.setPassword(password);
		userRepository.save(user);
		
		
	}
	public static String randomCharacter(String charachter) {
		int n = charachter.length();
		int r = (int)(n*Math.random());
		
		return charachter.substring(r,r+1);
	}
	public static String insertAtRandom(String str,String toInsert) {
		int n = str.length();
		int r=(int)(n * Math.random());
		return str.substring(0,r)+ toInsert + str.substring(r);
	}	
	
	
	
}

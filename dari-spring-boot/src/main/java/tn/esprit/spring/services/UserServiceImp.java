package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.agent;
import tn.esprit.spring.repository.AdminRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class UserServiceImp implements UserService {
	@Autowired
	ClientRepository clientRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	AdminRepository adminRepository;
	@Override
	public void ajouterClient(Client client) {
		
		clientRepo.save(client);
		//clientRepo.save(client);
		
		
	}
	@Override
	public void ajouterAdmin(Admin admin) {
		adminRepository.save(admin);
		
	}
	@Override
	public String authentification(String email, String password) {
		List<User> users =(List<User>) userRepo.findAll();
		int verifyemail=0;
		int verifypassword=0;
		for(User user:users) {
			if(user.getEmail().equals(email)) {
				verifyemail++;
				
				if(user.getPassword().equals(password)) {
					verifypassword++;
					if(user instanceof  Admin) {
						//System.out.println();
						return("Welcome Admin");
						
					}else if(user instanceof  Client) {
						if(((Client) user).isBlock()) {
							System.out.println(((Client) user).getDescriptionBlock());
							
						}else {
							return("Welcome Client");
							
						}
						
					}
					else if(user instanceof  agent){
						return("Welcome agent");
						
					}
				}else {
					if (user instanceof  Client) {
						int nbre=((Client) user).getNbre();
						((Client) user).setNbre(nbre+1);
						userRepo.save(user);
						if(((Client) user).getNbre()==3) {
							((Client) user).setBlock(true);
							((Client) user).setDescriptionBlock("security problem");
							userRepo.save(user);
							return("votre compte est blocke security problem" );
							
							
						}else if(((Client) user).getNbre()>=3) {
							((Client) user).setNbre(3);
							userRepo.save(user);
							return("votre compte est blocke security problem" );
						}else {
							return("password incorrect");
						}
					
					
					
				}
				
			}
				
				
			}
		}
		if(verifyemail==0) {
			return("email not found ");
		}else {
			return("");
		}
			
		
		
	}
	public void changerPassword(String id, String OldPassword) {
		
		Long j = Long.parseLong(id);
		List<User> users =(List<User>) userRepo.findAll();
		for(User user:users) {
			if(user.getId().equals(j)) {
				user.setPassword(OldPassword);
				userRepo.save(user);
			}
		}
	}
	public User findUserwithId(long id) {
		 User u = clientRepo.findById(id).orElse(null);
		 return u;
			}
	/*
	 * @Overrid
	public user retrieveUser(String id) {
		user u=userRepository.findById(Long.parseLong(id)).orElse(null); //optional<user> soit elle retourne un user soit not
		//user u=userRepository.findById(Long.parseLong(id)).get(); // soit .get soit .orElse

		l.info("user+++++"+u);
		return null;
	}
	 */
	@Override
	public List<User> retrieveAllUsers() {
		List<User> users =(List<User>) userRepo.findAll();
		for(User user:users) {
			System.out.println(user);
		}
		return users;
	}
	@Override
	public List<Ad> retrouveannoncesuivit(String Id){
		
		return null;
	}
	
		
		
	

}

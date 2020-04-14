package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;




public interface UserService {
	public void ajouterClient(Client client);
	public void ajouterAdmin(Admin admin);
	public String authentification(String email,String password);
	public User findUserwithId(long id) ;
	public List<User> retrieveAllUsers();
	public List<Ad> retrouveannoncesuivit(String Id);

}

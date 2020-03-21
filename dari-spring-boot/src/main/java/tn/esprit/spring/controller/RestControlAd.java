package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.services.IAdService;

@RestController
public class RestControlAd {
	@Autowired
	IAdService iadService;

	// localhost:8081/SpringMVC/servlet/retrieve-all-ads
	//GET
	@GetMapping("/retrieve-all-ads") 
	@ResponseBody 
	public List<Ad> getAds() { 
		List<Ad> list = iadService.retrieveAllAds(); 
		return list;  } 

	// localhost:8081/SpringMVC/servlet/retrieve-ad/{ad-id} 
	//GET
	@GetMapping("/retrieve-ad/{ad-id}") 
	@ResponseBody  
	public Ad retrieveAd
	(@PathVariable("ad-id") String adId) {
		return iadService.retrieveAd(adId);} 

	// Ajouter User : 
	// localhost:8081/SpringMVC/servlet/add-ad
	/*   {
 		"kindofgood": null,
 		"comments": [],
 		"multimedias": [],
 		"location": "italia",
 		"description": "ADMINISTRATEUR",
 		"idAd": 2,
 		"area": 100,
 		"adDate": null,
 		"viewsNumber": 0,
 		"success": null,
 		"score": 1
			}*/
	//POST

	@PostMapping("/add-ad") 
	@ResponseBody 
	public Ad addAd(@RequestBody Ad ad) { 
		iadService.addAd(ad); 
		return ad; }

	// /localhost:8081/SpringMVC/servlet/remove-ad/{ad-id} 
	//DELETE
	@DeleteMapping("/remove-ad/{ad-id}") 
	@ResponseBody 
	public void removeUser(@PathVariable("ad-id") int adId) { 
		iadService.deleteAd(adId);}  


	// localhost:8081/SpringMVC/servlet/modify-ad  
	//PUT
	@PutMapping("/modify-ad") @ResponseBody 
	public Ad modifyAd(@RequestBody Ad ad) { 
		return iadService.updateAd(ad); }

}


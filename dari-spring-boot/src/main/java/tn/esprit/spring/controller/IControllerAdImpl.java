package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.services.IAdService;

@Controller 
public class IControllerAdImpl {
	@Autowired
	IAdService iadService;


	public List<Ad> getAds() { 
		List<Ad> list = iadService.retrieveAllAds(); 
		return list;  } 


	public Ad retrieveAd
	(@PathVariable("ad-id") String adId) {
		return iadService.retrieveAd(adId);} 



	public Ad addAd(@RequestBody Ad ad) { 
		Ad a = iadService.addAd(ad); 
		return a; }


	public void removeUser(@PathVariable("ad-id") int adId) { 
		iadService.deleteAd(adId);}  


	public Ad modifyAd(@RequestBody Ad ad) { 
		return iadService.updateAd(ad); }


}

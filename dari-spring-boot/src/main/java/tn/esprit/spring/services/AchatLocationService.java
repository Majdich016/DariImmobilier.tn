package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.entities.Sell;


public interface AchatLocationService {
	//// 1er filtre : Séparation entre les annonces de vente et de Location
	List<Sell> SellAds();
	List<Rent> RentAds();
	//// 2eme type de filtre: Filtres multicritères 
	List<Ad> FiltreMulticritère();
	
	/// Les métiers:
	void Estimation();
	
}

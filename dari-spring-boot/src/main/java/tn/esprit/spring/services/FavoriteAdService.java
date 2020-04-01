package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.FavoriteAd;

public interface FavoriteAdService {
	void favoriserAnnonce(int adId, long idC);
	void deleteFavorite(int id); 
	//List<FavoriteAd> retrieveAllFavorites();
	FavoriteAd retrieveFavorite(String id);
    List<FavoriteAd> getAllFavoritesByClient(long clientId);
   

}

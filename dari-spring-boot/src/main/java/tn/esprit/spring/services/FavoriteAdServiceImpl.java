package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.FavoriteAd;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FavoriteAdRepository;

@Service
public class FavoriteAdServiceImpl implements FavoriteAdService{

	public static final Logger L = LogManager.getLogger(FavoriteAdServiceImpl.class);

	
	@Autowired
	FavoriteAdRepository favoriteAdRepository;
	
	@Autowired
	ClientRepository clientRepository;	
	
	@Autowired
	AdRepository adRepository;
	
	
	@Override
	public void favoriserAnnonce(int adId, long idC){
		FavoriteAd fav = new FavoriteAd();
		Ad ad = adRepository.findById(adId).get();
		fav.setAd(ad);
		fav.setIdClient(idC);
		favoriteAdRepository.save(fav);
	}
			

	@Override
	public void deleteFavorite(int id) {
		// TODO Auto-generated method stub
		favoriteAdRepository.delete(favoriteAdRepository.findById(id).get());
	}


/*	@Override
	public List<FavoriteAd> retrieveAllFavorites() {
		// TODO Auto-generated method stub
		List<FavoriteAd> f=(List<FavoriteAd>)favoriteAdRepository.findAll();
		for (FavoriteAd fa : f) {
			L.info("favoriteAd +++"+fa);
		}
		return f;
	}  */

	@Override
	public FavoriteAd retrieveFavorite(String id) {
		// TODO Auto-generated method stub
		FavoriteAd f= favoriteAdRepository.findById(Integer.parseInt(id)).orElse(null);
		L.info("retrive wishList by id ++++:"+f);
		return f;
				
	}
	
	
	@Override
	public List<FavoriteAd> getAllFavoritesByClient(long clientId) {
		Client clientManagedEntity = clientRepository.findById((long) clientId).get();
		
		List<WishList> list = new ArrayList<>();
		List<FavoriteAd> wls = new ArrayList<>();;
			
		wls=(List<FavoriteAd>)favoriteAdRepository.findAll();
		for (FavoriteAd wll : wls) {
			if(wll.getIdClient() == clientId)
			{
				L.info("Favoriiiit+++++++++"+true);
			}
			else {L.info("Favoriiiit+++++++++"+false);}
		}
		
		return wls;		
	} 
	
	
	
	
	

}

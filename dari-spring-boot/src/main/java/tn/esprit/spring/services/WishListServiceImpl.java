package tn.esprit.spring.services;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService{

	public static final Logger L = LogManager.getLogger(WishListServiceImpl.class);

	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	ClientRepository clientRepository;
/*	@Autowired
	SmsSender ss;*/
	
	@Override	
	public WishList addWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public void deleteWishList(int id) {
		// TODO Auto-generated method stub
		wishListRepository.delete(wishListRepository.findById(id).get());
	}

	@Override
	public WishList updateWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public List<WishList> retrieveAllWishLists() {
		// TODO Auto-generated method stub
		List<WishList> wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wl : wls) {
			L.info("whishlist +++"+wl);
		}
		return wls;
	}

	@Override
	public WishList retrieveWishList(String id) {
		// TODO Auto-generated method stub
		WishList u= wishListRepository.findById(Integer.parseInt(id)).orElse(null);
		L.info("retrive user by id ++++:"+u);
		return u;
				
	}
	
	@Override
	public List<WishList> getAllWhishListsByClient(long clientId) {
		Client clientManagedEntity = clientRepository.findById((long) clientId).get();
		List<WishList> list = new ArrayList<>();
		List<WishList> wls = new ArrayList<>();;
			
		wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wll : clientManagedEntity.getWishLists()) {
			L.info("whishlist +++"+wll);
		}
		
		return wls;		
	}

	
	 
	 
	@Override
	public Boolean comparaison(WishList wl, Ad ad) {
		Boolean k = false;
				
		if (ad.getPrice()>wl.getBudgetmin() && ad.getPrice()<wl.getBudgetmax() && ad.getSurface()>wl.getSurfacemin()&& ad.getSurface()<wl.getSurfacemax()
				&& ad.getBuildable().equals(wl.getBuildable()) && ad.getServiced().equals(wl.getServiced()) && ad.getNbRooms()== wl.getNbRooms() 
				&& ad.getGarden().equals(wl.getGarden()) && ad.getGarage().equals(wl.getGarage()) && ad.getSwimmingPool().equals(wl.getSwimmingPool())
				&& ad.getTerrace().equals(wl.getTerrace()) && ad.getAirConditioning().equals(wl.getAirConditioning()) 
				&& ad.getHeater().equals(wl.getHeater()) && ad.getFurnished().equals(wl.getFurnished()) && ad.getLocation().equals(wl.getLocation())
				){
			k= true;
		}
		L.info("Alerte++++++++++:"+k);		
		
		return k;		
		}
	
/*	
	@Override
	public void NotifSms(Ad ad) {
		
		//SmsRequest smsRequest = new SmsRequest();
		SmsRequest smsRequest = new SmsRequest("+21620752433","Une annonce conforme aux critères préenregistrés vient d'être poster! vous la retrouveré parmis vos favoris"); //commentaire
		List<Client> list= new ArrayList<>();
		
		for (WishList wl : wishListRepository.findAll()) {		
			if (comparaison(wl, ad) == true){
				list.add(wl.getClient());
				L.info("ALERTE +++++++++++: " + wl.getClient());
			}		
		}				
		for(Client client: list){
			//SmsRequest smsRequest = new SmsRequest("client.phoneNumber","Une annonce conforme aux critères préenregistrés vient d'être poster! vous la retrouveré parmis vos favoris");
			ss.sendSms(smsRequest);
		}	
	}*/
		
	
	
	
}

package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.WishListRepository;

@Service
public class WishListImpl implements WishListService{

	public static final Logger l = LogManager.getLogger(AdServiceImpl.class);

	@Autowired
	WishListRepository wishListRepository;
	
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

}

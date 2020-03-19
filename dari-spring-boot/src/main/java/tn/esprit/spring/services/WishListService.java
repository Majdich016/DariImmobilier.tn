package tn.esprit.spring.services;

import tn.esprit.spring.entities.WishList;

public interface WishListService {
	WishList addWishList(WishList wl);
	void deleteWishList(int id); 
	WishList updateWishList(WishList wl); 
}

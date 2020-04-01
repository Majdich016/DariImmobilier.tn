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

import tn.esprit.spring.entities.FavoriteAd;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.services.FavoriteAdService;
import tn.esprit.spring.services.WishListService;

@RestController
public class MaTacheRestController {
	 @Autowired 
	 WishListService wishListService;
	 @Autowired 
	 FavoriteAdService favoriteAdService;
	
	 /////////////////// WishList//////////////////////////////////
	 
	    //http://localhost:8081/SpringMVC/servlet/getWishListById/3
	    @GetMapping(value = "getWishListById/{id}")
	    @ResponseBody
		public WishList getWishListById(@PathVariable("id") String Id) {

			return wishListService.retrieveWishList(Id);
		}

	 
	// localhost:8081/SpringMVC/servlet/retrieve-all-wishLists
		//GET
	 @GetMapping("/retrieve-all-wishLists") 
	 @ResponseBody 
	 public List<WishList> getWishLists() {
		 List<WishList> list = wishListService.retrieveAllWishLists();
		 return list; } 
	 
 	 // http://localhost:8081/SpringMVC/servlet/getAllWishListByClient/5
	    @GetMapping(value = "getAllWishListByClient/{idclient}")
	    @ResponseBody
		public List<WishList> getAllWishListByClient(@PathVariable("idclient") int idclient) {
			return wishListService.getAllWhishListsByClient(idclient);
		}
	 
	 
	// Ajouter User : 
		// localhost:8081/SpringMVC/servlet/add-wishList
	 @PostMapping("/add-wishList") 
	 @ResponseBody 
	 public WishList addWishList(@RequestBody WishList u) { 
		 WishList user = wishListService.addWishList(u);	
		 return user; 
		 }
	 
	 
	// localhost:8081/SpringMVC/servlet/remove-wishList/{wishList-id} 
		//DELETE
	 
	 @DeleteMapping("/remove-wishList/{wishList-id}") 
	 @ResponseBody 
	 public void removeWishList(
			 @PathVariable("wishList-id") int userId) { 
		 wishListService.deleteWishList(userId);
	 	}
	 
	// localhost:8081/SpringMVC/servlet/modify-wishList  
		//PUT
	 @PutMapping("/modify-wishList")
	 @ResponseBody 
	 public WishList modifyWishList(@RequestBody WishList user) { 
		 return wishListService.updateWishList(user);
	 }

	 	/////////////////// Favoris //////////////////////////////////
	 
	// localhost:8081/SpringMVC/servlet/remove-favoris/{favoris-id} 
			//DELETE
		 
		 @DeleteMapping("/remove-favoris/{favoris-id}") 
		 @ResponseBody 
		 public void removeFavorisAd(
				 @PathVariable("favoris-id") int userId) { 
			 favoriteAdService.deleteFavorite(userId);
		 	}
		
		 
		 // http://localhost:8081/SpringMVC/servlet/getAllFavoritesByClient/5
		    @GetMapping(value = "getAllFavoritesByClient/{idclient}")
		    @ResponseBody
			public List<FavoriteAd> getAllFavoritesByClient(@PathVariable("idclient") int idclient) {
				return favoriteAdService.getAllFavoritesByClient(idclient);
			}
		    
		    
		 
}

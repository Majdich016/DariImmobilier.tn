package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.ShoppingCard;
import tn.esprit.spring.services.IShoppingCardService;

@RestController
public class RestControlShoppingCardImpl {

	@Autowired
	IShoppingCardService iShoppingCardService;
	
	
	@PostMapping("/ajouterCard")
	@ResponseBody
	public ShoppingCard ajouterShoppingCard(ShoppingCard shoppingCard){
		
		iShoppingCardService.ajouterShoppingCard(shoppingCard);
		return shoppingCard;
	}
}

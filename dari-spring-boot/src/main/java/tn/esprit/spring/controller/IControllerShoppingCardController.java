package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.ShoppingCard;
import tn.esprit.spring.services.IShoppingCardService;

@Controller
public class IControllerShoppingCardController {

	
	@Autowired
	IShoppingCardService iShoppingCardService;
	
	
	public int ajouterShoppingCard(ShoppingCard shoppingCard){
		iShoppingCardService.ajouterShoppingCard(shoppingCard);
		return shoppingCard.getId();
		
	}
	
}

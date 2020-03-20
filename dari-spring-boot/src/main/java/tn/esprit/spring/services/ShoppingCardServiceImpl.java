package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.ShoppingCard;
import tn.esprit.spring.repository.ShoppingCardRepository;


@Service
public class ShoppingCardServiceImpl implements IShoppingCardService{

	@Autowired
	ShoppingCardRepository cardRepository;
	
	
	@Override
	public int ajouterShoppingCard(ShoppingCard shoppingCard) {
		
		cardRepository.save(shoppingCard);
		return shoppingCard.getId();
	}
	


}

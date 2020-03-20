package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Furniture;
import tn.esprit.spring.entities.ShoppingCard;
import tn.esprit.spring.repository.FurnitureRepository;
import tn.esprit.spring.repository.ShoppingCardRepository;

@Service
public class FurnitureServiceImpl implements IFurnitureService{

	@Autowired
	FurnitureRepository furnitureRepository;
	
	@Autowired
	ShoppingCardRepository shoppingCardRepository;
	
	@Override
	public int ajouterMeuble(Furniture furniture) {
		
		furnitureRepository.save(furniture);
		
		
		
		return furniture.getId();
	}



	@Override
	public List<Furniture> getAllFurniture() {
	
		return (List<Furniture>) furnitureRepository.findAll();
	}



	@Override
	public List<String> getAllFurnitureNamesJPQL() {
		
		return  furnitureRepository.furnitureNames();
	}



	@Override
	public void deleteFurnitureById(int furnitureId) {
		furnitureRepository.delete(furnitureRepository.findById(furnitureId).get());
		
	}


	@Transactional
	public void ajouterMeubleDansPanier(int furnitureId, int panierId) {
		ShoppingCard cardManage = shoppingCardRepository.findById(panierId).get();
		Furniture furnitureManage = furnitureRepository.findById(furnitureId).get();
		if (cardManage.getFurnitures()== null) {
			List<Furniture> furnitures = new ArrayList<>();
			furnitures.add(furnitureManage);
			cardManage.setFurnitures(furnitures);
			
		} else {

			cardManage.getFurnitures().add(furnitureManage);
		}
		
		}



	@Transactional
	public void eliminerMeubleDansPanier(int furnitureId, int panierId) {
		// TODO Auto-generated method stub
		
	}

}

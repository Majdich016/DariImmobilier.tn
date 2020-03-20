package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Furniture;

import tn.esprit.spring.services.IFurnitureService;

@Controller
public class IControllerFurnitureImpl {
	
	@Autowired
	IFurnitureService iFurnitureService;
	
	
	
	public int ajouterMeuble(Furniture furniture){
		
		iFurnitureService.ajouterMeuble(furniture);
		
		return furniture.getId();
	}
	
	
	public List<Furniture> getAllFurniture(){
		
		return iFurnitureService.getAllFurniture();
	}
	
	public List<String> getAllFurnitureNamesJPQL() {
		
		return  iFurnitureService.getAllFurnitureNamesJPQL();
	}

	
	public void deleteFurnitureById(int furnitureId){
		
		iFurnitureService.deleteFurnitureById(furnitureId);
	}
	public void ajouterMeubleDansPanier(int furnitureId, int panierId){
		iFurnitureService.ajouterMeubleDansPanier(furnitureId, panierId);
	}
}

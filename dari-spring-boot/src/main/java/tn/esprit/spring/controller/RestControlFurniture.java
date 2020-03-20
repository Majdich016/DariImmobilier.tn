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

import tn.esprit.spring.entities.Furniture;
import tn.esprit.spring.services.IFurnitureService;


@RestController
public class RestControlFurniture {
	
	
	@Autowired
	IFurnitureService iFurnitureService;
	
	//    http://localhost:8081/SpringMVC/servlet/ajouterMeuble
	
	// {"name":"test","description":"test","price":20,"quantity":10,"type":"New"}
	@PostMapping("/ajouterMeuble")
	@ResponseBody
	public Furniture ajouterMeuble(@RequestBody Furniture furniture){
		iFurnitureService.ajouterMeuble(furniture);
		
		return furniture;
	}
	// http://localhost:8081/SpringMVC/servlet/getAllFurnitures
	@GetMapping(value = "/getAllFurnitures")
	@ResponseBody
	public List<Furniture> getAllFurniture(){
		return iFurnitureService.getAllFurniture();
	}
	
	// http://localhost:8081/SpringMVC/servlet/getAllFurnituresNamesJPQL 
	@GetMapping(value = "/getAllFurnituresNamesJPQL")
	@ResponseBody
	public List<String> getAllFurnitureNamesJPQL() {
		
		return  iFurnitureService.getAllFurnitureNamesJPQL();
	}

	
	// http://localhost:8081/SpringMVC/servlet/deleteFurnitureById/2
	@DeleteMapping("/deleteFurnitureById/{idfurniture}")
	@ResponseBody
	public void deleteFurnitureById(@PathVariable("idfurniture")int furnitureId){
		
		iFurnitureService.deleteFurnitureById(furnitureId);
	}
		
	@PutMapping(value = "/ajouterMeubleDansPanier/{idmeuble}/{idpanier}") 
	public void ajouterMeubleDansPanier(@PathVariable("idmeuble") int furnitureId, @PathVariable("idpanier") int panierId){
		iFurnitureService.ajouterMeubleDansPanier(furnitureId, panierId);
	}
	

}

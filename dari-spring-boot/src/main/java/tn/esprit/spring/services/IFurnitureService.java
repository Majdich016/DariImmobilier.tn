package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Furniture;

public interface IFurnitureService {
	public int ajouterMeuble(Furniture furniture);
	public List<Furniture> getAllFurniture();
	public List<String> getAllFurnitureNamesJPQL();
	public void deleteFurnitureById(int furnitureId);
	public void ajouterMeubleDansPanier(int furnitureId, int panierId);
	public void eliminerMeubleDansPanier(int furnitureId, int panierId);

}

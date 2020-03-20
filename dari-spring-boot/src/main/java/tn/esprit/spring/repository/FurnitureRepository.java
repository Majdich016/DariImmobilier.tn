package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Furniture;

public interface FurnitureRepository extends CrudRepository<Furniture, Integer>{

	
	 @Query("SELECT name FROM Furniture")
	    public List<String>  furnitureNames();
	    
}

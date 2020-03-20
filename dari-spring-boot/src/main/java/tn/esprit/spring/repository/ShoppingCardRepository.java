package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.ShoppingCard;

public interface ShoppingCardRepository extends CrudRepository<ShoppingCard, Integer> {

}

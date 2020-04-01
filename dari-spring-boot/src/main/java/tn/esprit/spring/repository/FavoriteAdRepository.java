package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.FavoriteAd;

@Repository
public interface FavoriteAdRepository extends CrudRepository<FavoriteAd,Integer>{

}

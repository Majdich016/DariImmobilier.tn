package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Follow;


public interface FollowRepository extends CrudRepository<Follow,Long>{

	
	@Modifying
	@Transactional
	@Query(
	  value = "INSERT INTO `follow` (`id`, `follow_id`, `followed_id`) VALUES (NULL, :follow_id, :followed_id);",nativeQuery = true)
	void insertFollow(@Param("follow_id") int follow_id, @Param("followed_id") int followed_id);
	//
	
	
	
	@Query(value="SELECT * FROM `follow` ",nativeQuery = true)
	public List<Follow> affFollow();

	
	
}

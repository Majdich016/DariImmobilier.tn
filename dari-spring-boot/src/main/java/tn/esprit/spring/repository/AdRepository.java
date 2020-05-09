package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Ad;


public interface AdRepository extends CrudRepository<Ad, Integer>{
	//Je selectionne les annonces qui on des commantaires avec plusieurs likes
	@Query(value =" select"+ " DISTINCT a.IdAd FROM Ad a" + " JOIN Comment c where c.NumberLikes >= 100")
	public List<Ad> getAdWithBestLikesOnCommentsJPQL();
	//UPDATE `t_ad` SET `success` = b'1', `end_date` = '2020-03-31', `start_date` = '2020-03-25', 
	//`rentingtype` = 'TEMPORARY_RENTING', `rentperiod` = 'DAY', `price` = '200' WHERE `t_ad`.`id_ad` = 1;
	
	//select"+ " DISTINCT a.id_ad FROM Ad a" + " JOIN a.Comment c where a.id_ad=?c.ads_id_ad"+ " where c.number_likes > nbrLikes
	//SELECT DISTINCT(`id_ad` )FROM `t_ad` a INNER JOIN t_comment c ON a.`id_ad`=c.ads_id_ad WHERE c.number_likes >100
	
	@Query(value="SELECT DescriptionComment FROM Comment where IsBlocked=True")
	public List<String> getAllCommentsBlockedJPQL();
	
	@Query(value="SELECT "
	+ "DISTINCT  a.IdAd, a.AdDate, a.Area, a.Description, a.Location, a.Score, a.Success, a.kindofgood FROM Ad a")
	public List<String> getAdsFromTheSameUserJPQL();
	
	@Query(value="SELECT ViewsNumber FROM Ad where IdAd=:idad")
	public int getNumberView(@Param("idad")int idad);
	
	

	@Query(value="SELECT * FROM `t_ad` order by `price` ",nativeQuery = true)
	public List<Ad> filter();
	
	
}


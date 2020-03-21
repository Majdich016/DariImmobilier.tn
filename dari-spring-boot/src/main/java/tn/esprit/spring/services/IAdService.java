package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Ad;

public interface IAdService {
	Ad addAd(Ad ad);
	List<Ad> retrieveAllAds();
	void deleteAd(int id); 
	Ad updateAd(Ad ad); 
	Ad retrieveAd(String id);
	void AssignCommentToanAd(int CommentId, int AdId);
	List<String> getAllCommentsByAd(int AdId);

}

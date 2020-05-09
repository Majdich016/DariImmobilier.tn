package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;

public interface IAdService {
	Ad addAd(Ad ad);
	Comment addComment(Comment comment,Long idClient,Integer idPub);
	List<Ad> retrieveAllAds();
	public void deleteAd(int IdAd);
	Ad updateAd(Ad ad); 
	Ad getAdById(int adId);
	public List<String> getAllCommentsByAd(int AdId);
	public void deleteComment(int IdComment);
	Comment UpdateComment(Comment comment);
	void AssignCommentToanAd(int CommentId, int AdId);
	public int countComments();
	public double  countAds();
	public List<Ad> getAdWithBestLikesOnCommentsJPQL();
	public int nbrLike();
	public boolean succes();
	public int maxnblike();
	public double AVG_nbcomment();
	public boolean BlockCommentsWithInsultingWords();
	public void ScoreIncrement();
	public int AdsForToday();
	public double AVG_Ads_Year();
	public List<String> getAdsFromTheSameUserJPQL();
	public List<String> getAllCommentsBlockedJPQL();
	public int countCommentsJPQL(int IdAd);
	public int addOrUpdateAd(Ad ad);
	public int getNumberView(int idad);
	public boolean increment(int idad);
	public boolean BlockCommentsWithInsultingWords2();
	public void ReclamerUser();
	public void BlockUserByBadComments();
	List<Comment> retrieveAllComments();
	public int addOrUpdateComment(Comment comment);
	public List<Ad> filter();
	public List<Comment> DescriptionComments(int idc);

}

package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.CommentRepository;

@Service
public class AdServiceImpl implements IAdService {
	@Autowired
	AdRepository adRepository;
	@Autowired
	CommentRepository commentRepoistory;
	public static final Logger l = LogManager.getLogger(AdServiceImpl.class);
	

	@Override
	public Ad addAd(Ad ad) {
		adRepository.save(ad);		
		return null;
	}

	@Override
	public List<Ad> retrieveAllAds() {
		List<Ad> ads=(List<Ad>)adRepository.findAll();
		for (Ad ad : ads) {
			l.info("ad +++"+ad);
		}
		return ads;
	}

	@Override
	public void deleteAd(int id) {
		
	  adRepository.delete(adRepository.findById(id).get());
	 	
	}

	@Override
	public Ad updateAd(Ad ad) {
		adRepository.save(ad);
		return null;
	}

	@Override
	public Ad retrieveAd(String id) {
	/*	Ad ad=adRepository.findById(id).orElse(null);//findById : optional <user> c'est a dire il peut n'envoyer rien
		//User u = userRepository.findById(Long.parsLong(id)).get();//get permet de renvoyer toull exception ken Id mafamech
		l.info("ad +++"+ad);
		return ad;*/
		return null;
	
	}

	@Override
	public void AssignCommentToanAd(int CommentId, int AdId) {
		Ad AdManagedEntity = adRepository.findById(AdId).get();
		Comment CommentManagedEntity = commentRepoistory.findById(CommentId).get();
		
		CommentManagedEntity.setAds(AdManagedEntity);
		commentRepoistory.save(CommentManagedEntity);
		
	}

	@Override
	public List<String> getAllCommentsByAd(int AdId) {
		Ad AdManagedEntity = adRepository.findById(AdId).get();
		List<String> CommentsDescription = new ArrayList<>();
		for(Comment com : AdManagedEntity.getComments()){
			CommentsDescription.add(com.getDescriptionComment());
		}
		
		return CommentsDescription;
	}

}

package tn.esprit.spring.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.ReclamtionRepository;


@Service
public class AdServiceImpl  implements IAdService {
	@Autowired
	AdRepository adRepository;

	@Autowired
	ReclamtionRepository ReclamationRepository;
	@Autowired
	ClientRepository ClientRepository;

	@Autowired
	RatingView ratingview;
	@Autowired
	Filter filter;
	@Autowired
	CommentRepository commentRepository;
	
	public static final Logger l = LogManager.getLogger(AdServiceImpl.class);
	public static Integer rating2=0;

	@Override
	public Ad addAd(Ad ad) {
		adRepository.save(ad);		
		return ad;
	}

	@Override
	public List<Ad> retrieveAllAds() {
	return (List<Ad>)adRepository.findAll();	
	}

	@Override
	public Ad updateAd(Ad ad) {
		adRepository.save(ad);
		return ad;
	}

	@Override
	public void deleteAd(int IdAd) {
	adRepository.deleteById(IdAd);
	}


	@Override
	public List<String> getAllCommentsByAd(int AdId) {
		Ad aa = adRepository.findById(AdId).get();
		List<String> CommentsDescription = new ArrayList<>();
		for(Comment com : aa.getComments()){
			CommentsDescription.add(com.getDescriptionComment());	
		}

		return CommentsDescription;
	}
	

	@Override
	public Ad getAdById(int adId) {
		return adRepository.findById(adId).get();	

	}
	

	@Override
	public Comment addComment(Comment comment,Long idClient,Integer idPub) {
		Client client = ClientRepository.findById(idClient).get();
		Ad ad =adRepository.findById(idPub).get();
		comment.setClient(client);
		comment.setAds(ad);
		List<Comment> com=(List<Comment>) commentRepository.findAll();
		commentRepository.save(comment);
		return comment;
	}

	@Override
	public void deleteComment(int IdComment) {
		l.info("supprimer "+ IdComment);
		commentRepository.deleteById(IdComment);
		
	}


	@Override
	public Comment UpdateComment(Comment comment) {
		commentRepository.save(comment);
		return comment;
	}
	@Override
	public int addOrUpdateComment(Comment comment) {
			commentRepository.save(comment);
			return comment.getIdComment();	
		}

	@Override
	public void AssignCommentToanAd(int CommentId, int AdId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countComments() {
		int max=0;
		List<Comment> com=(List<Comment>) commentRepository.findAll();
		for(Comment comments :com) {
			max++;
		}
		l.info(" you have "+ max + "comments");

		return max;

	}

	@Override
	public int nbrLike() {	
		int max1=0;
		List<Comment> com=(List<Comment>) commentRepository.findAll();		
		for(Comment aa : com ) {

			max1 +=aa.getNumberLikes();	 

		}
		l.info(" you have "+ max1 + "comments");

		return max1;
	}

	@Override
	public List<Ad>getAdWithBestLikesOnCommentsJPQL() {

		return adRepository. getAdWithBestLikesOnCommentsJPQL();
	}

	//max des nbres de likes dans commentaires
	@Override
	public int maxnblike() {	
		int k=0;
		List<Comment> com=(List<Comment>) commentRepository.findAll();		
		for(Comment aa : com ) {

			if(aa.getNumberLikes()> k) {
				k=aa.getNumberLikes();	  
			}  
		}

		l.info(" you have "+k+ " comments");
		return k;

	}


	public boolean succes() {

		List<Comment> com=(List<Comment>) commentRepository.findAll();
		List<Ad> zz=(List<Ad>) adRepository.findAll();	

		for(Comment aa :com) {
			for(Ad ee :zz) {
				if(aa.getNumberLikes()>=100 && ee.getViewsNumber()>=100) {

					ee.setSuccess(true); 
					adRepository.save(ee);

					l.info("True");

				} 
				else  {ee.setSuccess(false);
				l.info("False");}
			}


		}return true; 

	}

	//moyenne nombre commantaires par ans
	public double AVG_nbcomment() {	
		int A=0;
		double b=0;
		List<Comment> com=(List<Comment>) commentRepository.findAll();
		for(Comment comments :com) {
			A++;
		}
		b=(A*360)/100;
		l.info(" you have "+ b + "comments");

		return b;
	}
	
	public void ScoreIncrement()  {
		List<Ad> zz=(List<Ad>)adRepository.findAll();
		int b=0;  
		for(Ad aa :zz) {

			if(aa.getViewsNumber()>=1000) {
				b = aa.getScore()+100;
				aa.setScore(b);
				adRepository.save(aa);
			}

		} 
	}

	//total des ads par jour
	@Override
	public int AdsForToday() {
		List<Ad> ads=(List<Ad>)adRepository.findAll();
			int nbr_ads_for_day=0;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date date = new Date();
			l.info("******" + dateFormat.format(date));
			for(Ad a:ads) {	
				if ((a.getAdDate().getDay()== date.getDay() ) && (a.getAdDate().getMonth()== date.getMonth()) && (a.getAdDate().getYear()== date.getYear())) {
				nbr_ads_for_day++;
				
				l.info("******" + dateFormat.format(date) + a);
			
			}} 
			
			l.info("you have "+ nbr_ads_for_day +" ads today" );
			return nbr_ads_for_day;	
		}
		
	
	
	//Bloquer le comments avec des mots insultants	
	//String input= reclamation.getDescription();
	//String output = filter.getCensoredText(input);
	
	public boolean BlockCommentsWithInsultingWords()  {
		
		List<Comment> com=(List<Comment>) commentRepository.findAll();
		List<String> c = new ArrayList<>();
		java.nio.file.Path path= Paths.get("C:\\Users\\user\\Desktop\\4infoB-S2\\pidev\\Full_Bad_Word.txt");
		 try {
			for(String line :Files.readAllLines(path)) {
				c.add(line);
			
			 }
			System.out.println("\n");
		} catch (IOException e) {
		}
		 
		for(Comment aa :com) {
				
			if(c.contains(aa.getDescriptionComment())) {
						aa.setIsBlocked(true);
				commentRepository.save(aa);
				//return true;
			} else 

				aa.setIsBlocked(false);
			commentRepository.save(aa);

		}return true;

	}
	public boolean BlockCommentsWithInsultingWords2() {
		
		List<Comment> com=(List<Comment>) commentRepository.findAll();
		for(Comment aa :com) {
		String input= aa.getDescriptionComment();
		String output = Filter.getCensoredText(input);
		
			if(output.contains("*")) {
						aa.setIsBlocked(true);
				commentRepository.save(aa);
				//return true;
			}else 

				aa.setIsBlocked(false);
			commentRepository.save(aa);

		}return true;
}



	@Override
	public double AVG_Ads_Year() {
		int A=0;
		double b=0;
		List<Ad> ad=(List<Ad>) adRepository.findAll();
		for(Ad aa :ad) {
			A++;
		}
		b=(A*360)/100;
		l.info(" you have "+ b + "ads");

		return  b;
	}

	@Override
	public double countAds() {
		int a=0;
		
		List<Ad> aa=(List<Ad>) adRepository.findAll();
		for(Ad ads :aa) {
			a++;
		}
	return a;
	}

	@Override
	public List<String> getAllCommentsBlockedJPQL() {
	return adRepository.getAllCommentsBlockedJPQL();
	}

	@Override
	public List<String> getAdsFromTheSameUserJPQL() {
		return adRepository.getAdsFromTheSameUserJPQL();
	
	}

	@Override
	public int countCommentsJPQL(int IdAd) {
		return commentRepository.countCommentsJPQL(IdAd);
	}

	@Override
	public int addOrUpdateAd(Ad ad) {
			adRepository.save(ad);
			return ad.getIdAd();	
		}

	@Override
	public int getNumberView(int idad) {
		
		return adRepository.getNumberView(idad);
		
	}
	

	@Override
	public boolean increment(int idad) {
	   
		int A=0;
		int k=0;
		
		List<Ad> ads=(List<Ad>)adRepository.findAll();
		
			for(Ad aa: ads) {
		 if(aa.getIdAd()==idad) {
		   A=adRepository.getNumberView(idad);
		  A++;
		 aa.setViewsNumber(A);
		 if(aa.getViewsNumber()==20 || aa.getViewsNumber()==50) {
		        
			   k=aa.getRating2();
 		       k++;
 		      aa.setRating2(k);
		 }
	     adRepository.save(aa);
		 }
			}
			return true;
	     }
	
	
	
	
	public void ReclamerUser() { 
		List<Reclamation> appp=(List<Reclamation>) ReclamationRepository.findAll();
		List<Comment> app=(List<Comment>) commentRepository.findAll();
		Client iddd;
		for(Comment a:app) {
			if(a.getIsBlocked().equals(true) ) {
			iddd=a.getClient();
			Reclamation r = new Reclamation();
				r.setDescription("this user added comment with bad words");
				r.setUserId(iddd);
				//r.setId(1L);
				ReclamationRepository.save(r);

				l.info("*****"+r.getDescription());
					
					
					}
			
			
		}
		

	}

@Override
	public void BlockUserByBadComments() {
		
		List<Comment> app=(List<Comment>) commentRepository.findAll();
		List<Comment> ap=(List<Comment>) commentRepository.retrieveAllBadCommentByClient();

		List<Client> cc=(List<Client>) ClientRepository.findAll();
		int max=0;
		Long idd;
		for(Comment c:app) {
			//l.info("-------"+ap);
			if(c.getIsBlocked().equals(true) ) {  
						max++;
						l.info("***************"+max);
						if (max>=2) {
							idd=c.getClient().getId();
							for(Comment aa:ap) {
								if(c.getClient().getId()==idd) {
									c.getClient().setBlock(true);
									c.getClient().setDescriptionBlock("this user is blocked because he has added a lot of bad comments");
                                        
									max=0;
									for(Client client:cc) {
									
							ClientRepository.save(c.getClient());
							

						}
							
						l.info("user is Blocked+++++++" + c.getClient().getId()+ "+++++++"+ c.getClient().isBlock());

	}
							}		}}}
					
					
					}

@Override
public List<Comment> retrieveAllComments() {
	return (List<Comment>)commentRepository.findAll();	
}

public List<Ad> filter(){
return (List<Ad>)adRepository.filter();
}

@Override
public List<Comment> DescriptionComments(int idc) {
List<Ad> aa=(List<Ad>) adRepository.findAll();	
  for(Ad zz:aa) {
	 if( zz.getIdAd()==idc){
	 return (List<Comment>)commentRepository.DescriptionComments(idc);
	  }
  }
	return null;
	
}


	
}
package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.RentPeriod;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IAdService;
import tn.esprit.spring.services.RatingView;


@Scope(value = "session")
@Controller(value = "adController")
@ELBeanName(value = "adController")
@Join(path = "/", to = "/gererAd/basic.jsf")
public class IControllerAdImpl {


	public static final Logger l = LogManager.getLogger(IControllerAdImpl.class);



	@Autowired
	IAdService iadService;
	@Autowired
	IAdService adService;
	@Autowired
	RatingView ratingview;
	private int IdAd;
	private Ad ad;
	private Comment c;
	private List<Ad> ads;
	private List<Ad> kk;
	private List<Comment> com;
	private String Description;
	private String Location;
	private int Area;
	private int nbBaths;
	private String Image;
	private KindOfGood kindofgood;
	private Date AdDate;
	private Integer adIdToBeUpdated;
	private Integer CommetIdToBeUpdated;
	private int ViewsNumber;
	private Boolean Success;
	private int Score;
	private Date StartDate;
	private Date EndDate;
	private RentPeriod rentperiod;
	private RentingType rentingtype;
	private float Price;
	private String DescriptionComment;
	private int NumberLikes;
	private User user;
	private Client client;
	private int IdComment;
	private String descCom;
	private int idPub;
	private Ad aadDialog;
	private int a;
	private int nbRooms;
	private int nbGarage;
	private String destination = "C:\\work\\Pidevtest\\uploads\\";
	private Ad Ads;









	////////////////////////////////////Getters&Setters////////////////////////////////////////////////////////////




	public int getA() {
		return a;
	}

	

	public void setAds(Ad ads) {
		Ads = ads;
	}



	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	public int getNbGarage() {
		return nbGarage;
	}

	public void setNbGarage(int nbGarage) {
		this.nbGarage = nbGarage;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Ad getAadDialog() {
		return aadDialog;
	}

	public void setAadDialog(Ad aadDialog) {
		this.aadDialog = aadDialog;
	}

	public int getIdComment() {
		return IdComment;
	}

	public void setIdComment(int idComment) {
		IdComment = idComment;
	}

	public IAdService getIadService() {
		return iadService;
	}

	public void setIadService(IAdService iadService) {
		this.iadService = iadService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}



	public int getIdPub() {
		return idPub;
	}

	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getDescCom() {
		return descCom;
	}

	public void setDescCom(String descCom) {
		this.descCom = descCom;
	}


	private Ad selectedAd;


	public Ad getSelectedAd() {
		return selectedAd;
	}

	public void setSelectedAd(Ad selectedAd) {
		this.selectedAd = selectedAd;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		this.Image = image;
	}

	public Comment getC() {
		return c;
	}

	public void setC(Comment c) {
		this.c = c;
	}

	public List<Comment> getCom() {
		return com;
	}

	public void setCom(List<Comment> com) {
		this.com = com;
	}

	public String getDescriptionComment() {
		return DescriptionComment;
	}

	public void setDescriptionComment(String descriptionComment) {
		DescriptionComment = descriptionComment;
	}

	public int getNumberLikes() {
		return NumberLikes;
	}

	public void setNumberLikes(int numberLikes) {
		NumberLikes = numberLikes;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public RentPeriod getRentperiod() {
		return rentperiod;
	}

	public void setRentperiod(RentPeriod rentperiod) {
		this.rentperiod = rentperiod;
	}
	public RentPeriod[] getrentperiods() {
		return RentPeriod.values();
	}
	public int getViewsNumber() {
		return ViewsNumber;
	}

	public void setViewsNumber(int viewsNumber) {
		ViewsNumber = viewsNumber;
	}

	public Boolean getSuccess() {
		return Success;
	}

	public void setSuccess(Boolean success) {
		Success = success;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public Integer getAdIdToBeUpdated() {
		return adIdToBeUpdated;
	}

	public void setAdIdToBeUpdated(Integer adIdToBeUpdated) {
		this.adIdToBeUpdated = adIdToBeUpdated;
	}
	
	public Integer getCommetIdToBeUpdated() {
		return CommetIdToBeUpdated;
	}

	public void setCommetIdToBeUpdated(Integer commetIdToBeUpdated) {
		CommetIdToBeUpdated = commetIdToBeUpdated;
	}

	public int getIdAd() {
		return IdAd;
	}

	public void setIdAd(int idAd) {
		IdAd = idAd;
	}


	public Date getAdDate() {
		return AdDate;
	}

	public void setAdDate(Date adDate) {
		AdDate = adDate;
	}

	public KindOfGood[] getKindofgoods() {
		return KindOfGood.values();
	}

	public KindOfGood getKindofgood() {
		return kindofgood;
	}

	public IAdService getAdService() {
		return adService;
	}

	public void setAdService(IAdService adService) {
		this.adService = adService;
	}

	public void setKindofgood(KindOfGood kindofgood) {
		this.kindofgood = kindofgood;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getArea() {
		return Area;
	}

	public void setArea(int area) {
		Area = area;
	}

	public Ad getAd() {
		return ad;
	}


	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public List<Ad> getAds() {
		ads = adService.retrieveAllAds();
		return ads;
	}

	public RentingType[] getrentingtypes() {
		return RentingType.values();
	}

	public RentingType getRentingtype() {
		return rentingtype;
	}

	public void setRentingtype(RentingType rentingtype) {
		this.rentingtype = rentingtype;
	}


	public int getNbBaths() {
		return nbBaths;
	}

	public void setNbBaths(int nbBaths) {
		this.nbBaths = nbBaths;
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////


 public Ad addAd(Ad ad) { Ad a = iadService.addAd(ad); return a; }

	


	public void addad() {
		

	adService.addOrUpdateAd(new Ad(Description, Location, Area,kindofgood, StartDate,EndDate,rentperiod,Price,rentingtype,nbGarage,nbRooms,Image,nbBaths));
			
		
		}

	


	public String SeeAllAds(){
		
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}
	
	
	public void setKk(List<Ad> kk) {
		this.kk = kk;
	}

	public void deleteAd(int IdAd) {
		
		iadService.deleteAd(IdAd);
	}

	public String removeAd(int IdAd) {
		adService.getAdById(IdAd);
		adService.deleteAd(IdAd);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}

	public String displayAd(Ad ad) {
		this.setImage(ad.getImage());
		this.setKindofgood(ad.getKindofgood());
		this.setLocation(ad.getLocation());
		this.setArea(ad.getArea());
		this.setDescription(ad.getDescription());
		this.setUser(ad.getUser());
		this.setPrice(ad.getPrice());
		this.setNbRooms(ad.getNbRooms());
		this.setNbGarage(ad.getNbGarage());
		this.setAdIdToBeUpdated(ad.getIdAd());
		this.setAdDate(ad.getAdDate());
		this.setStartDate(ad.getStartDate());
		this.setEndDate(ad.getEndDate());
		this.setRentperiod(ad.getRentperiod());
		this.setRentingtype(ad.getRentingtype());
		this.setNbBaths(ad.getNbBaths());
		
		return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";
	
	}
	
	
	public String openDetail(Ad aad){
	     ad = aad;
			return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";
	    }
	public String go() {
		return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";
	}

	public String ClearAd() {
		//String navigateTo = "null";
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setDescription(null);
		this.setAdIdToBeUpdated(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		//navigateTo = "/webapp/gererAd/ModifyAd.xhtml?faces-redirect=true";
		return "/gererAd/AddHouseSell.xhtml?faces-redirect=true";

	}

	
	
	public String Clear() {
		//String navigateTo = "null";
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setDescription(null);
		this.setAdIdToBeUpdated(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		//navigateTo = "/webapp/gererAd/ModifyAd.xhtml?faces-redirect=true";
		return "/gererAd/ModifyTemplate.xhtml?faces-redirect=true";

	}
	
	public String ClearAdRent() {
		this.setKindofgood(null);
		this.setLocation(null);
		this.setArea(0);
		this.setStartDate(null);
		this.setEndDate(null);
		this.setDescription(null);
		this.setRentperiod(null);
		this.setRentingtype(null);
		this.setPrice(0);
		this.setNbBaths(0);
		this.setNbGarage(0);
		this.setNbRooms(0);
		this.setAdIdToBeUpdated(null);
		return "/gererAd/AddHouseRent.xhtml?faces-redirect=true";

	} 
	
	public String updateAd() {
		adService.addOrUpdateAd(new Ad(adIdToBeUpdated,Description, Location, Area,AdDate,kindofgood,StartDate,EndDate,rentperiod,Price,rentingtype,nbGarage,nbRooms,Image,nbBaths));
		return "/gererAd/basic.xhtml?faces-redirect=true";

	}

	public Ad modifyAd(@RequestBody Ad ad) {
		return iadService.updateAd(ad);
	}

	public Ad getAdById(int adId) {
		return adService.getAdById(adId);
	}
	public void addMessage(String summary) {  //addMessage("Data saved");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);}

	public String getAdById1(int idAd) {
		l.info("aaaaaaaaaa"+idAd);
		adService.getAdById(idAd);
		//getAllCommentsByAd
		setIdPub(idAd);
		setCom(adService.DescriptionComments(idAd)); 
		return "/gererAd/DescriptionComment.xhtml?faces-redirect=true";
	}




	public String removeComment(int IdComment) {
		//String navigateTo = "null";
		l.info("hhhhhhhhhhh"+ IdComment);
		adService.deleteComment(IdComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";


	}
	public String deleteComment(int IdComment) {
		adService.deleteComment(IdComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";}
		
	
	
	
	public Comment UpdateComment(Comment comment) {
		adService.UpdateComment(comment);
		return comment;
	}
	
	
	


	public void AssignCommentToanAd(int CommentId, int AdId) {

		iadService.AssignCommentToanAd(CommentId, AdId);
	}

	public List<String> getAllCommentsByAd(int AdId) {
		return adService.getAllCommentsByAd(AdId);
	}
	

	public String displayAdComment(Comment c) {

		this.setDescriptionComment(c.getDescriptionComment());
		return "/gererAd/showComments.xhtml?faces-redirect=true";

	}

	public int countComments() {

		return iadService.countComments();
	}

	public int nbrLike() {
		return iadService.nbrLike();
	}

	public List<Ad> getAdWithBestLikesOnCommentsJPQL() {
		return iadService.getAdWithBestLikesOnCommentsJPQL();
	}

	public int maxnblike() {
		return iadService.maxnblike();
	}

	public boolean succes() {
		return iadService.succes();
	}

	public double AVG_nbcomment() {
		return iadService.AVG_nbcomment();
	}

	public boolean BlockCommentsWithInsultingWords() {
		return iadService.BlockCommentsWithInsultingWords();
	}

	public void ScoreIncrement() {
		iadService.ScoreIncrement();
	}

	public int AdsForToday() {
		return iadService.AdsForToday();
	}

	public double AVG_Ads_Year() {
		return iadService.AVG_Ads_Year();
	}

	public double countAds() {
		return iadService.countAds();
	}

	public List<String> getAllCommentsBlockedJPQL() {
		return iadService.getAllCommentsBlockedJPQL();

	}

	public List<String> getAdsFromTheSameUserJPQL() {
		return iadService.getAdsFromTheSameUserJPQL();

	}

	public int countCommentsJPQL(int IdAd) {
		return iadService.countCommentsJPQL(IdAd);
	}
	public int getNumberView(int idad) {
		return iadService.getNumberView(idad);
	}
	public int getNumberViewId(int idad) {
		return adService.getNumberView(idad);
	}

	public boolean increment(int idad) {
		return iadService.increment(idad);

	}
	public boolean incrementad(int idAd) {
		a=ratingview.getRating8(idAd);
		ad = adService.getAdById(idAd);
		//setAadDialog(adService.getAdById(idAd)); 
		//adService.getAdById(idAd);
		l.info("mmmmmmm" + idAd);
		return adService.increment(idAd);

	}

	public Integer getRating8(int idad) {
		return ratingview.getRating8(idad);
	}



	public boolean BlockCommentsWithInsultingWords2() {
		return iadService.BlockCommentsWithInsultingWords2();
	}

	public void ReclamerUser() {
		iadService.ReclamerUser();
	}
	public void BlockUserByBadComments() {
		adService.BlockUserByBadComments();
	}

	public List<Ad> filter(){

		return iadService.filter();
	}
	public List<Comment> DescriptionComments(int idc) {
		return iadService.DescriptionComments(idc);
	}



	
	

	  
}

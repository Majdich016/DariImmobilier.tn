package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Ad;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.KindOfGood;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.RentPeriod;
import tn.esprit.spring.entities.RentingType;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.services.IAdService;
import tn.esprit.spring.services.MailService;

import tn.esprit.spring.services.RatingView;



@Scope(value = "session")
@ELBeanName(value = "adController")
//@Join(path = "/", to = "/gererAd/basic.jsf")
@Controller(value = "adController")
public class IControllerAdImpl {


	public static final Logger l = LogManager.getLogger(IControllerAdImpl.class);
	@Autowired
	UserRestController urc;
	@Autowired
	IAdService iadService;
	@Autowired
	IAdService adService;
	@Autowired
	RatingView ratingview;
	
	@Autowired
	MailService mails;
	
	
	private int IdAd;
	private Ad ad;
	private Comment c;
	private List<Ad> ads;
	private List<Ad> filterprix;
	private List<Comment> com;
	private String Description;
	private String Location;
	private int Area;
	private int nbBaths;
	private String Image;
	private KindOfGood kindofgood;
	private Date AdDate;
	private Integer adIdToBeUpdated;
	private int ViewsNumber;
	private Boolean Success;
	private int Score;
	private Date StartDate;
	private Date EndDate;
	private RentPeriod rentperiod;
	private RentingType rentingtype;
	private float Price;
	private UploadedFile file;
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
	private Integer CommetIdToBeUpdated;
	private String destination = "C:\\work\\Pidevtest_template\\src\\main\\resources\\META-INF\\resources\\upload\\";
	private Ad Ads;
	private String updatedComment;
	private DonutChartModel donutModel;
	private DonutChartModel donutModel2;
	private int nbDisLikes;
	private Etat etat;
	private Boolean Furnished;
	private Boolean Terrace;
	private Boolean Garden;
	private Boolean SwimmingPool;
	private Boolean SousSol;
	private Boolean Garage;
	private Boolean AirConditioning;
	private Boolean Ascenseur;
	private Boolean Heater;
	private String newComment;
	private List<Reclamation> reclamations;
	private int IdRec;
	////////////////////////////////////Getters&Setters////////////////////////////////////////////////////////////




	public int getA() {
		return a;
	}

	



	public List<Reclamation> getReclamations() {
		return reclamations;
	}





	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}





	public String getNewComment() {
		return newComment;
	}





	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}





	public MailService getMails() {
		return mails;
	}





	public void setMails(MailService mails) {
		this.mails = mails;
	}




	public Etat getEtat() {
		return etat;
	}



	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	public UserRestController getUrc() {
		return urc;
	}



	public void setUrc(UserRestController urc) {
		this.urc = urc;
	}



	public Boolean getFurnished() {
		return Furnished;
	}



	public void setFurnished(Boolean furnished) {
		Furnished = furnished;
	}



	public Boolean getTerrace() {
		return Terrace;
	}



	public void setTerrace(Boolean terrace) {
		Terrace = terrace;
	}



	public Boolean getGarden() {
		return Garden;
	}



	public void setGarden(Boolean garden) {
		Garden = garden;
	}



	public Boolean getSwimmingPool() {
		return SwimmingPool;
	}



	public void setSwimmingPool(Boolean swimmingPool) {
		SwimmingPool = swimmingPool;
	}



	public Boolean getSousSol() {
		return SousSol;
	}



	public void setSousSol(Boolean sousSol) {
		SousSol = sousSol;
	}



	public Boolean getGarage() {
		return Garage;
	}



	public void setGarage(Boolean garage) {
		Garage = garage;
	}



	public Boolean getAirConditioning() {
		return AirConditioning;
	}



	public void setAirConditioning(Boolean airConditioning) {
		AirConditioning = airConditioning;
	}



	public Boolean getAscenseur() {
		return Ascenseur;
	}



	public void setAscenseur(Boolean ascenseur) {
		Ascenseur = ascenseur;
	}



	public Boolean getHeater() {
		return Heater;
	}



	public void setHeater(Boolean heater) {
		Heater = heater;
	}



	public static Logger getL() {
		return l;
	}



	public DonutChartModel getDonutModel2() {
		return donutModel2;
	}



	public void setDonutModel2(DonutChartModel donutModel2) {
		this.donutModel2 = donutModel2;
	}



	public DonutChartModel getDonutModel() {
		return donutModel;
	}



	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}



	public int getNbDisLikes() {
		return nbDisLikes;
	}



	public void setNbDisLikes(int nbDisLikes) {
		this.nbDisLikes = nbDisLikes;
	}



	public void setAds(Ad ads) {
		Ads = ads;
	}



	public RatingView getRatingview() {
		return ratingview;
	}



	public void setRatingview(RatingView ratingview) {
		this.ratingview = ratingview;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public Integer getCommetIdToBeUpdated() {
		return CommetIdToBeUpdated;
	}

	public void setCommetIdToBeUpdated(Integer commetIdToBeUpdated) {
		this.CommetIdToBeUpdated = commetIdToBeUpdated;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
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
	  
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
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


 public String getUpdatedComment() {
		return updatedComment;
	}



	public void setUpdatedComment(String updatedComment) {
		this.updatedComment = updatedComment;
	}



public Ad addAd(Ad ad) { Ad a = iadService.addAd(ad); return a; }

	
	public String addad() {
		
		//Ad tmp = new Ad(Description, Location, Area,kindofgood, StartDate,EndDate,rentperiod,Price,rentingtype,nbGarage,nbRooms,nbBaths,c);
	
		
		Date currentdate = new Date();
		Ad adnotif;
		
	
		
		//mails.sendEmail(user);
		//System.out.println("ededededede " + file.getFileName());

		
		return "/gererAd/basic.xhtml?faces-redirect=true";

	}



	public String SeeAllAds(){
		
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}
	
	/*public List<Ad> getKk() {
	

		kk=adService.filter();

		return kk;
	}
*/
	

	public void deleteAd(int IdAd) {
		iadService.deleteAd(IdAd);
	}

	public List<Ad> getFilterprix() {
		filterprix=adService.filter();
		return filterprix;
	}

	public void setFilterprix(List<Ad> filterprix) {
		this.filterprix = filterprix;
	}


	public void removeAddash(int IdAd) {
		iadService.deleteAd(IdAd);
	}

	public String removeAd(int IdAd) {
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
	 	
			return "/gererAd/chaquead.xhtml?faces-redirect=true";
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
		
		
		Date currentdate = new Date();
		//Ad adnotif;
		
	//	adService.addOrUpdateAd(new Ad(adIdToBeUpdated,Description, Location, Area,currentdate,kindofgood,StartDate,EndDate,rentperiod,Price,rentingtype,nbGarage,nbRooms,Image,nbBaths,currentuser));
		
		
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


	public String addComment() {

		
		
		System.out.println("cmnt " + newComment);
		Comment cmnt = new Comment();
		cmnt.setDescriptionComment(newComment);
		cmnt.setIsBlocked(false);
		cmnt.setAds(ad);
		
		adService.addCommentaire(cmnt);
		return "/gererAd/basic.xhtml?faces-redirect=true";

	}

	public String addComment1(int idAd) {
	
		
		
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}


	public String removeComment(int idComment) {
		//String navigateTo = "null";
		l.info("hhhhhhhhhhh"+ idComment);
		adService.deleteComment(idComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";


	}
	/*public String deleteComment(int idComment) {
		adService.deleteComment(idComment);
		return "/gererAd/basic.xhtml?faces-redirect=true";}
		
	*/
	public List<Comment> listCommentaire(Ad ad) {
		return ad.getComments();
	}
	
	public Comment UpdateComment(Comment comment) {
		return adService.UpdateComment(comment);
		
	}
	
	
	public String ModifyComment() {
		System.out.println("cccmmt "+updatedComment);
		l.info("modifyyyyyy    "+ CommetIdToBeUpdated);
	return "/gererAd/basic.xhtml?faces-redirect=true";
	}


	public void AssignCommentToanAd(int CommentId, int AdId) {
		iadService.AssignCommentToanAd(CommentId, AdId);
	}

	public List<String> getAllCommentsByAd(int AdId) {
		return adService.getAllCommentsByAd(AdId);
	}
	public void displayComment(Comment com) {
		
		this.setUpdatedComment(com.getDescriptionComment());
		this.setNumberLikes(com.getNumberLikes());
		this.setClient(com.getClient());
		this.setAds(com.getAds());
		this.setCommetIdToBeUpdated(com.getIdComment());
	}


	public String displayAdComment(Comment c) {

		this.setDescriptionComment(c.getDescriptionComment());
		this.setCommetIdToBeUpdated(c.getIdComment());
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



	public String BlockCommentsWithInsultingWords2(int idComment) {
		
		//c = adService.getCommentById(IdComment);
		l.info("Id Of Comment isssssss   " + idComment);
		adService.getCommentById(idComment);
		 iadService.BlockCommentsWithInsultingWords2(idComment);
		//Long idclient =c.getClient().getId();
		adService.BlockUserByBadComments(c.getClient().getId());
		 return "/gererAd/DescriptionComment.xhtml?faces-redirect=true\";";
	
	}

	
	
	public String incrementdislike(int idad) {
		adService.incrementdislike(idad);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}
	public String incrementlike(int idad) {
		 adService.incrementlike(idad);
		return "/gererAd/basic.xhtml?faces-redirect=true";
	}

	/*private List<Predicate<Ad>> configFilter(Filter<Ad> filter) {
    List<Predicate<Ad>> predicates = new ArrayList<>();
    if (filter.hasParam("id")) {
        Predicate<Ad> idPredicate = (Ad c) -> c.getIdAd().equals(filter.getParam("id"));
        predicates.add(idPredicate);
    }

    if (filter.hasParam("minPrice") && filter.hasParam("maxPrice")) {
        Predicate<Ad> minMaxPricePredicate = (Ad c) -> c.getPrice()
                >= Double.valueOf((String) filter.getParam("minPrice")) && c.getPrice()
                <= Double.valueOf((String) filter.getParam("maxPrice"));
        predicates.add(minMaxPricePredicate);
    } else if (filter.hasParam("minPrice")) {
        Predicate<Ad> minPricePredicate = (Ad c) -> c.getPrice()
                >= Double.valueOf((String) filter.getParam("minPrice"));
        predicates.add(minPricePredicate);
    } else if (filter.hasParam("maxPrice")) {
        Predicate<Ad> maxPricePredicate = (Ad c) -> c.getPrice()
                <= Double.valueOf((String) filter.getParam("maxPrice"));
        predicates.add(maxPricePredicate);
    }

    if (has(filter.getEntity())) {
    	Ad filterEntity = filter.getEntity();
        if (has(filterEntity.getModel())) {
            Predicate<Ad> modelPredicate = (Ad c) -> c.getModel().toLowerCase().contains(filterEntity.getModel().toLowerCase());
            predicates.add(modelPredicate);
        }

        if (has(filterEntity.getPrice())) {
            Predicate<Ad> pricePredicate = (Ad c) -> c.getPrice().equals(filterEntity.getPrice());
            predicates.add(pricePredicate);
        }

        if (has(filterEntity.getName())) {
            Predicate<Ad> namePredicate = (Ad c) -> c.getName().toLowerCase().contains(filterEntity.getName().toLowerCase());
            predicates.add(namePredicate);
        }
    }
    return predicates;
}*/
	public List<Ad> filter(){

		return iadService.filter();
	}
	
	public List<Comment> DescriptionComments(int idc) {
		return iadService.DescriptionComments(idc);
	}



	public void upload() {

		if (file != null) {
			FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else
			System.out.println("file is null");
	}

	public void handleFileUpload(FileUploadEvent event) {
		l.info("ddddddddddddddd " + event.getFile().getFileName());
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void TransferFile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int reader = 0;
			byte[] bytes = new byte[(int) file.getSize()];
			while ((reader = in.read(bytes)) != -1) {
				out.write(bytes, 0, reader);
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public List<Ad> retrieveAllVillaJPQL(KindOfGood kindofgood) {
		return adService.retrieveAllVillaJPQL(kindofgood);
	}

	
	public List<Ad> retrieveAllAppartementJPQL(KindOfGood kindofgood) {
		return adService.retrieveAllAppartementJPQL(kindofgood);
	}

	public List<Ad> retrieveAllStudioJPQL(KindOfGood kindofgood) {
		return adService.retrieveAllStudioJPQL(kindofgood);
	}

	
	public List<Ad> retrieveAllWorkshopJPQL(KindOfGood kindofgood) {
		return adService.retrieveAllWorkshopJPQL(kindofgood);
	}
	
	
	public String donutGraph(Model model) {
	
		donutModel = new DonutChartModel();
        ChartData data = new ChartData();
         
        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(adService.retrieveAllAppartementJPQL(kindofgood).size());
		values.add(adService.retrieveAllStudioJPQL(kindofgood).size());
		values.add(adService.retrieveAllVillaJPQL(kindofgood).size());
		values.add(adService.retrieveAllWorkshopJPQL(kindofgood).size());
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(183, 185, 189)");
		bgColors.add("rgb(255, 205, 86)");
		bgColors.add("rgb(54, 162, 235)");
		
        dataSet.setBackgroundColor(bgColors);
         
		data.addChartDataSet(dataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Villa");
		labels.add("Apartment");
		labels.add("Studio");
		labels.add("Workshop");
		data.setLabels(labels);
		donutModel.setData(data);
		return "/gererAd/donutGraph.xhtml?faces-redirect=true";
        
	}
	
	
	
	
	public void ReclamerUser() {
		iadService.ReclamerUser();
	}


	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public void BlockUserByBadComments1(Long id){
		//Long idclient =c.getClient().getId();
		adService.BlockUserByBadComments(id);
	
	}
	public int Countads() {
		return adService.Countads();
	}
	
}

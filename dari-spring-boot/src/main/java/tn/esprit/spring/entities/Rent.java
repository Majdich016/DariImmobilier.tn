package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent extends Ad {
	private static final long serialVersionUID = -3046278688391172322L;

	
	@Temporal(TemporalType.DATE)
	private Date StartDate;
	
	@Temporal(TemporalType.DATE)
	private Date EndDate;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private RentingType rentingtype;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rent") 
	private Set<RatingA> Ratings;


	public Rent() {
		super();
	}

	public Rent(Date startDate, Date endDate, RentingType rentingtype) {
		super();
		StartDate = startDate;
		EndDate = endDate;
		this.rentingtype = rentingtype;
	}

	public Rent(int idAd, String description, String location, Date addDate, int viewsNumber, Boolean success,
			int score, float price, int nbRooms, int surface, Boolean terrace, Boolean swimmingPool, Boolean garage,
			Boolean garden, Boolean furnished, Boolean airConditioning, Boolean heater, Boolean buildable,
			Boolean serviced, KindOfGood kindofgood, User user, List<Comment> comments, Set<Multimedia> multimedias,
			FavoriteAd favoriteAd) {
		super(idAd, description, location, addDate, viewsNumber, success, score, price, nbRooms, surface, terrace, swimmingPool,
				garage, garden, furnished, airConditioning, heater, buildable, serviced, kindofgood, user, comments,
				multimedias, favoriteAd);
		// TODO Auto-generated constructor stub
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public RentingType getRentingtype() {
		return rentingtype;
	}

	public void setRentingtype(RentingType rentingtype) {
		this.rentingtype = rentingtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rent [StartDate=" + StartDate + ", EndDate=" + EndDate + ", rentingtype=" + rentingtype + "]";
	}

	

	
	
	
}

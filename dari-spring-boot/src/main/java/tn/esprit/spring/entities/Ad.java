package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_AD")
public class Ad implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int IdAd;
		
		private String Description;
		private String Location;
		private int Area;
		
		@Temporal(TemporalType.DATE)
		private Date AdDate;

		private int ViewsNumber;
		
		private Boolean Success;
		private int Score;
		
		@Enumerated(EnumType.STRING)
		//@NotNull
		private KindOfGood kindofgood;
		
		@OneToMany
		(mappedBy="ads", 
				cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
				fetch=FetchType.EAGER)
		private List<Comment> comments = new ArrayList<>();
		
		@OneToMany
		(cascade = CascadeType.ALL, mappedBy="ad")
		private Set<Multimedia> multimedias;


		public Ad() {
			super();
			// TODO Auto-generated constructor stub
		}
		

	


		public Ad(int idAd, String description, String location, int area, Date adDate, int viewsNumber,
				Boolean success, int score, KindOfGood kindofgood, List<Comment> comments,
				Set<Multimedia> multimedias) {
			super();
			IdAd = idAd;
			Description = description;
			Location = location;
			Area = area;
			AdDate = adDate;
			ViewsNumber = viewsNumber;
			Success = success;
			Score = score;
			this.kindofgood = kindofgood;
			this.comments = comments;
			this.multimedias = multimedias;
		}





		public int getIdAd() {
			return IdAd;
		}

		public void setIdAd(int idAd) {
			IdAd = idAd;
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


		public Date getAdDate() {
			return AdDate;
		}

		public void setAdDate(Date adDate) {
			AdDate = adDate;
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


		public KindOfGood getKindofgood() {
			return kindofgood;
		}


		public void setKindofgood(KindOfGood kindofgood) {
			this.kindofgood = kindofgood;
		}


		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}


		public Set<Multimedia> getMultimedias() {
			return multimedias;
		}


		public void setMultimedias(Set<Multimedia> multimedias) {
			this.multimedias = multimedias;
		}


		@Override
		public String toString() {
			return "Ad [IdAd=" + IdAd + ", Description=" + Description + ", Location=" + Location + ", Area=" + Area
					+ ", AdDate=" + AdDate + ", ViewsNumber=" + ViewsNumber + ", Success=" + Success + ", Score="
					+ Score + ", kindofgood=" + kindofgood + ", comments=" + comments + ", multimedias=" + multimedias
					+ "]";
		}


	
	
		
		
		
}

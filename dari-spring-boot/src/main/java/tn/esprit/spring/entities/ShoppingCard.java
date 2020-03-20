package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SHOPPING_CARD")
public class ShoppingCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "SHOPPING_CARD_ID")
	private int id;

	
	@Column(name = "SHOPPING_CARD_NBR_ARTICLE")
	private int nbrArticle;
	
	@Column(name = "SHOPPING_CARD_TOTAL_ARTICLE")
	private int totalArticle;
	
	
	
	
	@ManyToMany(mappedBy="shoppingCards",fetch=FetchType.EAGER )
	private List<Furniture> furnitures;
	
	@OneToOne(mappedBy="shoppingCard")
	private Ordered ordered;

	
	
	

	public ShoppingCard() {
		super();
	}

	public ShoppingCard(int id, int nbrArticle, int totalArticle, List<Furniture> furnitures, Ordered ordered) {
		super();
		this.id = id;
		this.nbrArticle = nbrArticle;
		this.totalArticle = totalArticle;
		this.furnitures = furnitures;
		this.ordered = ordered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrArticle() {
		return nbrArticle;
	}

	public void setNbrArticle(int nbrArticle) {
		this.nbrArticle = nbrArticle;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	

	

	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}

	public Ordered getOrdered() {
		return ordered;
	}

	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

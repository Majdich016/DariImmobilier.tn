package tn.esprit.spring.entities;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_FURNITURE")
public class Furniture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "FURNITURE_ID")
	private int id;

	@Column(name = "FURNITURE_NAME")
	private String name;
	
	@Column(name = "FURNITURE_DESCRIPTION")
	private String description;

	@Column(name = "FURNITURE_PRICE")
	private float price;
	
	@Column(name = "FURNITURE_QUANTITY")
	private float quantity;
	
	@Column(name = "FURNITURE_PUBLISHED_DATE")
	@Temporal(TemporalType.DATE)
	private Timestamp publishedDate;
	
	@Column(name = "FURNITURE_IS_ACTIF")
	private boolean isActif;

}

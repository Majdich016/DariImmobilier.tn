package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.InheritanceType;


@Entity
@Table(name = "Appointment")
//@Inheritance(strategy = InheritanceType.JOINED)

public class Appointment  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long IdAppointement; 
	@Temporal(TemporalType.DATE)
	private Date dateAppointement;
	private String StateAppointment;
	
	@ManyToOne
	//Client client;
	
	
	public Long getIdAppointement() {
		return IdAppointement;
	}
	public void setIdAppointement(Long idAppointement) {
		IdAppointement = idAppointement;
	}
	public Date getDateAppointement() {
		return dateAppointement;
	}
	public void setDateAppointement(Date dateAppointement) {
		this.dateAppointement = dateAppointement;
	}
	public String getStateAppointment() {
		return StateAppointment;
	}
	public void setStateAppointment(String stateAppointment) {
		StateAppointment = stateAppointment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Appointment [IdAppointement=" + IdAppointement + ", dateAppointement=" + dateAppointement
				+ ", StateAppointment=" + StateAppointment + "]";
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

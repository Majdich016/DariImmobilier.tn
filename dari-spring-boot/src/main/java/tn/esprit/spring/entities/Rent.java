package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent extends Ad {
	private static final long serialVersionUID = -3046278688391172322L;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Enumerated(EnumType.STRING)
	//@NotNull
	private RentPeriod rentperiod;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private RentingType rentingtype;

	
	
	public Rent(Date dateDebut, Date dateFin, RentPeriod rentperiod, RentingType rentingtype) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.rentperiod = rentperiod;
		this.rentingtype = rentingtype;
	}
	

	public RentPeriod getRentperiod() {
		return rentperiod;
	}


	public void setRentperiod(RentPeriod rentperiod) {
		this.rentperiod = rentperiod;
	}


	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public RentPeriod getRentperiode() {
		return rentperiod;
	}

	public void setRentperiode(RentPeriod rentperiod) {
		this.rentperiod = rentperiod;
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
		return "Rent [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", rentperiod=" + rentperiod
				+ ", rentingtype=" + rentingtype + "]";
	}
	
}

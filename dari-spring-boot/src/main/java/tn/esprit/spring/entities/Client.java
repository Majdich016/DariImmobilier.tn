package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client  extends User  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	private String picture;
	private boolean block;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<AppointmentFeedBack> AppointmentFeedBack;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Appointment> Appointment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public String toString() {
		return "Client [id=" + id + ", picture=" + picture + ", block=" + block +  "]";
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long id, String picture/*, boolean block*/) {
		super();
		this.id = id;
		this.picture = picture;
		//this.block = block;
	}
	public Set<AppointmentFeedBack> getAppointmentFeedBack() {
		return AppointmentFeedBack;
	}
	public void setAppointmentFeedBack(Set<AppointmentFeedBack> appointmentFeedBack) {
		AppointmentFeedBack = appointmentFeedBack;
	}
	public Set<Appointment> getAppointment() {
		return Appointment;
	}
	public void setAppointment(Set<Appointment> appointment) {
		Appointment = appointment;
	}
	
	
	
	

}

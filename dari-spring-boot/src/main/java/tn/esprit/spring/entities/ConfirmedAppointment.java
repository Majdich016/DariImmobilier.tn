package tn.esprit.spring.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ConfirmedAppointment")


public class ConfirmedAppointment extends Appointment{
	private static final long serialVersionUID = 1L;
	 
	private String Attendance;
	
	
	@Override
	public String toString() {
		return "ConfirmedAppointment [Attendance=" + Attendance + "]";
	}
	public String getAttendance() {
		return Attendance;
	}
	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

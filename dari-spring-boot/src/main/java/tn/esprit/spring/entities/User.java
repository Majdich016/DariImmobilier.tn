package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	
	private String FirstName;
	
	private String Lastname;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Ad> Ad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String Email;
	private String Password;
	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", Lastname=" + Lastname + ", dateNaissance="
				+ dateNaissance + ", Email=" + Email + ", Password=" + Password + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

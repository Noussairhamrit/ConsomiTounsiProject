package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
 
@Entity
@Data
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AppUser {
	@Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;
 
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
 
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
     
    private String nom;
    private String prenom;
    private long cin;
    private String address;
    private long num_tel;
    private String email;
    
    
    
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AppUser(Long userId, String userName, String encrytedPassword, boolean enabled, String nom, String prenom,
			long cin, String address, long num_tel, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.address = address;
		this.num_tel = num_tel;
		this.email = email;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public long getCin() {
		return cin;
	}


	public void setCin(long cin) {
		this.cin = cin;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getNum_tel() {
		return num_tel;
	}


	public void setNum_tel(long num_tel) {
		this.num_tel = num_tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
    
}

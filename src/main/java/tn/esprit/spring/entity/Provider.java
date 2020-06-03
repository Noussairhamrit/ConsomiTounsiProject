package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



@Entity
@Table(name = "Providers")
public class Provider extends AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Provider")
	private int IdProvider;

	@Column(name = "Provider_Name")
	private String pro_name;

	@Column(name = "Domain")
	private String Domain;

	@Column(name = "Email")
	private String email;

	@Column(name = "GSM")
	private int gsm;

	public int getIdProvider() {
		return IdProvider;
	}




	public void setIdProvider(int idProvider) {
		IdProvider = idProvider;
	}




	public Stock getStockP() {
		return stockP;
	}




	public void setStockP(Stock stockP) {
		this.stockP = stockP;
	}




	public Provider() {
		super();
	}
	



	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Stock stockP;

}

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
	

	@Column(name = "Domain")
	private String Domain;



	

	
	
	public String getDomain() {
		return Domain;
	}



	public void setDomain(String domain) {
		Domain = domain;
	}




	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Stock stockP;

}

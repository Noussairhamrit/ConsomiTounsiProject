package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "SousCat")

public class SousCategories implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SousCat_Id")
	private Long IdSousCat;
	@Column(name = "SousCat_nom")
	private String Snom;
	@Column(name = "SousCat_desc")
	private String Sdescription;
	
	@OneToMany(mappedBy="souscat")
	private List<Produit> produit;
	
	@ManyToOne
	private Categorie categorie;
	
	
	
	public Long getIdSousCat() {
		return IdSousCat;
	}
	public void setIdSousCat(Long idSousCat) {
		IdSousCat = idSousCat;
	}
	public String getSnom() {
		return Snom;
	}
	public void setSnom(String snom) {
		Snom = snom;
	}
	public String getSdescription() {
		return Sdescription;
	}
	public void setSdescription(String sdescription) {
		Sdescription = sdescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public SousCategories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SousCategories(Long idSousCat, String snom, String sdescription) {
		super();
		IdSousCat = idSousCat;
		Snom = snom;
		Sdescription = sdescription;
	}
	@Override
	public String toString() {
		return "SousCategories [IdSousCat=" + IdSousCat + ", Snom=" + Snom + ", Sdescription=" + Sdescription + "]";
	}
	
	

}

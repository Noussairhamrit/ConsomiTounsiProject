package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Categories")

public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cat_Id")
	private Long IdCat;
	@Column(name = "Cat_nom")
	private String nom;
	@Column(name = "Cat_desc")
	private String description;
	
	
	@OneToMany(mappedBy="categorie", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<SousCategories> souscategories = new ArrayList<>();
	
	public Long getIdCat() {
		return IdCat;
	}
	public void setIdCat(Long idCat) {
		IdCat = idCat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(Long idCat, String nom, String description) {
		super();
		IdCat = idCat;
		this.nom = nom;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Categorie [IdCat=" + IdCat + ", nom=" + nom + ", description=" + description + "]";
	}
	
	
}

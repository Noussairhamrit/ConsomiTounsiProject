package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Produit")

public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "Prod_Id")
	private Long id;
	@Column(name = "Prod_nom")
	private String nom;
	@Column(name = "Prod_Prix")
	private Long prix;
	@Column(name = "Prod_Desc")
	private String Description;
	@Column(name = "Prod_Qount")
	private Long quantite;
	@Column(name = "Prod_Poid")
	private Long poid;
	@Column(name = "Barre_code")
	private Long barreCode;
	@Column(name = "image")
	private String img;
	@Column(name = "Prix_Achat")
	private Long prixAchat;
	@Column(name = "Prix_Vente")
	private Long prixVente;
	
	@ManyToOne
	private SousCategories souscat;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getPrix() {
		return prix;
	}
	public void setPrix(Long prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Long getQuantite() {
		return quantite;
	}
	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
	public Long getPoid() {
		return poid;
	}
	public void setPoid(Long poid) {
		this.poid = poid;
	}
	public Long getBarreCode() {
		return barreCode;
	}
	public void setBarreCode(Long barreCode) {
		this.barreCode = barreCode;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Long getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(Long prixAchat) {
		this.prixAchat = prixAchat;
	}
	public Long getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Long prixVente) {
		this.prixVente = prixVente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(Long id, String nom, Long prix, String description, Long quantite, Long poid, Long barreCode,
			String img, Long prixAchat, Long prixVente) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.img = img;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", Description=" + Description + ", quantite="
				+ quantite + ", poid=" + poid + ", barreCode=" + barreCode + ", img=" + img + ", prixAchat=" + prixAchat
				+ ", prixVente=" + prixVente + "]";
	}
	
	

}

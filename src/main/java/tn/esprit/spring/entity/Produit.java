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

import lombok.Data;


@Data
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
	private int id;
	@Column(name = "Prod_nom")
	private String nom;
	@Column(name = "Prod_Prix")
	private long prix;
	@Column(name = "Prod_Desc")
	private String Description;
	@Column(name = "Prod_Qount")
	private long quantite;
	@Column(name = "Prod_Poid")
	private long poid;
	@Column(name = "Barre_code")
	private long barreCode;
	@Column(name = "image")
	private String img;
	@Column(name = "Prix_Achat")
	private long prixAchat;
	@Column(name = "Prix_Vente")
	private int prixVente;
	
	@ManyToOne
	private SousCategories souscat;
	
	@ManyToOne
	private Ray ray;
	
	@ManyToOne
	private Stock stock;
	
	

	////////////panier
	@OneToMany(mappedBy="produit")
	private  List<Panier> panier;
	
	public Produit() {
		super();
	}

	public Produit(int id, String nom, long prix, String description, long quantite, long poid, long barreCode,
			String img, long prixAchat, int prixVente, SousCategories souscat, List<Panier> panier) {
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
		this.souscat = souscat;
		this.panier = panier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getPoid() {
		return poid;
	}

	public void setPoid(long poid) {
		this.poid = poid;
	}

	public long getBarreCode() {
		return barreCode;
	}

	public void setBarreCode(long barreCode) {
		this.barreCode = barreCode;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public long getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(long prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public SousCategories getSouscat() {
		return souscat;
	}

	public void setSouscat(SousCategories souscat) {
		this.souscat = souscat;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}

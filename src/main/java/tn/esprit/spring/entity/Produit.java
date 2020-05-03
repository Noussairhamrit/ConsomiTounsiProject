package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name = "Produit")
@JsonIgnoreProperties
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
	private String img;
	@Column(name = "Prix_Achat")
	private long prixAchat;
	@Column(name = "Prix_Vente")
	private int prixVente;
	
	
	
	/////Actor
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private StoreManger gerant;
	
	@ManyToOne
	@JsonIgnore
	private SousCategories souscat;
	
	////////ImageProduit
	
	@OneToMany(mappedBy="Idproduit",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<ImageProduit> Images;
	
	
	@ManyToOne
	private Ray ray;
	
	@ManyToOne
	private Stock stock;
	
	

	////////////panier
	@OneToMany(mappedBy="produit" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private  List<Panier> panier;
	
	public Produit() {
		super();
	}



	public Produit(int id, String nom, long prix, String description, long quantite, long poid, long barreCode,
			long prixAchat, int prixVente, SousCategories souscat, Set<ImageProduit> images) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.souscat = souscat;
		Images = images;
	}
	








	public Set<ImageProduit> getImages() {
		return Images;
	}



	public void setImages(Set<ImageProduit> images) {
		Images = images;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public Produit(int id, String nom, long prix, String description, long quantite, long poid, long barreCode,
			long prixAchat, int prixVente, SousCategories souscat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.souscat = souscat;
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
	

	public StoreManger getGerant() {
		return gerant;
	}

	public void setGerant(StoreManger gerant) {
		this.gerant = gerant;
	}
	
	

//	public Set<ImageProduit> getImages() {
//		return Images;
//	}
//
//	public void setImages(Set<ImageProduit> images) {
//		Images = images;
//	}

	

	public Boolean BarcodeIsvalid(long barreCode){
		long c =10000000000L;
		long b=barreCode/c;
		if(b==619){
			return true;
		}
		return false;
	}

	public Produit(String nom, long prix, String description, long quantite, long poid, long barreCode, long prixAchat,
			int prixVente, Set<ImageProduit> images) {
		super();
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		Images = images;
	}



	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", Description=" + Description + ", quantite="
				+ quantite + ", poid=" + poid + ", barreCode=" + barreCode + ", img=" + img + ", prixAchat=" + prixAchat
				+ ", prixVente=" + prixVente + ", souscat=" + souscat + ", Images=" + Images + "]";
	}
	
	
	
	

}


	


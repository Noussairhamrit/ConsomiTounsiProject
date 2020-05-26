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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name = "Produit")
@JsonIgnoreProperties
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7950217207447904668L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Prod_Id")
	private int id;
	@NotNull (message="product name is null")
	@Column(name = "Prod_nom")
	private String nom;
	@NotNull
	@Positive(message="The price should be positive number ")
	@Column(name = "Prod_Prix")
	private long prix;
	@Column(name = "Prod_Desc")
	private String Description;
	@Column(name = "Prod_Qount")
	private long quantite;
	@NotNull
	@Positive(message="Poid should be positive number ")
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
	
	@JsonIgnore
	@ManyToOne
	private SousCategories souscat;
	
	////////ImageProduit
	@JsonIgnore
	@OneToMany(mappedBy="Idproduit",cascade=CascadeType.ALL)
	private Set<ImageProduit> Images;
	
	
	@ManyToOne
	private Ray ray;
	
	@ManyToOne
	private Stock stock;
	
	
	///////publicite
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List <Publicite> ads;
	

	////////////panier
	@OneToMany(mappedBy="produit" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private  List<Panier> panier;
	
	public Produit() {
		super();
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
		if (!BarcodeIsvalid(barreCode)) {
			throw new IllegalArgumentException("Invalid Barcode, barcode should be a number with '13' digits and starts with '619'");
		}
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

	

	boolean  BarcodeIsvalid(Long barreCode){
		if((barreCode.toString().indexOf("619")!=0)||(barreCode.toString().length()!=13)) return false;
		return true;
	}


	public Produit(@NotNull(message = "product name is null") String nom,
			@NotNull @Positive(message = "The price should be positive number ") long prix, String description,
			long quantite, @NotNull @Positive(message = "Poid should be positive number ") long poid, long barreCode,
			long prixAchat, int prixVente, StoreManger gerant, SousCategories souscat, Set<ImageProduit> images) {
		super();
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.gerant = gerant;
		this.souscat = souscat;
		Images = images;
	}


	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + ", Description=" + Description + ", quantite=" + quantite
				+ ", poid=" + poid + ", barreCode=" + barreCode + ", img=" + img + ", prixAchat=" + prixAchat
				+ ", prixVente=" + prixVente + ", gerant=" + gerant + ", souscat=" + souscat + ", Images=" + Images
				+ ", ray=" + ray + ", stock=" + stock + ", ads=" + ads + ", panier=" + panier + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((Images == null) ? 0 : Images.hashCode());
		result = prime * result + ((ads == null) ? 0 : ads.hashCode());
		result = prime * result + (int) (barreCode ^ (barreCode >>> 32));
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((panier == null) ? 0 : panier.hashCode());
		result = prime * result + (int) (poid ^ (poid >>> 32));
		result = prime * result + (int) (prix ^ (prix >>> 32));
		result = prime * result + (int) (prixAchat ^ (prixAchat >>> 32));
		result = prime * result + prixVente;
		result = prime * result + (int) (quantite ^ (quantite >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Images == null) {
			if (other.Images != null)
				return false;
		} else if (!Images.equals(other.Images))
			return false;
		if (ads == null) {
			if (other.ads != null)
				return false;
		} else if (!ads.equals(other.ads))
			return false;
		if (barreCode != other.barreCode)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (panier == null) {
			if (other.panier != null)
				return false;
		} else if (!panier.equals(other.panier))
			return false;
		if (poid != other.poid)
			return false;
		if (prix != other.prix)
			return false;
		if (prixAchat != other.prixAchat)
			return false;
		if (prixVente != other.prixVente)
			return false;
		if (quantite != other.quantite)
			return false;
		return true;
	}



	
	
	
	
	

}


	


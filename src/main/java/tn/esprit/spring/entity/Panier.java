package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PanierPK panierpk;
	
	private int quantite;
	private double prix;

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	// idcommande est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_commande", referencedColumnName = "id_commande", insertable = false, updatable = false)
	private Commandes commande;

	// idproduit est a la fois primary key et foreign key
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_produit", referencedColumnName = "Prod_Id", insertable = false, updatable = false)
	private Produit produit;
	
	
	


	public PanierPK getPanierpk() {
		return panierpk;
	}

	public void setPanierpk(PanierPK panierpk) {
		this.panierpk = panierpk;
	}

	public Commandes getCommande() {
		return commande;
	}

	public void setCommande(Commandes commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}

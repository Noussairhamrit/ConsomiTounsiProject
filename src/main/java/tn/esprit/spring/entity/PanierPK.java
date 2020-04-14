package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class PanierPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_commande;
	private int id_produit;
	
	
	


	public PanierPK() {
		super();
	}



	public int getId_commande() {
		return id_commande;
	}



	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}



	public int getId_produit() {
		return id_produit;
	}



	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}



	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

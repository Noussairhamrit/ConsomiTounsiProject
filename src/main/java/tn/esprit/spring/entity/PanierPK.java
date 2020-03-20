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
	
    private int id;
    
    
    public PanierPK() {
		super();
	}
    
    
	public PanierPK(int id_commande, int id_produit, int id) {
		super();
		this.id_commande = id_commande;
		this.id_produit = id_produit;
		this.id = id;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + id_commande;
		result = prime * result + id_produit;
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
		PanierPK other = (PanierPK) obj;
		if (id != other.id)
			return false;
		if (id_commande != other.id_commande)
			return false;
		if (id_produit != other.id_produit)
			return false;
		return true;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}

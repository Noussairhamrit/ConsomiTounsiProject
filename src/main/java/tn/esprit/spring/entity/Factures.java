package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Factures  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id_facture")
	private int id;
	private int montant;
	
	private Date date_de_depart;
	private String type;
	@OneToOne
	private Commandes commande;
	
	public Factures(){
		super();
	}
	public Factures(int id, int montant, Date date_de_depart, String type, Commandes commande) {
		super();
		this.id = id;
		this.montant = montant;
		this.date_de_depart = date_de_depart;
		this.type = type;
		this.commande = commande;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((date_de_depart == null) ? 0 : date_de_depart.hashCode());
		result = prime * result + id;
		result = prime * result + montant;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Factures other = (Factures) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (date_de_depart == null) {
			if (other.date_de_depart != null)
				return false;
		} else if (!date_de_depart.equals(other.date_de_depart))
			return false;
		if (id != other.id)
			return false;
		if (montant != other.montant)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Date getDate_de_depart() {
		return date_de_depart;
	}
	public void setDate_de_depart(Date date_de_depart) {
		this.date_de_depart = date_de_depart;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Commandes getCommande() {
		return commande;
	}
	public void setCommande(Commandes commande) {
		this.commande = commande;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	
	
	
}

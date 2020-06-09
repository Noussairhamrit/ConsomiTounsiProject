package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "Reclamation")
public class Reclamation  implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	private Decision decision;
	@OneToOne
	private Commandes commandes;
	@OneToOne
	private Produit produit;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Recl")
	private Integer id_recl;
	
	public void setId_recl(Integer id_recl) {
		this.id_recl = id_recl;
	}

	@Column(name = "description_Recl")
	private String descrip;

	
	
	public Integer getId_recl() {
		return id_recl;
	}
	

	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation() {
		super();
	}

	public Reclamation(int id_recl, String descrip) {
		super();
		this.id_recl = id_recl;
		this.descrip = descrip;
		
	}

	public Reclamation(Commandes commandes, Produit produit, Integer id_recl, String descrip) {
		super();
		this.commandes = commandes;
		this.produit = produit;
		this.id_recl = id_recl;
		this.descrip = descrip;
	}


	@Override
	public String toString() {
		return "Reclamation [id_recl=" + id_recl + ", descrip=" + descrip + "]";
	}

	public Reclamation(String descrip) {
		super();
		this.descrip = descrip;
	}
	
	


	public Reclamation(String descrip, Produit produit, Commandes commandes) {
		super();
		this.commandes = commandes;
		this.produit = produit;
		this.descrip = descrip;
	}


	public Decision getDecision() {
		return decision;
	}
	public void setDecision(Decision decision) {
		this.decision = decision;
	}
	public Commandes getCommandes() {
		return commandes;
	}
	public void setCommandes(Commandes commandes) {
		this.commandes = commandes;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}

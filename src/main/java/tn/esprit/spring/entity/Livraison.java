package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity 
@Table(name = "Livraison")
public class Livraison implements Serializable  {

	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Livreur livreur;
	
	@OneToOne
	private Commandes commandes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livraison")
	private int id_livra;
	
	@Column(name = "Frais_Livraison")
	private int frais_livra;
	
	@Column(name = "Dest_Livraison")
	private String dest_livra;
	
	@Column(name = "Etat_Livraison")
	@Enumerated(EnumType.STRING)
	private Etat_livra etat_livra;

	public int getId_livra() {
		return id_livra;
	}

	public void setId_livra(int id_livra) {
		this.id_livra = id_livra;
	}

	public int getFrais_livra() {
		return frais_livra;
	}

	public void setFrais_livra(int frais_livra) {
		this.frais_livra = frais_livra;
	}

	public String getDest_livra() {
		return dest_livra;
	}

	public void setDest_livra(String dest_livra) {
		this.dest_livra = dest_livra;
	}

	
	

	public Etat_livra getEtat_livra() {
		return etat_livra;
	}

	public void setEtat_livra(Etat_livra etat_livra) {
	 this.etat_livra = etat_livra;
	}

	public Livraison(int id_livra, int frais_livra, String dest_livra, Etat_livra etat_livra) {
		super();
		this.id_livra = id_livra;
		this.frais_livra = frais_livra;
		this.dest_livra = dest_livra;
		this.etat_livra = etat_livra;
	}

	public Livraison(int frais_livra, String dest_livra, Etat_livra etat_livra) {
		super();
		this.frais_livra = frais_livra;
		this.dest_livra = dest_livra;
		this.etat_livra = etat_livra;
	}

	public Livraison() {
		super();
	}

	@Override
	public String toString() {
		return "Livraison [id_livra=" + id_livra + ", frais_livra=" + frais_livra + ", dest_livra=" + dest_livra
				+ ", etat_livra=" + etat_livra + "]";
	}
	
	public void setLivreur(Livreur livreur) {
		this.livreur= livreur;
	}
	

}

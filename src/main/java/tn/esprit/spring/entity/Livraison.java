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
@Table(name = "Livraison")
public class Livraison implements Serializable  {

	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Livreur livreur;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livraison")
	private Long id_livra;
	
	@Column(name = "Frais_Livraison")
	private Long frais_livra;
	
	@Column(name = "Dest_Livraison")
	private String dest_livra;
	
	@Column(name = "Etat_Livraison")
	private String etat_livra;

	public Long getId_livra() {
		return id_livra;
	}

	public void setId_livra(Long id_livra) {
		this.id_livra = id_livra;
	}

	public Long getFrais_livra() {
		return frais_livra;
	}

	public void setFrais_livra(Long frais_livra) {
		this.frais_livra = frais_livra;
	}

	public String getDest_livra() {
		return dest_livra;
	}

	public void setDest_livra(String dest_livra) {
		this.dest_livra = dest_livra;
	}

	public String getEtat_livra() {
		return etat_livra;
	}

	public void setEtat_livra(String etat_livra) {
		this.etat_livra = etat_livra;
	}

	public Livraison(Long id_livra, Long frais_livra, String dest_livra, String etat_livra) {
		super();
		this.id_livra = id_livra;
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
	
	
	

}

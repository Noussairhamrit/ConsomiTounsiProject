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
	
	@OneToOne(mappedBy="reclamation")
	private Decision decision;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Recl")
	private int id_recl;
	
	@Column(name = "description_Recl")
	private String description_Recl;
	
	
	public int getId_recl() {
		return id_recl;
	}

	public void setId_recl(int id_recl) {
		this.id_recl = id_recl;
	}

	
	
	

	public String getDescription_Recl() {
		return description_Recl;
	}

	public void setDescription_Recl(String description_Recl) {
		this.description_Recl = description_Recl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation() {
		super();
	}

	public Reclamation(int id_recl, String description_Recl) {
		super();
		this.id_recl = id_recl;
		this.description_Recl = description_Recl;
		
	}

	@Override
	public String toString() {
		return "Reclamation [id_recl=" + id_recl + ", description_Recl=" + description_Recl + "]";
	}

	public Reclamation(String description_Recl) {
		super();
		this.description_Recl = description_Recl;
	}
	

}

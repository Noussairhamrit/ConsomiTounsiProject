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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Recl")
	private Long id_recl;
	
	@Column(name = "description_Recl")
	private String description;
	
	@Column(name = "type_recl")
	private String type_recl;

	public Long getId_recl() {
		return id_recl;
	}

	public void setId_recl(Long id_recl) {
		this.id_recl = id_recl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType_recl() {
		return type_recl;
	}

	public void setType_recl(String type_recl) {
		this.type_recl = type_recl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation() {
		super();
	}

	public Reclamation(Long id_recl, String description, String type_recl) {
		super();
		this.id_recl = id_recl;
		this.description = description;
		this.type_recl = type_recl;
	}

	@Override
	public String toString() {
		return "Reclamation [id_recl=" + id_recl + ", description=" + description + ", type_recl=" + type_recl + "]";
	}
	

}

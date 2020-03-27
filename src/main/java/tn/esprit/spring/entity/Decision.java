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
@Table(name = "Decision")
public class Decision implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy="decision")
	private Reclamation reclamation;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deci")
	private Long id_deci;

	public Long getId_deci() {
		return id_deci;
	}

	public void setId_deci(Long id_deci) {
		this.id_deci = id_deci;
	}
	
}

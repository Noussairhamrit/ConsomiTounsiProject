package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Decision")
public class Decision implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="decision")
	private Reclamation reclamation;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deci")
	private int id_deci;
	
	@Enumerated(EnumType.STRING)
	private TypeDecision typedecision;

	/*String desc = reclamation.getDescription_Recl();

	public String getDesc() {
		return desc;
	}
*/
	@Override
	public String toString() {
		return "Decision [id_deci=" + id_deci + ", typedecision=" + typedecision + "]";
	}

	/*public void setDesc(String desc) {
		this.desc = desc;
	}*/

	public TypeDecision getTypedecision() {
		return typedecision;
	}

	public void setTypedecision(TypeDecision typedecision) {
		this.typedecision = typedecision;
	}

	public  int  getId_deci() {
		return id_deci;
	}

	public void setId_deci( int  id_deci) {
		this.id_deci = id_deci;
	}

	public Decision() {
		super();
	}

	public Decision( int  id_deci, TypeDecision typedecision) {
		super();
		this.id_deci = id_deci;
		this.typedecision = typedecision;
		
	}
	public void setReclamation(Reclamation reclamation) {
		this.reclamation= reclamation;
	}
	


}

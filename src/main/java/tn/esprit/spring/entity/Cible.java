package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tn.esprit.spring.entity.*;


@Entity
@Table(name = "Cible")
public class Cible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cible_Id")
	private int idCib;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "pays")
	private String pay;
	@Column(name = "Localisation")
	private String local;
	
	
	
	@ManyToOne
	private Publicite publicite;
	
	
	public int getIdCib() {
		return idCib;
	}
	public void setIdCib(int idCib) {
		this.idCib = idCib;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Cible() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cible(String gender, String pay, String local) {
		super();
		this.gender = gender;
		this.pay = pay;
		this.local = local;
	}
	@Override
	public String toString() {
		return "Cible [idCib=" + idCib + ", gender=" + gender + ", pay=" + pay + ", local=" + local + "]";
	}
	
	

}

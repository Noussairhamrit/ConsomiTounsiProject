package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity 
@Table(name = "Livreur")
public class Livreur extends AppUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="livreur")
	private List<Livraison> livraison;
	
	@Column(name = "MOY_TRANS_liv")
	private String moy_trans_liv;
	
	@Column(name = "Dispo_liv")
	private boolean dispo_liv;
	
	@Column(name = "chargeT_liv")
	private int chargeT_liv;
	
	@Column(name = "salaire_liv")
	private int salaire_liv;
	
	public String getMoyen_de_transport() {
		return moy_trans_liv;
	}
	public void setMoyen_de_transport(String moy_trans_liv) {
		this.moy_trans_liv = moy_trans_liv;
	}
	public boolean isDispo_liv() {
		return dispo_liv;
	}
	public void setDispo_liv(boolean dispo_liv) {
		this.dispo_liv = dispo_liv;
	}
	public int getChargeT_liv() {
		return chargeT_liv;
	}
	public void setChargeT_liv(int chargeT_liv) {
		this.chargeT_liv = chargeT_liv;
	}
	public int getSalair_liv() {
		return salaire_liv;
	}
	public void setSalair_liv(int salaire_liv) {
		this.salaire_liv = salaire_liv;
	}
	public Livreur() {
		super();
	}
	
	public Livreur(String moyen_de_transport, boolean dispo_liv, int chargeT_liv, int salair_liv) {
		super();
		this.moy_trans_liv = moyen_de_transport;
		this.dispo_liv = dispo_liv;
		this.chargeT_liv = chargeT_liv;
		this.salaire_liv = salair_liv;
	}
	@Override
	public String toString() {
		return "Livreur [moy_trans_liv=" + moy_trans_liv + ", dispo_liv=" + dispo_liv + ", chargeT_liv="
				+ chargeT_liv + ", salaire_liv=" + salaire_liv + "]";
	}
	
	

}

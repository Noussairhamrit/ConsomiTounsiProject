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
	private List<Livraison> livraisons;
	
	@Column(name = "MOY_TRANS_liv")
	private String moy_trans_liv;
	
	@Column(name = "Dispo_liv")
	private boolean dispo_liv;
	
	@Column(name = "chargeT_liv")
	private int chargeT_liv;
	
	@Column(name = "salaire_liv")
	private int salaire_liv;
	
	
	public String getMoy_trans_liv() {
		return moy_trans_liv;
	}
	public void setMoy_trans_liv(String moy_trans_liv) {
		this.moy_trans_liv = moy_trans_liv;
	}
	public int getSalaire_liv() {
		return salaire_liv;
	}
	public void setSalaire_liv(int salaire_liv) {
		this.salaire_liv = salaire_liv;
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
	
	public Livreur() {
		super();
	}
	
	
	
	public Livreur(String moy_trans_liv, boolean dispo_liv, int chargeT_liv, int salaire_liv) {
		super();
		this.moy_trans_liv = moy_trans_liv;
		this.dispo_liv = dispo_liv;
		this.chargeT_liv = chargeT_liv;
		this.salaire_liv = salaire_liv;
	}
	@Override
	public String toString() {
		return "Livreur [moy_trans_liv=" + moy_trans_liv + ", dispo_liv=" + dispo_liv + ", chargeT_liv="
				+ chargeT_liv + ", salaire_liv=" + salaire_liv + "]";
	}
	
	public void setLivraison(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	public Livreur( String prenom,String nom,String userName,String encrytedPassword, String email ,long cin,long num_tel,String address, 
			  String moy_trans_liv,boolean dispo_liv,int salaire_liv , int chargeT_liv) {
		super();
		
		this.prenom = prenom;
		this.nom = nom;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.email = email;
		this.cin = cin;
		this.num_tel = num_tel;
		this.address = address;
		this.moy_trans_liv = moy_trans_liv;
		this.dispo_liv = dispo_liv;
		this.salaire_liv = salaire_liv;
		this.chargeT_liv = chargeT_liv;
	}
	
	public Livreur(Long userId, String userName, String encrytedPassword,boolean enabled,
    String nom, String prenom,
			long cin, String address, long num_tel, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.address = address;
		this.num_tel = num_tel;
		this.email = email;
	}
	public List<Livraison> getLivraisons() {
		return livraisons;
	}
	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
}


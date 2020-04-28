package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "commande")

public class Commandes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private int id;
	private Date date_commande;
	private double prixtotale;
	private String status;
	private String payment_type;
	private String Payment_state;
	private String poucentage;
	private double prix_after_remise;
	
	
	public String getPoucentage() {
		return poucentage;
	}



	public void setPoucentage(String poucentage) {
		this.poucentage = poucentage;
	}



	public double getPrix_after_remise() {
		return prix_after_remise;
	}



	public void setPrix_after_remise(double prix_after_remise) {
		this.prix_after_remise = prix_after_remise;
	}



	@JsonIgnore
	@OneToOne(mappedBy = "commande",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Factures facture;
	@JsonIgnore
	@OneToMany(mappedBy = "commande",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Panier> panier;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Client client;

	public Commandes() {
		super();
	}

	

	public Commandes(Date date_commande, String payment_type, String payment_state, String status, double prixtotale,
			Factures facture, List<Panier> panier, Client client) {
		super();
		this.date_commande = date_commande;
		this.payment_type = payment_type;
		Payment_state = payment_state;
		this.status = status;
		this.prixtotale = prixtotale;
		this.facture = facture;
		this.panier = panier;
		this.client = client;
	}



	public Commandes(int id, Date date_commande, double prixtotale, String status) {
		super();
		this.id = id;
		this.date_commande = date_commande;
		this.prixtotale = prixtotale;
		this.status = status;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_state() {
		return Payment_state;
	}

	public void setPayment_state(String payment_state) {
		Payment_state = payment_state;
	}

	public double getPrixtotale() {
		return prixtotale;
	}

	public void setPrixtotale(double prixtotale) {
		this.prixtotale = prixtotale;
	}

	public Factures getFacture() {
		return facture;
	}

	public void setFacture(Factures facture) {
		this.facture = facture;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

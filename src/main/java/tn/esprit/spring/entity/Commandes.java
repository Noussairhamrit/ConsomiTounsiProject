package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="commande")
@Data
public class Commandes implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int id;
	private Date date_commande;
	@Embedded
	Payment_TYPE payment_type;
	private boolean Payment_state;
	@OneToOne
	private Factures facture;
	
	@OneToMany(mappedBy="commande")
	private  List<Panier> panier;
	
	public Commandes() {
		super();
	}

	public Commandes(int id, Date date_commande, Payment_TYPE payment_type, boolean payment_state, Factures facture,
			List<Panier> panier) {
		super();
		this.id = id;
		this.date_commande = date_commande;
		this.payment_type = payment_type;
		Payment_state = payment_state;
		this.facture = facture;
		this.panier = panier;
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

	public Payment_TYPE getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Payment_TYPE payment_type) {
		this.payment_type = payment_type;
	}

	public boolean isPayment_state() {
		return Payment_state;
	}

	public void setPayment_state(boolean payment_state) {
		Payment_state = payment_state;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

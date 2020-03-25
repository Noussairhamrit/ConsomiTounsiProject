package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="commande")

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
	@Enumerated(EnumType.STRING)
	private Payment_TYPE payment_type;
	private boolean Payment_state;
	@OneToOne(mappedBy="commande")
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Payment_state ? 1231 : 1237);
		result = prime * result + ((date_commande == null) ? 0 : date_commande.hashCode());
		result = prime * result + ((facture == null) ? 0 : facture.hashCode());
		result = prime * result + id;
		result = prime * result + ((panier == null) ? 0 : panier.hashCode());
		result = prime * result + ((payment_type == null) ? 0 : payment_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commandes other = (Commandes) obj;
		if (Payment_state != other.Payment_state)
			return false;
		if (date_commande == null) {
			if (other.date_commande != null)
				return false;
		} else if (!date_commande.equals(other.date_commande))
			return false;
		if (facture == null) {
			if (other.facture != null)
				return false;
		} else if (!facture.equals(other.facture))
			return false;
		if (id != other.id)
			return false;
		if (panier == null) {
			if (other.panier != null)
				return false;
		} else if (!panier.equals(other.panier))
			return false;
		if (payment_type != other.payment_type)
			return false;
		return true;
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

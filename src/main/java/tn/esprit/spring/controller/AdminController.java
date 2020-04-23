package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.service.CommandesServiceIMP;

@Scope(value = "session")
@Controller(value = "AdminController")
@ELBeanName(value = "AdminController")
@Join(path = "/login", to = "/login.jsf")

public class AdminController {
	@Autowired
	CommandesServiceIMP CommandesService;
	
	private Date date_commande;
	private double prixtotale;
	private String status;
	private String payment_type;
	private String Payment_state;
	private String poucentage;
	private double prix_after_remise;
	private Commandes commande;
	private List<Commandes>commandes;
	
	
	public List<Commandes> getAllCommande() {
		return CommandesService.get_all_commandes();
		
	}
	
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public double getPrixtotale() {
		return prixtotale;
	}
	public void setPrixtotale(double prixtotale) {
		this.prixtotale = prixtotale;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public Commandes getCommande() {
		return commande;
	}

	public void setCommande(Commandes commande) {
		this.commande = commande;
	}

	public List<Commandes> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commandes> commandes) {
		this.commandes = commandes;
	}

	
	
	

}

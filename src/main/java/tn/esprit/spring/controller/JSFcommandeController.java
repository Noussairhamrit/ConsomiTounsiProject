package tn.esprit.spring.controller;



import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.service.CommandesServiceIMP;


@Scope(value = "session")
@Controller(value = "CommandeController")
@ELBeanName(value = "CommandeController")
public class JSFcommandeController {
	@Autowired
	CommandesServiceIMP commandeservice;
	private Commandes cmd;
	private Panier panier;
	private int id;
	private Date date_commande;
	private double prixtotale;
	private String status;
	private String payment_type;
	private String payment_state;
	private String poucentage;
	private double prix_after_remise;
	private Client client;
	private long userId;
	private String prenom;
	private List<Commandes>listecommande;
	
	public Commandes commande_en_cour_Idclient(long idclient){
		cmd= commandeservice.commande_en_cour_Idclient(idclient);
		return cmd;
	}
	@Transactional
	public List<Commandes> get_all_commandes() {
		listecommande= commandeservice.get_all_commandes();
		
		return listecommande;
	}
	@Transactional
	public long pt_merci(int idCommande){
		return commandeservice.pt_merci(idCommande);
	}
	
	
	
	
	
	
	
	
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Commandes getCmd() {
		return cmd;
	}
	public void setCmd(Commandes cmd) {
		this.cmd = cmd;
	}
	public List<Commandes> getListecommande() {
		return listecommande;
	}
	public void setListecommande(List<Commandes> listecommande) {
		this.listecommande = listecommande;
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
		return payment_state;
	}
	public void setPayment_state(String payment_state) {
		this.payment_state = payment_state;
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
	

}
package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.service.FacturesServiceIMP;

@Scope(value = "session")
@Controller(value = "FactureController")
@ELBeanName(value = "FactureController")
public class JSFfactureController {
	@Autowired
	FacturesServiceIMP FacturesService;
	private Factures facture;
	private int id;
	private double montant;
	
	private Date date_de_depart;
	private String type;
	private Commandes commande;
	private List<Factures> listefacture;
	@Transactional
	public List<Factures> getAllfactures() {
		return FacturesService.getAllfactures();
	}
	@Transactional
	public void facturepdf (int id){
		FacturesService.facturepdf(id);
	}
	


	public List<Factures> getListefacture() {
		return listefacture;
	}



	public void setListefacture(List<Factures> listefacture) {
		this.listefacture = listefacture;
	}



	public Factures getFacture() {
		return facture;
	}
	public void setFacture(Factures facture) {
		this.facture = facture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDate_de_depart() {
		return date_de_depart;
	}
	public void setDate_de_depart(Date date_de_depart) {
		this.date_de_depart = date_de_depart;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Commandes getCommande() {
		return commande;
	}
	public void setCommande(Commandes commande) {
		this.commande = commande;
	}
	
	

}

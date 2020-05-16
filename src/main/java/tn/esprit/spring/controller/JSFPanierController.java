package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.lignecommandeproduit;
import tn.esprit.spring.service.ClientServiceIMP;
import tn.esprit.spring.service.CommandesServiceIMP;
import tn.esprit.spring.service.PanierServiceIMP;

@Scope(value = "session")
@Controller(value = "PanierController")
@ELBeanName(value = "PanierController")
public class JSFPanierController {
	@Autowired
	PanierServiceIMP panierservice;
	@Autowired
	CommandesServiceIMP CommandesService;
	@Autowired
	ClientServiceIMP clientservice;
	private Panier panier;
	private int id;
	private Commandes commande;
	private Client client;
	private int quantity;
	private double price;
	private double total;
	private String status;
	private String nomProduit;

	private List<lignecommandeproduit> listpanier;

	public List<lignecommandeproduit> panierParIdclient(long id) {

		listpanier = panierservice.panierParIdclient(id);
		return listpanier;
	}

	public void supprimerPanier(int id) {
		panierservice.supprimerpanier(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commandes getCommande() {
		return commande;
	}

	public void setCommande(Commandes commande) {
		this.commande = commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<lignecommandeproduit> getListpanier() {
		return listpanier;
	}

	public void setListpanier(List<lignecommandeproduit> listpanier) {
		this.listpanier = listpanier;
	}

}

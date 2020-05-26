package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.lignecommandeproduit;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.service.ClientServiceIMP;
import tn.esprit.spring.service.CommandesServiceIMP;
import tn.esprit.spring.service.FacturesServiceIMP;
import tn.esprit.spring.service.PanierServiceIMP;
import tn.esprit.spring.service.StripeService;

@Scope(value = "session")
@Controller(value = "PanierController")
@ELBeanName(value = "PanierController")
public class JSFPanierController {
	@Autowired
	PanierServiceIMP panierservice;
	@Autowired
	FacturesServiceIMP FacturesService;
	@Autowired
	CommandesServiceIMP CommandesService;
	@Autowired
	CommandesRepository CommandesRepository; 
	@Autowired
	ClientServiceIMP clientservice;
	@Autowired
	StripeService  stripeService;
	private Panier panier;
	private Factures facture;
	private int id_facture;
	private int id;
	private int idc;
	private Commandes commande;
	private Client client;
	private int quantity;
	private double price;
	private double total;
	private String status;
	private String nomProduit;
	private long userId;
	private String carta;
	private int expMonth;
	private int expYear;
	private String cvc;

	private List<lignecommandeproduit> listpanier;

	public List<lignecommandeproduit> panierParIdclient(long id) {

		listpanier = panierservice.panierParIdclient(id);
		return listpanier;
	}
	

	public void supprimerPanier(int id,long userId) {
		panierservice.supprimerpanier(id,userId);
	}
	public void update_after_remove(int id,long userId){
		panierservice.update_after_remove(id,userId);
	}
	public void updateLigne(int  id,int quantity,long userId){
		panierservice.updateLigne(id, quantity,userId);
	}
	 public int numProduitPanier(long userId)
	 {
		
		 return panierservice.numProduitPanier(userId);
	 }
	 public String Pay(int idc, long id,String carta, int expMonth,int expYear,String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
		 String navigateTo = "null";
		facture=	stripeService.Pay(idc,id,carta,expMonth,expYear,cvc);
			navigateTo = "/template/facture.xhtml?faces-redirect=true";
			return navigateTo;
		}
	 
	 public void facturepdf (int id) {
		
		 FacturesService.facturepdf(id);
	 }
	
	 
	public Factures getFacture() {
		return facture;
	}

	public void setFacture(Factures facture) {
		this.facture = facture;
	}

	public int getId_facture() {
		return id_facture;
	}

	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

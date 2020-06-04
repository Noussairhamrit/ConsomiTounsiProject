package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.service.AdminService;
import tn.esprit.spring.service.ClientServiceIMP;
import tn.esprit.spring.service.CommandesServiceIMP;

@Scope(value = "session")
@Controller(value = "AdminController")
@ELBeanName(value = "AdminController")
@Join(path = "/log", to = "/LoginAdmin.jsf")

public class AdminController {
	@Autowired
	CommandesServiceIMP CommandesService;
	@Autowired
	AdminService AdminService;
	@Autowired
	ClientServiceIMP clientservice;
	
	private Date date_commande;
	private double prixtotale;
	private String status;
	private String payment_type;
	private String Payment_state;
	private String poucentage;
	private double prix_after_remise;
	private Commandes commande;
	private List<Commandes>commandes;
	private Admin authenticatedAdmin;
	private Client authenticatedClient;
	private long userId;
				  
	//private Client c;
	private String login;
	private String password;
	private Boolean loggedIn;
	private String nom;
	private String prenom;
	private Boolean enabled;
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String doLogin() {
		String navigateTo = "null";
		 authenticatedAdmin = AdminService.authenticate(login, password,enabled);
		 authenticatedClient=clientservice.authenticateClient(login, password,enabled);
		if (authenticatedAdmin != null ) {
			navigateTo = "/template/templateAdmin/index2.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		else if (authenticatedClient != null ) {
			navigateTo = "/template/index.jsf?faces-redirect=true";
			loggedIn = true;
		}
		else {
			FacesMessage facesMessage = new FacesMessage(
					"Login Failed: please check your username/password and try again.");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}
	
	public List<Commandes> getAllCommande() {
		return CommandesService.get_all_commandes();
		
	}
	
	public Client getAuthenticatedClient() {
		return authenticatedClient;
	}

	public void setAuthenticatedClient(Client authenticatedClient) {
		this.authenticatedClient = authenticatedClient;
	}
	




	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Admin getAuthenticatedAdmin() {
		return authenticatedAdmin;
	}

	public void setAuthenticatedAdmin(Admin authenticatedAdmin) {
		this.authenticatedAdmin = authenticatedAdmin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
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

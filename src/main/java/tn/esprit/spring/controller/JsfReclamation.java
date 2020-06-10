package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.repository.Product.ProduitRepository;
import tn.esprit.spring.service.CommandesServiceIMP;
import tn.esprit.spring.service.IReclamationService;
import tn.esprit.spring.service.Product.ProduitServiceImp;

@Scope(value = "session")
@Controller(value = "reclamationController")
@ELBeanName(value = "reclamationController")
public class JsfReclamation {
	@Autowired
	JSFPanierController jsfpanier;
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	IReclamationService iReclamationService;
	@Autowired
	CommandesServiceIMP commandesServiceIMP;
	@Autowired
	ProduitServiceImp produitServiceImp;
	@Autowired
	CommandesRepository commandesRepository;
	@Autowired
	ProduitRepository produitRepository;
	private Integer id_recl;
	private String a;
	private Commandes commandes;
	private Produit produit;
	private Client client;
	private Panier panier;
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commandes getCommandes() {
		return commandes;
	}

	public void setCommandes(Commandes commandes) {
		this.commandes = commandes;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Integer getId_recl() {
		return id_recl;
	}

	public void setId_recl(Integer id_recl) {
		this.id_recl = id_recl;
	}

	private String descrip;

	

	public Reclamation ajouterReclamation(Reclamation reclamation) {
		iReclamationService.ajouterReclamation(reclamation);
		return reclamation;
	}
	String a1;
	//String b;
	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idprod");
	}
	public int outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a1 = getCountryFromJSF(context);
		System.out.println("((((((((((((((((("+a1);
		return Integer.parseInt(a1);
	}


	public String addReclamation(int idp,int idc) {
		idp=outcome();
		String h=jsfpanier.a;
		System.out.println("hhhhhhhhhhh"+h);

		idc=Integer.parseInt(h);
		System.out.println("namiiiiiiiiii"+idc);
			Commandes cmd=commandesRepository.findById(idc).get();
		    Produit pro=produitRepository.findById(idp).get();
		
		//description_Recl = "M";
		System.out.println(a);
		iReclamationService.ajouterReclamation(new Reclamation(descrip,pro,cmd));

		return "null";
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	public List<Reclamation> getAlllReclamations() {
		return reclamationRepository.findAll();
	}
}

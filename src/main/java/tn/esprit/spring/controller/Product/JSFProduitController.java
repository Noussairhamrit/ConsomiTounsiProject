package tn.esprit.spring.controller.Product;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.service.Product.ProduitServiceImp;

@Scope(value = "session")
@Controller(value = "ProduitController")
@ELBeanName(value = "ProduitController")
public class JSFProduitController {
	
	     @Autowired
	ProduitServiceImp produitserImp;
	
	private Produit prod;
	private int id;
	private String nom;
	private long prix;
	private long quantite;
	private long poid;
	
	
	private List<Produit> listprod;
	
	public List<Produit> getAllProduits() {
		listprod = (List<Produit>) produitserImp.findAll();
		return listprod;
}
	
	
	
	
	public void deleteProduitById(int produitId)

	{
		produitserImp.deleteProduitById(produitId);
	}

	public ProduitServiceImp getProduitserImp() {
		return produitserImp;
	}

	public void setProduitserImp(ProduitServiceImp produitserImp) {
		this.produitserImp = produitserImp;
	}

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getPoid() {
		return poid;
	}

	public void setPoid(long poid) {
		this.poid = poid;
	}

	public List<Produit> getListprod() {
		return listprod;
	}

	public void setListprod(List<Produit> listprod) {
		this.listprod = listprod;
	}

	
	
}

package tn.esprit.spring.controller.Product;


import java.util.List;
import java.util.Map;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;




import org.primefaces.model.file.UploadedFiles;

import javax.faces.context.FacesContext;

import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.repository.Product.ProduitRepository;
import tn.esprit.spring.service.Product.ProduitService;


@Component(value = "ProductController")
@ELBeanName(value = "ProductController")
@Join(path = "/addproduct", to = "/checkout.jsf")
public class ProductController {
	
	@Autowired
	ProduitService produitser;
	@Autowired
	ProduitRepository produitRepository;
	
	
	private int id;
	private String nom;
	private long prix;
	private String description;
	private Long barcode;
	private long poid;
	private long prixAchat;
	private UploadedFiles files;
	
	
	public void addProduit() {
		produitser.addProdImage(new Produit( nom,  prix,  description,  barcode,  poid,  prixAchat),files);
	}
	public void ajouterProduit(Produit produit) {
		produitser.ajouterProduit(produit);
		
	}
	
	public List<Produit> getProduitsByCategorie(Long idCategorie) {
		return produitser.findProdCat(idCategorie);
	}
	
	public List<Produit> findProdBySCat(long scatId) {
		return produitser.findProduitBySCategorie(scatId);
	}
	
	
	
	public List<Produit> getAllProduits() {
		return produitser.getAllProduits();
	}

	
	public Produit getOneProduit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return produitRepository.findProd(getId());
		//return produitRepository.findProd((int) Long.parseLong(params.get("idProduit")));
	}
	
	public String save() {
		return produitser.save();
	}


	public ProduitService getProduitser() {
		return produitser;
	}


	public void setProduitser(ProduitService produitser) {
		this.produitser = produitser;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public long getPoid() {
		return poid;
	}

	public void setPoid(long poid) {
		this.poid = poid;
	}

	public long getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(long prixAchat) {
		this.prixAchat = prixAchat;
	}

	public UploadedFiles getFiles() {
		return files;
	}

	public void setFiles(UploadedFiles files) {
		this.files = files;
	}
	
	
	

}

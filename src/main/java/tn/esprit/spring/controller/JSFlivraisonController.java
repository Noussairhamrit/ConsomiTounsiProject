package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Etat_livra;
import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.service.ILivreurService;
import tn.esprit.spring.service.LivraisonSerciceImpl;

@Scope(value = "session")
@Controller(value = "livraisonController")
@ELBeanName(value = "livraisonController")
public class JSFlivraisonController {
	@Autowired
	ILivreurService iLivreurService;
	@Autowired
	LivraisonSerciceImpl LivraisonSercice;
	private Commandes commandes;

	private int id;
	private int id_livra;
	private int frais_livra;
	private String dest_livra;
	private Etat_livra etat_livra;
	
	public Etat_livra[] getEtat_livraa() {
		return Etat_livra.values();
	}
	
	public List<Livraison> retrieveAllLivraisons(){
		
	return	LivraisonSercice.retrieveAllLivraisons();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId_livra() {
		return id_livra;
	}
	public void setId_livra(int id_livra) {
		this.id_livra = id_livra;
	}
	public int getFrais_livra() {
		return frais_livra;
	}
	public void setFrais_livra(int frais_livra) {
		this.frais_livra = frais_livra;
	}
	public String getDest_livra() {
		return dest_livra;
	}
	public void setDest_livra(String dest_livra) {
		this.dest_livra = dest_livra;
	}
	public Etat_livra getEtat_livra() {
		return etat_livra;
	}
	public void setEtat_livra(Etat_livra etat_livra) {
		this.etat_livra = etat_livra;
	}

	

	public Commandes getCommandes() {
		return commandes;
	}

	public void setCommandes(Commandes commandes) {
		this.commandes = commandes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

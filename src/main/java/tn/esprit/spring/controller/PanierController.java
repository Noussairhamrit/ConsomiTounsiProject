package tn.esprit.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.lignecommandeproduit;
import tn.esprit.spring.service.PanierServiceIMP;

@RestController
public class PanierController {
	@Autowired
	PanierServiceIMP panierservice;
	
	@GetMapping("/findPanier_by_id_client/{idClient}")
	public List<Panier> findPanier_by_id_client(@PathVariable(value = "idClient") long id_client){
		return panierservice.findPanier_by_id_client(id_client) ;
	}
	@GetMapping("/findPanier/{idProduit}/{idClient}")
	public Panier findPanier(@PathVariable(value = "idProduit") int idProduit,@PathVariable(value = "idClient")Long idClient){
		
		return panierservice.findPanier(idProduit, idClient);
	}
	@GetMapping("/findPanierrr/{idProduit}/{idClient}/{idCommande}")
	public Panier findPanier(@PathVariable(value = "idProduit") int idProduit,@PathVariable(value = "idClient")Long idClient,@PathVariable(value = "idProduit") int idCommande){
		
		return panierservice.findPanier(idProduit, idClient,idCommande);
	}
	@GetMapping("a/{idUser}")
	public List<lignecommandeproduit> panierParIdclient(@PathVariable(value = "idUser") long id) {
	
		return panierservice.panierParIdclient(id);
	}
	@GetMapping("b/{idUser}")
	public List<lignecommandeproduit> panierParIdclient_confirmer(@PathVariable(value = "idUser") long id) {
	
		return panierservice.panierParIdclient_confirmer(id);
	}
	@PostMapping("/ajouter/{idprod}/{iduser}")
	public List<lignecommandeproduit> AjouterLigne (@PathVariable(value = "idprod") int idprod,@PathVariable(value = "iduser") Long iduser,
			@Valid @RequestBody Panier lc) {
	
		panierservice.AjouterAuPanier(idprod, iduser, lc);
		
		return panierservice.panierParIdclient(iduser);
	}
	@GetMapping("findAllPanier")
	public List<Panier> findAll(){
		return panierservice.findAll();
	}
	@GetMapping("findAllPanier_par_cmd/{idCommande}")
	public List <Panier> findPanier_par_commande(@PathVariable(value = "idCommande") int idCommande){
		
		return panierservice.findPanier_par_commande(idCommande);
	}

	 
}

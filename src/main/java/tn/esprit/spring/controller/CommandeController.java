package tn.esprit.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.service.CommandesServiceIMP;

@CrossOrigin("*")
@RestController
public class CommandeController {

	@Autowired
	 CommandesServiceIMP CommandesService;
	
	@PostMapping("/ajouter")
	public Commandes AjouterCommande(@Valid @RequestBody Commandes c) {
		return CommandesService.ajoutercommande(c);
	}
	
	@GetMapping("/afficher")
	public List<Commandes> getAllCommande() {
		return CommandesService.get_all_commandes();
		
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Commandes> DeleteCommande(@PathVariable(value = "id") int idCommande) {
		Commandes c = CommandesService.findOne(idCommande);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		CommandesService.supprimercommande(idCommande);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("rechercheparcode/{code}")
	public List<Commandes> Commandeparcode(@PathVariable(value = "code") long code) {

		return CommandesService.Commandeparcode(code);
	}
	
	@GetMapping("/recherchetype/{type}")
	public List<Commandes> CommandeparType(@PathVariable(value = "type") String type) {
		return CommandesService.CommandeparType(type);
	}
	@GetMapping("/recherche/{idClient}")
	public List<Commandes> CommandeparClient(@PathVariable(value = "idClient") int id) {
		return CommandesService.CommandeparClient(id);
	}
	@PutMapping("/payerenligne/{idCommande}")
	public void PayerEnLigne(@PathVariable(value = "idCommande") int idCommande) {
		CommandesService.PayerEnLigne(idCommande);
	}

	@PutMapping("/payerporteaporte/{idCommande}")
	public void PayerPorteaPorte(@PathVariable(value = "idCommande") int idCommande) {
		CommandesService.PayerPorteaPorte(idCommande);
	}
	@PostMapping("/confirmer/{idCommande}/{iduser}")
	public Factures confirmer_commande(@PathVariable(value ="idCommande")int idCommande,@PathVariable(value ="iduser")long iduser){
		Factures f=CommandesService.confirmer_commande(idCommande, iduser);
		return f;
	}
	@GetMapping("commande_encour/{iduser}")
	public Commandes commande_en_cour_Idclient(@PathVariable(value ="iduser")long idclient){
		return CommandesService.commande_en_cour_Idclient(idclient);
	}
	
	@GetMapping("pt_merci/{idCommande}")
	public long pt_merci(@PathVariable(value ="idCommande")int idCommande){
		return CommandesService.pt_merci(idCommande);
	}
	
 }

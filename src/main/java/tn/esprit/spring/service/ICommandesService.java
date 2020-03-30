package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.controller.CommandeForm;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Produit;

public interface ICommandesService {
	public Commandes ajoutercommande(Commandes commande);
	public void supprimercommande(int commande_id);
	public Optional<Commandes> getCommande_by_id(int commande_di);
	public List<Commandes> get_all_commandes();
	public List<Commandes> CommandeparClient(int id) ;
	public List< Commandes> Commandeparcode( long code);
	public void PayerEnLigne(int idCommande);
	public void PayerPorteaPorte(int idCommande);
	public List<Commandes> CommandeparType(String type);
	public List<Commandes> CommandeparStatus(String status);
	public List<Commandes> Commandepar_PaymentState(String PaymentState);
	public Commandes findOne(int id);

	
	
	
}

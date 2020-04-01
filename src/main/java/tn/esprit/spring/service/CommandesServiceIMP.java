package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.controller.CommandeForm;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.repository.ProduitRepository;
@Service
public class CommandesServiceIMP implements ICommandesService {
	@Autowired
	CommandesRepository commandesrepository;
	

	@Override
	public Commandes ajoutercommande(Commandes commande) {
		commande.setDate_commande(new Date());
		return commandesrepository.save(commande);
		 
	}

	@Override
	public void supprimercommande(int commande_id) {
		commandesrepository.deleteById(commande_id);

	}

	@Override
	public Optional<Commandes> getCommande_by_id(int commande_id) {

		return commandesrepository.findById(commande_id);
	}

	@Override
	public List<Commandes> get_all_commandes() {

		return (List<Commandes>) commandesrepository.findAll();
	}

	@Override
	public List<Commandes> CommandeparClient(int id_client) {
		return commandesrepository.CommandeparClient(id_client);
	}

	@Override
	public List<Commandes> Commandeparcode(long code) {

		return commandesrepository.Commandeparcode(code);
	}

	@Override
	public void PayerEnLigne(int idCommande) {
		commandesrepository.PayerEnLigne(idCommande);

	}

	@Override
	public void PayerPorteaPorte(int idCommande) {
		commandesrepository.PayerPorteaPorte(idCommande);
	}

	@Override
	public List<Commandes> CommandeparType(String type) {
		return commandesrepository.CommandeparType(type);
	}

	@Override
	public List<Commandes> CommandeparStatus(String status) {
		return commandesrepository.Commandeparstatus(status);
	}

	@Override
	public List<Commandes> Commandepar_PaymentState(String PaymentState) {
		
		return commandesrepository.Commandepar_PaymentState(PaymentState);
	}

	@Override
	public Commandes findOne(int id) {
		return commandesrepository.getOne(id);
		 
	}

}

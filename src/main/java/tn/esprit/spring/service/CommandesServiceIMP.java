package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.CommandesRepository;

public class CommandesServiceIMP implements ICommandesService{
	@Autowired
	CommandesRepository commanderepository;
	@Autowired
	

	@Override
	public int ajoutercommande(Commandes commande) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void supprimercommande(int commande_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Commandes> getCommande_by_id(int commande_di) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commandes> get_all_commandes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commandes createcommande(int id_client, List<Produit> list_produit) {
		// TODO Auto-generated method stub
		return null;
	}

}

package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Produit;

public interface ICommandesService {
	public int ajoutercommande(Commandes commande);
	public void supprimercommande(int commande_id);
	public Optional<Commandes> getCommande_by_id(int commande_di);
	public List<Commandes> get_all_commandes();
	public Commandes createcommande(int id_client,List<Produit> list_produit);
}

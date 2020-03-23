package tn.esprit.spring.service;

import tn.esprit.spring.entity.Commandes;

public interface IPanierService {
	public int ajouterCommande(Commandes commande);
	public void ajouterPanier(int id_commande,int id_produit,int id,int quantite );
	

}

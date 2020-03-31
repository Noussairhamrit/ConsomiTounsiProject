package tn.esprit.spring.service;

import java.util.Date;

import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.*;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.PanierPK;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class PanierServiceIMP implements IPanierService {

	@Autowired
	PanierRepository panierRepository;
	@Autowired
	CommandesRepository commandesRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ClientRepository clientRepository;

	public List<lignecommandeproduit> addProduit_To_Panier(int idprod, long iduser,Panier pp) {
		//List<lignecommandeproduit> List = panierRepository.panier_en_cour_ParIdclient(iduser);
		List<lignecommandeproduit> List2 = new ArrayList<>();
		
		Client c = clientRepository.getOne(iduser);
		Produit prod = produitRepository.getOne(idprod);
		Commandes commande = new Commandes();
		double total = 0;
		for (lignecommandeproduit l2 : List2) {
			Panier panier = new Panier();
			panier.setCommande(commande);
			Produit produit = produitRepository.getOne(l2.getId());
			panier.setProduit(produit);
			panier.setPrix(produit.getPrix());
			panier.setQuantite(l2.getQuantity());
			panier.setStatus("en cours");
			panierRepository.save(panier);
			total += l2.getQuantity() * produit.getPrix();

		}
		commande.setClient(c);
		commande.setDate_commande(new Date());
		commande.setPayment_state(null);
		commande.setPayment_type(null);
		commande.setPrixtotale(total);
		commandesRepository.save(commande);
	

		return panierRepository.panier_en_cour_ParIdclient(iduser);
		
	}
	public List<Panier> findPanier_by_id_client(long id_client) {
		return (List<Panier>) panierRepository.findPanier_by_id_client(id_client);
	}
	public Panier findPanier(int idProduit,Long idClient){
		return panierRepository.findPanier(idProduit, idClient);
	}
	public Panier findPanier(int idProduit,Long idClient,int idCommande){
		return panierRepository.findPanier(idProduit, idClient,idCommande);
	}
	public List<lignecommandeproduit> panierParIdclient( long id){
		return panierRepository.panier_en_cour_ParIdclient(id);
	}
	public Panier findOne(int id_panier) {
		return panierRepository.getOne(id_panier);
	}

	public List<Panier> findAll() {
		return panierRepository.findAll();
	}
	
	

	
}

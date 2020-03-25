package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.PanierPK;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;

@Service
public class PanierServiceIMP implements IPanierService {

	@Autowired
	PanierRepository panierRepository;
	@Autowired
	CommandesRepository commandesRepository;

	@Override
	public int ajouterCommande(Commandes commande) {
		commandesRepository.save(commande);
		return commande.getId();
	}

	@Override
	public void ajouterPanier(int id_commande, int id_produit, int id, int quantite) {
		PanierPK PPK=new PanierPK();
		PPK.setId(id);
		PPK.setId_commande(id_commande);
		PPK.setId_produit(id_produit);
		PPK.setQuantite(quantite);
		
		Panier P=new Panier(); 
		P.setPanierpk(PPK);
		panierRepository.save(P);
		
	
		
	}

}

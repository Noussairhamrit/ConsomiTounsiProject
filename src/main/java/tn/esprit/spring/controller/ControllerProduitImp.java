package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;

public class ControllerProduitImp {
	@Autowired
	ProduitRepository produitRepository;

	public long ajouterProduit(Produit produit) {
		produitRepository.save(produit);
		// TODO Auto-generated method stub
		return produit.getId();
	}

}

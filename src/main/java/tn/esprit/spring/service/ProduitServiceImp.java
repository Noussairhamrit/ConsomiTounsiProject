package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;
@Service
public class ProduitServiceImp implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;

	public long ajouterProduit(Produit produit) {
		produitRepository.save(produit);
		// TODO Auto-generated method stub
		return produit.getId();
	}

}

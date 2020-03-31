package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.repository.LivreurRepository;
@Service
public class LivraisonSerciceImpl implements ILivraisonService {
	@Autowired
	LivraisonRepository livraisonRepository;
	@Autowired
	LivreurRepository livreurRepository;


	public int ajouterLivraison(Livraison livraison) {
		livraisonRepository.save(livraison);
		return livraison.getId_livra();
	}

	@Override
	public void deleteLivraison(int id_livra) {
		livraisonRepository.deleteById(id_livra);
	}
	@Override
	public void mettreAjourLivraison(int id_livra,String etat_livra) {
		Livraison livraison = livraisonRepository.findById(id_livra).get();
		livraison.setEtat_livra(etat_livra);
		livraisonRepository.save(livraison);
	}
	@Override
	public List<Livraison> retrieveAllLivraisons(){
		return (List<Livraison>)livraisonRepository.findAll();
}
	@Override
	public Livraison retriveLivraison(int id_livra){
		return 	livraisonRepository.findById((id_livra)).orElse(null);
	}
	
	public void affecterLivraisonALivreur(String id_livra,Long userId){
		Livreur livreurManagedEntity = livreurRepository.findById(userId).get();
		Livraison livraisonManagedEntity = livraisonRepository.findById((int) Long.parseLong(id_livra)).get();
		
		livraisonManagedEntity.setLivreur(livreurManagedEntity);
		livraisonRepository.save(livraisonManagedEntity );
		
	}
}

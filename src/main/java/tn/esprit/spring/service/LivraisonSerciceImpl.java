package tn.esprit.spring.service;

import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Etat_livra;
import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.repository.LivreurRepository;
@Service
@Transactional
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
	public void mettreAjourLivraison(int id_livra,Etat_livra  etat_livra,Long userId) {
		Livreur livreurManagedEntity = livreurRepository.findById(userId).get();
		Livraison livraison = livraisonRepository.findById(id_livra).get();
		livraison.setEtat_livra(etat_livra);
		//Etat_livra l1 = Etat_livra.livrer; 
		if(livraison.getEtat_livra()==Etat_livra.livrer ){
			
			livreurManagedEntity.setDispo_liv(true);
			livraison.setLivreur(livreurManagedEntity);
			
		
		}livraisonRepository.save(livraison);
	}
	@Override
	public List<Livraison> retrieveAllLivraisons(){
		return (List<Livraison>)livraisonRepository.findAll();
}
	@Override
	public Livraison retriveLivraison(int id_livra){
		return 	livraisonRepository.findById((id_livra)).orElse(null);
	}
	@Override
	public void affecterLivraisonALivreur(int id_livra,Long userId){
		
		Livreur livreurManagedEntity = livreurRepository.findById(userId).get();
		Livraison livraisonManagedEntity = livraisonRepository.findById(id_livra).get();
		//int charge = livreurManagedEntity.getChargeT_liv();
		
		if( livreurManagedEntity.isDispo_liv()== false){
			 System.out.println("Ce livreur est non disponible pour le momment");
		}
		else
			//charge+= charge;

			livreurManagedEntity.setChargeT_liv(livreurManagedEntity.getChargeT_liv()+1);

		livreurManagedEntity.setChargeT_liv(livreurManagedEntity.getChargeT_liv()+1);
		livraisonManagedEntity.setEtat_livra(Etat_livra.en_cours_de_livraison);
		livreurManagedEntity.setDispo_liv(false);
		livraisonManagedEntity.setLivreur(livreurManagedEntity);
		
		
		livraisonRepository.save(livraisonManagedEntity );
	}
	@Override
	public List<Livraison> afficherleslivraison(Long userId) {
		return livraisonRepository.afficherleslivraison(userId);
	}

	@Override
	public void affecterCommandeALivraison(int id_livra, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Notificationlivreur() throws MailException {
		// TODO Auto-generated method stub
		
	}
}

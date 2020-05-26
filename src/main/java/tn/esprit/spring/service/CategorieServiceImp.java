package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.SousCategories;
import tn.esprit.spring.repository.CategorieRepository;
import tn.esprit.spring.repository.SousCategoriesRepository;


@Service
public class CategorieServiceImp implements CategorieService {
	
	@Autowired
	CategorieRepository categorieRep;
	
	@Autowired
	SousCategoriesRepository sousCatRep;
	
	
	
	public SousCategories findOne(long scatId) {
		return sousCatRep.getOne(scatId);
	}
	public Categorie findUn(long catId) {
		return categorieRep.getOne(catId);
	}

	
	public long addCategorie(Categorie categorie) {
		categorieRep.save(categorie);
		return categorie.getIdCat();
	}


	
	public long addSousCat(SousCategories souscategories) {
		sousCatRep.save(souscategories);
		return souscategories.getIdSousCat();

	}



	
	public void affectSousCatToCat(long scatId, long catId) {
		Categorie catManagedEntity = categorieRep.findById(catId).get();
		SousCategories SCatManagedEntity = sousCatRep.findById(scatId).get();
		
		SCatManagedEntity.setCategorie(catManagedEntity);
		sousCatRep.save(SCatManagedEntity);
		
	}



	
	public List<String> getAllSousCategoriesNamesByCategory(long catId) {
		Categorie catManagedEntity = categorieRep.findById(catId).get();
		List<String> SousCatNames = new ArrayList<>();
		for(SousCategories Scat : catManagedEntity.getSouscategories()){
			SousCatNames.add(Scat.getSnom());
		}
		
		return SousCatNames;
	}



	@Transactional
	public void deleteCategorie(long catId) {
		categorieRep.delete(categorieRep.findById(catId).get());	
		
	}



	@Transactional
	public void deleteSousCategorie(long scatId) {
		sousCatRep.delete(sousCatRep.findById(scatId).get());
		
	}



	
	public Categorie chercherCategorie(long catId) {
		return categorieRep.findById(catId).get();
	}



	
	public SousCategories chercherSousCategorie(long scatId) {
		return sousCatRep.findById(scatId).get();
	}
	
	

}

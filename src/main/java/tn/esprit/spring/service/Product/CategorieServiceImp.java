package tn.esprit.spring.service.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.controller.Product.JSFSousCategorie;
import tn.esprit.spring.entity.Product.Categorie;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.entity.Product.SousCategories;
import tn.esprit.spring.repository.Product.CategorieRepository;
import tn.esprit.spring.repository.Product.SousCategoriesRepository;


@Service
public class CategorieServiceImp implements CategorieService {
	
	@Autowired
	CategorieRepository categorieRep;
	
	@Autowired
	SousCategoriesRepository sousCatRep;
	
	@Autowired
	JSFSousCategorie controllersouscat;
	
	
	
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
		Categorie cat = categorieRep.findCategorieByName(controllersouscat.getNomCategorie());
		souscategories.setCategorie(cat);
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
	
	public List<SousCategories> findAll() {
		return sousCatRep.findAll();
	}
	
	public List<Categorie> findAllCategorie() {
		return categorieRep.findAll();
	}
	
	public List<SousCategories> findSCategorieByCategorie(Long id) {
		return  sousCatRep.findByIdCategories(id);
	}
	
	

}

package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.SousCategories;

public interface CategorieService {
	
	public long addCategorie(Categorie categorie);
	public long addSousCat(SousCategories souscategories);
	void affectSousCatToCat(long scatId, long catId);
	List<String> getAllSousCategoriesNamesByCategory(long catId);
	public void deleteCategorie(long catId);
	public void deleteSousCategorie(long scatId);
	public Categorie chercherCategorie(long catId);
	public SousCategories chercherSousCategorie(long scatId);
	public SousCategories findOne(long scatId);
	public Categorie findUn(long catId);


}

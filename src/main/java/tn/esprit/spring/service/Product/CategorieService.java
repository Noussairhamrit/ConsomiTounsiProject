package tn.esprit.spring.service.Product;

import java.util.List;


import tn.esprit.spring.entity.Product.Categorie;
import tn.esprit.spring.entity.Product.SousCategories;

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
	public List<SousCategories> findAll();
	public List<Categorie> findAllCategorie();
	public List<SousCategories> findSCategorieByCategorie(Long id);
	


}

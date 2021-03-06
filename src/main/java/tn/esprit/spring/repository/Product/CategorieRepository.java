package tn.esprit.spring.repository.Product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entity.Product.Categorie;
import tn.esprit.spring.entity.Product.SousCategories;

public interface CategorieRepository extends JpaRepository<Categorie,Long>{
	
	//Optional <Categorie> findById(Long id);
	@Query(value = "SELECT * FROM categories WHERE cat_nom=?1", nativeQuery = true)
	public Categorie findCategorieByName(String name);

}

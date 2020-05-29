package tn.esprit.spring.repository.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Product.SousCategories;

public interface SousCategoriesRepository extends JpaRepository<SousCategories,Long> {
	
	@Query(value = "SELECT * FROM sous_cat WHERE s_nom=?1", nativeQuery = true)
	public SousCategories findSousCategorieByName(String name);
	
	@Query(value = "SELECT * FROM sous_cat WHERE categorie_id=?1", nativeQuery = true)
	public List<SousCategories> findByIdCategorie(Long id);

	
}

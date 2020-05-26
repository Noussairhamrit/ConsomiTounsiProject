package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer>{
	
	
	
	    @Modifying
	    @Transactional
	    @Query("UPDATE Produit e SET e.quantite=:quantite1 where e.id=:prodId")
	    public void mettreAjourQuantiteProduit(@Param("quantite1")String email, @Param("prodId")int produitId);
	    
	    
	    @Query(value = "SELECT * FROM Produit  WHERE souscat_sous_cat_id=?1", nativeQuery = true)
		public List<Produit> findProduitBySCategorie(long scatId);
	    
	    
	    
	    
	    @Query("SELECT count(*) FROM Produit")
	    public int countemp();
}
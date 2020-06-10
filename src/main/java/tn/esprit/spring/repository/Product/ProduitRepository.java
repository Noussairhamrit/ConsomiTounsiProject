package tn.esprit.spring.repository.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Product.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer>{
	
	
	
	    @Modifying
	    @Transactional
	    @Query("UPDATE Produit e SET e.quantite=:quantite1 where e.id=:prodId")
	    public void mettreAjourQuantiteProduit(@Param("quantite1")String email, @Param("prodId")int produitId);
	    
	    
	    @Query(value = "SELECT * FROM Produit  WHERE souscat_sous_cat_id=?1", nativeQuery = true)
		public List<Produit> findProduitBySCategorie(long scatId);
	    
	    
	    @Query(value = "SELECT * FROM produit WHERE prod_id=?1", nativeQuery = true)
		public Produit findProd(int idProd);
	    
	    @Query("SELECT count(*) FROM Produit")
	    public int countemp();
	    
	    
	    @Query(value = "SELECT * FROM Produit l join sous_cat c on l.souscat_sous_cat_id=c.sous_cat_id join categories ca on c.categorie_cat_id=ca.cat_id WHERE ca.cat_id=?1", nativeQuery = true)
		public List<Produit> findProdCat(Long idCategorie);
	    @Query(value = "SELECT image FROM image_produit  WHERE idproduit_prod_id =?1", nativeQuery = true)
		public String findProdimg(int idProd);
	    
}
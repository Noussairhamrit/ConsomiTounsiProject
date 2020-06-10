package tn.esprit.spring.repository.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Product.ImageProduit;

public interface ImageProduitRepository extends JpaRepository<ImageProduit, Long> {
	@Query(value = "SELECT * FROM image_produit  WHERE idproduit_prod_id=?1", nativeQuery = true)
	public ImageProduit findImageProd(int idProd);
	
	@Query(value = "SELECT * FROM image_produit  WHERE idproduit_prod_id=?1", nativeQuery = true)
	public List<ImageProduit> findAllImages(int idProduit);
}

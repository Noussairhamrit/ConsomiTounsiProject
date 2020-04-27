package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Livraison;



public interface LivraisonRepository extends CrudRepository<Livraison,Integer> {
	@Query(value = "SELECT * FROM Livraison WHERE livreur_user_id=? ", nativeQuery = true)
	public List<Livraison> afficherleslivraison(Long userId);
	
}
